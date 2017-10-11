package com.neusoft.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.entity.Product;
import com.neusoft.services.ProductService;
@WebServlet("/UpdateProductOutServlet")
public class UpdateProductOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UpdateProductOutServlet() {
        super();
        
        System.out.println("进入修改");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pname=request.getParameter("pname");
		int cid =Integer.parseInt(request.getParameter("sel1"));
		int id =Integer.parseInt(request.getParameter("sel2"));
		String pno = request.getParameter("pno");
//		String sel3 = request.getParameter("sel3");
		ProductService ps = new ProductService();
		boolean b =ps.updateProduct(new Product(id, pname, cid, pno));
		System.out.println("ps============"+new Product(id, pname, cid, pno));
		if(b){
			System.out.println("修改成功");
			request.getRequestDispatcher("productServlet.do").forward(request, response);
		}else{
			System.out.println("修改失败");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
