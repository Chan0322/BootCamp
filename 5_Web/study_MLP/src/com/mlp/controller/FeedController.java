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
import com.mlp.dto.BoardDto;

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
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
