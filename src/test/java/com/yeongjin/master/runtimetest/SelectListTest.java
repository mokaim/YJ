package com.yeongjin.master.runtimetest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.yeongjin.domain.WriteDTO;
import com.yeongjin.persistence.WriteTableDAO;

public class SelectListTest {
	
	WriteTableDAO writeTableDAO;

	@Before
	public void setUp() throws Exception {
		writeTableDAO = WriteTableDAO.getinstance();
	}

	@Test
	public void test() {
		
		List<WriteDTO> list = writeTableDAO.getList(23);
		for(WriteDTO dto : list) {
			System.out.println(dto.getPostNumber());
		}
		
	}

}
