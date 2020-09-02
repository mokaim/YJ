package com.yeongjin.action;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yeongjin.domain.WriteDTO;

import com.yeongjin.message.MessageView;
import com.yeongjin.service.WriteImageService;
import com.yeongjin.service.WriteService;

import lombok.extern.slf4j.Slf4j;

@Slf4j

@WebServlet("/write")
public class WriteAction implements Action{
	
	private final int size = 1024 * 1024 * 15;
	

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		WriteService service = new WriteService();
		WriteImageService service2 = new WriteImageService();
		
		MessageView message = new MessageView();
		
		String path = request.getServletContext().getRealPath("/image");
		
		
		MultipartRequest multipartRequest = new MultipartRequest(request, path, size, "UTF-8", new DefaultFileRenamePolicy());
		
		String uploadFile = multipartRequest.getFilesystemName("uploadFile");	
		String userEmail = (String)request.getSession(true).getAttribute("id");
		String title = multipartRequest.getParameter("title");
		String content = multipartRequest.getParameter("content");
		
		
		
		
		log.info("title : " + title);
		log.info("content : " + content);
		
		WriteDTO writeDTO = new WriteDTO();
		writeDTO.setTitle(title);
		writeDTO.setContent(content);
		writeDTO.setWriter(userEmail);
		writeDTO.setImageLocation(uploadFile);
		
		
		boolean isFaild = service.WriteInsert(writeDTO);
		
		
		
		if(isFaild) {
			service2.writeImageInsert(writeDTO);
		}
		
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
