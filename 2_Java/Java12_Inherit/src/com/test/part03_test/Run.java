package com.test.part03_test;

import com.test.part02_OverridingTest.book.Book;

public class Run {

	public static void main(String[] args) {
		Car c1 = new SUV("하얀");
		c1.accelPedal();
		System.out.println(c1.toString());
	}
	
//	Object obj = new SUV(); // 다형성. 단, 이 안에 어떤 객체가 있는지 정확히 파악하지 못하면 문제가 발생한다.
//	Book b = (Book)obj;

//	c1.bPedal();
}
