package com.boot.prac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/member")
@Controller
public class MemberController {

	@GetMapping("/registform")
	public String registForm() {
		System.out.println("[registerform]");
		return "memregister";
	}
}
