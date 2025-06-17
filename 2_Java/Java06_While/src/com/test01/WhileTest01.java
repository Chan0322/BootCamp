package com.test01;

import java.util.Scanner;

public class WhileTest01 {

	public static void main(String[] args) {
//		testWhile1();
//		testWhile2();
//		testWhile3();
//		testWhile4();
		testWhile5();
	}

	public static void testWhile1() {
		int i=0;
		while(i<10) {
			System.out.println(i+"번째 반복 중");
			i++;
		}
		System.out.println("while 종료 후 i 값: " + i);
	}
	
	public static void testWhile2() {
		//문자열을 입력 받아 인덱스별로 문자 출력
		// chatAt();
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열 입력: ");
		String str = sc.next();
		
		int index=0;
		while(index <= str.length()-1) {
			char ch = str.charAt(index);
			System.out.println(index+":"+ch);
			index++;
		} // 자바스크립트의 배열의 length와 자바의 length()의 차이점.
	}
	
	public static void testWhile3() {
		//1부터 입력받은 수까지 정수들의 합
		System.out.print("정수 하나 입력: ");
		int num = new Scanner(System.in).nextInt();
		
		int sum = 0;
		
		int i = 1;
		while(i<=num) {
			sum += i;
			i++;
		}
		System.out.println("sum: " + sum);
	}
	
	public static void testWhile4() {
		int i=1;
		while(true) { // 조건식이 true이면 종료되는 문장을 꼭 추가해야 한다.
			System.out.println(i);
			i++;
			
			if(i==10) {
				break;
			}
		}
		
		//키보드로 4를 입력 받을때 까지 반복.
		//4 입력하면 while문 종료
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("숫자 입력: ");
			int no = sc.nextInt();
			
			if(no==4) {
				System.out.println("4입력! 종료!");
				break;
			}
		}
		
		while(true) {
			System.out.print("문자열 입력(1,2,3,4,5)");
			String tmp = sc.next();
			
			if(tmp.equals("4")) { // String의 경우 == 가 아닌, equals() 함수를 이용해야 한다. (String은 참조형 이기 때문)
				System.out.println("4입력! 종료!");
				break;
			}
		}
	}
	
	public static void testWhile5() {
		int no1 = 1;
		while(no1<10) {
			int no2=10;
			while(no2<15) {
				System.out.println("no1: "+no1+", no2: " + no2);
				no2++;
			}
			System.out.println();
			no1++;
		}
		
		//구구단 2~9단까지 출력
		int num1 = 2;
		while(num1<10) {
			int num2=1;
			while(num2<10) {
				System.out.println(num1+"*" + num2 + "="+(num1*num2));
				num2++;
			}
			System.out.println();
			num1++;
		}
	}
}
