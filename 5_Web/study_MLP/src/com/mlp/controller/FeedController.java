package com.mlp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mlp.dao.BoardDao;
import com.mlp.dao.MemberDao;
import com.mlp.dto.BoardDto;
import com.mlp.dto.MemberDto;

@WebServlet("/feed")
public class FeedController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		HttpSession session = request.getSession(false);
		if(session==null || session.getAttribute("dto")==null) {
			response.sendRedirect("index.html");
			return;
		}
		
		String command = request.getParameter("command");
		
		BoardDao bdao = new BoardDao();
		
		if(command.equals("list")) {
			List<BoardDto> list = bdao.selectAll();
			request.setAttribute("list", list);
			RequestDispatcher dis = request.getRequestDispatcher("feedPage.jsp");
			dis.forward(request, response);
			
		}else if(command.equals("insertFeed")) {
			String feedtitle = request.getParameter("feedtitle");
			String feedcontent = request.getParameter("feedcontent");
			int memno = Integer.parseInt(request.getParameter("memno"));
			String memgroup = request.getParameter("memgroup");
			String memdepart = request.getParameter("memdepart");
			String memname = request.getParameter("memname");
			
			BoardDto dto = new BoardDto();
			dto.setFeedtitle(feedtitle);
			dto.setFeedcontent(feedcontent);
			dto.setMemno(memno);
			dto.setMemgroup(memgroup);
			dto.setMemdepart(memdepart);
			dto.setMemname(memname);
			
			int res = bdao.insert(dto);
			
			MemberDao mdao = new MemberDao();
			// 수정된 사용자 정보 다시 조회
		    MemberDto refreshedDto = mdao.selectOneByMemno(memno);
		    if (refreshedDto != null) {
		        session.setAttribute("dto", refreshedDto);
		    }
			
			if(res>0) {
				System.out.println("작성 성공");
				
				response.sendRedirect("feed?command=list");
			}else {
				System.out.println("작성 실패...");
				response.sendRedirect("feed?command=list");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
