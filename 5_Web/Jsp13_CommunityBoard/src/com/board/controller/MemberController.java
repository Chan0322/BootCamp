package com.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.dao.MemberDao;
import com.board.dto.MemberDto;

@WebServlet("/member")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		HttpSession session = request.getSession();
		
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
			
			
		}else if(command.equals("login")) {
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			
			MemberDto dto = new MemberDto();
			dto.setId(id);
			dto.setPw(pw);
			
			MemberDto res = mdao.login(dto);
			
			if(res.getId() != null || res.getEnabled().equals("Y")) {
				System.out.println("로그인 성공!");
				session.setAttribute("dto", res);
				session.setMaxInactiveInterval(60*60);
				
				response.sendRedirect("board?command=list");
			}else {
				System.out.println("로그인 실패ㅠ");
				response.sendRedirect("index.html");
			}
			
		}else if(command.equals("logout")) {
			session.invalidate();
			System.out.println("정상적으로 로그아웃 되었습니다. 안녕히가세요!");
			response.sendRedirect("index.html");
			
		}else if(command.equals("userinfo")) {
			int no = Integer.parseInt(request.getParameter("no"));
			
			MemberDto dto = mdao.selectMember(no);
			
			request.setAttribute("dto", dto);
			response.sendRedirect("memberinfo.jsp");
			
		}else if(command.equals("deletemem")) {
			int no = Integer.parseInt(request.getParameter("no"));
			
			int res = mdao.deleteMember(no);
			
			if(res>0) {
				System.out.println("탈퇴처리 되었습니다. 다음에 또 만나요...");
				session.invalidate();
				response.sendRedirect("index.html");
			}else {
				System.out.println("탈퇴 실패! 도망칠 수 없어요...");
				response.sendRedirect("member?command=userinfo&no="+no);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
