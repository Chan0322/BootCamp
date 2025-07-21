package com.boot.jpa.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boot.jpa.model.dao.JpaDao;
import com.boot.jpa.model.entity.JpaEntity;

@Controller
@RequestMapping("/board")
public class JpaController {

	@Autowired
	private JpaDao dao;
	
	@GetMapping("/list")
	public String selectAll(Model model) {
		System.out.println("[list]");
		
		// findAll을 dao에서 만들지 않아도 jpa는 자동으로 구현되어 있음!
		//List<JpaEntity> list = dao.findAll();
		List<JpaEntity> list = dao.findAll(Sort.by(Sort.Direction.ASC, "myno"));
		
		//System.out.println(list.get(1).getMytitle());
		
		model.addAttribute("list", list);
		return "jpalist";
	}
	
	@GetMapping("/detail")
	public String selectOne(int myno, Model model) {
		System.out.println("[detail]");
		
		JpaEntity dto = dao.findByMyno(myno);
		//findBy필드이름 : 필드 이름을 기반으로 조회
		
		model.addAttribute("dto", dto);
		
		//System.out.println(dto.getMyname());
		return "jpadetail";
	}
	
	@GetMapping("/insertform")
	public String insertForm() {
		System.out.println("[insertForm]");
		return "jpainsert";
	}
	
	@PostMapping("/insert")
	public String insert(JpaEntity dto) {
		System.out.println("[insert]");
		//System.out.println(dto.getMyname()+", "+dto.getMytitle()+", "+dto.getMycontent());
		dto.setMydate(new Date());
		
//		JpaEntity res = dao.save(dto);
		dao.save(dto);
		
//		System.out.println(res.getMyno()+", "+res.getMyname());
		
		return "redirect:list";
	}
	
	@GetMapping("/updateform")
	public String updateForm(int myno, Model model) {
		System.out.println("[updateform]");
		model.addAttribute("dto", dao.findByMyno(myno));
		return "jpaupdate";
	}
	
	@PostMapping("/update")
	public String update(JpaEntity dto) {
		System.out.println("[update]");
		//System.out.println(dto.getMytitle()+", "+dto.getMyno());
		dao.save(dto);	// 수정도 save를 통해 진행한다.
		// jpa에서 save() => insert or update 작업을 진행한다.
		// id가 null => insert 실행
		// id가 존재, db에 id와 일치하는 데이터 존재 => update 실행.
		
		return "redirect:/board/detail?myno="+dto.getMyno();
	}
	
	@GetMapping("/delete")
	public String delete(int myno) {
		System.out.println("[delete]");
		
//		dao.deleteById(myno);
		dao.deleteByMyno(myno);
		
		return "redirect:/board/list";
	}
}
