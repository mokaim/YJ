package com.yeongjin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yeongjin.action.Action;
import com.yeongjin.action.LoginAction;
import com.yeongjin.action.SignUpAction;
import com.yeongjin.domain.UserDTO;

import lombok.extern.slf4j.Slf4j;

/**
 * Servlet implementation class SignUp
 */

@Slf4j
@WebServlet("/signup")
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpController() {
        super();
        // TODO Auto-generated constructor stub
    }



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String pw2 = request.getParameter("pw2");
		
		log.info("username : " + username);
		log.info("email : " + email);
		log.info("pw : " + pw);
		log.info("pw2 : " + pw2);
		
		UserDTO userDTO = new UserDTO();
		userDTO.setUserName(username);
		userDTO.setEmail(email);
		userDTO.setPw(pw);
		userDTO.setPw2(pw2);
		
		request.setAttribute("userDTO", userDTO);
		Action action = new SignUpAction();
		action.execute(request, response);

		
	}

}
