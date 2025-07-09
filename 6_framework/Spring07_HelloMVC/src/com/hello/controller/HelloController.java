package com.hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hello.service.HelloService;

// 컨트롤러 선언
@Controller
public class HelloController {
	
	@Autowired
	private HelloService service;
	
	@RequestMapping(value="/hello.do")
	public String getHello(Model model) {
		//System.out.println("helloController getHello() 실행");
		String res = service.getHello();
		model.addAttribute("msg",res);	// 모델 객체에 담아놓으면 데이터 전송 가능해짐!
		return "/WEB-INF/views/hello.jsp";
	}
	
	/*
	@RequestMapping(value="/bye.do")
	public String getBye(@RequestParam("name")String myName) {
		//System.out.println("bye~");
		System.out.println(myName);
		return null;
	}
	*/
	@RequestMapping("/bye.do")
	public ModelAndView getBye(String name) {
		//System.out.println(name);
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("/WEB-INF/views/bye.jsp");	// 응답하고자 하는 뷰의 이름
		mav.addObject("msg", "bye, "+name);	// 응답 시 필요한 데이터
		
		return mav;
	}
	
	@RequestMapping("/res.do")
	public String getRes(String name, String addr, Model model) {
		model.addAttribute("resMsg", name + ":" + addr);
//		ModelAndView mav = new ModelAndView();
//		
//		mav.setViewName("/WEB-INF/views/res.jsp");
//		mav.addObject("name", "이름: "+name);
//		mav.addObject("addr", "주소: "+addr);
		
		return "/WEB-INF/views/res.jsp";
	}
}
