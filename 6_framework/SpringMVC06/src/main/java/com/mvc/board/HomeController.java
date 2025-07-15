package com.mvc.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.board.model.dto.BoardDto;
import com.mvc.board.model.service.BoardService;

// board (test)

@Controller
public class HomeController {
	
	@Autowired
	private BoardService service;
	
	@RequestMapping("/list.do")
	public String list(Model model) {
		List<BoardDto> res = service.selectAll();
		
		model.addAttribute("list", res);
		return "listpage";
	}
	
	@RequestMapping("/detail.do")
	public String detail(int testno, Model model) {
		BoardDto dto = service.selectOne(testno);
		
		model.addAttribute("dto", dto);
		
		return "detailpage";
	}
	
	@RequestMapping("/updateform.do")
	public String updateForm(int testno, Model model) {
		BoardDto dto = service.selectOne(testno);
		model.addAttribute("dto", dto);
		return "updatepage";
	}
	
	@RequestMapping("/update.do")
	public String update(BoardDto dto) {
		int res = service.update(dto);
		
		return null;
	}
}
