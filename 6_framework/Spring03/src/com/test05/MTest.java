package com.test05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		// spring bean config 파일에서
		// Board 클래스 bean을 3개 생성하여 main애서 확인
		// 객체의 필드 값들은 자유롭게 작성해 생성해봅시다.
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test05/applicationContext.xml");
		
		Board kim = factory.getBean("kimcj", Board.class);
		Board lee = factory.getBean("leecj", Board.class);
		Board park = factory.getBean("parkcj", Board.class);
		
		System.out.println(kim);
		System.out.println(lee);
		System.out.println(park);
	}

}
