package com.yeongjin.service;

import com.yeongjin.domain.WriteDTO;
import com.yeongjin.persistence.JDBCUtil;
import com.yeongjin.persistence.WriteTableDAO;

public class WriteImageService {
	
	
	public boolean writeImageInsert(WriteDTO writeDTO) {
		
		boolean isfaild = false;
		
		WriteTableDAO writeTableDAO = WriteTableDAO.getinstance();
		
		int result = writeTableDAO.insertImage(writeDTO);
		
		if(result > 0) {
			
			JDBCUtil.getInstance().commit(writeTableDAO.conn);
			isfaild = true;
		}
		
		JDBCUtil.getInstance().ConnClose(writeTableDAO.conn);

		return isfaild;
	}
	
	
	
	

}
