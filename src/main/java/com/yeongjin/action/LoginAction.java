package com.yeongjin.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yeongjin.message.MessageView;
import com.yeongjin.service.LoginService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class LoginAction implements Action{

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LoginService service = new LoginService();
		MessageView message = new MessageView();
		boolean isLogin = false;
		String id = (String)request.getAttribute("id");
		String pw = (String)request.getAttribute("pw");
		log.info("�α��� ��û�� ���̵� : " + id);
		log.info("�α��� ��û�� ���̵��� ��й�ȣ : " + pw);
		
		isLogin = service.loginCheck(id, pw);
	
		
		if(isLogin) {			
			HttpSession httpSession = request.getSession(false);
			httpSession.setAttribute("id", id);
			log.info("�α��� �� ����ڴ� : " + httpSession.getAttribute("id"));
			//message.LoginSuccess(id);	
			response.sendRedirect("/master/index");
			
		}else {
			log.info("�α��� fail�� �̵� ");
			message.LoginFail(id);
		}
		
	}

}
