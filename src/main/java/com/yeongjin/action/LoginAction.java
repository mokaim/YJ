package com.yeongjin.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yeongjin.message.MessageView;
import com.yeongjin.service.LoginService;


public class LoginAction implements Action{

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LoginService service = new LoginService();
		MessageView message = new MessageView();
		boolean isLogin = false;
		String id = (String)request.getAttribute("id");
		String pw = (String)request.getAttribute("pw");
		
		
		isLogin = service.Login(id, pw);
		
		if(isLogin) {			
			HttpSession httpSession = request.getSession(false);
			httpSession.setAttribute("id", id);			
			message.LoginSuccess(id);		
		}else {
			message.LoginFail(id);
		}
		
	}

}
