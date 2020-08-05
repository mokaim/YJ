package com.yeongjin.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.dsig.spec.XPathType.Filter;

public class RequestFilters implements javax.servlet.Filter{

	
	String encoding;
	FilterConfig filterConfig;
	
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
		this.encoding = null;
		this.filterConfig = null;
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filter)
			throws IOException, ServletException {
		
		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession(true);
		
		
		String path = req.getRequestURI().substring(req.getContextPath().length());

		System.out.println(path);
		
		if(session.getAttribute("loginValidate") == null) {
			
			System.out.println("로그인으로 실행 ㄱㄱ");
			req.getRequestDispatcher("/login").forward(req, res);
			
			
		}else {
			
			if (path.startsWith("/resources")) {
				System.out.println("hello");
			    filter.doFilter(request, response); // Goes to container's own default servlet.
			    
			} else {
				System.out.println("NOt");
			    request.getRequestDispatcher(path).forward(request, response); // Goes to controller servlet.
			    
			}
			
		}
		
		
	}

	@Override
	public void init(FilterConfig init) throws ServletException {
		// TODO Auto-generated method stub
		
		this.encoding = init.getInitParameter("initparam");
		this.filterConfig = init;
		
	}

}
