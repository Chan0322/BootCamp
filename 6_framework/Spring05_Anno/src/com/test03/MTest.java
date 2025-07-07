package com.test03;

import org.springframework.beans.factory.FactoryBeanNotInitializedException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		
		// 두 클래스(lgtv, samsungoledtv)의 빈을 생성하여
		// main에서 가져와 각각의 메소드 실행 하며 확인
		// 단, annotation을 활용하여 bean 생성!
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test03/applicationContext.xml");
		
		TV lgTV = factory.getBean("lgTV", LgTV.class);
		lgTV.powerOn();
		lgTV.powerOff();
		
		TV samsungTV = factory.getBean("sam", SamsungOLEDTV.class);
		samsungTV.powerOn();
		samsungTV.powerOff();
		
		
		samsungTV = factory.getBean("samsung", SamsungOLEDTV.class);
		samsungTV.powerOn();
		samsungTV.powerOff();
	}

}
