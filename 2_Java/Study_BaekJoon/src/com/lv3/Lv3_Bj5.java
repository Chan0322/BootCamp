package com.lv3;

import java.util.Scanner;

public class Lv3_Bj5 {

	public static void main(String[] args) {
		byteTest();
	}

	public static void byteTest() {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		String str = "long ";
		
		for(int i=0; i<(N/4); i++) {
			System.out.print("long ");
		}
		System.out.println("int");
	}
}
