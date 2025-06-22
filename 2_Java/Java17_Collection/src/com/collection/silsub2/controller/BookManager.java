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
			int lastNum = bd.getLastBookNo();
			book.setBNo(lastNum+1);
//			book.setBNo(bd.getLastBookNo()+1);
		} catch (IndexOutOfBoundsException e) {
			book.setBNo(1);
		}
		bd.addBook(book);
	}
	
	public int deleteBook(int no) {
		int res = bd.deleteBook(no);
		return res;
	}
	
	public int searchBook(String title) {
		int index = bd.searchBook(title);
		return index;
	}
	
	public Book selectBook(int index) {
		Book res = bd.selectBook(index);
		return res;
	}
	
	public ArrayList<Book> selectAll(){
		ArrayList<Book> res = bd.selectAll();
		return res;
	}
	
	public Book[] sortedBookList() {
		ArrayList<Book> sortedList = bd.sortedBookList();
		Book[] bArr = new Book[sortedList.size()];
		for(int i=0; i<bArr.length; i++) {
			bArr[i] = sortedList.get(i);
		}
		return bArr;
	}
	
	public void printBookList(Book[] br) {
		for(Book b : br) {
			System.out.println(b);
		}
	}
}
