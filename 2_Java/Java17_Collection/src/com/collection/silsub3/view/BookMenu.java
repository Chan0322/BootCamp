package com.collection.silsub3.view;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import com.collection.silsub3.controller.BookManager;
import com.collection.silsub3.model.vo.Book;

public class BookMenu {
	Scanner sc = new Scanner(System.in);
	private BookManager bm = new BookManager();
	
	public BookMenu() {}
	
	public void mainMenu() {
		while(true) {
			System.out.println("*** 도서 관리 프로그램 ***");
			System.out.println("1. 새 도서 추가");
			System.out.println("2. 도서정보 정렬 후 출력");
			System.out.println("3. 도서 삭제");
			System.out.println("4. 도서 검색출력");
			System.out.println("5. 전체 출력");
			System.out.println("6. 끝내기");
			System.out.print("메뉴 번호 선택: ");
			int n = sc.nextInt();
			sc.nextLine();
			
			switch (n) {
			case 1:
				bm.addBook(inputBook());
				break;
			case 2:
				bm.printBookList(bm.sortedBookList());
				break;
			case 3:
				Book res = bm.deleteBook(inputBookNo());
				if(res != null) {
					System.out.println("성공적으로 삭제");
				}else {
					System.out.println("삭제할 글이 존재하지 않음");
				}
				break;
			case 4:
				String key = bm.searchBook(inputBookTitle());
				if(key == null) {
					System.out.println("조회한 글이 존재하지 않음");
				}else {
					System.out.println(bm.selectBook(key));
				}
				break;
			case 5:
				HashMap<String, Book> map = bm.selectAll();
				Iterator<String> i = map.keySet().iterator();
				if(!i.hasNext()) {
					System.out.println("없습니다.");
				}else {
					while(i.hasNext()) {
						Book book = map.get(i.next());
						System.out.println(book);
					}
				}
				break;
			case 6:
				return;
			}
		}
	}
	
	public Book inputBook() {
		System.out.print("도서 제목: ");
		String title = sc.nextLine();
		System.out.print("도서 장르 (1:인문 / 2:자연과학 / 3.의료 / 4.기타) : ");
		int category = sc.nextInt();
		sc.nextLine();
		System.out.print("도서 저자: ");
		String author = sc.nextLine();
		return new Book(category, title, author);
	}
	
	public String inputBookNo() {
		System.out.print("도서 번호: ");
		String bNo = sc.nextLine();
		return bNo;
	}
	
	public String inputBookTitle() {
		System.out.print("도서 제목: ");
		String title = sc.nextLine();
		return title;
	}
	
}
