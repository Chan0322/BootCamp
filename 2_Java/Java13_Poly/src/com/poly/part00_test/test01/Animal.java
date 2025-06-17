package com.poly.part00_test.test01;

//추상 클래스
public abstract class Animal {
	
	//추상 메소드는 상속 받는 class가 반드시 구현.
	public abstract void bark(); // 추상메소드는 선언부만 존재. 추상 메소드가 없어도 추상 클래스 선언 가능.
	
	public void eat(String str) {
		System.out.println(str + " 먹는다.");
	}
}
