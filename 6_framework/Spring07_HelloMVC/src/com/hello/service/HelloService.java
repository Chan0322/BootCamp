package com.hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hello.dao.HelloDao;

//Service 클래스 선언
@Service
public class HelloService {

	@Autowired
	private HelloDao dao;
	
	public String getHello() {
		String str = dao.getHello();
		return "Hello, " + str;
	}
}
