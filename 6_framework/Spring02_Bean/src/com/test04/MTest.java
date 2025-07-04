package com.test04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test04/applicationContext.xml");
		
		Address lee = (Address)factory.getBean("lee");
		System.out.println(lee);
		
		Address kim = (Address)factory.getBean("kim");
		System.out.println(kim);
		
		Member user01 = (Member)factory.getBean("user01");
		System.out.println(user01);
		
		Member user02 = (Member)factory.getBean("user02");
		System.out.println(user02);
		
		Member user03 = (Member)factory.getBean("user03");
		System.out.println(user03);
	}
}
