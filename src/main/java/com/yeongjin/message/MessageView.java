package com.yeongjin.message;

import com.yeongjin.domain.UserTable;
import com.yeongjin.domain.WriteTable;

public class MessageView {
	// 로그인
	public void LoginSuccess(String id) {
		System.out.println(id+" 님 로그인 성공");
	}
	public void LoginFail(String id) {
		System.out.println(id+" 님 로그인 Fail");
	}
	
	// 로그 아웃
	public void LogoutSuccess() {
		System.out.println("로그아웃 성공");
	}
	public void LogoutFail() {
		System.out.println("로그아웃 Fail");
	}
	
	// UserTable
	// 회원가입
	public void UserTableInsertSuccess(UserTable userTable) {
		System.out.println(userTable.getID()+" 님 회원가입 성공");
		
	}
	public void UserTableInsertFail(UserTable userTable) {
		System.out.println(userTable.getID()+" 님 회원가입 Fail");

	}
	
	// 회원탈퇴
	public void UserTableDeleteSuccess(String id) {
		System.out.println(id+"님 탈퇴 성공");
	}
	public void UserTableDeleteFail(String id) {
		System.out.println(id+"님 탈퇴 Fail");
	}
	
	// 회원정보 수정
	public void UserTableUpdateSuccess(UserTable userTable) {
		System.out.println(userTable.getID() +"님 회원정보 수정 성공");
	}
	public void UserTableUpdateFail(UserTable userTable) {
		System.out.println(userTable.getID() +"님 회원정보 수정 Fail");
	}
	
	// WriteTable
	// 글쓰기
	public void WriteTableInsertSuccess(WriteTable writeTable) {
		System.out.println(writeTable.getNName()+"님 글쓰기 성공");
	}
	public void WriteTableInsertFail(WriteTable writeTable) {
		System.out.println(writeTable.getNName()+"님 글쓰기 Fail");
	}
	
	// 글 수정
	public void WriteTableUpdateSuccess(WriteTable writeTable) {
		System.out.println("제목 : "+writeTable.getHeader()+"\n"+"내용 : "+writeTable.getContent()+"수정 성공");
	}
	public void WriteTableUpdateFail(WriteTable writeTable) {
		System.out.println("글 수정 실패");
	}
	
	
}
