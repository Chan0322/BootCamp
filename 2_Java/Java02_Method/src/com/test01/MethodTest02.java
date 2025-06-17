package com.test01;

public class MethodTest02 {
	public static void main(String[] args) {
		//메소드 호출
		MethodTest01.publicMethod();
		MethodTest01.protectedMethod();
		MethodTest01.defaultMethod();
		//MethodTest01.privateMethod(); //private 접근제한자는 해당 클래스 내에서만 사용 가능.
		
		//nonStaticMethod 변수 생성 없이 실행
		//준비과정과 실행을 한번에...
		new MethodTest01().NonStaticMethod(); // 해당 메소드를 여러번 사용해야 할 경우 매번 똑같이 반복해야 한다는 단점. 보통 한번만 실행해야 할 경우 사용.
		
	}
}
