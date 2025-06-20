<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 한글 깨짐 방지 인코딩 설정 -->
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>ㄴㄴ

<!-- import -->
<%@page import="com.mvc.dao.MVCBoardDao"%>
<%@page import="com.mvc.dto.MVCBoardDto" %>
<%@page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 요청이 들어오면 확인하고, 그에 맞는 작업을 수행 후 응답헤준다. -->
<%
	//view에서 요청한 내용인 무엇인지 확인 할 수 있는 parameter 값.
	String command = request.getParameter("command");

	System.out.println("[command: "+command+"]");
	MVCBoardDao dao = new MVCBoardDao();
	
	if(command.equals("boardlist")){
		//필요 데이터 준비하고 해당하는 페이지로 전환
		
		//1. 데이터 준비
		List<MVCBoardDto> res = dao.selectAll();
		
		//2. list 페이지로 이동(준비된 데이터와 함께)
		request.setAttribute("allList", res);		//request 객체 안에 allList라는 이름으로 res를 담아준다. => 다음 페이지에서 받아볼 수 있음.
		
		pageContext.forward("boardlist.jsp");		// 해당하는 페이지로 페이지를 이동하겠다.
		//화면의 흐름을 제어하는 방법, 페이지 이동하는 방법
		// forward : request에 담긴 값이 유지된다. req, res 객체가 유지.
		//			 <jsp:foward>, pageContext.forward(jsp 내에서), requestDispatcher객체(서블릿)
		// redirect : 클라이언트가 새로운 페이지로 요청한 것과 같은 방식으로 페이지 이동
		//			  response.sendRedirect
		
	}else if(command.equals("boarddetail")){
		// 필요 데이터 준비 후 화면 전환
		
		int seq = Integer.parseInt(request.getParameter("seq"));
		MVCBoardDto res = dao.selectOne(seq);
		
		request.setAttribute("dto", res);
		pageContext.forward("boarddetail.jsp");
	}
%>

</body>
</html>