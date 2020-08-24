package com.yeongjin.action;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yeongjin.domain.WriteDTO;
import com.yeongjin.persistence.WriteTableDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ListAction implements Action{
	
	
	WriteTableDAO writeTableDAO = WriteTableDAO.getinstance();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<WriteDTO> list;
		
		HttpSession session = request.getSession(true);
		session = request.getSession(true); 
		request.setAttribute("session", (String)session.getAttribute("id"));
		String a = request.getParameter("page");

		String str_page = Optional.ofNullable(a)
				.filter(o -> o != null).orElse("1");
		
		
		log.info("page : " + a);
		log.info("page2 : " + str_page);
		
		int postCount = writeTableDAO.getCountPost();
		int subPostCount = 0;
		int page = 0;
		
		

		try {
			
		
			page = Integer.parseInt(str_page);
			
			
			subPostCount = postCount - (page - 1) * 10;
			log.info("보여줄 포스트 넘버는 " + subPostCount + "에서 부터");
			
			list = writeTableDAO.getList(subPostCount);
			
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
			
			
			
			
		}catch(NumberFormatException e) {
			
			log.warn("잘못된 페이지 번호를 입력하셨습니다.");
			response.sendRedirect("/master/index");
		}
		
	}

}
