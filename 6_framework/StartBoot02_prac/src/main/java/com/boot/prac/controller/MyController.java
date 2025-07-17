package com.boot.prac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boot.prac.model.dto.MyDto;
import com.boot.prac.model.service.MyService;

@Controller
@RequestMapping("/mymember")
public class MyController {

	@Autowired
	private MyService service;
	
	@GetMapping("/list")
	public String selectList(Model model) {
		List<MyDto> res = service.selectList();
		
		model.addAttribute("list", res);
		
		return "mymemberlist";
	}
}
