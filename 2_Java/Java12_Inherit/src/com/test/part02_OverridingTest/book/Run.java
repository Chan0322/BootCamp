package com.test.part02_OverridingTest.book;

public class Run {

	public static void main(String[] args) {
		Book b1 = new Book("안녕하세요", "김창진", 10000);
		Book b2 = new Book("Hello", "박창진", 20000);
		
		System.out.println("b1 = " + b1);
		System.out.println("b2 = " + b2);
		
//		System.out.println("b1 = " + b1.toString());
//		System.out.println("b2 = " + b2.toString());
		//그냥 변수만 입력해도 알아서 toString이 되므로 훨씬 편해짐.
		
		System.out.println("b1과 b2가 같나? : " + b1.equals(b2));
		
		Book b3 = b1;
		System.out.println("b1과 b3가 같나? : " + b1.equals(b3));
		
		Book b4 = new Book("안녕하세요", "김창진", 10000);
		System.out.println("b1과 b4가 같나? : " + b1.equals(b4));
		//b1과 값이 동일 객체 b4는 false
		// 2개의 공간이 다른 공간이 할당되므로 둘은 다름.
		System.out.println(b1.hashCode());
		System.out.println(b4.hashCode());
		
		//주소값은 다르지만 값이 같은 객체 동등하다라 한다.
		//주소값까지 완전히 같으면 동일 객체.
		//equals()의 값이 true인데 hashcode()가 다르면
		//다른 객체로 취급될 수 있다.
		//그래서 hashcode()도 overriding 해줘야 한다.
	}

}
