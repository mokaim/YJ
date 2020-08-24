package com.yeongjin.master.runtimetest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.yeongjin.persistence.WriteTableDAO;

class GetUserNumberTest {
	
	WriteTableDAO writeDAO;

	@BeforeEach
	void setUp() {
		writeDAO = WriteTableDAO.getinstance();
	}
	
	
	@Test
	void test() {
		int number = writeDAO.getUserNumber("naruto@naver.com");
		
		System.out.println("해당 유저의 번호는 : " + number);
		
		assertEquals(2, number);
	}

}
