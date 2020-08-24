package com.yeongjin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yeongjin.action.Action;
import com.yeongjin.action.ListAction;
import com.yeongjin.domain.WriteDTO;
import com.yeongjin.persistence.JDBCUtil;
import com.yeongjin.persistence.WriteTableDAO;

import lombok.extern.slf4j.Slf4j;

/**
 * Servlet implementation class IndexService
 */
@Slf4j
@WebServlet("/index")
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		/*
		 * List<WriteDTO> list = WriteTableDAO.getinstance().getList(); HttpSession
		 * session = request.getSession(true); request.setAttribute("list", list);
		 * request.setAttribute("session", (String)session.getAttribute("id"));
		 * System.out.println(list.get(0).getTitle()); log.info("현재 로그인 한 사용자의 이름은 : " +
		 * session.getAttribute("id"));
		 */
		
		Action listAction = new ListAction();
		listAction.execute(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	
}
