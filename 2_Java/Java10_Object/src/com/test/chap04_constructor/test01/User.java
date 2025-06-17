package com.test.chap04_constructor.test01;

import java.util.Date;

public class User {
	private String userId;
	private String userPwd;
	private String userName;
	private Date date;

	//생성자 : 객체 생성, 필드 초기화
	//생성자 작성 : 이름은 반드시 클래스명과 동일, 리턴타입(반환형)이 없다.
	// 생성자의 갯수는 필드의 갯수에 따른다. 몇개든 상관 없음.
	
	//기본생성자 -> 필드 초기화 역할은 수행하지 못하고
	//			 객체를 생성할 때 사용             // 이름까지 완전히 동일(대소문자 등)하게 작성!
	public User() {
		System.out.println("기본 생성자 생성");
	}
	
	//매개변수 있는 생성자 -> 객체 생성과 필드 초기화 두 가지 목적으로 사용.
	//같은 이름, 다른 매개변수 => 오버로딩을 통해 구현.
	public User(String userId, String userPwd, String userName) {
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		// 만약 매개변수의 이름이 동일하지 않다면 this 필요 없이 알아서 필드의 값으로 인식.
		//하지만 이렇게 하면 어떤 값이 넘어오는지 보기 불편함.
		// 기본생성자에서 초기화 작업을 해도 되긴 함. 하지만 매개변수로 하는 걸 추천.
	}

	public User(String userId, String userPwd, String userName, Date date) {
//		this.userId = userId;
//		this.userPwd = userPwd;
//		this.userName = userName;
		//this() : 해당 클래스 내의 다른 생성자 호출
		this(userId, userPwd, userName); // 다른 생성자를 호출하는 코드는 맨 위에 존재해야 함.
		this.date = date;
	}
	
//	public User(String userId) {}
//	public User(String userId, String userPwd) {}
	
	//필드에 값을 저장하는 메소드 추가
	//setter 메소드 : 필드에 값을 저장하는 메소드
	//getter 메소드 : 필드에 저장된 값을 불러오는 메소드
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserId() { // 반환형이 필드의 타입과 동일
		return userId;
	}
	
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserPwd() {
		return userPwd;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserName() {
		return userName;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getDate() {
		return date;
	}
	
	//public void set필드명(필드타입 매개변수){
	//		필드 = 매개변수;
	//}
	
	//public 필드타입 get필드명(){
	//		return 필드;
	//}
	
	// 출력용 메소드
	public void info() {
		System.out.println(userId+", "+userPwd+", "+userName+", "+date);
	}
}
