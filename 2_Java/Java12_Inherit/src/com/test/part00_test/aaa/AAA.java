package com.test.part00_test.aaa;

public class AAA {
	private int no;
	
	//생성자
	public AAA() {
		System.out.println("AAA 생성");
	}
	public AAA(int no) {
//		super(); 상속 받지 않은 상태에서도 기본적으로 super()가 생략되어 있다. 클래스를 만들 때 이미 Object 클래스를 부모 클래스로 가짐.
		System.out.println("AAA 생성(no)");
		this.no = no;
	}
	
	//getter&setter
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public void prn() {
		System.out.println("AAA의 prn메소드");
	}
}
