<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>마이페이지</h1>
	<table>
		<tr>
			<th>회원번호</th>
			<td>${dto.no }</td>
		</tr>
		<tr>
			<th>아 이 디</th>
			<td>${dto.id }</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td>${dto.pw }</td>
		</tr>
		<tr>
			<th>이 름</th>
			<td>${dto.name }</td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td>${dto.phone }</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" value="탈퇴하기" onclick="location.href='member?command=deletemem&no=${dto.no}'">
				<input type="button" value="정보수정" onclick="location.href='member?command=updatememform&no=${dto.no}'">
				<input type="button" value="이전으로" onclick="history.back();">
			</td>
		</tr>
	</table>
</body>
</html>