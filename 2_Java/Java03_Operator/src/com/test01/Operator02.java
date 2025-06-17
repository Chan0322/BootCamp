package com.test01;

public class Operator02 {
	public static void main(String[] args) {
		// 코드를 적다보면 추천하는 커서 이동위치를 초록색커서로 보여줌. 그때 tab을 누르면 바로 이동.
		
		Operator02 o = new Operator02();
		o.test1();
		o.test2();
		o.test3();
	}
	
	//++ : 1증가, ++값, 값++
	//-- : 1감소, --값, 값--
	public void test1() {
		int no = 20;
		
		System.out.println("현재 no: " + no);
		
		++no;
		System.out.println("++no의 결과: " + no);
		
		no++;
		System.out.println("no++의 결과: " + no);
		
		--no;
		System.out.println("--no의 결과: " + no);
		
		System.out.println("-----------------------");
		
		int num1 = 20;
		
		//후위연산자 : 다른 계산 먼저 처리 한 후 증감처리된다.
		int res = num1++ * 3;
		System.out.println("res: " + res);
		System.out.println("num1: " + num1);
		
		//전위연산자 : 증감을 먼저 처리 한 후 다른 계산을 한다.
		
		num1 = 20;
		res = ++num1 * 3;
		System.out.println("res: " + res);
		System.out.println("num1: " + num1);
		
		//2씩 증가 하고 싶다.
		// += 2     => 복합 대입 연산자 이용.
	}
	
	public void test2() {
		int num1 = 10;
		int num2 = 3;
		
		System.out.println(num1+num2);
		System.out.println(num1-num2);
		System.out.println(num1*num2);
		System.out.println(num1/num2); // 몫
		System.out.println(num1%num2); // 나머지
		
		//%
		//홀수냐 짝수냐, 배수
	}
	
	public void test3() {
		//비교연산 : 비교 후 논리값을 결과값으로 받는다.
		//<,>,<=,>=,==,!=
		int a=10, b=20; // 동일 타입이라면 여러개를 나열하여 선언과 초기화를 할 수 있다.
		boolean res1, res2, res3;
		
		res1 = a == b;
		res2 = (a != b);
		res3 = (a <= b);
		System.out.println(res1);
		System.out.println(res2);
		System.out.println(res3);
	}
}
