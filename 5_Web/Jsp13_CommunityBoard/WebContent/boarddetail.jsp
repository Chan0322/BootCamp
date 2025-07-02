<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 상세 조회</h1>
	<form action="board" method="post">
		<input type="hidden" name="command" value="updateform">
		<input type="hidden" name="no" value="${dto.no }">
		<table>
			<tr>
				<th>글 번호</th>
				<td>${dto.no }</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${dto.name }</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td><fmt:formatDate value="${dto.regdate }" pattern="yy년MM월dd일hh시mm분ss초"/></td>
			</tr>
			<tr>
				<th>제 목</th>
				<td>${dto.title }</td>
			</tr>
			<tr>
				<th>내 용</th>
				<td><textarea rows="10" cols="40" readonly="readonly">${dto.content }</textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정">
					<input type="button" value="삭제" onclick="location.href='board?command=delete&no=${dto.no}'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>