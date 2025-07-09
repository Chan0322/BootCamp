<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Board</h1>
	<table>
		<tr>
			<th>no</th>
			<td>${dto.no }</td>
		</tr>
		<tr>
			<th>writer</th>
			<td>${dto.writer }</td>
		</tr>
		<tr>
			<th>title</th>
			<td>${dto.title }</td>
		</tr>
		<tr>
			<th>content</th>
			<td><textarea rows="10" cols="40" readonly="readonly">${dto.content }</textarea></td>
		</tr>
	</table>
</body>
</html>