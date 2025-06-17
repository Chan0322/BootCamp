package com.poly.part00_test.test07;

public class Profile {
	private String name;
	private String phone;
	
	//매개변수 있는 생성자만 사용할 것이라면, 기본 생성자는 만들지 않아도 된다. 기본 생성자는 이용하지 않을 것임!
	public Profile(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}
	
	public void printProfile() {
		System.out.println("이름: " + name);
		System.out.println("전화번호: " + phone);
	}
}
