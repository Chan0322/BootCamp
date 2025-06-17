package com.test.singleton;

public class Singleton {
	//클래스의 객체를 하나만 생성해서 사용하는 패턴
	
	private static Singleton one; // 저장이 가능한 객체를 생성.
	
	private Singleton() {
		
	}
	
	public static Singleton getInstance() {
//		return new Singleton();  // 동일 클래스 내부이므로 기본 생성자 접근 가능.
		// 해당하는 클래스로 객체가 만들어지므로 실행 시마다, 다른 객체를 가져옴.
		
//		return one; // 아무런 초기화를 진행하지 않았으므로 null.
		
		//해당 메소드가 호출이 될 때, Singleton 객체를 생성해서
		//one에 저장.
		//단, 첫 호출시에만.
		
		if(one == null) {
			one = new Singleton();
		}
		return one;
	}
	
	public void prn() {
		System.out.println("Singleton클래스의 일반 메소드");
		System.out.println(this);
	}
	
	
	//Singleton으로 메모리 낭비를 줄일 수 있고
	//단점 : 결합도가 높아짐. 특정 클래스에 있는 코드들과 다른 클래스의 코드들이 영향력이 세진다.
}
