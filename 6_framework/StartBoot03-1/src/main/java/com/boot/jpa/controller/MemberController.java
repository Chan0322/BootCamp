package com.boot.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boot.jpa.model.dao.MemberDao;
import com.boot.jpa.model.entity.MemberEntity;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberDao dao;
	
	@GetMapping("/list")
	public String selectAll(Model model) {
		
		List<MemberEntity> list = dao.findAll(Sort.by(Sort.Direction.ASC, "memberno"));
		
		model.addAttribute("list", list);
		return "memberlist";
	}
	
	@GetMapping("/insertform")
	public String insertForm() {
		System.out.println("[insertForm]");
		return "memberinsert";
	}
	
	@PostMapping("/insert")
	public String insert(MemberEntity dto) {
		System.out.println("[insert]");
		dao.save(dto);
		
		return "redirect:/member/list";
	}
	
	@GetMapping("/updateform")
	public String updateForm(int memberno, Model model) {
		System.out.println("[updateForm]");
		
		model.addAttribute("dto", dao.findByMemberno(memberno));
		
		return "memberupdate";
	}
	
	@PostMapping("/update")
	public String update(MemberEntity dto) {
		System.out.println("[update]");
		dao.save(dto);
		return "redirect:/member/list";
	}
	
	@GetMapping("/delete")
	public String delete(int memberno) {
		System.out.println("[delete]");
		dao.deleteByMemberno(memberno);
		return "redirect:/member/list";
	}
}
