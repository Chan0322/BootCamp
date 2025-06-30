package com.my.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.dao.MyBoardDao;
import com.my.dto.MyBoardDto;

@WebServlet("/myboard")
public class MyBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command = request.getParameter("command");
		System.out.println("command: "+command);
		
		MyBoardDao dao = new MyBoardDao();
		
		if(command.equals("list")) {
			List<MyBoardDto> res = dao.selectAll();
//			System.out.println(res.get(0).getMyname());
			
			request.setAttribute("list", res);
			
//			System.out.println("dao 완료!!");
//			System.out.println(res.get(1).getMyno());
			RequestDispatcher dis = request.getRequestDispatcher("mylist.jsp");
			dis.forward(request, response);
			
			
		}else if(command.equals("detail")){
			int myno = Integer.parseInt(request.getParameter("myno"));
			
			MyBoardDto res = dao.selectOne(myno);
//			System.out.println(res.getMytitle());	// 값이 잘 넘어오는지 체크하기 위함
//			System.out.println(res.getMyname());
			
			request.setAttribute("dto", res);
		
			RequestDispatcher dis = request.getRequestDispatcher("mydetail.jsp");
			dis.forward(request, response);
			
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
