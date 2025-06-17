package com.test02.model.vo;

public class Person {
	//필드
	private String name;
	private int age;
	private int wealth;
	
	//생성자(기본, 매개변수)
	public Person() {}
	public Person(String name, int age, int wealth) {
		this.name = name;
		this.age = age;
		this.wealth = wealth;
	}
	
	//get&set
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getWealth() {
		return wealth;
	}
	public void setWealth(int wealth) {
		this.wealth = wealth;
	}
	
	//info(필드값 문자열로 리턴)
	public String info() {
		return "name: " + name + ", age: " + age + ", wealth: " + wealth;
	}
}
