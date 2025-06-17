package com.chap03_stringTokenizer.run;

import java.util.StringTokenizer;

public class Run {
	// StringTokenizer
	//util 패키지
	//split 차이점: split()은 추출한 문자를 배열로 저장, StringTokenizer는 토큰으로 처리된다.
	
	
	//--------------주요 메소드------------------
	//hasMoreTokens() : 토큰이 남아 있는지 확인.
	//nextToken() : 토큰 읽어오기
	public static void main(String[] args) {
		String str = "이창진,20,경기 하남시,남";
		StringTokenizer st = new StringTokenizer(str, ",");
		System.out.println(st.countTokens());  // 몇 개로 잘렸는지 확인
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		//위 아래 동일
		String arr[] = str.split(",");
		for(String s:arr) {
			System.out.println(s);
		}
	}

	
}
