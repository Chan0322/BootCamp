package com.poly.part00_test.test03;

public class Cat implements Animal {

	@Override
	public void bark() {
		System.out.println("야옹");
	}

	@Override
	public void eat(String str) {
		System.out.println(str + " 먹는다.");
	}

}
