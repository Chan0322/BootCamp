package com.chap02_stringBuffer_stringBuilder.run;

public class Run {

	public static void main(String[] args) {
		//StringBuffer. StringBuilder
		//mutable클래스. => 수정이 가능하다.
		//test1();
//		test2();
		test3();
	}
	
	public static void test1() {
		//String str = new String("ab cde");
		StringBuilder sb = new StringBuilder("AB CDE");
		System.out.println(sb);
		System.out.println(sb.length());
		System.out.println(sb.capacity()); // 용량.   16 + 6
		
		StringBuffer sf = new StringBuffer("FG HI");
		System.out.println(sf);
		System.out.println(sf.length());
	}
	
	public static void test2() {
		String str = "Hello!";
		StringBuffer sf = new StringBuffer("Hi! ");
		StringBuilder sb = new StringBuilder("Hey~ ");
		
		//String 클래스
		System.out.println("str: "+str+". 주소: "+System.identityHashCode(str));
		str+=" I'm java!)";
		System.out.println("변경 후 str: "+str+", 주소: "+System.identityHashCode(str));  // 문자열을 추가하면 원래 주소값이 변경되는 것이 아니라, 사라지고, 새로운 공간을 할당한다. 새로운 공간이 만들어짐.
		
		//StringBuffer
		System.out.println("sf: "+sf+", 주소: " + System.identityHashCode(sf));
//		sf += "I'm JAVA"; 스트링 빌더는 연산자를 통해 주가 불가.
		sf.append("I'm JAVA!");
		System.out.println("변경 후 sf: "+sf+", 주소: " + System.identityHashCode(sf));
		// 버퍼
		
		//StringBuilder
		System.out.println("sb: "+sb+", 주소: "+System.identityHashCode(sb));
		sb.append("im JaVa@");
		System.out.println("변경 후 sb: "+sb+", 주소: " + System.identityHashCode(sb));
		// 새로운 공간을 만들지 않고, 그 공간에 값들을 수정할 수 있다.
	}

	public static void test3() {
//		StringBuilder sb = new StringBuilder();
		StringBuffer sb = new StringBuffer();
		sb.append("오늘은 "); // append는 매개변수 갯수는 동일하지만 다양한 타입이 들어갈 수 있다. -> 오버로딩
		sb.append("금요일").append("입니다"); // 메소드 체이닝  // append는 여러번 실행 가능하다. 
		System.out.println(sb);
		System.out.println(sb.length());
		sb.insert(0, "너무너무 신나는 ");   // insert(idx, String) 문자열 넣기.
		System.out.println(sb);
		sb.delete(0, 8);	// delete(start, end);  start부터 end-1까지 제거.
		System.out.println(sb);
		sb.reverse();       // 뒤집기
		System.out.println(sb);
	}
}
