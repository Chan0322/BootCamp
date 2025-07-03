package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	public static void main(String[] args) {
		// 레이지 로딩, 게으른 호출. getBean이 발생해야 호출이 시작됨.
//		Resource res = new ClassPathResource("com/test03/beans.xml");
//		BeanFactory factory = new XmlBeanFactory(res);
		
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test03/beans.xml");
		
		MessageBean bean = (MessageBean)factory.getBean("korean");
		bean.sayHello("스프링");
		
		bean = (MessageBean)factory.getBean("english");
		bean.sayHello("Spring");
	}
}
