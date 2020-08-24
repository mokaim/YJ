package com.yeongjin.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserTable {
	private String ID;
	private String PW;
	private String NName; // �땳�꽕�엫
	private String Phone;
	private String Email;

}
