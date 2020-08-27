package com.yeongjin.filter;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RequesetInitFilter implements Filter{
	
	String encoding;
	
	FilterConfig filterConfig;
	
	

	@Override
	public void doFilter(ServletRequest par_request, ServletResponse par_response, FilterChain filter)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		HttpServletRequest request = (HttpServletRequest) par_request;
		HttpServletResponse response = (HttpServletResponse) par_response;
		HttpSession session = request.getSession();

		log.info("���� �ʱ�ȭ �Ķ���ͷ� ���� ���ڵ� ���� : " + encoding);
		
		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);
		
		
		String path = request.getRequestURI().substring(request.getContextPath().length());
		
		String user_id = Optional.ofNullable((String)session.getAttribute("id"))
				.filter(o -> o != null).orElse("no");
		
		if(!user_id.equals("no")) {
			log.info("���� ������ ������ : " + user_id);
		}else {
			
			log.info("�α��� ���� ����");
		}
		
		log.info("���� �Է��� �н� : " + path);
		
		
		if(path.equals("/")) {
			log.info("Filter ���� �̵��� �н� : " + path);
			request.getRequestDispatcher("/index").forward(request, response);
		}else if(path.equals("/signup")) {
			request.getRequestDispatcher("/signup").forward(request, response);
		}else if(path.equals("/login")) {
			request.getRequestDispatcher("/login").forward(request, response);
		}
		
		
		else {
			
			log.info("�׳� doFilter");
			filter.doFilter(request, response);
		}
		
		
		
		
		
		

	}
	
	
	
	@Override
	public void init(FilterConfig init) throws ServletException {
		// TODO Auto-generated method stub

		this.encoding = init.getInitParameter("initparam");
		this.filterConfig = init;

	}

}
