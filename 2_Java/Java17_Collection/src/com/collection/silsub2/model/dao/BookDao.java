package com.collection.silsub2.model.dao;

import java.util.ArrayList;

import com.collection.silsub2.model.comparator.AscCategory;
import com.collection.silsub2.model.vo.Book;

public class BookDao {
	private ArrayList<Book> bookList = new ArrayList<>();
	
	public BookDao() {}
	public BookDao(ArrayList<Book> list) {}
	public int getLastBookNo() {
		return bookList.get(bookList.size()-1).getBNo();
	}
	public void addBook(Book book) {
		bookList.add(book);
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
	public ArrayList<Book> sortedBookList(){
		bookList.sort(new AscCategory());
		return bookList;
	}
}
