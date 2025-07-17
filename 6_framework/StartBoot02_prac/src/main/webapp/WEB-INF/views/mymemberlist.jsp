<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table tr td{
		text-align: center;
	}
</style>
</head>
<body>
	<h1>전체 회원</h1>
	<table>
		<col width="100px"><col width="100px"><col width="700px"><col width="100px">
		<tr>
			<th>회원번호</th>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
		</tr>
		<c:forEach items="${list }" var="dto">
			<tr>
				<td>${dto.memberno }</td>
				<td>${dto.memberid }</td>
				<td>${dto.memberpw }</td>
				<td>${dto.membername }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>