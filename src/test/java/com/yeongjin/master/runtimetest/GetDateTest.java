package com.yeongjin.master.runtimetest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.yeongjin.domain.WriteDTO;
import com.yeongjin.persistence.UserTableDAO;
import com.yeongjin.persistence.WriteTableDAO;

import junit.framework.TestCase;


public class GetDateTest {
	
	UserTableDAO dao = UserTableDAO.getInstance();
	


	@Test
	public void getDate() {
		
		System.out.println(dao.getUserNumber());
		
	}
	


}
