package com.poly.part00_test.test03;

//인터페이스
//인터페이스 안에는 무조건 추상 메소드만.
//추상 클래스안에는 일반 메소드 가능.
public interface Animal {
//	/*static final*/ String name = "a"; // 일반 변수처럼 보이지만, 앞에 static void가 생략됨. 상수는 선언이 가능하지만 일반 변수는 선언 불가.
	public abstract void bark();
	void eat(String str);
//	public void test() {
//	          일반 메소드 불가.	
//	}
//	public static void test() {
//		// static 붙으면 허용해주긴 함.
//	}
	
}
