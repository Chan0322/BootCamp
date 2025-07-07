package com.test04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Developer {

	private Emp emp;
	private String dept;
	
	public Developer() {
		super();
	}
	
	
	@Autowired
	public Developer(@Qualifier("emp2") Emp emp, @Value("개발팀") String dept) {
		super();
		this.emp = emp;
		this.dept = dept;
	}



	@Override
	public String toString() {
		return emp + " \t 부서: " + dept;
	}
}
