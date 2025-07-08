package com.test05;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyAspect {
	//Pointcut ReUse, 메소드 방식이라고도 함.
	
	// Pointcut으로 사용되는 메소드는 void로, 비어있어야 한다.
	
	@Pointcut("execution(public void *(..))")
	public void myClass() {
	}
	
	@Pointcut("execution(public String *(..))")
	public void yourClass() {
	}
	
	@Before("myClass()")
	public void before(JoinPoint join) {
		System.out.println("컴퓨터를 켠다.");
	}
	
	@After("myClass()")
	public void after() {
		System.out.println("집에 간다.");
	}
	
}
