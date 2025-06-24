package com.hello.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 어노테이션을 통한 서블릿 매핑   hi 라는 요청이 들어오면 실행.
@WebServlet("/hi")
public class HiController extends HttpServlet {
	//hello라는 요청이 get 방식을 넘어올 때 실행.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청을 보내는 방식이 get 방식일 경우 실행.
		System.out.println("get 방식!");
		String command = request.getParameter("command");
		System.out.println("command: "+command);
	}
	
	//hello라는 요청이 post 방식을 넘어올 때 실행
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		// 요청을 보내는 방식이 post 방식일 경우 실행.
		System.out.println("post 방식!");
		String command = request.getParameter("command");
		System.out.println("command: "+command);
	}
}
