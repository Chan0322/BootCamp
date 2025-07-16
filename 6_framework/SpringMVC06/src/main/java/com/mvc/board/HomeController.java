package com.mvc.board;

import java.util.List;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.board.model.dto.BoardDto;
import com.mvc.board.model.dto.MemberDto;
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
	public String updateForm(int testno, int memno, Model model, HttpSession session) {
		MemberDto mem = (MemberDto) session.getAttribute("login");
		BoardDto dto = null;
		if(mem.getMemno()==memno) {
			dto = service.selectOne(testno);
			model.addAttribute("dto", dto);
			return "updatepage";
		}else {
			System.out.println("작성자 본인만 수정 가능합니다.");
			return "redirect:detail.do?testno="+testno;
		}
	}
	
	@RequestMapping("/update.do")
	public String update(BoardDto dto) {
		int res = service.update(dto);
		if(res>0) {
			return "redirect:list.do";
		}else {
			return "redirect:detail.do?testno="+dto.getTestno();
		}
	}
	
	@RequestMapping("/insertform.do")
	public String insertForm() {
		
		return "insertpage";
	}
	
	@RequestMapping("/insert.do")
	public String insert(BoardDto dto) {
		int res = service.insert(dto);
		if(res>0) {
			return "redirect:list.do";
		}else {
			return "redirect:list.do";
		}
	}
	
	@RequestMapping("/delete.do")
	public String delete(int testno, int memno, HttpSession session) {
		MemberDto mem = (MemberDto) session.getAttribute("login");
		int res = 0;
		if(mem.getMemno()==memno) {
			res = service.delete(testno);
		}else{
			System.out.println("작성자 본인만 삭제할 수 있습니다.");
			return "redirect:detail.do?testno="+testno;
		}
		if(res>0) {
			return "redirect:list.do";
		}else {
			System.out.println("삭제 실패");
			return "redirect:list.do";
		}
	}
}
