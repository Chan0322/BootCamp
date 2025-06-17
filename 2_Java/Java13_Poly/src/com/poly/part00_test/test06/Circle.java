package com.poly.part00_test.test06;

import java.util.Scanner;

public class Circle extends AreaImpl {

	@Override
	public void make() {
		Scanner sc = new Scanner(System.in);
		System.out.print("반지름: ");
		int r = sc.nextInt();
		
		double res = Math.PI * r * r;
//		super.setResult(res+""); // String 타입으로 변환
		super.setResult(String.format("%f", res)); // %.2f = double 타입의 소수점 2째 자리까지 format에 맞는 String 값으로 리턴
	}

	@Override
	public void print() {
		System.out.print("원의 ");
		super.print();
	}
}
