package com.test01.model;

public class Book {
	// 필드
	private String title;
	private String writer;
	private String publisher;
	private int price;
	
	
	//생성자
	//기본 생성자
	public Book() {}
	
	//매개변수 생성자
	public Book(String title, String writer, String publisher, int price) {
		this.title = title;
		this.writer = writer;
		this.publisher = publisher;
		this.price = price;
	}
	//메소드
	//getter&setter
	public String getTitle() {
		return title;
	}
	public String getWriter() {
		return writer;
	}
	public String getPublisher() {
		return publisher;
	}
	public int getPrice() {
		return price;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	//필드 값을 확인할 수 있게 리턴해주는 메소드
	public String info() {
		String str = "title: " + title + ", writer: " + writer + ", publisher: " + publisher + ", price: " + price;
		return str;
	}
}
