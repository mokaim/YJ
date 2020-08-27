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
			log.info("비번이 맞지 않음....");
			print.write("<script>");
			print.write("alert('입력하신 비밀번호가 확인란의 비밀번호와 다릅니다.')");
			print.write("<script>");
			response.sendRedirect("/master/");
		}else {			
			SignupService signupService = new SignupService();		
			result = signupService.InsertUserTable(userDTO);
			System.out.println("true? : ");					
		}
		
		if(result == true) {	
			log.info("회원가입 성공");
			response.sendRedirect("/master/");
			
		}else {
			log.info("회원가입 실패");
			print.write("<script>");
			print.write("alert('회원가입에 실패하셨습니다.')");
			print.write("<script>");
			response.sendRedirect("/master/");
		}
	}
}
