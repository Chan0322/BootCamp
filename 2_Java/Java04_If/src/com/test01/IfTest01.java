package com.test01;

import java.util.Scanner;

public class IfTest01 {
	
	Scanner sc2 = new Scanner(System.in); // 이렇게 작성하면 각 메소드마다 생성할 필요 없이 sc2를 호출해 사용 가능하디. 전역변수의 역할로 사용
	//필드, 멤버변수, 전역변수

	final double PI = 3.145;
	
	public void testIf() {
		// 단독 if문
		// 조건식의 결과가 참이면 {}안에 코드 실행
		// 조건식의 결과가 거짓이면 {}안에 있는 코드를 무시하고 건너뛰기.
		
		int num = 11;
		
		//짝수인지 확인
		if( num%2 == 0 ) {
			System.out.println("입력하신 숫자는 짝수 입니다.");
		}
		// 짝수가 아닌 경우
		if(num%2 != 0) {
			System.out.println("입력하신 숫자는 홀수 입니다.");
		}
		// 이렇게 조건을 두 번 확인해야 함.
		System.out.println("프로그램 종료"); // 조건을 만족하지 않으면 if의 내용을 건너뛰고 다음 코드 실행.
	}
	
	public void testIfElse() {
		//else : 조건식을 사용 X. if의 조건식이 거짓이면 무조건 else의 {}안에 코드가 실행
		int num = 11;
		
		if( num%2 == 0 ) { // if의 조건을 만족하지 않으면 else 실행. => 조건을 한번만 확인함.
			System.out.println("입력하신 숫자는 짝수 입니다.");
		}else {
			System.out.println("입력하신 숫자는 홀수 입니다.");
		}
	}
	
	public void testIfElse2() {
//		//정수를 입력받아(Scanner)
//		//50보다 큰 수라면 "크다"		>=50
//		//50보다 작은 수라면 "작다" 라고 출력
//		Scanner sc = new Scanner(System.in);
//		System.out.println("정수 입력: ");
//		int no = sc.nextInt();
//		
//		if( no>=50 ) {
//			System.out.println("크다");
//		}else {
//			System.out.println("작다");
//		}
		
		//정수를 입력받아(Scanner)
		//50보다 큰 수일 때 짝수인지 홀수인지 출력.
		//50보다 작은 수라면 "작다" 라고 출력
		Scanner sc = new Scanner(System.in);
		System.out.println("정수 입력: ");
		int no = sc.nextInt();
				
		if( no>=50 ) {
//			System.out.println("크다");
			if(no%2 == 0) {
				System.out.println("짝수");
			}else {
				System.out.println("홀수");
			}
		}else {
			System.out.println("작다");
		}
		
		//이 if문을 삼항연산자로 작성
		String str = (no>=50) ? ((no%2==0) ? "짝수":"홀수") : "작다";
		System.out.println(str);
	}
	
	public void testIfElse3() {
		//정수 하나를 입력 받아
		//양수인지 음수인지 출력
		//단, 0이면 "0입니다"리고 출력
		//else 문, 중첩 if
		Scanner sc = new Scanner(System.in);
		int no = sc.nextInt();
		
		if(no != 0) {
			//0아니면 양수 음수 출력
			if(no>0) {
				System.out.println("양수입니다.");
			}else {
				System.out.println("음수입니다.");
			}
		}else {
			System.out.println("0입니다.");
		}
	}
	
	public void testIfElse4() {
		// 정수 두 개를 입력 받는다.
		// 입력받은 두 수의 산술연산을 처리하여 출력한다.(+,-,*,/,%)
		//단, 두 수 모두 반드시 1부터 100사이의 값이어야 한다.
		//둘 중 하나라도 범위에 속하지 않은 수라면
		//"값은 1부터 100사이어야 합니다"라고 출력
		// if else로 처리(중첩X)
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		if((num1>=1 && num1<=100)&&(num2>=1 && num2<=100)) {
			System.out.println("+: " + (num1+num2));
			System.out.println("-: " + (num1-num2));
			System.out.println("*: " + (num1*num2));
			System.out.println("/: " + (num1/num2));
			System.out.println("%: " + (num1%num2));
		}else {
			System.out.println("값은 1부터 100사이어야 합니다.");
		}
		
//		if((num1>=1 && num1<=100)) {
//			if(num2>=1 && num2<=100) {
//				System.out.println("+: " + (num1+num2));
//				System.out.println("-: " + (num1-num2));
//				System.out.println("*: " + (num1*num2));
//				System.out.println("/: " + (num1/num2));
//				System.out.println("%: " + (num1%num2));
//			}else {
//				System.out.println("값은 1부터 100사이어야 합니다.");
//			}
//		}else {
//			System.out.println("값은 1부터 100사이어야 합니다.");
//		}
		
//		if(num1>1)
//			System.out.println(num1); // if문 내무에 작성할 코드가 한 줄이라면 {}를 생략할 수 있지만, 헷갈린다. 
//			System.out.println("asdf"); // 이 코드는 if문 안에 있는게 아니다.
	}
}
