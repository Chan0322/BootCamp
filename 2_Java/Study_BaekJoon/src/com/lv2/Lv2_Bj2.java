package com.lv2;

import java.util.Scanner;

public class Lv2_Bj2 {

	public static void main(String[] args) {
		Lv2_Bj2 bj = new Lv2_Bj2();
		bj.testScore();
	}
	
	public void testScore() {
		Scanner sc = new Scanner(System.in);
		
		int score = sc.nextInt();
		char grade = ' ';
		if(score>=90 && score<=100) {
			grade = 'A';
		}else if(score>=80 && score<90) {
			grade = 'B';
		}else if(score>=70 && score<80) {
			grade = 'C';
		}else if(score>=60 && score<70) {
			grade = 'D';
		}else {
			grade = 'F';
		}
		System.out.println(grade);
	}

}
