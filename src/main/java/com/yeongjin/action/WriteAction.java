package com.yeongjin.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yeongjin.domain.WriteDTO;
import com.yeongjin.domain.WriteTable;
import com.yeongjin.message.MessageView;
import com.yeongjin.service.WriteService;

import lombok.extern.slf4j.Slf4j;

@Slf4j

@WebServlet("/write")
public class WriteAction implements Action{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		WriteService service = new WriteService();
		MessageView message = new MessageView();
		
		String userEmail = (String)request.getSession(true).getAttribute("id");
		
		
		String title = (String)request.getAttribute("title");
		title = "test";
		String content = (String)request.getAttribute("content");
		log.info("title : " + title);
		log.info("content : " + content);
		
		WriteDTO writeDTO = new WriteDTO();
		writeDTO.setTitle(title);
		writeDTO.setContent(content);
		writeDTO.setWriter(userEmail);
		
		
		service.WriteInsert(writeDTO);
		
		response.sendRedirect("/master/index");
		
		
		/*
		 * String header = (String)request.getAttribute("header"); String content =
		 * (String)request.getAttribute("content");
		 * 
		 * String nname = service.getNName(id); WriteTable writeTable = new
		 * WriteTable(nname, header, content); boolean isInsert =
		 * service.WriteInsert(writeTable);
		 * 
		 * if(isInsert) message.WriteTableInsertSuccess(writeTable); else
		 * message.WriteTableInsertFail(writeTable);
		 */
	}
}
