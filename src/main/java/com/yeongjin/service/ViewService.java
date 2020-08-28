package com.yeongjin.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.yeongjin.domain.WriteDTO;
import com.yeongjin.persistence.WriteTableDAO;

public class ViewService {
	
	public List<WriteDTO> getViewService(int postNumber){
		
		WriteTableDAO writeTableDAO = WriteTableDAO.getinstance();
		
		List<WriteDTO> view = Optional.ofNullable(writeTableDAO.getViewList(postNumber))
				.filter(o -> o != null).orElseGet(() -> {
					
					return new ArrayList<>();
				});
		
		return view;
		
		
	}

}
