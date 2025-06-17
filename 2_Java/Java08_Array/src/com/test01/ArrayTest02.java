package com.test01;

public class ArrayTest02 {

	public static void main(String[] args) {
		//1. a~z 배열에 저장하여 그 배열을 출력
		
		// 배열 생성
		char[] ch;
		ch = new char[26];
		for(int i=0; i<26; i++) {
			ch[i] = (char)((int)'a'+i);
//			ch[i] = (char)(97+i);
		}
		prn(ch);
		
		//2. 1에서 만든 배열을 거꾸로 출력
		reverse(ch);
		
		//3. 1에서 만든 배열을 대문자로 바꿔 출력.
		upper(ch);
		
		System.out.println("-----");
		prn(ch);
		//메인에서 ch를 만들고 ch는 배열을 가리킴.
		//upper에서 넘겨받는 배열도 동일한 배열을 가리키고 있음.
		//두 변수가 같은게 아니라, 두 변수가 같은 주소의 배열을 가리키고 있는 것. 배열을 넘겨주고 넘겨받는 과정에서는 주소가 왔다갔다 하는 것.
	}
	
	public static void prn(char[] ch) {
		for(int i=0; i<ch.length; i++) {
			System.out.print(ch[i]+" ");
		}
		System.out.println();
	}
	
	public static void reverse(char[] ch) {
//		for(int i=ch.length-1; i>=0; i--) {
//			System.out.print(ch[i]+" ");
//		}
		//배열의 값을 역순을 저장한 새로운 배열 생성.
		char re[] = new char[26];
		int tmp=0;
		
		for(int i=ch.length-1; i>=0; i--) {
			re[tmp] = ch[i];
			tmp++;
		}
		prn(re);
	}
	
	public static void upper(char[] carr) {
//		for(int i=0; i<ch.length; i++) {
//			System.out.print(Character.toUpperCase(ch[i]) + " ");
//			System.out.print( (char)(ch[i]-32) );
//		}
		for(int i=0; i<carr.length; i++) {
			carr[i] = Character.toUpperCase(carr[i]);
		}
		prn(carr);
	}

}
