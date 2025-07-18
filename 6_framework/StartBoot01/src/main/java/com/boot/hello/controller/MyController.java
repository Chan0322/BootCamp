package com.boot.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

	//@GetMapping("/bye")
	@RequestMapping("/bye")
	public String bye() {
		System.out.println("mycontroller bye method");
		return "bye";
	}
}
