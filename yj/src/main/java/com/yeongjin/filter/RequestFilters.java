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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestFilters implements javax.servlet.Filter{
	
	
	private Logger log = LoggerFactory.getLogger(RequestFilters.class);

	
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

		log.info("Filter start!!");
		
		if(session.getAttribute("loginValidate") == null) {
			
			log.info("No Session");
			//req.getRequestDispatcher("/login").forward(req, res);
			
			
			
		}//else {
			
			if (path.startsWith("/resources/")) {
				log.info("request resources : " + "@" + path + "@");
			    filter.doFilter(req, res); // Goes to container's own default servlet.
			    
			} else if(path.startsWith("/")) {
				log.info("/list濡� �씠�룞!!!");
				req.getRequestDispatcher("WEB-INF/index.jsp").forward(req, res);
			} else {
				

				
				log.info("Go to other filter!! : " + "@" + path + "@");
			    req.getRequestDispatcher(path).forward(req, res); // Goes to controller servlet.
			    
			}
			
		//}
		
		
	}

	@Override
	public void init(FilterConfig init) throws ServletException {
		// TODO Auto-generated method stub
		
		this.encoding = init.getInitParameter("initparam");
		this.filterConfig = init;
		
	}

}
