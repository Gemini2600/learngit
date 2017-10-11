package com.neusoft.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionService
 */
@WebServlet("/SessionService")
public class SessionService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionService() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//设置编码集
		response.setContentType("text/html;charset=utf-8");
		//创建会话
		HttpSession session=request.getSession();
		//设置会话超时
		session.setMaxInactiveInterval(20);
		//打印到页面
		PrintWriter pw=response.getWriter();
		//是否为新建会话
		if(session.isNew()){
			pw.println("<p>新创建了一个会话，会话id="+session.getId()+"</p>");
		}else{
			pw.println("<p>已存在的一个会话，会话id="+session.getId()+"</p>");
		}
		//格式化时间
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String _date=dateFormat.format(new Date(session.getCreationTime()));
		pw.println("<p>session的创建时间:"+_date+"</p>");
		
		String _last_date=dateFormat.format(new Date(session.getLastAccessedTime()));
		pw.println("<p>最后一次访问的时间:"+_last_date+"</p>");
	
		pw.println("<p>会话超时时间:"+session.getMaxInactiveInterval()+"</p>");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
