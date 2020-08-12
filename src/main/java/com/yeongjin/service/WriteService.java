package com.yeongjin.service;

import com.yeongjin.domain.WriteTable;
import com.yeongjin.persistence.JDBCUtil;
import com.yeongjin.persistence.UserTableDAO;
import com.yeongjin.persistence.WriteTableDAO;

public class WriteService {	
	private UserTableDAO userDAO = UserTableDAO.getInstance();
	
	public String getNName(String id) {	
		String nname = userDAO.selectUserNName(id);
		return nname;
	}
	
	public boolean WriteInsert(WriteTable writeTable) {		
		WriteTableDAO WriteDAO = WriteTableDAO.getinstance();
		
		boolean isInsert = false;			
		int Cnt = WriteDAO.insertWriteTable(writeTable);
		
		if(Cnt > 0) {
			JDBCUtil.getInstance().commit(WriteDAO.conn);
			isInsert = true;
		}else {
			JDBCUtil.getInstance().commit(WriteDAO.conn);
		}
		JDBCUtil.getInstance().ConnClose(WriteDAO.conn);
		return isInsert;
	}
}
