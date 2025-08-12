package com.study;

public class House {
	String type;
	// 생성자는 오버로딩이 가능하다.
	// 오버로딩 시, 생성자의 이름은 같게 하고, 매개변수의 개수나 타입은 달라야 한다!
	public House() {
		this.type = "기본형";
	}
	public House(String type) {
		this.type = type;
	}
}



//public class House {
//	// 생성자의 이름은 클래스의 이름과 동일하다.
//	public House() {
//		System.out.println("기본 생성자로 집 짓기.");
//	}
//}
