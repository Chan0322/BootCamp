package com.test04;

public class Teacher implements Person{

	@Override
	public String classWork() {
		// 일부러 예외 발생.
		String s = null;
		s.length();
		
		System.out.println("줌 회의를 시작한다.");
		return "Spring";
	}

}
