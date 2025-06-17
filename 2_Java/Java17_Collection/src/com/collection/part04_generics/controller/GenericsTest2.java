package com.collection.part04_generics.controller;

public class GenericsTest2<T> { // 클래스에 제네릭스 설정. 보통 T, V, K 사용. 대문자!
	private T[] array;	//T 타입으로 배열 선언
	
	public GenericsTest2() {}
	
	public GenericsTest2(T[] array) {
		this.array = array;
	}
	public void prn() {
		for(T tmp : array) {
			System.out.println(tmp);
		}
	}
}
