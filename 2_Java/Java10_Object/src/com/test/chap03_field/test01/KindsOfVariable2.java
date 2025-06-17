package com.test.chap03_field.test01;

public class KindsOfVariable2 {

	public static int staticNum; // 메소드 내부에서는 static을 선언하면 안된다. 클래스 필드 내부에서 가능.
	
	public final int num = 1; // 필드 내부의 final은 초기화 과정이 필요.
	
	//public 접근 제한자에 static, final 키워드 함께 사용하는 필드
	//'상수필드'
	public static final int STATIC_NUM = 1;
	public final static int STATIC_NUM2 = 2; // static과 final 순서가 바뀌어도 상관없음.
	
	public void methodTest() {
//		static int localStaticNum;
		final int localFinalNum;
		
	}
	public static void methodTest2() {
//		static int localStaticNum;
		final int localFinalNum;
		// 메소드가 실행될 때 지역변수들이 만들어지고, 스택 영역에 공간이 할당된다.
		// 그런데, static은 프로그램이 실행 될 때 만들어져야 하므로, 메소드 내부에서는 선언 불가.
	}
}
