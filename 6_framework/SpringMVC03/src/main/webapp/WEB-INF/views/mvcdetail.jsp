<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>detail</h1>
	<table>
		<tr>
			<th>Writer</th>
			<td>${dto.myname }</td>
		</tr>
		<tr>
			<th>Title</th>
			<td>${dto.mytitle }</td>
		</tr>
		<tr>
			<th>Content</th>
			<td><textarea rows="10" cols="40" readonly="readonly">${dto.mycontent }</textarea></td>
		</tr>
	</table>
</body>
</html>