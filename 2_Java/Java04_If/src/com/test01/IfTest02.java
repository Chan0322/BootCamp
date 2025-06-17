package com.test01;

import java.util.Scanner;

public class IfTest02 {
	// else if : 다중 조건을 줄 수 있는 문법
	public void testElseIf1() {
		int no = 10;
		//----------------------------------------
		if(no != 0) {
			//0아니면 양수 음수 출력
			if(no>0) {
				System.out.println("양수입니다.");
			}else {
				System.out.println("음수입니다.");
			}
		}
		
		//if를 만족하고, 그 안의 if문도 만족해야 함. => 둘 다 만족해야 함.
		//-----------------------------------------
		if(no != 0) {
			
		}else if(no>0) {
			System.out.println("양수입니다.");
			System.out.println("음수입니다.");
		}
		//if를 만족하지 않으면 else if를 실행.
		//-----------------------------------------
		
		int i=10, j=20;
		
		if(i>j) {
			System.out.println("i가 j보다 크다.");
		}else if(i==j) {
			System.out.println("i와 j는 같다.");
		}else {
			System.out.println("i가 j보다 작다.");
		}
		
	}
	
	public void testElseIf2() {
		//점수 하나를 입력 받아서 등급을 나누어 점수와 등급을 출력.
		// 90이상 A
		// 90미만 80이상 B
		// 80미만 70이상 C
		// 70미만 60이상 D
		// 60미만 F
		
		Scanner sc = new Scanner(System.in);
		System.out.println("점수: ");
		int score = sc.nextInt();
		char grade = ' '; // 자바에서 문자열이 아닌 문자형식에서는 공백을 넣어줘야 인식.
//		String str = "";
		
		if(score >= 90) {
			grade = 'A';
		}else if(/*score<90 && */score>=80) { // 90보다 크지 않아서 내려온 것이기 때문에 생략 가능.
			grade = 'B';
		}else if(/*score<80 && */score>=70) {
			grade = 'C';
		}else if(/*score<70 && */score>=60) {
			grade = 'D';
		}else {
			grade = 'F';
		}
		System.out.printf("당신의 점수는 %d 이고, 등급은 %c입니다.", score, grade);
	}
	
	public void testElseIf03() {
		//testElseIf2에서
		//각 등급별 중간 점수 이상의 경우에는
		//등급에 +라는 문자를 추가하여 출력
		//95이상은 A+
		//85이상은 B+
		Scanner sc = new Scanner(System.in);
		System.out.println("점수: ");
		int score = sc.nextInt();
		String grade = ""; // 자바에서 문자열이 아닌 문자형식에서는 공백을 넣어줘야 인식.
//		String str = "";
		
		if(score >= 90) {
			grade = "A";
			if(score>=95) {
				grade+="+";
			}
		}else if(/*score<90 && */score>=80) { // 90보다 크지 않아서 내려온 것이기 때문에 생략 가능.
			if(score>=85) {
				grade = "B+";
			}else {
				grade = "B";
			}
		}else if(/*score<80 && */score>=70) {
			grade = "C";
			if(score>=75) {
				grade+="+";
			}
		}else if(/*score<70 && */score>=60) {
			grade = "D";
			if(score>=65) {
				grade+="+";
			}
		}else {
			grade = "F";
		}
		System.out.printf("당신의 점수는 %d 이고, 등급은 %s입니다.", score, grade);
		
		System.out.println(score%10); // 1의자리 숫자 판단 가능.
		
		if(score >= 90) {
			grade = "A";
		}else if(/*score<90 && */score>=80) { // 90보다 크지 않아서 내려온 것이기 때문에 생략 가능.
			grade = "B";
		}else if(/*score<80 && */score>=70) {
			grade = "C";
		}else if(/*score<70 && */score>=60) {
			grade = "D";
		}else {
			grade = "F";
		}
		
		if(score%10>=5) {
			grade+="+";
		}
		System.out.printf("당신의 점수는 %d 이고, 등급은 %s입니다.", score, grade);
	}
}
