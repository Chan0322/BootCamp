package com.test01.run;

import java.util.Scanner;

import com.test01.model.Book;

public class ObjectArrayTest {

	public static void main(String[] args) {
		int[] arr = new int[5];
		
		Book b1 = new Book("NICE", "robert", "banana", 30000);
		
		//객체 배열
		Book[] b = new Book[5];
		b[0] = new Book("안녕하세요", "이창진", "나무", 10000);
		b[1] = new Book("프로그래밍", "김창진", "mul", 15000);
		b[2] = new Book("잘가세요", "박창진", "multi", 20000);
		b[3] = new Book("Hello", "choi", "apple", 25000);
		b[4] = new Book("NICE", "robert", "banana", 30000);
		
		Book[] bk = {
						new Book("안녕하세요", "이창진", "나무", 10000),
						new Book("프로그래밍", "김창진", "mul", 15000),
						new Book("잘가세요", "박창진", "multi", 20000),
						new Book("Hello", "choi", "apple", 25000),
						b1
					};
		System.out.println(bk); // bk => 참조형, Book[]  Book클래스 타입의 배열을 가리킴.  베열의 주소값이 출력됨.
		System.out.println(bk[1]); // bk[idx] => 참조형, Book 객체.
		System.out.println(bk[1].getPrice()); // bk[idx].getPrice() => 정수(기본자료형), int
		
		Scanner sc = new Scanner(System.in);
		System.out.print("검색할 제목: ");
		String searchTitle = sc.nextLine();
		
		for(int i=0; i<bk.length; i++) {
			if(bk[i].getTitle().equals(searchTitle)) {
				System.out.println(bk[i].info());
			}
		}
	}

}
