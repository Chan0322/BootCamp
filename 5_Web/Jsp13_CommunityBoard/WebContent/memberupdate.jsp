<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원정보 수정</h1>
	<form action="member" method="post">
		<input type="hidden" name="command" value="updatemem">
		<input type="hidden" name="no" value="${dto.no }">
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
				<td><input type="text" name="pw" value="${dto.pw }"></td>
			</tr>
			<tr>
				<th>이 름</th>
				<td><input type="text" name="name" value="${dto.name }"></td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td><input type="text" name="phone" value="${dto.phone }"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정완료">
					<input type="button" value="이전으로" onclick="history.back();">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>