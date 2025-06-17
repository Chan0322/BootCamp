package com.test.chap05_method.test02;

public class Run {
	// ctrl + space : 무적, 기적, 자동완성 가능. ex) main입력 + ctrl + space
	public static void main(String[] args) {
		MethodTest mt = new MethodTest();
		
		//각종의 메소드 호출(실행)
		
		//1. 매개변수X, 반환값X 메소드 실행
		mt.method1();
		
		//2. 매개변수X, 반환값O 메소드 살행
		String str = mt.method2();
		System.out.println(str);
		
		//3. 매개변수O, 반환값X 메소드 실행
		mt.method3(10, 20);
		
		//4. 매개변수O, 반환값O 메소드 실행
		System.out.println("res: " + mt.method4(20, 30));
		
		mt.method3(mt.method4(20, 30), mt.method4(10, 20));
		
//		mt.method3(50, 30);
		
		
		//static 메소드 실행
		//클래스명.메소드명();
		StaticMethodTest.staticMethod1();
		System.out.println("res: " + StaticMethodTest.staticMethod2());
		StaticMethodTest.staticMethod3("이창진");
		System.out.println(StaticMethodTest.staticMethod4(str));
	}

}
