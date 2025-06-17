package com.test01;

import java.util.Scanner;

public class Variable02 {
	public static void main(String[] args) {
		//준비
		Variable02 test = new Variable02();
		//실행
		test.test1();
		//상단의 버튼 클릭!, ctrl+f11
	}
	
	public void test1() {
		//콘솔창에 키보드로 값 입력받기
		//Scanner 클래스
		
		//준비
		//다른 패키지의 클래스 사용 //같은 패키지안에 있지 않으면 자바는 못찾으므로 외부 패키지에 있는 메소드의 위치를 알려줘야 함.
		//1. java.util.Scanner sc = new java.util.Scanner();
		
		//2. import    => 패키지와 클래스 사이에.
		Scanner sc = new Scanner(System.in);
		
		
		//실행
		//sc.nextInt();
		System.out.println("이름 입력하세요: ");
		String name = sc.nextLine(); // 문자열 받아오는 메소드(공백 포함)  //입력을 해줄때까지 기다림. 숫자를 입력해도 스트링으로 받아옴.
									 // next(); 문자열(공백 미포함)
		System.out.println("이름: " + name);
		
		//타입별로 받아올 수 있는 메소드가 존재
		System.out.println("나이 입력하세요: ");
		int age = sc.nextInt(); // 정수값 받아오는 메소드
		System.out.println("나이: " + age);
		
		//문자는 문자열로 받아 charAt(index)이용하여 받는다.
		//문자열이 아닌 문자로 받으려면 넥스트라인/넥스트로 받고 이렇게 떼와야 함.
		char gender = "M".charAt(0);
		
		
		//BufferedRead br = new BufferedReader(new InputStreamReader(System.in));
		//int a = br.readLine();
	}
	/*
		public void t() {int num;}
		public void t1() {int num;}
		public void t2() {}
		public void t3() {}
		int num;
		int num1; // 같은 블럭 안에서 변수의 이름이 중복되서는 안된다. 다른 블럭이라면 상관 없음.
	*/
}
