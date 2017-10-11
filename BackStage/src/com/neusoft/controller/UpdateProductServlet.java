package com.neusoft.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.entity.Product;
import com.neusoft.services.ProductService;

/**
 * Servlet implementation class UpdateProductServlet
 */
@WebServlet("/updateProductServlet.do")
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UpdateProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("getid"));
		ProductService ps = new ProductService();
		Product product = ps.getproductById(id);
		request.setAttribute("product", product);
		request.getRequestDispatcher("updateproduct.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
