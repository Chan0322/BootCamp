package com.test.part00_test.bbb;

import com.test.part00_test.aaa.AAA;

public class BBB extends AAA {
	private int b;
	
	public BBB() {
		System.out.println("BBB 생성()");
	}
	public BBB(int b) {
//		super(); 생략되어 있음. 생략해도 알아서 자동으로 생성된다.
		super(b); // 이렇게 작성될 경우, 부모의 기본 생성자가 아닌 매개변수 있는 생성자가 실행.
		System.out.println("BBB 생성(b)");
		this.b = b;
	}
	public BBB(int no, int b) {
//		super.setNo(no);
		super(no);
		this.b = b;
		System.out.println("BBB 생성(no, b");
	}
	
	//getter & setter
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	
	public int getSum() {
		int sum = this.getB() + super.getNo(); // this와 super 키워드로 부모 클래스 객체인지, 본인 클래스 객체인지 구분할 수 있으며, 생략도 가능하다. 구분시켜주는게 좋긴 할듯
		return sum;
	}
	
	// 오버라이딩.
	@Override
	public void prn() {
		System.out.println("BBB의 prn()");
	}
}
