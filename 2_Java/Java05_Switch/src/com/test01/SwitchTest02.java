package com.test01;

import java.util.Scanner;

public class SwitchTest02 {
	public void test1() {
		//정수 두개와 연산기호를 문자로 입력받아
		//입력받은 연산기호에 해당하는 계산을 수행하고 출력.
		// 3 4 + => 3+4
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 값: ");
		int no1 = sc.nextInt();
		System.out.print("두번째 값: ");
		int no2 = sc.nextInt();
		System.out.print("연산자(+,-,*,/,%): ");
		char op = sc.next().charAt(0);
		
		int res = 0;
		
		switch(op) {
		case '+':
			res = no1 + no2;
			break;
		case '-':
			res = no1 - no2;
			break;
		case '*':
			res = no1 * no2;
			break;
		case '/':
			res = no1 / no2;
			break;
		case '%':
			res = no1 % no2;
			break;
		default: System.out.println("연산기호를 입력해 주세요.");
		}
		System.out.println(no1 + " " + op + " " + no2 + " = " + res);
	}
}
