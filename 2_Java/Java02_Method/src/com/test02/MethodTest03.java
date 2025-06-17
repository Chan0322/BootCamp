package com.test02;

import com.test01.MethodTest01;

public class MethodTest03 /*extends MethodTest01*/{
	public static void main(String[] args) {
		/*com.test01.*/MethodTest01.publicMethod(); // 다른 패키지의 메소드를 가져오기 위해 import 필요.
		//MethodTest01.protectedMethod(); // 프로텍티드의 경우 다른 패키지에서는 상속할 경우 사용 가능.
		//MethodTest01.defaultMethod();
		//MethodTest01.privateMethod();
		
	}
}
