package com.mlp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mlp.dao.MemberDao;
import com.mlp.dto.MemberDto;


@WebServlet("/member")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		HttpSession session = request.getSession();
		
		String command = request.getParameter("command");
		
		MemberDao mdao = new MemberDao();
		
		if(command.equals("login")) {
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			
			MemberDto dto = new MemberDto();
			dto.setMemid(id);
			dto.setMempw(pw);
			
			MemberDto res = mdao.selectOne(dto);
			
			if(res.getMemid()!=null || res.getMemenabled().equals("Y")) {
				System.out.println("로그인 성공!");
				session.setAttribute("dto", res);
				session.setMaxInactiveInterval(60*60);
				
				response.sendRedirect("feed?command=list");
			}else {
				System.out.println("로그인 실패..");
				response.sendRedirect("index.html");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
