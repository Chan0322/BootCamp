package com.boot.prac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class StartBoot02PracApplication {

	public static void main(String[] args) {
		SpringApplication.run(StartBoot02PracApplication.class, args);
	}

	@RequestMapping("/*")
	public String root() {
		return "index";
	}
}
