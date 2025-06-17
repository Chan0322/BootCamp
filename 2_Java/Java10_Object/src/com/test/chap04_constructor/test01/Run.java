package com.test.chap04_constructor.test01;

import java.util.Date;

public class Run {

	public static void main(String[] args) {
		User u1 = new User();
		u1.info();
		User u2 = new User("admin","1234","이창진");
		u2.info(); //this는 u2 객체의 userId, Pwd....를 가리킴.
		User u3 = new User("user01","1234","박창진",new Date());
		u3.info();
		
		u1.setUserId("user02");
		u1.setUserPwd("333");
		u1.info();
		System.out.println(u1.getUserId());
	}

}
