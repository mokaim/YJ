package com.yeongjin.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yeongjin.domain.UserDTO;
import com.yeongjin.service.SignupService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SignUpAction implements Action{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter print = response.getWriter();
		boolean result = false;
		UserDTO userDTO = (UserDTO)request.getAttribute("userDTO");
		
		
		if(!userDTO.getPw().equals(userDTO.getPw2())) {
			log.info("����� ���� ����....");
			print.write("<script>");
			print.write("alert('�Է��Ͻ� ��й�ȣ�� Ȯ�ζ��� ��й�ȣ�� �ٸ��ϴ�.')");
			print.write("<script>");
			response.sendRedirect("/master/");
		}else {			
			SignupService signupService = new SignupService();		
			result = signupService.InsertUserTable(userDTO);
			System.out.println("true? : ");					
		}
		
		if(result == true) {	
			log.info("ȸ������ ����");
			response.sendRedirect("/master/");
			
		}else {
			log.info("ȸ������ ����");
			print.write("<script>");
			print.write("alert('ȸ�����Կ� �����ϼ̽��ϴ�.')");
			print.write("<script>");
			response.sendRedirect("/master/");
		}
	}
}
