package com.mvc.board;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvc.board.model.dto.MemberDto;
import com.mvc.board.model.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService service;
	
	@RequestMapping("/loginform.do")
	public String loginForm() {
		return "memlogin";
	}
	
	@RequestMapping("/ajlogin.do")
	@ResponseBody
	public Map<String, Boolean> login(@RequestBody MemberDto dto, HttpSession session){
		MemberDto res = service.login(dto);
		
		boolean chk = false;
		if(res != null) {
			chk = true;
			session.setAttribute("login", res);
		}
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("chk", chk);
		return map;
	}
	
	@RequestMapping("/registerform.do")
	public String insertMemForm() {
		return "memregisterform";
	}
	
	@RequestMapping("/register.do")
	public String insertMem(MemberDto dto) {
		int res = service.insert(dto);
		if(res>0) {
			return "redirect:loginform.do";
		}else {
			return "redirect:registerform.do";
		}
	}
}
