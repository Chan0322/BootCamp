package com.test04;

public class Student implements Person {

	@Override
	public String classWork() {
		System.out.println("qr을 찍는다.");
		return "스프링";
	}

}
