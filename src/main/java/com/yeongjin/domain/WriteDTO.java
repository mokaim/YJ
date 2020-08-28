package com.yeongjin.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WriteDTO {

	
	private int userNumber;
	private int postNumber;
	private String writer;
	private String title;
	private String content;
	private int likes;
	private int hate;
	private int visit;
	private String posted_date;
	private String imageLocation;
	
	
	
}
