package com.test01.recu;

public class Euclid {

	// 유클리드 호제법 = 최대 공약수 구함.
	// 유클리드 호제법 : 두 수의 최대 공약수를 구하는 알고리즘
	
	public static void main(String[] args) {
		int gcd = euclid(20, 8);
		System.out.println("최대공약수: "+gcd);
	}
	public static int euclid(int no1, int no2) {
		if(no2 == 0) {
			return no1;
		}else {
			return euclid(no2, no1%no2);
		}
	}
}
