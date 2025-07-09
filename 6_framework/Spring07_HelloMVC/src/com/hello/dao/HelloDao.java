package com.hello.dao;

import org.springframework.stereotype.Repository;

// Dao 클래스 선언
@Repository
public class HelloDao {
	
	public String getHello() {
		//System.out.println("dao!!");
		return "SpringMVC";
	}
}
