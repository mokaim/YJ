package com.yeongjin.master.runtimetest;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.yeongjin.domain.WriteDTO;
import com.yeongjin.persistence.WriteTableDAO;

class InsertImageTest {

	WriteTableDAO dao;
	
	
	@BeforeEach
	void setUp() throws Exception {
		
		dao = WriteTableDAO.getinstance();
	
	}

	@Test
	void test() {
		
		WriteDTO writeDTO = new WriteDTO();
		writeDTO.setWriter("naruto@naver.com");
		writeDTO.setImageLocation("testImageLocation");
		
		int result = dao.insertImage(writeDTO);
		try {
			dao.conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(1, result);
		
		
	}

}
