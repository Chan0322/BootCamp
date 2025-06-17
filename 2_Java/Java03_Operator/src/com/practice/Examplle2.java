package com.practice;

import java.util.Scanner;

public class Examplle2 {
	
	//문제1
	public void sample1() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("점수를 입력하세요");
		System.out.print("국어: ");
		int kor = sc.nextInt();
		System.out.print("영어: ");
		int eng = sc.nextInt();
		System.out.print("수학: ");
		int math = sc.nextInt();
		
		int sum = kor+eng+math;	// 총점
		double avg = sum/3.0;	// 평균
		
		if(kor>=40 && eng>=40 && math>=40 && avg>=60) {
			System.out.println("합격");
		}else {
			System.out.println("불합격");
		}
	}
	
	//문제2
	public void sample2() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("학생 이름: ");
		String stuName = sc.next();
		System.out.print("학년: ");
		int grade = sc.nextInt();
		System.out.print("반: ");
		int classRoom = sc.nextInt();
		System.out.print("번호: ");
		int stuNum = sc.nextInt();
		System.out.print("성별(M/F): ");
		char gender = sc.next().charAt(0);
		System.out.println("성적: ");
		double score = sc.nextDouble();
		
		String gen = "";
		if(gender=='F' || gender=='f') {
			gen = "여학생";
		}else {
			gen = "남학생";
		}
		
		String str = grade + "학년 " + classRoom + "반 " + stuNum + "번 " + gen + " " + stuName + "은 성적이 " + score +"이다.";
		System.out.println(str);
	}
	
	//문제3
	public void sample3() {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		if(n > 0) {
			System.out.println("양수다.");
		}else {
			System.out.println("양수가 아니다.");
		}
	}
	
	//문제4
	public void sample4() {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		String str = "";
		if(num%2 == 0) {
			str = "짝수다.";
		}else {
			str = "홀수다.";
		}
		System.out.println(str);
	}
}
