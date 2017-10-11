package com.neusoft.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.entity.Cate;
import com.neusoft.services.CateService;

/**
 * Servlet implementation class DelCateServlet
 */
@WebServlet("/delCateServlet.do")
public class DelCateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelCateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String delet_cid=request.getParameter("delet_cid");
		System.out.println("dele="+delet_cid);
		String button_value=request.getParameter("del_button_name");
		
		System.out.println("buttonvalue="+button_value);
		
		CateService cs=new CateService();
		
		
		
		
		
		if(button_value!=null&&!button_value.equals("")) {
			if(button_value.equals("True")) {
				
				int _delet_cid=Integer.parseInt(delet_cid);
				
				System.out.println(_delet_cid);
				
				cs.delRegion(_delet_cid);
				request.getRequestDispatcher("cServlet.do").forward(request, response);
	
			}else {//点击取消
				
				request.getRequestDispatcher("cServlet.do").forward(request, response);
			}
		}else{
			int cid=Integer.parseInt(delet_cid);
			System.out.println("进入删除界面输出cid="+cid);
			request.setAttribute("delet_cid", cid);
			request.getRequestDispatcher("delcate.jsp").forward(request, response);
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
