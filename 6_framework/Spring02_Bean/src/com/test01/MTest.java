package com.test01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test01/applicationContext.xml");
		
		MessageBean fruit = (MessageBean)factory.getBean("fruit");
		fruit.sayHello();
		System.out.println();
		MessageBean apple = (MessageBean)factory.getBean("apple");
		apple.sayHello();
		
		System.out.println();
		//id가 mango인 bean을 가지고 와서 sayHello() 출력.
		//단, mango bean은 매개변수 3개인 생성자 이용하여 빈 생성! (매개변수 값은 마음대로!)
		MessageBean mango = (MessageBean)factory.getBean("mango");
		mango.sayHello();
	}

}
