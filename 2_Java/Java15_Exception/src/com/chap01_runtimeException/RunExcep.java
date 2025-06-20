package com.chap01_runtimeException;

import java.util.Scanner;

public class RunExcep {
	/*
	 * 예외(Exception) : 코드 수정으로 해결 가능한 에러
	 * 		- 해당하는 상황이 발생 되면 예외 발생, throw 명령어를 통해 예외 발생.    (throws와 throw는 다름!!!!)
	 * 		
	 * RuntimeException
	 * 		ArrayIndexOutOfBoundsException : 배열의 접근에 잘못된 인덱스 값을 사용하는 상황
	 * 		ClassCastException : 잘못된 형변환을 진행하는 상황
	 * 		NullpointerException : 참조변수가 null을 가진 상황에서 메소드 호출하는 상황
	 * 		주로 if문을 통해 처리.
	 */
	Scanner sc = new Scanner(System.in);
	public void arithEx() {
		//if 로 처리
//		System.out.print("정수 입력: ");
//		int no = sc.nextInt();
//		
//		if(no!=0) {
//			int ran = (int)(Math.random()*10)+1;
//			
//			int res = ran / no;
//			System.out.println(ran+" / "+no+" = "+res);
//		}else {
//			System.out.println("0입력. 잘못 입력하였습니다.");
//		}
		
		//try-catch
		try {
			//예외가 발생할 코드를 작성
			System.out.print("정수 입력: ");
			int no = sc.nextInt();
			
			int ran = (int)(Math.random()*10)+1;
			
			int res = ran / no;
			System.out.println(ran+" / "+no+" = "+res);
			
		}catch(ArithmeticException e){
			//예외 발생 시 실행할 코드를 작성.
			//e.printStackTrace(); // 스택을 출력. 어디서 어떻게 문제가 발생했는지에 대한 정보들.
			System.out.println("0을 입력하셨습니다. 잘못입력");
			System.out.println(e.getMessage());
		}
		
		System.out.println("프로그램 종료");
	}
	
	public void classCastNarrayIndexEx() {
		//ClassCastException
		/*
		Object obj = 'a'; // 'a' => Character => Object //문자 a가 자동으로 형변환 되며 객체화
		System.out.println(obj);
		if(obj instanceof String) {
			String str = (String)obj; //classcastexception 발생.
			System.out.println(str);
		}else {
			System.out.println("String이 아니다.");
		}
		*/
		try {
//			Object obj = 'a';
//			String str = (String)obj;
//			System.out.println(str);
			
			//ArrayIndexOutOfBoundsException
//			int[] arr = new int[2];
//			arr[0] = 1;
//			arr[2] = 2;
			
			//NullPointerException
			String str = test();
			int length = str.length();
			
		}/*catch(ClassCastException e) {
			System.out.println("예외 발생");                  /// 둘 중 해당하는 예외처리 부분만 실행 됨.
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("인덱스.. 잘못 작성");
		}catch(NullPointerException e){
			System.out.println("null... 어디야...");
		}*/
		catch(Exception e) {
			System.out.println("문제야...");   //위 캐치문들을 이렇게 한번에 잡을 수 있음.
			// 그러나 발생된 예외에 하나하나 대응하는 것이 힘듷다
		}finally {
			//예외가 발생하건 발생하지 않건
			//무조건 마지막에 발생
			System.out.println("실행 되나..?");
		}
	}
	
	public String test() {
		try {
			System.out.println("dldldl");
		}catch(ClassCastException | ArrayIndexOutOfBoundsException | NullPointerException | NegativeArraySizeException e) {
			System.out.println("런타임 익셉");
		}
		return null;
	}
}
