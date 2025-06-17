package com.test01;

import java.util.Scanner;

public class WhileTest02 {
	public static void main(String[] args) {
//		WhileTest02.testDoWhile1();
//		testDoWhile2();
		testDoWhile3();
	}

	public static void testDoWhile1() {
		int i=1;
		do {
			System.out.println(i);
			i++;
		}while(i<=10);
		System.out.println("do while 종료 후 i: " + i);
		
		//이 시점에서 i=11
		do {
			System.out.println(i);
			i++;
		}while(i<=10);   // do while은 처음 한번은 일단 실행되므로 11이 출력됨.
		System.out.println("do while 종료 후 i: " + i); // i는 12가 됨.
	}
	
	public static void testDoWhile2() {
		//키보드로 영어 문자열 값을 입력 받아 출력하는 걸 반복.
		//단, exit입력할 때까지.
		//do while을 이용해서
		Scanner sc = new Scanner(System.in);
		String str = ""; // 변수를 do 안에서 선언하면 do 블럭 밖에 있는 while 블럭에서는 사용할 수 없다.
		do {
			System.out.println("문자열: ");
			str = sc.next();
			System.out.println("str: " + str);
		}while( !str.equals("exit") );
	}
	
	public static void testDoWhile3() {
		//testDoWhile2와 동일하게 동작하도록 구현
		Scanner sc = new Scanner(System.in);
		String str = "";
		do {
			System.out.println("문자열 입력: ");
			str = sc.next();
			if(str.equals("exit")) {
				break;
			} // if문을 여기에 작성하면 exit를 출력하지 않고 바로 종료 가능.
			System.out.println(str);
//			if(str.equals("exit")) {
//				break;
//			}
		}while(true);
	}
}
