package com.boot.leaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.boot.leaf.dto.LeafDto;

@Controller
public class LeafController {
	
	@GetMapping("/hello")
	public String hello(Model model) {
		System.out.println("[hello]");
		model.addAttribute("name", "Thymeleaf!! ");
		return "hello";
	}
	
	@GetMapping("/util")
	public String util() {
		return "utility";
	}
	
	@GetMapping("/expr")
	public String expression(Model model) {
		model.addAttribute("name", "Thymeleaf");
		model.addAttribute("dto", new LeafDto("Java", 22));
		return "expression";
	}
}
