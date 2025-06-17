package com.test_chap01_encapsulation;

public class Main {

	public static void main(String[] args) {
		//객체 생성
		Account a = new Account();
//		Account b = new Account();
		
		// 잔액조회
		a.prnBalance();
		
		// 입금
		a.in(100000);
		a.prnBalance();
		
		a.in(150000);
		a.prnBalance();
		
		//출금
		a.out(50000);
		a.prnBalance();
		
//		a.balance -=200000; // 현재 상태로는 필드에 직접적인 접근이 가능하다. 20만원이 하늘로 날아가버림; 이 것을 캡슐화 과정에서 외부로부터 필드에 직접적인 접근을 하지 못하도록 막아야 한다.
		// Account.java 파일에서 변수들에 접근 제한자로 private 설정을 해야 한다.
		// 이처럼 우회해서 접근할 수 있도록 적절한 메소드를 만들어 사용해야 한다.
		
		a.out(50000);
		a.prnBalance();
		
		//객체 추가
//		Account a = new Account(); // 중복된 변수명 사용 불가.
		Account b = new Account(); // 만들어진 객체는 heap 영역의 다른 공간이다. a와는 다름!
		
		b.prnBalance();
		a.prnBalance();
	}

}
