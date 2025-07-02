<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table{
		text-align:center;
	}
</style>
</head>
<body>
	<h3>${dto.name }님 환영합니다!</h3>
	<div>
		<span><a href="member?command=logout">로그아웃</a></span>
		<span><a href="member?command=userinfo&no=${dto.no }">마이페이지</a></span>
	</div>
	<table>
		<tr>
			<th>글 번호</th>
			<th>작성자</th>
			<th>제 목</th>
			<th>작성일</th>
		</tr>
		<c:forEach var="bDto" items="${list }">
			<tr>
				<td>${bDto.no }</td>
				<td>${bDto.name }</td>
				<td><a href="board?command=detail&no=${bDto.no }">${bDto.title }</a></td>
				<td><fmt:formatDate value="${bDto.regdate }" pattern="yy년MM월dd일hh시mm분ss초"/></td>
			</tr>
		</c:forEach>
		<tr>
			<td><input type="button" value="글 작성" onclick="location.href='board?command=writeform&writer=${dto.name}'"></td>
		</tr>
	</table>
</body>
</html>