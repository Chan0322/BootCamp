package com.test02;

public class BreakContinue {

	public static void main(String[] args) {
		testBreak();
		testCon();
	}
	
	public static void testBreak() {
		int no = 10;
		int sum = 0;
		
		int i=1;
		while(true) {
			sum += i;
			if(i==no) {
				break;
			}
			i++;
//			if(i==no+1) {
//				break;		//위치에 따라 조건이 달라짐.
//			}
		}
		System.out.println("sum: " + sum);
	}
	public static void testCon() {
		int i=0;
		while(i<10) {
			i++;
			if( i%2==1 ) {
				continue; // 다음 코드를 무시하고, 다음번 반복 진행.
			}
			System.out.println(i);
		}
	}
}
