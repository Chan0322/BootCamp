package com.lv3;

import java.util.Scanner;

public class Lv3_Bj1 {

	public static void main(String[] args) {
		mulTest();
	}
	
	public static void mulTest() {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for(int i=1; i<10; i++) {
			System.out.println(n + " * " + i + " = " + n*i);
		}
	}

}
