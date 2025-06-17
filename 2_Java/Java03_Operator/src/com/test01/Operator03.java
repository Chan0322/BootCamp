package com.test01;

import java.util.Scanner;

public class Operator03 {
	public static void main(String[] args) {
		//new Operator03().test1();
		new Operator03().test2();
	}
	// &&(그리고, ~면서)
	// ||(또는, ~이거나)
	// 논리값 && 논리값, 논리값 || 논리값
	public void test1() {
		// 정수 하나 키보드로 입력받아 1~100 사이의 숫자인지 확인
		
		//스캐너 생성
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 하나 입력: ");
		int num = sc.nextInt();
		
		System.out.println("1부터 100사이인지 확인: " + (num>=1 && num<=100));
		
		//영어 문자(char) 하나 입력 받아 영문 대문자인지 확인
		//charAt, 문자>='A',		Character 클래스의 메소드
		System.out.print("문자 하나 입력: ");
		char ch = sc.next().charAt(0);
		System.out.println("대문자?: " + (ch >= 'A' && ch <= 'Z'));
		System.out.println(Character.isUpperCase(ch));
		
		System.out.print("계속 하시려면 y혹은 Y를 입력하세요: ");
		char ch2 = sc.next().charAt(0);
		System.out.println("확인: " + (ch2=='y' || ch2=='Y'));
	}
	
	public void test2() {
		//논리값 && 논리값 : 앞의 논리값이 false면 뒤를 실행 안한다.
		//논리값 || 논리값 : 앞의 논리 값이 true면 뒤를 실행 안한다.
		
		int num = 10;
		int res = (false && ++num>0)? num:num; // and 연산인데, 앞에 false 값이 있으므로 뒷부분은 노란 줄이 생김 => 데드코드 죽은코드. 쟤가 실행될 일이 절대 없다.
		System.out.println("&&에서 num " + num); // 증감 연산자가 들어있긴 하나, 뒷부분이 데드코드로, 실행이 안되므로 증감연산이 안된다.
		
		res = (true || ++num>0)?num:num; // or 연산은 하나만 true여도 true => 앞이 이미 true이므로 뒷부분은 데드코드.
		System.out.println("||에서 num " + num);
	}
}
