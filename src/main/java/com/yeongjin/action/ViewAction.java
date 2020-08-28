package com.yeongjin.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.yeongjin.domain.WriteDTO;
import com.yeongjin.persistence.WriteTableDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ViewAction implements Action{

	
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		String str_viewId = request.getParameter("viewId");
		WriteTableDAO writeTableDAO = WriteTableDAO.getinstance();
		List<WriteDTO> list;
		
		JSONArray jsonArray = new JSONArray();
		
        response.setContentType("application/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
		
		
		try {
			
			int viewId = Integer.parseInt(str_viewId);
			list = Optional.ofNullable(writeTableDAO.getViewList(viewId))
					.filter(o -> o != null).orElse(new ArrayList<>());
			
			if(list.size() <= 0) {
				response.getWriter().append("잘못된 페이지 번호");
			}
			
			
			list.stream().forEach(o -> {
				
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("title", o.getTitle());
				jsonObject.put("content", o.getContent());
				jsonObject.put("imageLocation", o.getImageLocation());
				
				jsonArray.put(jsonObject);
				
			});
			
			
			response.getWriter().append(jsonArray.toString());
			
			
		}catch(NumberFormatException e) {
			
			log.info("잘못된 뷰 번호입니다.");
			response.sendRedirect("/master/index");
			
		}catch(NullPointerException e) {
			
			log.info("뷰 번호를 입력하지 않으셨습니다..");
			response.sendRedirect("/master/index");
		}
		
		
		
		
		
	}
	
	

}
