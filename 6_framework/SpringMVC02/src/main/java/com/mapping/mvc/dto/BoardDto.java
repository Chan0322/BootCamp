package com.mapping.mvc.dto;

public class BoardDto {
	private int no;
	private String writer;
	private String title;
	private String content;
	
	public BoardDto() {}

	public BoardDto(int no, String writer, String title, String content) {
		super();
		this.no = no;
		this.writer = writer;
		this.title = title;
		this.content = content;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
	
}
