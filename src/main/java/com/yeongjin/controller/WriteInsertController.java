package com.yeongjin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.yeongjin.action.Action;
import com.yeongjin.action.WriteAction;

import lombok.extern.slf4j.Slf4j;

/**
 * Servlet implementation class WriteInsertService
 */
@Slf4j
@WebServlet("/writer")
public class WriteInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WriteInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/write.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		Action action = new WriteAction();
		
		HttpSession session = request.getSession(true);
		

		String id = (String)session.getAttribute("id");
		String header = request.getParameter("Header");
		//String content = request.getParameter("Content");
		
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		
		log.info("글쓰기 타이틀 테스트 : " + title);
		log.info("글쓰기 내용 테스트 : " + content);
		
		
		request.setAttribute("id", id);
		request.setAttribute("title", title);
		request.setAttribute("header", header);
		request.setAttribute("content", content);
		
		action.execute(request, response);
		
		
	}

}
