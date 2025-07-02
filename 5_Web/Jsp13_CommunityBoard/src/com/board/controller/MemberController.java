package com.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.MemberDao;
import com.board.dto.MemberDto;

@WebServlet("/member")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command = request.getParameter("command");
		
		MemberDao mdao = new MemberDao();
		
		if(command.equals("registform")) {
			response.sendRedirect("registmember.jsp");
			
		}else if(command.equals("idchk")) {
			String id = request.getParameter("id");
			String res = mdao.idChk(id);

			boolean idnotused = true;
			if(res != null) {
				idnotused = false;
			}
			
			response.sendRedirect("idcheck.jsp?idnotused="+idnotused);
			
			
		}else if(command.equals("insertmember")) {
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String name = request.getParameter("name");
			String phone = request.getParameter("phone");
			
			MemberDto dto = new MemberDto();
			dto.setId(id);
			dto.setPw(pw);
			dto.setName(name);
			dto.setPhone(phone);
			
			int res = mdao.insertMem(dto);
			
			if(res>0) {
				System.out.println("회원가입 성공!");
				response.sendRedirect("index.html");
			}else {
				System.out.println("회원가입 실패ㅠ");
				response.sendRedirect("member?command=registform");
			}
			
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
