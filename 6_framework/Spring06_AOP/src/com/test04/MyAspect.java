package com.test04;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAspect {
	
	@Before("execution(public * com.test04.*.*(..))")
	public void before(JoinPoint join) {
		System.out.println(join.getTarget().getClass().getSimpleName()); // 호출되는 클래스의 이름
		System.out.println(join.getSignature().getName()); // 호출되는 메소드의 이름
		System.out.println(Arrays.deepToString(join.getArgs()));
		
		System.out.println("컴퓨터를 켠다.");
	}
	
	//finally 처럼 종료 시 실행
	@After("execution(public * *(..))")
	public void after(JoinPoint join) {
		System.out.println("집에 간다.");
	}
	// After는 다 끝난 후에. AfterReturning은 return 한 이후에
	@AfterReturning(pointcut="execution(public * *(..))", returning="returnVal")
	public void returning(Object returnVal) {
		System.out.println(returnVal+" 공부 하는 날입니다!");
	}
	
	// 타겟이 실행되다 예외 발생 시 동작
	@AfterThrowing(pointcut="execution(public * *(..))")
	public void throwing() {
		System.out.println("쉬는 날이었다.");
	}
}
