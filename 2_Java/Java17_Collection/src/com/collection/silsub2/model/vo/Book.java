package com.collection.silsub2.model.vo;

public class Book {
	private int bNo;
	private int category;
	private String title;
	private String author;
	
	public Book() {}
	public Book(int category, String title, String author) {
		this.category = category;
		this.title = title;
		this.author = author;
	}
	
	public int getBNo() {
		return bNo;
	}
	public void setBNo(int bNo) {
		this.bNo = bNo;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	@Override
	public String toString() {
		return "[bNo=" + bNo + ", category=" + category + ", title=" + title + ", author=" + author + "]";
	}	
}
