package com.lv2;

import java.util.Scanner;

public class Lv2_Bj1 {

	public static void main(String[] args) {
		compareTest();
	}

	public static void compareTest() {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		if(A>B) {
			System.out.println(">");
		}else if(A<B) {
			System.out.println("<");
		}else {
			System.out.println("==");
		}
	}
}
