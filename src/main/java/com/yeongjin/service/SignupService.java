package com.yeongjin.service;

import com.yeongjin.domain.UserDTO;
import com.yeongjin.domain.UserTable;
import com.yeongjin.persistence.JDBCUtil;
import com.yeongjin.persistence.UserTableDAO;

public class SignupService {
	
	public boolean InsertUserTable(UserDTO userTable) {
		UserTableDAO userDAO = UserTableDAO.getInstance();
		
		boolean isInsert = false;
		
		int Cnt = userDAO.insertUserTable(userTable);
		
		if(Cnt > 0) {
			isInsert = true;
			JDBCUtil.getInstance().commit(userDAO.conn);
		}else {
			JDBCUtil.getInstance().Rollback(userDAO.conn);
		}
		JDBCUtil.getInstance().ConnClose(userDAO.conn);
		return isInsert;
	}
	
}