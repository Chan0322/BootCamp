package com.test.chap03_field.test02;

public class InitBlock {
/*	1. 기본값
 *  private String pName; 
	private int price;
	private static String brand;
*/
	//2. 명시적 초기화
	private String pName = "iPhone";
	private int price = 200;
	private static String brand = "apple";
	
	//3. 초기화 블럭
	static {
		//static 초기화 블럭
		//프로그램 시작 시 실행.
		brand = "samsung";
		
//		pName = "fold"; //일반적인 필드는 생성되는 시점이 객체를 만들 때이다. 그래서 static 필드로 초기화를 하는 시점에 brand를 찾지 못한다. 
	}
	{
		//인스턴스 초기화 블럭  new 연산자로 객체를 생성할 때 만들어짐.
		pName = "flip";
		price = 150;
		brand = "삼성";
	}
	
	//4. 매개변수 있는 생성자
	public InitBlock() {} // 기본 생성자
	// 매개변수 있는 생성자 : 위의 초기화된 값을 덮어쓰고 전달받은 값을 초기화.
	public InitBlock(String pName, int price, String brand) {
		this.pName = pName; // 매개변수로 넘어온 값을 필드에 저장하겠다.
		this.price = price; //this = 현재 생성되는 객체 자체. i
		InitBlock.brand = brand;
	}
	
	//4.5 값을 저장하는 메소드
	public void savePName(String pName) {
		this.pName = pName; // 필드에 매개변수로 넘어오는 값을 저장.
	}
	//setter메소드
	public void setPrice(int price) {
		this.price = price;
	}
	// public void set필드이름(필드타입 매개변수)
	//		해당 필드의 값 저장하는 코드
	
	
	public void information() {
		System.out.println(pName + ", " + price + ", " + brand);
	}
}
