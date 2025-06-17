package com.test01;

// 클래스의 이름과 자바 파일의 이름은 동일해야 한다!
public class Variable03 {
	public static void main(String[] args) {
		//상수
		int age; // 변수 선언은 일반적으로 소문자로 생성.
		final int AGE; //final이 붙으면 상수. 상수 선언은 일반적으로 대문자로 생성. 한 번 값이 저장된 이후로는 바뀌지 않는다. 바꾸려 하면 문제 발생.
		
		//초기화
		age = 20;
		AGE = 50;
		
		System.out.println(age);
		System.out.println(AGE);
		
		//값 변경
		age = 30;
		//AGE = 60; 에러 발생
		
		final double PI = 3.141592;
		
		// 오버플로우
		//byte bnum = 128; // 바이트는 -128~127까지만 저장 가능.
		// 에러, 범위를 벗어난 값
		
		//계산 과정에서 범위를 벗어나면 오버플로우 처리된다. => 값이 최솟값으로 바뀌어 순환되어 버림.
		byte bnum = 127;
		bnum++;
		// 값이 순환된다
		System.out.println("bnum: " + bnum); // string + byte = string => 자동형변환
		
	}

}
