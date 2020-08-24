package com.yeongjin.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	
	private int userNumber;
	private String userName;
	private String email;	
	private String pw;
	private String pw2;
	
}
