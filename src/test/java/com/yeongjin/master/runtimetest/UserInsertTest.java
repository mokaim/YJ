package com.yeongjin.master.runtimetest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.yeongjin.domain.UserDTO;
import com.yeongjin.domain.UserTable;
import com.yeongjin.persistence.UserTableDAO;
import com.yeongjin.persistence.WriteTableDAO;
import com.yeongjin.service.SignupService;

class UserInsertTest {

	
	SignupService sign = new SignupService();
	UserTableDAO dao = UserTableDAO.getInstance();
	
	@Test
	void test() {
		UserDTO user = new UserDTO();
		user.setUserNumber(6);
		user.setUserName("hello");
		user.setEmail("test1@naver.com");
		user.setPw("123456789");
		
		dao.insertUserTable(user);
		
		
		
	}

}
