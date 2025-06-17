package com.chap01_string.run;

public class Run {

	public static void main(String[] args) {
		
		//String 클래스
		//문자열, immutable(불변)
		
//		test1();
		test2();
	}
	
	public static void test1() {
		//문자열 리터럴로 생성
		String str = "abc";
		String str1 = "abc";
		//String pool 활용
		
		System.out.println(str);
		System.out.println(str1);
		System.out.println(str.hashCode()); // 객체이므로 해시코드 찍힘.
		System.out.println(str1.hashCode());
		
		// new 연산자로 생성
		System.out.println("-----------------------");
		String str2 = new String("abc");
		String str3 = new String("abc");
		System.out.println(str2);
		System.out.println(str3);
		System.out.println(str2.hashCode());
		System.out.println(str3.hashCode());
		
		// 동일한 hashcode() 값, 오버라이딩 되어 있어 같은 값일 경우 같은 hashcode.
		// 안에 있는 값이 전부 같기에 동일한 해시코드 값을 출력해준다.
		System.out.println("abc".hashCode());
		
		System.out.println("-------------------------------");
		System.out.println("st: "+System.identityHashCode(str));
		System.out.println("st1: "+System.identityHashCode(str1));
		System.out.println("st2: "+System.identityHashCode(str2));
		System.out.println("st3: "+System.identityHashCode(str3));
		// 안에 들어있는 값을 신경쓰지 않고 오버라이딩 된 해시코드가 아닌, 고유의 해시코드 값.
		// str과 str1은 완전히 같다. String을 리터럴로 만들었다. // String pool 활용
		// str2, str3은 new 연산자를 사용해 만들었다. // new 연산자는 새롭게 공간을 만들어서 값을 넣고 리턴해준다.
		
		System.out.println(str == str1); // 오버라이딩 된 해시코드가 아닌, 고유의 해시코드 값으로 비교한다.
		System.out.println(str2 == str3);
		
		String s1 = new String("ABC");
		String s2 = new String("ABC"+"D");
		String s3 = "ABCD";
		System.out.println("-----------------");
		System.out.println(s1 == s2);
		System.out.println(s1 == s3);
		System.out.println(s2 == s3); // new 연산자와 String pool로 만들어지면 같을 수 없다.
		// 자바 인터닝
		System.out.println(s2.intern() == s3); // intern() 값이 같은지
		
		String s4 = "ABCDE";
		System.out.println(s2 == s4);
	}
	
	public static void test2() {
		//String 클래스의 대표 메소드
		String str = "abc";
		
		System.out.println(str.charAt(1));// 해당하는 문자열에서, 인덱스 번호에 있는 문자 하나만 가져오겠다. 리턴 타입은 char
		System.out.println(str.concat("def")); // 합치기.
		System.out.println(str.contains("ac")); // ab가 포함되어 있는지 체크.
		System.out.println(str.equals("abc")); // String 값이 동일한지 비교. Object의 equals를 오버라이딩한 메소드;
		System.out.println(str.length());
		
		str = "a,b,c";
//		str.split(","); // , 를 기준으로 나누고, String 배열에 담아서 리턴해줌.   ,b => ,b를 기준으로 양쪽으로 나눔.
		String[] arr = str.split(",");
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		str = "			ab c	";
		System.out.println(str);
		System.out.println(str.trim()); // 앞, 뒤 공백 제거. 문자 사이에 있는 공백은 지우지 못함.
	}

}
