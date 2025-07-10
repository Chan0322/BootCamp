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
			
		}else if(command.equals("memupdate")) {
			int memno = Integer.parseInt(request.getParameter("memno"));
			String memname = request.getParameter("memname");
			String mememail = request.getParameter("mememail");
			String memphone = request.getParameter("memphone");
			String mempw = request.getParameter("mempw");
			
			MemberDto dto = new MemberDto();
			dto.setMemno(memno);
			dto.setMemname(memname);
			dto.setMememail(mememail);
			dto.setMemphone(memphone);
			dto.setMempw(mempw);
			
			int res = mdao.update(dto);
			
			if(res>0) {
				System.out.println("프로필 수정 성공!");
				
				// 수정된 사용자 정보 다시 조회
			    MemberDto refreshedDto = mdao.selectOneByMemno(memno);
			    if (refreshedDto != null) {
			        session.setAttribute("dto", refreshedDto);
			    }
				
				response.sendRedirect("feed?command=list");
			}else {
				System.out.println("수정 실패...");
				response.sendRedirect("feed?command=list&&memno="+memno);
			}
			
		}else if(command.equals("insertmemform")) {
			response.sendRedirect("insertmemform.jsp");
			
		}else if(command.equals("idchk")) {
			String memid = request.getParameter("memid");
			String res = mdao.idChk(memid);

			boolean idnotused = true;
			if(res != null) {
				idnotused = false;
			}
			
			response.sendRedirect("idcheck.jsp?idnotused="+idnotused);
			
		}else if(command.equals("insertmem")) {
			String memgroup = request.getParameter("memgroup");
			String memdepart = request.getParameter("memdepart");
			String memname = request.getParameter("memname");
			String memid = request.getParameter("memid");
			String mempw = request.getParameter("mempw");
			String mememail = request.getParameter("mememail");
			String memphone = request.getParameter("memphone");
			
			MemberDto dto = new MemberDto();
			dto.setMemgroup(memgroup);
			dto.setMemdepart(memdepart);
			dto.setMemname(memname);
			dto.setMemid(memid);
			dto.setMempw(mempw);
			dto.setMememail(mememail);
			dto.setMemphone(memphone);
			
			int res = mdao.insert(dto);
			
			if(res>0) {
				System.out.println("회원가입 성공! 환영합니다.");
				response.sendRedirect("index.html");
			}else {
				System.out.println("회원가입 실패.. 다시 시도해 주세요ㅠㅠ");
				response.sendRedirect("index.html");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
