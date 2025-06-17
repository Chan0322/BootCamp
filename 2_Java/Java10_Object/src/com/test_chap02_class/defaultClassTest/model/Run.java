package com.test_chap02_class.defaultClassTest.model;

//import com.test_chap02_class.defaultClassTest.model.DefaultClassTest;    // default로 선언된 클래스는 다른 패키지에서 사용할 수 없다. 같은 패키지 내부에서만 사용 가능.

public class Run {

	public static void main(String[] args) {
		// 객체 생성
		DefaultClassTest d = new DefaultClassTest();
		d.test();
		
		//default 클래스는 패키지 외부에서 접근이 불가능.
	}

}
