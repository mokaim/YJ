package com.yeongjin.master.runtimetest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.yeongjin.persistence.WriteTableDAO;

class GetPostCountTest {
	
	WriteTableDAO writeTableDAO;

	@BeforeEach
	void setUp() throws Exception {
		writeTableDAO = WriteTableDAO.getinstance();
		
	}

	@Test
	void test() {
		
		int count = writeTableDAO.getCountPost();
		
		System.out.println("������ ����Ʈ ���� : " +count);
		
		assertEquals(2, count);
	}

}
