package com.study;

public class House {
	public static int houseSize(int size) {
		return size;
		// 접근 지정자 : public
		// 예약어 : static
		// 반환형 : int
		// 메서드명 : houseSize
		// 매개변수 : int size
	}
	
	public static void main(String[] args) {
		int size = 42;
		System.out.println("평수: " + houseSize(size));
	}
}
