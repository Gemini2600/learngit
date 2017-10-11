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
		//���ñ��뼯
		response.setContentType("text/html;charset=utf-8");
		//�����Ự
		HttpSession session=request.getSession();
		//���ûỰ��ʱ
		session.setMaxInactiveInterval(20);
		//��ӡ��ҳ��
		PrintWriter pw=response.getWriter();
		//�Ƿ�Ϊ�½��Ự
		if(session.isNew()){
			pw.println("<p>�´�����һ���Ự���Ựid="+session.getId()+"</p>");
		}else{
			pw.println("<p>�Ѵ��ڵ�һ���Ự���Ựid="+session.getId()+"</p>");
		}
		//��ʽ��ʱ��
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String _date=dateFormat.format(new Date(session.getCreationTime()));
		pw.println("<p>session�Ĵ���ʱ��:"+_date+"</p>");
		
		String _last_date=dateFormat.format(new Date(session.getLastAccessedTime()));
		pw.println("<p>���һ�η��ʵ�ʱ��:"+_last_date+"</p>");
	
		pw.println("<p>�Ự��ʱʱ��:"+session.getMaxInactiveInterval()+"</p>");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
