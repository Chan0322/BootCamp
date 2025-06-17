package com.test_chap01_encapsulation;

public class Account {
	//필드
	private String name = "이창진";
	private String accNo = "010-1111-2222";
	private String pwd = "1234";
	private int bankCode = 22;
	private int balance = 0;
	//private를 통해 외부에서 접근이 불가능하도록 막는다.
	
	//메소드
	
	// 생성자(객체 생성을 위한 일종의 메소드)
	public Account() {}
	
	//입금
	public void in(int money) {
		if(money > 0) {
			balance += money;
			System.out.println(name+"님의 계좌에 "+money+"원이 입금되었습니다.");
		}else {
			System.out.println("잘못된 금액을 입력하였습니다.");
		}
	} 
	//출금
	public void out(int money) {
		if(money<balance) {
			balance -= money;
			System.out.println(name+"님의 계좌에서 "+money+"원이 출금되었습니다.");
		}else {
			System.out.println("잔액이 부족합니다. 잔액을 확인하세요.");
		}
	}
	//잔액 확인
	public void prnBalance() {
		System.out.println(name+"님의 계좌의 잔액은 "+balance+"원 입니다.");
	}
}
