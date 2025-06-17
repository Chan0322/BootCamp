package com.chap04_wrapperclass.run;

public class Run {
	// wrapper 클래스 (java.lang 패키지 내에 존재.
	// 프로그램에 따라 기본 타입의 데이터가 아닌 객체로 취급해야 하는 경우 활용
	// ex)메소드 실행 시 매개변수로 객체타입만 요구하는 경우
	// Object 클래스와 관련된 메소드 활용할 때.
	
	// 8개의 기본타입에 해당하는 데이터를 객체로 만들 수 있는 wrapper클래스가 존재한다.
	
	// Boxing : 기본 자료형을  => Wrapper 클래스 객체로 포장.
	// UnBoxing : Wrapper 클래스 객체를 => 기본 자료형으로 언박싱.
	public static void main(String[] args) {
		// boxing
		Integer i = new Integer(10); // deplicate 사용은 할 수 있지만 쓰지 마라.
		Integer i2 = new Integer(10);
		Integer i3 = 15;
		//객체화 => boxing => 자동으로 boxing==autoBoxing
		
		System.out.println(i == i2);
		System.out.println(i.equals(i2));
		System.out.println(i3.equals(i));
		System.out.println(i.compareTo(i3)); // i를 기준으로 i3와 비교. i3가 크면 음수, i가 크면 양수, 같으면 0
		
		Short id = 10;
		Double d1 = 10.0;
		
//		객체화 하고 싶으면?
//		int no = 10;
//		Integer noObj = no;
		
		//Unboxing
		int pi = i.intValue();
		double pd = d1.doubleValue(); 	// 기본 자료형으로 바꾼다.
		System.out.println(pi);
		System.out.println(pd);
		
		//AutoUnBoxing;
		int a = i;
		double d = d1;
		int b = i3;
		
		ab(a+b); //int >> (autoboxing) >> Integer 객체 >> (다형성) >> Object obj
		
		test1();
	}
	
	public static void ab(Object obj) {
		System.out.println(obj);
		int o1 = (Integer)obj;
	}
	
	public static void test1() {
		// String => primitive
		byte b = Byte.parseByte("1"); //String 값을 Byte로 변환시켜 저장.
		int i = Integer.parseInt("4");
		double d= Double.parseDouble("1.0");
		char c = "a".charAt(0); //char 값으로 변환하려면 charAt()
		
		b = Byte.valueOf("1");
		i = Integer.valueOf("1");
		
		//primitive => String
		String str = b+"";
		str = ((Integer)i).toString();
		str = Integer.valueOf(1).toString();
		System.out.println(str);
	}
}
