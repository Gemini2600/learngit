package com.neusoft.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neusoft.entity.Account;
import com.neusoft.services.LoginService;
import com.neusoft.utils.MD5Utils;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw=response.getWriter();
		
	/*	pw.append("<html>");
		pw.append("<head>");
		pw.append("<meta charset=\"UTF-8\">");	
		pw.append("<title>��¼����</title>");	
		pw.append("<link rel=\"stylesheet\" href=\"css/login.css\"/>");
		pw.append("<style type=\"text/css\">");		
		pw.append("	body{background: #1a1a1a;color: white;font-family: 'Roboto';}");
		pw.append("	#login{background: #e74c3c;margin: 200px auto;width: 390px;height: 340px;font-family: 'Roboto';}");
		pw.append("h1{font-size: 42px;padding-bottom: 10px;}");			
		pw.append("p{font-size: 12px;padding-bottom: 10px;line-height: 25px;text-align: center;}");			
		pw.append("li{list-style: none;margin-top: 20px;}");
		pw.append("</style>");		
	    pw.append("</head>");
	    pw.append("<body>");
	    pw.append("<div id=\"login\" class=\"form-action show\">");
	    pw.append("<h1>Login on web</h1>");
		pw.append("<p>��ӭʹ��*****����ƽ̨</p>");
	    pw.append("<form action=\"\" method=\"post\">");
		pw.append("<input type=\"text\" name=\"username\" value=\"�������û���\" class=\"loginInput\" /> </br>");
		pw.append("<input type=\"text\" name=\"password\" value=\"����������\" class=\"loginInput\"/> </br>");
		pw.append("<input type=\"submit\" value=\"��¼\" class=\"loginSubmit\" />");
		pw.append("<input type=\"hidden\" name=\"type\" value=\"1\" />");
		pw.append("</form>");
	    pw.append("</div>");
		pw.append("</body>");
		pw.append("</html>");*/
		
		
	String _username=request.getParameter("username");
	String _password=request.getParameter("password");
	String type=request.getParameter("type");
	
	HttpSession session=request.getSession();
	
	if(type!=null && !type.equals("") && type.equals("1")){
		
		if(_username==null || _username.equals("")){
			pw.append("<script>var _uesrid=document.getElementById(\"uesrid\");"
					+ "_userid.innerHtml=\"�û�������Ϊ��\"</script>");
			
		}
		if(_password==null || _password.equals("")){
//				pw.append("<script>alert(\"���벻��Ϊ��\")</script>");
			return;
		}
		LoginService ls=new LoginService();
		Account acc=new Account(_username,MD5Utils.GetMD5Code(_password),request.getRemoteAddr());
		acc=ls.doLoginWeb(acc);
		
		if(acc!=null){
//				pw.append("<script>alert(\"��¼�ɹ�\")</script>");
			//request.setAttribute�����������������һ������Ĳ�����������sendRedirect�Ժ����޷�ȡ��request.setAttribute�������
//				request.setAttribute("acc", acc);
			
			String isChecked=request.getParameter("checkbox"); //�Զ���¼��ť
//			System.out.println("ischecked="+isChecked);
			if(isChecked!=null && isChecked.equals("1")){
				//URLEncoder.encode 
				Cookie username_cookie=new Cookie("username_cookie", URLEncoder.encode(_username,"utf-8"));
				username_cookie.setMaxAge(7*24*60*60);
				//MD5��������
				Cookie password_cookie=new Cookie("password_cookie",MD5Utils.GetMD5Code(_password));
				password_cookie.setMaxAge(7*24*60*60);
				response.addCookie(username_cookie);
				response.addCookie(password_cookie);
			
			}
			session.setAttribute("acc", acc);
			//�������
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else{
			//��¼ʧ�ܺ���ת���µ�ҳ��(HomeServlet)
//				request.setAttribute("acc", new Account("admin1","admin","127.0.0.2"));
//				session.setAttribute("acc", new Account("admin","admin","127.0.0.1"));
			
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			//�ض���
//				response.sendRedirect("home");
		}
	}
	
		
		
	   
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
