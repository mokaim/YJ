package com.yeongjin.domain;

public class WriteTable {
	private int Number;
	private String NName;
	private String Header;
	private String Content;
	private int Likes;
	private int Hate;
	private int Visit;
	
	public WriteTable(String nname, String header, String content) {
		this.NName = nname;
		this.Header = header;
		this.Content = content;
		Likes = 0;
		Hate = 0;
		Visit = 0;
	}
	// Getter Setter
	
	public String getNName() {
		return NName;
	}

	public int getNumber() {
		return Number;
	}

	public void setNumber(int number) {
		Number = number;
	}

	public void setNName(String nName) {
		NName = nName;
	}

	public String getHeader() {
		return Header;
	}

	public void setHeader(String header) {
		Header = header;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public int getLikes() {
		return Likes;
	}

	public void setLikes(int likes) {
		Likes = likes;
	}

	public int getHate() {
		return Hate;
	}

	public void setHate(int hate) {
		Hate = hate;
	}

	public int getVisit() {
		return Visit;
	}

	public void setVisit(int visit) {
		Visit = visit;
	}
}
