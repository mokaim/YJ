package com.yeongjin.master.runtimetest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.yeongjin.persistence.WriteTableDAO;

class GetViewTest {
	
	WriteTableDAO writeTable;

	@BeforeEach
	void setUp() throws Exception {
		
		writeTable = WriteTableDAO.getinstance();
	}

	@Test
	void test() {
		
		writeTable.getViewList(1).stream()
		.forEach(o -> System.out.println("���� Ÿ��Ʋ : " + o.getTitle()));
		
	}

}
