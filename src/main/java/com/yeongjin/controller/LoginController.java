package com.yeongjin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yeongjin.action.LoginAction;
import com.yeongjin.service.LoginService;

import lombok.extern.slf4j.Slf4j;


/**
 * Servlet implementation class LoginController
 */

@Slf4j
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String uri = request.getRequestURI().substring(request.getContextPath().length());
		
		postCommend(request, response, uri);
	}
	
	
	protected void getCommend(HttpServletRequest request, HttpServletResponse response, String contextPath, String requestUri) throws IOException {
	
		response.getWriter().append("해당 URI").append(request.getContextPath())
			.append("는 함부로 접근하실 수 없습니다.");
	
	}
	
	
	protected void postCommend(HttpServletRequest request, HttpServletResponse response, String uri) throws IOException, ServletException {
	
		LoginAction loginAction = new LoginAction();
		
		boolean loginCheck = false;
		
		if(uri.equals("/login")) {
			String id = request.getParameter("username");
			String pw = request.getParameter("psw");
			
			request.setAttribute("id", id);
			request.setAttribute("pw", pw);
			
			log.info("첫번 째 컨트롤러의 아이디는 : " + id);
			log.info("그리고 비밀번호는 : " + pw);
			
			loginAction.execute(request, response);
			
			
			
		}


		
		
	}

}
