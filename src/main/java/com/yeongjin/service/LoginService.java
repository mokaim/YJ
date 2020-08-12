package com.yeongjin.service;

import com.yeongjin.persistence.JDBCUtil;
import com.yeongjin.persistence.UserTableDAO;

public class LoginService {
	public boolean Login(String id, String pw) {
		boolean isLogin = false;
		
		isLogin = UserTableDAO.getInstance().LoginUser(id, pw);
		
		JDBCUtil.getInstance().ConnClose(UserTableDAO.getInstance().conn);
		return isLogin;
	}
}
