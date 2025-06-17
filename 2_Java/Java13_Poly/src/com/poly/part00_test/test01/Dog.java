package com.poly.part00_test.test01;

public class Dog extends Animal{

	@Override
	public void bark() {
		// 상속 받은 클래스에서 반드시 구현해야 함.
		System.out.println("멍멍");
	}
	
	@Override
	public void eat(String str) {
		System.out.print("강아지가 " );
		super.eat(str);
	}
}
