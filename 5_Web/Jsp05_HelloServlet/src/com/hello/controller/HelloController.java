package com.hello.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// hello라는 요청이 클라이언트로부터 넘어오면 실행되는 서블릿
public class HelloController extends HttpServlet {
	//hello라는 요청이 get 방식을 넘어올 때 실행.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청을 보내는 방식이 get 방식일 경우 실행.
		System.out.println("get 방식!");
		String command = request.getParameter("command");
		System.out.println("command: "+command);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<h1 style='background-color:skyblue;'>HelloServlet</h1>");
		out.print("<span>서블릿 연습</span>");
		out.print("<a href='home.html'>돌아가기</a>");
	}
	
	//hello라는 요청이 post 방식을 넘어올 때 실행
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		// 요청을 보내는 방식이 post 방식일 경우 실행.
		System.out.println("post 방식!");
		String command = request.getParameter("command");
		System.out.println("command: "+command);
		
		response.sendRedirect("Test.jsp");
	}
}
