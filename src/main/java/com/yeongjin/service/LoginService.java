package com.yeongjin.service;

import com.yeongjin.persistence.JDBCUtil;
import com.yeongjin.persistence.UserTableDAO;

public class LoginService {
	public boolean loginCheck(String id, String pw) {
		boolean isLogin = false;
		
		isLogin = UserTableDAO.getInstance().LoginUser(id, pw);

		return isLogin;
	}
}
