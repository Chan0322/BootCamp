package com.collection.silsub2.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.collection.silsub2.model.dao.BookDao;
import com.collection.silsub2.model.vo.Book;

public class BookManager {
	private BookDao bd = new BookDao();
	private Scanner sc = new Scanner(System.in);
	
	public BookManager() {}
	public void addBook(Book book) {
		try {
			book.setBNo(bd.getLastBookNo()+1);
		} catch (IndexOutOfBoundsException e) {
			book.setBNo(1);
		}
		bd.addBook(book);
	}
	public int deleteBook(int no) {
		return 0;
	}
	public int searchBook(String title) {
		return 0;
	}
	public Book selectBook(int index) {
		return null;
	}
	public ArrayList<Book> selectAll(){
		return null;
	}
	public Book[] sortedBookList() {
		for(Book b : bd.sortedBookList()) {
			
		}
		return null;
	}
	public void printBookList(Book[] br) {}
}
