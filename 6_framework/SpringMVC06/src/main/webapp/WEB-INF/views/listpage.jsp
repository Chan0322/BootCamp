<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>${login.memname }님 환영합니다.</h3>
	<h1>전체 게시글</h1>
	<table>
		<tr>
			<th>NO</th>
			<th>Writer</th>
			<th>Title</th>
			<th>Date</th>
		</tr>
		<c:forEach items="${list }" var="dto">
			<tr>
				<td>${dto.testno }</td>
				<td>${dto.testname }</td>
				<td><a href="detail.do?testno=${dto.testno }">${dto.testtitle }</a></td>
				<td>${dto.testdate }</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="4" align="right">
				<button onclick="location.href='insertform.do'">작성</button>
			</td>
		</tr>
	</table>
</body>
</html>