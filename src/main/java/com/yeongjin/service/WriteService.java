package com.yeongjin.service;

import javax.servlet.http.HttpSession;

import com.yeongjin.domain.WriteDTO;
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
	
	public boolean WriteInsert(WriteDTO writeDTO) {		
		WriteTableDAO writeDAO = WriteTableDAO.getinstance();
		
		
		int userNumber = writeDAO.getUserNumber(writeDTO.getWriter());
		int postNumber = writeDAO.getCountPost();
		
		String date = writeDAO.getDate();
		
		writeDTO.setUserNumber(userNumber);
		writeDTO.setPostNumber(postNumber);
		writeDTO.setLikes(0);
		writeDTO.setHate(0);
		writeDTO.setVisit(0);	
		writeDTO.setPosted_date(date);

		
		
				
		
		
		
		boolean isInsert = false;			
		int Cnt = writeDAO.insertWriteTable(writeDTO);
		
		if(Cnt > 0) {

			JDBCUtil.getInstance().commit(writeDAO.conn);
			isInsert = true;
			

		}else {
			
			JDBCUtil.getInstance().commit(writeDAO.conn);
		}
		
		
		return isInsert;
	}
}
