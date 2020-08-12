package com.yeongjin.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yeongjin.domain.WriteTable;
import com.yeongjin.message.MessageView;
import com.yeongjin.service.WriteService;

public class WriteAction implements Action{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		WriteService service = new WriteService();
		MessageView message = new MessageView();
		String id = (String)request.getAttribute("id");
		String header = (String)request.getAttribute("header");
		String content = (String)request.getAttribute("content");
		
		String nname = service.getNName(id);
		WriteTable writeTable = new WriteTable(nname, header, content);
		boolean isInsert = service.WriteInsert(writeTable);
		
		if(isInsert)
			message.WriteTableInsertSuccess(writeTable);
		else
			message.WriteTableInsertFail(writeTable);
	}
}
