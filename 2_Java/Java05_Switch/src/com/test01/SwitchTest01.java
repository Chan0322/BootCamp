package com.test01;

import java.util.Scanner;

public class SwitchTest01 {
	/*switch(조건){
	*	case 값1:
	*	case 값2: 
	* }
	*/
	public void test1() {
		int no = 1;
		
		switch(no) {
			case 1: 
				System.out.println("1입니다.");
				return; // 메소드 종료
			case 2: 
				System.out.println("2입니다.");
				break;
			case 3: 
				System.out.println("3입니다.");
				break;
			default:
				System.out.println("다른 숫자입니다.");
				//default의 위치는 상관 없다. case또한 마찬가지. 다만, 위치에 따른 break문을 적절히 사용해야 한다.
		}
		
		char ch = 'a';
		switch(ch) {
		case 'a':
			System.out.println("a입니다.");
			break;
		case 'b':
			System.out.println("b입니다.");
			break;
		case 'c':
			System.out.println("c입니다.");
			return;
		default:
			System.out.println("다른 영어입니다.");
		}
		// 예전엔 문자열 사용 불가능했으나, 이제는 가능.
		
		// break일 경우에는 switch 문이 종료되어 다음에 있는 코드가 실행됨.
		// return일 경우에는 메소드가 종료되어 다음 코드가 실행되지 않음.
//		return;     // 메소드의 마지막에는 항상 return이 숨겨져 있다.
	}
	
	public void test2() {
		//스캐너
		Scanner sc = new Scanner(System.in);
		
		System.out.print("month 입력: ");
		String month = sc.next();
		
		// switch 문의 case에서 동일한 작업을 반복할 경우 아래와 같이 간단하게 작성할 수 있다.
		// switch 문의 특성을 이용. break문이 없는 case들을 상단에 모으고, 처리할 코드를 하나만 남겨둔다.
		switch(month) {
		case "1":
		case "3":
		case "5":
		case "7":
		case "8":
		case "10":
		case "12":
			System.out.println("31일 까지 있는 달입니다.");
			break;
			
		case "2":
			System.out.println("28일or29일 까지 있는 달입니다.");
			break;
			
		case "4":
		case "6":
		case "9":
		case "11":
			System.out.println("30일 까지 있는 달입니다.");
			break;
			
		default: System.out.println("1~12까지 입력해야 합니다.");		}
	}
}
