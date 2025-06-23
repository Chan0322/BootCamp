<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<%@page import="com.login.dto.MyMemberDto"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	MyMemberDto dto = (MyMemberDto)session.getAttribute("dto");	// Object 타입 객체로 저장되어 있으므로 형변환 필요.
	if(dto == null){
		//로그인 상태가 아니라면 초기 화면으로 이동!
		pageContext.forward("index.jsp");
	}
%>
	<div>
		<span><%=dto.getMyname() %> 님 환영합니다.(등급: <%=dto.getMyrole() %>)</span>
		<button onclick="location.href='logincontroller.jsp?command=logout'">logout</button>
	</div>
	<h1>Admin Main</h1>
	<div>
		<h3><a href="logincontroller.jsp?command=userlistall">회원정보 조회(All)</a></h3>
	</div>
</body>
</html>