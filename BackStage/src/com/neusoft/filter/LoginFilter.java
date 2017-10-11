package com.neusoft.filter;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neusoft.entity.Account;
import com.neusoft.services.LoginService;
import com.neusoft.utils.MD5Utils;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/login.jsp")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)resp;
		
		Cookie[] cookies=request.getCookies();
		Cookie username_cookie=null;//用户名的cookie
		Cookie password_cookie=null;//密码的cookie
		String username=null;//从cookie中获取用户名
		String password=null;//从cookie中获取密码
		if(cookies!=null && cookies.length>0){
			for (Cookie c : cookies) {
			
				String name=c.getName();
				String value=c.getValue();
				if(name!=null && name.equals("username_cookie")){
					//解码
					username=URLDecoder.decode(value, "utf-8");
					username=value;
					username_cookie=c;
				}
				if(name!=null && name.equals("password_cookie")){
					
					password=value;
					password_cookie=c;
				}
			}
		}
		if(username!=null && password!=null){//从cookie中获取到了用户名和密码
			LoginService ls=new LoginService();
			Account acc=new Account(username,password,request.getRemoteAddr());
			acc=ls.doLoginWeb(acc);
			
				if(acc!=null){//登录成功
					HttpSession session=request.getSession();
					session.setAttribute("acc", acc);
//					request.getRequestDispatcher("index.jsp").forward(request, response);
				}else{//用户名或密码发生变化
					username_cookie.setMaxAge(0);
					password_cookie.setMaxAge(0);
					response.addCookie(username_cookie);
					response.addCookie(password_cookie);
					response.sendRedirect("login.jsp");
				}
				
			}
		
		System.out.println("===doFilter===");
		// pass the request along the filter chain
		chain.doFilter(req, resp);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
