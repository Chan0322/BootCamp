package com.lv3;

import java.util.Scanner;

public class Lv3_Bj10 {
	public static void main(String[] args) {
		revStar();
	}
	
	public static void revStar() {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for(int i=0; i<n; i++) {
			for(int j=1; j<n-i; j++) {
				System.out.print(" ");
			}
			for(int k=0; k<=i; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
