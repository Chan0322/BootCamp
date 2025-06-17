package com.practice;

import java.util.Scanner;

public class Example {
	public void sample1() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("국어: ");
		int kor = sc.nextInt();
		System.out.println("영어: ");
		int eng = sc.nextInt();
		System.out.println("수학: ");
		int math = sc.nextInt();
		
		int sum = kor + eng + math;
//		double avg = (double)sum/3;
		double avg = sum/3.0;
		
		String res = (avg>=60 && kor>=40 && eng>=40 && math>=40)?"합격":"불합격";
		System.out.println(res);
	}
	
	public void sample2() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("성별(M/F): ");
		char gender = sc.next().charAt(0);
		
		String gen = (gender == 'F' || gender == 'f')?"여학생":"남학생";
		///////////////////////////
		if(gender == 'F' || gender == 'f') { 
			gen = "여학생";
		}else {
			gen = "남학생";
		}
		///////////////////////////
		gen = "남학생";
		if(gender == 'F' || gender == 'f') { 
			gen = "여학생";
		}
		
		System.out.println(gen);
	}
	
	public void sample3() {
		int no = 10;
		String res = (no>0)?"양수":"양수가아니다";
		
		if(no>0) {
			res = "양수";
		}else {
			res = "양수가아니다";
		}
	}
	
	public void sample4() {
		int no = 10;
		
		String res = ( no%2==0 )?"짝수":"홀수";
		if(no%2==0) {
			res = "짝수";
		}else {
			res = "홀수";
		}
	}
	
	public String test() {
		int no = 0;
		return (no%2==0)?"짝수":"홀수";
	}
}
