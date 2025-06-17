package com.test01;

public class MethodTest01 {
	public static void main(String[] args) {
		//static 메소드 실행
		//클래스명.메소드명();
		MethodTest01.publicMethod();
		MethodTest01.protectedMethod();
		MethodTest01.defaultMethod();
		privateMethod(); // 다른 클래스에 중복되는 메소드 명이 없다면, 클래스 명 생략 가능. 그러나 클래스명 붙이는게 좋음.
		
		//nonStaticMethod 실행
		//클래스명 변수명 = new 클래스명();
		//변수명.메소드명();
		MethodTest01 mt = new MethodTest01();
		mt.NonStaticMethod();
	}
	
	//접근제한자
	
	//어디서나 누구나 접근, 참조 가능하다. (+)		+test1();   <= 퍼블릭으로 테스트 1이라는 이름의 메소드.
	public static void publicMethod() {
		System.out.println("public method");
	}
	
	//상속일 경우 상속된 곳에서
	//상속이 아닐 경우 같은 패키지 안에서 접근, 참조 가능하다. (#)
	protected static void protectedMethod() {
		System.out.println("protected method");
	}
	
	//같은 패키지 안에서 접근, 참조 가능하다. (default) 앞에 그냥 비워놓으면 됨.
	static void defaultMethod() {
		System.out.println("default method");
	}
	
	//현재 클래스 안에서만 접근, 참조 가능하다.
	private static void privateMethod() {
		System.out.println("private method");
	}
	
	//위에는 static이 있어서 다 프로그램 실행과 동시에 준비.
	//static이 없으면 코드상으로 준비해둬야 실행 가능.
	public void NonStaticMethod() {
		System.out.println("nonStatic method");
	}
	
	// private int a;
}
