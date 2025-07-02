package com.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.dao.BoardDao;
import com.board.dto.BoardDto;

@WebServlet("/board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		HttpSession session = request.getSession(false);
		if(session == null || session.getAttribute("dto")==null) {
			response.sendRedirect("index.html");
			return;
		}
		
		String command = request.getParameter("command");
		
		BoardDao bdao = new BoardDao();
		
		if(command.equals("list")) {
			List<BoardDto> list = bdao.selectAll();
			
			request.setAttribute("list", list);
			RequestDispatcher dis = request.getRequestDispatcher("boardlist.jsp");
			dis.forward(request, response);
			
			
		}else if(command.equals("writeform")) {
			response.sendRedirect("boardwrite.jsp");
			
			
		}else if(command.equals("write")) {
			String name = request.getParameter("name");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			BoardDto dto = new BoardDto();
			dto.setName(name);
			dto.setTitle(title);
			dto.setContent(content);
			
			int res = bdao.insert(dto);
			
			if(res>0) {
				System.out.println("글 작성 성공");
				response.sendRedirect("board?command=list");
			}else {
				System.out.println("글 작성 실패......");
				response.sendRedirect("board?command=list");
			}
			
			
		}else if(command.equals("detail")) {
			int no = Integer.parseInt(request.getParameter("no"));
			
			BoardDto dto = bdao.selectOne(no);
			
			request.setAttribute("dto", dto);
			RequestDispatcher dis = request.getRequestDispatcher("boarddetail.jsp");
			dis.forward(request, response);
			
			
		}else if(command.equals("updateform")) {
			int no = Integer.parseInt(request.getParameter("no"));
			
			BoardDto dto = bdao.selectOne(no);
			
			request.setAttribute("dto", dto);
			RequestDispatcher dis = request.getRequestDispatcher("boardupdate.jsp");
			dis.forward(request, response);
			
			
		}else if(command.equals("update")) {
			int no = Integer.parseInt(request.getParameter("no"));
			String name = request.getParameter("name");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			BoardDto dto = new BoardDto();
			dto.setNo(no);
			dto.setName(name);
			dto.setTitle(title);
			dto.setContent(content);
			
			int res = bdao.update(dto);
			
			if(res>0) {
				System.out.println("업데이트 성공!!!");
				response.sendRedirect("board?command=list");
			}else {
				System.out.println("업데이트 실패. 다시 시도해주세요ㅠ");
				response.sendRedirect("board?command=updateform&no="+no);
			}
			
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
