package com.neusoft.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.entity.PageModel;
import com.neusoft.entity.Product_orderinfo;
import com.neusoft.services.OrderService;

/**
 * Servlet implementation class OrderDisplayServlet
 */
@WebServlet("/orderDisplayServlet.do")
public class OrderDisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderDisplayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderService os=new OrderService();
		
		String orderid=request.getParameter("orderId");
		System.out.println(orderid);
		String page_no=request.getParameter("pageNo");
		System.out.println(page_no);
		
		String page_size=request.getParameter("pageSize");
		System.out.println(page_size);
		
		String search=request.getParameter("searchType");
		System.out.println(search);
		
		String button_value=request.getParameter("button_back");
	    
		//得到button的值，为返回值为1
	    if(button_value!=null&&!button_value.equals("")) {
			if(button_value.equals("1")) {
			   request.getRequestDispatcher("orderServlet.do").forward(request, response);

			}
		}
	    //加载页面值
		else if(orderid!=null&&!orderid.equals("")) {
			//得到商品的id
			int order_id=Integer.parseInt(orderid);
			int pageno=Integer.parseInt(page_no);
			int pagesize=Integer.parseInt(page_size);
			
			if(search!=null&&!search.equals("")) {
				//得到查询的类型，1，2，3，4
				int searchType=Integer.parseInt(search);
				PageModel<Product_orderinfo> orderlist=os.getPageModelStatus(pageno, pagesize,searchType);
				System.out.println(orderlist);
				Product_orderinfo po=null;
				for(int i=0;i<orderlist.getDatas().size();i++) {
					System.out.println("查询的列表为"+orderlist.getDatas().get(i));
					if(orderlist.getDatas().get(i).getOrderid()==order_id) {
						po=orderlist.getDatas().get(i);
					}
				}
				request.setAttribute("order",po);
			    request.getRequestDispatcher("orderdisplay.jsp").forward(request, response);
				
			}
			else {
				PageModel<Product_orderinfo> orderlist=os.getPageModel(pageno, pagesize);
				System.out.println(orderlist);
				Product_orderinfo po=null;
				for(int i=0;i<orderlist.getDatas().size();i++) {
					System.out.println("查询的列表为"+orderlist.getDatas().get(i));
					if(orderlist.getDatas().get(i).getOrderid()==order_id) {
						po=orderlist.getDatas().get(i);
					}
				}
				request.setAttribute("order",po);
			    request.getRequestDispatcher("orderdisplay.jsp").forward(request, response);
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
