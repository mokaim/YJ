package com.yeongjin.master.runtimetest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.yeongjin.domain.UserTable;
import com.yeongjin.persistence.UserTableDAO;

class LoginTest {

	
	UserTableDAO user;
	
	@BeforeEach
	void setUp() {
		user = UserTableDAO.getInstance();
	}
	
	@Test
	void test() {
		
		boolean validation =  user.LoginUser("naruto@naver.com", "1234");
		
		assertEquals(true, validation);
	}

}
