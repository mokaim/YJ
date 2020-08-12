package com.yeongjin.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yeongjin.domain.UserTable;
import com.yeongjin.message.MessageView;
import com.yeongjin.service.SignupService;

public class SignUpAction implements Action{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SignupService signupService = new SignupService();
		MessageView message = new MessageView();
		
		UserTable userTable = (UserTable)request.getAttribute("userTable");
		boolean isInsert = signupService.InsertUserTable(userTable);
		
		if(isInsert)
			message.UserTableInsertSuccess(userTable);
		else
			message.UserTableInsertFail(userTable);
	}
}
