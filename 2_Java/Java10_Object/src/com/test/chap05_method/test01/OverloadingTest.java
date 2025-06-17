package com.test.chap05_method.test01;

public class OverloadingTest {
//	public void test() {
//		System.out.println(1);
//		System.out.println('a');
//		System.out.println("b");
//		
//	}
	
	public int test() {
		return 0;
	}
	public int test(int a) {
		return 0;
	}
	public int test(int a, int b) {
		return 0;
	}
	public int test(int b, String s) {// 타입이 다르다면, 매개변수의 갯수가 같아도 된다.
		return 0;
	}
	
	//오버로딩에서 매개변수의 이름은 상관 없다. 타입, 갯수만 따짐.
	//매개변수의 갯수, 순서, 타입이 달라야 한다.
//	public int test(int b, int a) {
//		return 0;
//	}
	
	public int test(String b, int s) {
		return 0;
	}
	
	//static, final 키워드는 오버로딩에 영향X.
//	public final int test(String b, int a) {
//		return 0;
//	}
	
	public String test(int a, int b, String s) {
		return null;
	}
	
	//반환형 상관 없음. 매개변수의 타입만 보고 있다.
	//리턴 타입이 다르다고 오버로딩이 적용되지 않는다.
//	public int test(int a, int b, String s) {
//		return 0;
//	}
	
	// 접근제한자가 다르다고 오버로딩이 적용되지 않는다. 매개변수의 타입, 순서, 갯수만 보고 있다.
//	private String test(int a, int b, String s) {
//		return null;
//	}
	
	
	// 오버로딩과 오버라이딩(오버라이드)는 다르다.
}
