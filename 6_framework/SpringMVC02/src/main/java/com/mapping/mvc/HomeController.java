package com.mapping.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mapping.mvc.dto.AddressDto;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value="/command.do", method=RequestMethod.GET)
	public String getCommand(Model model, String name, @RequestParam("addr")String address, String phone) {
//		System.out.println("getCommand() 실행");
//		System.out.println(address);
		model.addAttribute("dto", new AddressDto(name, address, phone));
		
		return "getcommand";
	}
	
	@RequestMapping(value="/command.do", method=RequestMethod.POST)
	public String postCommand(Model model, @ModelAttribute AddressDto dto) {
		// 파라미터와 dto 필드 명이 같으면 이렇게 한번에 받아올 수 있다.
//		System.out.println("postCommand");
		System.out.println(dto.getName());
		System.out.println(dto.getAddr());
		System.out.println(dto.getPhone());
		
		model.addAttribute("dto", dto);
		
		return "postcommand";
	}
	
	// [2] board.do 요청을 받아 처리하는 메소드 작성
	//	- 입력받은 값은 BoardDto 객체로 받는다.
	//	boardres.jsp 페이지로 응답하고 입력받은 데이터를 출력해 확인한다.
}
