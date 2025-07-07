package com.test04;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
	
	@Bean(name="emp1")
	public Emp emp1() {
		return new Emp("박창진", 30);
	}
	
	@Bean(name="emp2")
	public Emp emp2() {
		return new Emp("최창진", 50);
	}
}
