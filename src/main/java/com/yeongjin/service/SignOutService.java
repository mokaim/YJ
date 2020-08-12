package com.yeongjin.service;

import com.yeongjin.persistence.JDBCUtil;
import com.yeongjin.persistence.UserTableDAO;

public class SignOutService {
	public boolean DeleteUserTable(String id, String pw) {
		boolean isDelete = false;
		UserTableDAO DAO = UserTableDAO.getInstance();
		int Cnt = DAO.deleteUserTable(id, pw);
		
		if(Cnt > 0) {
			JDBCUtil.getInstance().commit(DAO.conn);
			isDelete = true;
		}else {
			JDBCUtil.getInstance().Rollback(DAO.conn);
		}
		JDBCUtil.getInstance().ConnClose(DAO.conn);
		return isDelete;
	}
}
