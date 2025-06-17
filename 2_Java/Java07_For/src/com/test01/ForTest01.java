package com.test01;

import java.util.Scanner;

public class ForTest01 {

	public static void main(String[] args) {
//		testFor1();
//		testFor2();
//		testFor3();
//		testFor4();
		testFor5();
	}
	public static void testFor1() {
		// 출력문을 반복하여 실행.
		int i=0;
		while(i<10) {
			System.out.println(i);
			i++;
		}
		
		//for(초기식; 조건식; 증감식)
		for( int no=0; no<10; no++ ) {
			System.out.println("no: " + no);
		}
		
		System.out.println("===============");
		//역순으로
		for(int no=9; no>=0; no--) {
			System.out.println("no: " + no);
		}
	}
	
	
	int no = 10;
	public static void testFor2() {
//		int no = 99; // 지역변수가 전역변수보다 우선순위가 세기 때문에, 전역변수와 겹쳐도 큰 문제 없다.
//		// 그러나, 지역변수끼리는 겹쳐선 안된다.
//		System.out.println(no);
		// 증감식
		for(int i=0; i<10; i+=2) { // i가 2씩 늘어남.
			System.out.println("i: " + i);
		}
		System.out.println();
		
		for(int i=0,j=10; i<10 && j>0; i++,j--) { // 조건식을 제외하고, 초기식과 증감식에는 하나 이상의 식이 들어갈 수 있다.
			// 조건식의 경우에는 결과값은 무조건 true/false이므로 무조건 하나의 식만 작성 가능하다.
			//만약 조건식에 두 개의 식을 작성하고 싶다면 && || 같은 논리연산자를 사용해야 한다.
			System.out.println("i: " + i);
			System.out.println("j: " + j);
		}
		
		System.out.println();
		for(char ch='a'; ch<='z'; ch++) {
			System.out.println(ch); // 문자타입도 사용 가능하다.
		}
	}
	
	public static void testFor3() {
		/*
		while(true) {
			System.out.println(11);
			if() {
				break;
			}
		}
		*/
		
		int i=1;
		for(;;) {//초기식, 조건식, 증감식 아무것도 적지 않으면 무한 반복됨.
			System.out.println(12);
			i++;
			if(i==11) {
				break;
			}
		}
	}
	
	public static void testFor4() {
		//정수 하나를 입력 받아 입력받은 수의 구구단을 출력.
		//3 입력 => 3단 출력
		//4 입력 => 4단 출력
		//단, 1~9 사이의 수가 아닌 경우 "반드시 1~9 사이의 양수 입력 해야 합니다" 출력
		Scanner sc = new Scanner(System.in);
		System.out.print("1~9 양수 입력: ");
		int no = sc.nextInt();
//		int su = 1;
		if(no>0 && no<=9) {
//			for(int i=0; i<9; i++) {
//				System.out.println(no + "*" + su + "=" + (no*su));
//				su++;
//			}
//			for(int i=0; i<9; i++) {
//				System.out.println( no + "*" + (i+1) + "=" + (no*(i+1)) );
//			}
			for(int i=1; i<10; i++) {
				System.out.println( no + "*" + i + "=" + (no*i) );
			}
		}else {
			System.out.println("반드시 1~9 사이의 양수 입력 해야 합니다.");
		}
	}
	
	public static void testFor5() {
		//1~100 사이의 숫자 중 1부터 임의의 난수 까지의 합을 구하여 출력
//		System.out.println( (int)(Math.random()*100)+1 );
		int ran = (int)(Math.random()*100)+1;
		System.out.println("random: " + ran);
		
		int sum = 0;
		for(int i=1; i<=ran; i++) {
			sum += i;
		}
		System.out.println("1부터 " + ran + "까지의 합: " + sum);
	}
}
