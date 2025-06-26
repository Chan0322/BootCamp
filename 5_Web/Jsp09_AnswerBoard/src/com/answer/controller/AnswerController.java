package com.answer.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.answer.dto.AnswerDto;
import com.answer.service.AnswerService;

// .do 없이도 요청 가능.
@WebServlet("/answer")
public class AnswerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command = request.getParameter("command");
		System.out.println("["+command+"}");
		
		AnswerService service = new AnswerService();
		
		if(command.equals("list")) {
			request.setAttribute("list", service.selectAll());
			disp("boardlist.jsp", request, response);
			
		}else if(command.equals("writeform")) {
			response.sendRedirect("boardwrite.jsp");
			
		}else if(command.equals("boardwrite")) {
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String writer = request.getParameter("writer");
			
			AnswerDto dto = new AnswerDto();
			dto.setTitle(title);
			dto.setContent(content);
			dto.setWriter(writer);
			
			int res = service.insert(dto);
			
			if(res>0) {
				request.setAttribute("msg", "게시글 작성 성공");
				request.setAttribute("url", "answer?command=list");
			}else {
				request.setAttribute("msg", "게시글 작성 실패");
				request.setAttribute("url", "answer?command=writeform");
			}
			disp("result.jsp", request, response);
			
		}
	}

	private void disp(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
