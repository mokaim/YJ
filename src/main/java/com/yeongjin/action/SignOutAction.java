package com.yeongjin.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yeongjin.message.MessageView;
import com.yeongjin.service.SignOutService;

public class SignOutAction implements Action{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SignOutService service = new SignOutService();
		MessageView message = new MessageView();
		String id = (String)request.getAttribute("id");
		String pw = (String)request.getAttribute("pw");
		
		boolean isDelete = service.DeleteUserTable(id, pw);
		
		if(isDelete)
			message.UserTableDeleteSuccess(id);
		else
			message.UserTableDeleteFail(id);
	}
}
