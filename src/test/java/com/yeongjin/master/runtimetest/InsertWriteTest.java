package com.yeongjin.master.runtimetest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.yeongjin.domain.WriteDTO;
import com.yeongjin.persistence.WriteTableDAO;

class InsertWriteTest {

	WriteTableDAO writeDAO;
	
	
	@BeforeEach
	void setUp() throws Exception {
		writeDAO = WriteTableDAO.getinstance();
		
	}

	@Test
	void test() {
		
		WriteDTO writeDTO = new WriteDTO();
		writeDTO.setWriter("naruto@naver.com");
		int userNumber = writeDAO.getUserNumber(writeDTO.getWriter());
		int postNumber = writeDAO.getCountPost();
		String date = writeDAO.getDate();
		
		System.out.println("userNumber : " + userNumber);
		System.out.println("postNumber : " + postNumber);
		
		writeDTO.setTitle("test");
		writeDTO.setContent("test123");
		
		writeDTO.setUserNumber(userNumber);
		writeDTO.setPostNumber(3);
		writeDTO.setLikes(0);
		writeDTO.setHate(0);
		writeDTO.setVisit(0);	
		writeDTO.setPosted_date(date);
		
		writeDAO.insertWriteTable(writeDTO);
		
	}

}
