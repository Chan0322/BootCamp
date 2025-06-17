package com.test.chap05_method.test02;

public class MethodTest {
	//매개변수, 반환값에 따른 메소드 구분
	
	//1. 매개변수X, 반환값X
	public void method1() {
		System.out.println("매개변수와 반환값이 없는 메소드");
//		return; // 모든 void 메소드에는 return이 생략되어 있다고 생각하자. return을 작성해도 문제 없음.
	}
	
	//2. 매개변수X, 반환값O
	public String method2() {
		return "매개변수 없고 반환값 있는 메소드";
	}
	
	//3. 매개변수O, 반환값X
	public void method3(int num1, int num2) {
		int sum = num1 + num2;
		System.out.println("sum: " + sum);
//		return;
	}
	
	//4. 매개변수O, 반환값O
	public int method4(int num1, int num2) {
		return num1+num2; // 다른타입의 데이터는 그냥 return 불가. 형 변환으로 int 타입으로 만들어야 한다. 'a'와 같은 문자는 자동 형변환이 되므로 가능.
	}
}
