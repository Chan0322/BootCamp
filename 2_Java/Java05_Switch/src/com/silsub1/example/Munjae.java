package com.silsub1.example;

import java.util.Scanner;

public class Munjae {
	//문제1
	public void test1() {
		Scanner sc = new Scanner(System.in);
		System.out.println("점수를 입력하세요");
		System.out.print("국어: ");
		int kor = sc.nextInt();
		System.out.print("영어: ");
		int eng = sc.nextInt();
		System.out.print("수학: ");
		int math = sc.nextInt();
		
		int sum = kor + eng + math;
		double avg = sum/3;
		
		if(kor>=40 && eng>=40 && math>=40 && avg>=60) {
			System.out.println("합격입니다.");
			System.out.println("국어:"+kor+"점, 영어:"+eng+"점, 수학:"+math+"점, 합계:"+sum+"점, 평균:"+avg+"점");
		}else {
			System.out.println("불합격.");
		}
	}
	
	//문제2
	public void test2() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("*** 초기 메뉴 ***");
		System.out.println("1. 입력");
		System.out.println("2. 수정");
		System.out.println("3. 조회");
		System.out.println("4. 삭제");
		System.out.println("7. 종료");
		System.out.print("메뉴번호 입력: ");
		
		int n = sc.nextInt();
		
		switch(n) {
		case 1:
			System.out.println("입력메뉴가 선택되었습니다.");
			break;
		case 2:
			System.out.println("수정메뉴가 선택되었습니다.");
			break;
		case 3:
			System.out.println("조회메뉴가 선택되었습니다.");
			break;
		case 4:
			System.out.println("삭제메뉴가 선택되었습니다.");
			break;
		case 7:
			System.out.println("프로그램이 종료됩니다.");
			break;
		default:
			System.out.println("번호가 잘못 입력되었습니다.");
			System.out.println("다시 입력하십시오.");
			break;
		}
	}
	
	public void inputTest() {
		Scanner sc = new Scanner(System.in);
		System.out.print("이름: ");
		String name = sc.nextLine();
		System.out.print("나이: ");
		int age = sc.nextInt();
		System.out.print("키: ");
		double height = sc.nextDouble();
		
		if(name!=null && name.length()>0 && age>0 && height>0) {
			System.out.println("확인: " + name + "의 나이는 " + age + "세이고, 키는 " + height + "cm 이다.");
		}
	}
	
	public void test6(){
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 정수: ");
		int n1 = sc.nextInt();
		System.out.print("두번째 정수: ");
		int n2 = sc.nextInt();
		
		if(n1>0 && n2>0) {
			System.out.println(n1 + " + " + n2 + " = " + (int)(n1+n2));
			System.out.println(n1 + " - " + n2 + " = " + (n1-n2));
			System.out.println(n1 + " * " + n2 + " = " + n1*n2);
			System.out.println(n1 + " / " + n2 + " = " + n1/n2);
			System.out.println(n1 + " % " + n2 + " = " + n1%n2);
		}else {
			System.out.println("모두 양수만 입력해주세요!!");
		}
	}
	
	public void test7(){
		Scanner sc = new Scanner(System.in);
		System.out.print("점수를 입력해주세요: ");
		int score = sc.nextInt();
		char c;
		if(score>=0) {
			if(score>=90) {
				c = 'A';
			}else if(score>=80) {
				c = 'B';
			}else if(score>=70) {
				c = 'C';
			}else if(score>=60) {
				c = 'D';
			}else {
				c = 'F';
			}
			System.out.println("점수: " + score + "점, 학점: " + c);
		}else {
			System.out.println("점수는 0 이상의 값이어야 합니다!");
		}
	}
}
