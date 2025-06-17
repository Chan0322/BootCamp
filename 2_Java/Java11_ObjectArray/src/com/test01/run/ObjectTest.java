package com.test01.run;

import java.util.Scanner;

import com.test01.model.Book;

public class ObjectTest {
	public static void main(String[] args) {
//		Book b1 = new Book();
		
//		System.out.println(b1.info()); // 초기화 전이므로, 비어있음.
		
		Book b1 = new Book("안녕하세요", "이창진", "나무", 10000);
		Book b2 = new Book("프로그래밍", "김창진", "mul", 15000);
		Book b3 = new Book("잘가세요", "박창진", "multi", 20000);
		Book b4 = new Book("Hello", "choi", "apple", 25000);
		Book b5 = new Book("NICE", "robert", "banana", 30000);
		
		System.out.println(b1.info());
		System.out.println(b2.info());
		System.out.println(b3.info());
		System.out.println(b4.info());
		System.out.println(b5.info());
		
		//도서 검색
		Scanner sc = new Scanner(System.in);
		System.out.println("검색할 책 제목: ");
		String searchTitle = sc.nextLine();
		
		if(b1.getTitle().equals(searchTitle)) {
			System.out.println(b1.info());
		}else if(b2.getTitle().equals(searchTitle)) {
			System.out.println(b2.info());
		}else if(b3.getTitle().equals(searchTitle)) {
			System.out.println(b3.info());
		}else if(b4.getTitle().equals(searchTitle)) {
			System.out.println(b4.info());
		}else if(b5.getTitle().equals(searchTitle)) {
			System.out.println(b5.info());
		}else {
			System.out.println("검색하는 책이 없습니다.");
		} // 이런 식으로 작성해서 관리하려면 힘들다. 
	}
}
