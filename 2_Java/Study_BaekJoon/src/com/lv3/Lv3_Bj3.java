package com.lv3;

import java.util.Scanner;

public class Lv3_Bj3 {

	public static void main(String[] args) {
		plusTest();
	}

	public static void plusTest() {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int sum = 0;
		for(int i=1; i<=n; i++) {
			sum+=i;
		}
		System.out.println(sum);
	}
}
