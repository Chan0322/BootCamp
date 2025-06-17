package com.test01;

public class Variable04 {
	public static void main(String[] args) {
		//준비
		//클래스명 변수명 = new 클래스명();
		Variable04 v04 = new Variable04();
		//실행
		//변수명.메소드명();
		v04.test1();
		
		v04.test2();
		
		v04.test3();
	}
	
	//자동 형변환(묵시적), 강제 형변환(명시적)
	
	//컴퓨터의 데이터 처리 원칙
	//같은 자료형끼리 대입 가능, 같은 자료형끼리 연산 가능.
	//작은 자료형을 큰 자료형으로, 정수형을 실수형으로 자동형변환 가능
	public void test1() {
		//형변환의 예외
		boolean flag = true;
		//flag = "true";
		
		int num = 'A'; // 자동 형변환. 문자 A의 ASCII 코드값인 65 변환됨.
		System.out.println("num: " + num);
		
		char ch = 97; // 자동 형변환. ASCII 코드가 97인 문자 'a' 출력.
		System.out.println("ch: " + ch);
		
		// num = -65; //음수 저장한 변수를 char강제 형변환 하게 되면 문자로 인식할 수 없다.
		//int 변수의 값을 강제 형변환 해야 한다.
		char ch2 = (char)num; // 타입 미스매치. => 강제 형변환 해줘야 함.
		System.out.println("ch: " + ch2);
	}
	
	public void test2() {
		int inum = 10;
		long lnum = 100L;
		
		// inum+lnum => 결과 값은 long 타입
		// 다른 자료형끼리 연산 후에 결과로 큰 자료형의 데이터가 나온다.
		//int isum = inum + lnum;
		
		//1. 
		int isum = (int)(inum+lnum);
		//2.
		int isum2 = inum + (int)lnum;
		//3
		long lsum = inum+lnum;
		
		System.out.printf("isum:%d, isum2:%d, lsum=%d", isum,isum2,lsum);
		
		byte bnum = 1;
		short snum = 2;
		//byte랑 short은 연산 결과가 무조건 Int다.
		
		//short sum = bnum+snum; //에러
		
		int sum = bnum+snum;
		short sum2 = (short)(bnum+snum);
		System.out.println();
		System.out.println();
		System.out.println(sum + ", " + sum2);
	}
	public void test3() {
		long lnum = 100;
		
		float fnum = lnum;
		//정수는 실수로 자동 형변환 된다.
		System.out.println("fnum: " + fnum);
		
		//실수에서 정수로는 강제 형변환 필요
		double dnum = 1234.567;
		int inum = (int)dnum;
		
		System.out.println("inum: " + inum);
		// 강제 형변환 후 데이터 손실 발생
		System.out.println("inum: " + (double)inum);
	}
	
}
