<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>${dto.name }님 환영합니다!</h3>
	<div>
		<span><a href="member?command=logout">로그아웃</a></span>
		<span><a href="member?command=userinfo&no=${dto.no }">마이페이지</a></span>
	</div>
</body>
</html>