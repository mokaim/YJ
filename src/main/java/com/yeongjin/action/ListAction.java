package com.yeongjin.action;

import java.io.IOException;
import java.util.ArrayList;
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
		
		List<Integer> pagingList = new ArrayList<>();
		
		HttpSession session = request.getSession(true);
		session = request.getSession(true); 
		request.setAttribute("session", (String)session.getAttribute("id"));
		

		String str_page = Optional.ofNullable(request.getParameter("page"))
				.filter(o -> o != null).orElse("1");
		
		
		log.info("page2 : " + str_page);
		
		int postCount = writeTableDAO.getCountPost();
		int subPostCount = 0;
		int page = 0;
		
		int pagingNumber = (postCount / 10) + 1;


		/*
		 * for(int i=1; i<=pagingNumber; i++) { pagingList.add(i); }
		 */

		try {
			
		
			page = Integer.parseInt(str_page);
			
			
			if((page - 2) <= 0) {
				
				for(int i=1; i <=5; i++) {
					pagingList.add(i);
				}

			}else if(page >=(pagingNumber - 2)) {
				
				for(int i=pagingNumber - 4; i <=pagingNumber; i++) {
					pagingList.add(i);
				}
	
			}else {
				
				for(int i=page - 2; i<=(page + 2); i++) {
					pagingList.add(i);
				}
				
			}
			
	
			subPostCount = postCount - (page - 1) * 10;
			
			
			list = writeTableDAO.getList(subPostCount);
			
			request.setAttribute("list", list);
			request.setAttribute("pagingNumber", pagingList);
			request.setAttribute("currentPage", page);
			request.setAttribute("totalPage", pagingNumber);
			
			request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
			
			
			
			
		}catch(NumberFormatException e) {
			
			log.warn("잘못된 페이지 번호를 입력하셨습니다.");
			response.sendRedirect("/master/index");
		}
		
	}

}
