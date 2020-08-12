package com.yeongjin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yeongjin.action.Action;
import com.yeongjin.action.SignUpAction;
import com.yeongjin.domain.UserTable;
/**
 * Servlet implementation class t
 */

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rs = request.getRequestDispatcher("WEB-INF/signup.jsp");
		rs.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String ID = request.getParameter("ID").toString();
		String PW = request.getParameter("PW").toString();
		String NName = request.getParameter("NName").toString();
		String Phone = request.getParameter("Phone").toString();
		String Email = request.getParameter("Email").toString();
		
		UserTable userTable = new UserTable(ID,PW,NName,Phone,Email);
		request.setAttribute("userTable", userTable);
		
		Action action = new SignUpAction();
		action.execute(request, response);
		
		
		
		
	}
	
}
