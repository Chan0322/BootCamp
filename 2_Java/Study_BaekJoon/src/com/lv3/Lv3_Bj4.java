package com.lv3;

import java.util.Scanner;

public class Lv3_Bj4 {
	public static void main(String[] args) {
		receipt();
	}
	
	public static void receipt() {
		Scanner sc = new Scanner(System.in);
		
		int X = sc.nextInt();
		
		int N = sc.nextInt();
		
		int sum = 0;
		for(int i=1; i<=N; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			sum += a*b;
		}
		if(X == sum) {
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}
	}
}
