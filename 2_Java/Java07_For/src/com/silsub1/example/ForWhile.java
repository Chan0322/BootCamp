package com.silsub1.example;

import java.util.Scanner;

public class ForWhile {
	Scanner sc = new Scanner(System.in);
	
	public void printStar1(){
		System.out.print("정수 하나 입력: ");
		int no = sc.nextInt();
		
		if(no>=0) {
			for(int i=0; i<no; i++) {
				for(int j=0; j<no; j++) {
					if(i==j) {
						System.out.print(i+1);
					}else if(j<i) {
						System.out.print("*");
					}
				}
				System.out.println();
			}
		}else {
			System.out.println("양수가 아닙니다.");
		}
	}

	public void printStar2() {
		System.out.print("정수 입력: ");
		int no = sc.nextInt();
		if(no>0) {
			for(int i=0; i<no; i++) {
				for(int j=0; j<no; j++) {
					if(i<=j) {
						System.out.print("*");
					}
				}
				System.out.println();
			}
		}else if(no<0) {
			for(int i=0; i<(-no); i++) {
				for(int j=(-no); j>i; j--) {
					if(i<=j) {
						System.out.print("*");
					}
				}
				System.out.println();
			}
			
		}else {
			System.out.println("출력 기능이 없습니다.");
		}
	}
	
	public void countInputCharacter() {
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열 하나 입력: ");
		String str = sc.next();
		System.out.print("문자 하나 입력: ");
		char ch = sc.next().charAt(0);
		
		int cnt = 0;
		/*
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) == ch) {
				cnt++;
			}
		}
		*/
		char carr[] = str.toCharArray(); // String을 Char 배열로 바꿔서 반환해주는 함수.
		for(int i=0; i<carr.length; i++) {
			if(carr[i] == ch) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
	
	public void exc1() {
		int cnt = 1;
		int sum=0;
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if(i==j || i+j==4) {
					sum += cnt;
				}
				System.out.print(cnt + " ");
				cnt++;
			}
			System.out.println();
		}
		System.out.println("sum: " + sum);
	}
}
