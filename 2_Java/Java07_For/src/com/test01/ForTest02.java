package com.test01;

import java.util.Scanner;

public class ForTest02 {

	public static void main(String[] args) {
//		testFor1();
//		testFor2();
//		testFor3();
		testFor4();
	}

	
	public static void testFor1() {
		for(int i=0; i<10; i++) {
			System.out.println(i+" : ");
			for(int j=0; j<10; j++) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}
	
	public static void testFor2() {
		//구구단(2~9)
		for(int i=2; i<10; i++) {
			System.out.println(i+" 단" );
			for(int j=1; j<10; j++) {
				System.out.println(i + "*" + j + "=" + (i*j));
			}
			System.out.println();
		}
	}
	
	public static void testFor3() {
		
//		for(int i=0; i<5; i++){
//			System.out.print("@");
//		}
//		System.out.println();
//		for(int i=0; i<5; i++){
//			System.out.print("@");
//		}
//		System.out.println();
//		for(int i=0; i<5; i++){
//			System.out.print("@");
//		}
//		System.out.println();
//		for(int i=0; i<5; i++){
//			System.out.print("@");
//		}
//		System.out.println();
//		for(int i=0; i<5; i++){
//			System.out.print("@");
//		}
//		System.out.println();
		
		
		for(int k=0; k<5; k++) {
			for(int i=0; i<5; i++) {
				System.out.print("@");
			}
			System.out.println();
		}
		System.out.println();
		
		int no = 1;
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				System.out.print(no+" ");
				no++;
			}
			System.out.println();
		}
	}
	
	public static void testFor4() {
		/*
		 * 1@@@@
		 * @2@@@
		 * @@3@@
		 * @@@4@
		 * @@@@5
		 * 
		 * 1@@@@@
		 * @2@@@@
		 * @@3@@@
		 * @@@4@@
		 * @@@@5@
		 * @@@@@6
		 * 
		 * 한줄에 @문자를 입력된 줄의 수와 칸의 수만큼 출력하자.
		 * */
		Scanner sc = new Scanner(System.in);
		
		System.out.print("줄 수: ");
		int row = sc.nextInt();
		System.out.print("칸 수: ");
		int col = sc.nextInt();
		
		for(int r=0; r<row; r++) {
			for(int c=0; c<col; c++) {
				if(r==c) {
					System.out.print(r+1);
				}else {
					System.out.print("@");	
				}
			}
			System.out.println();
		}
		
//		for(int r=1; r<=row; r++) {
//			for(int c=1; c<=col; c++) {
//				if(r==c) {
//					System.out.print(r);
//				}else {
//					System.out.print("@");	
//				}
//			}
//			System.out.println();
//		}
	}
}
