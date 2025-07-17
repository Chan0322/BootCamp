package com.boot.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@SpringBootApplication
//=> @Configuration + @EnableAutoConfiguration + @ComponentScan
public class SpringBoot01Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot01Application.class, args);
		
		// run이 실행되면서 스프링 부트가 동작하게 된다.
	}

	@GetMapping("/hello")
	//get 방식으로 들어오는 요청을 처리할 수 있다.
	public String hello() {
		System.out.println("controller hello method");
		return "test";
	}
}
