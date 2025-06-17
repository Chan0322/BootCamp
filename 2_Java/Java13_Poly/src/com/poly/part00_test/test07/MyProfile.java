package com.poly.part00_test.test07;

public class MyProfile extends Profile implements Display, Job{ // 여러 개의 인터페이스 상속 시, ','로 구분 // extends가 implements보다 먼저 와야 함.
	private String loc;

	public MyProfile(String name, String phone) {
		super(name, phone); // 부모클래스의 생성자를 호출하는 코드는 꼭 들어가야 한다. Profile에서 기본 생성자를 만들지 않았으므로, Profile에 있는 생성자를 호출해야 한다. 기본 생성자가 있을 경우에는 알아서 호출 된다. 하지만 지금은 기본 생성자를 만들지 않았다.
	}
	
	@Override
	public void jobLoc(String loc) {
		this.loc = loc;
	}

	@Override
	public void display() {
		super.printProfile();
		System.out.println("회사 주소: " + loc);
		System.out.println("회사 직종: " + jobId);
	}
	
}
