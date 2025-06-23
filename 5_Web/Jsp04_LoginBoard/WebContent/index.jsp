<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h1>Login</h1>
		<form action="logincontroller.jsp" method="post">
			<input type="hidden" name="command" value="login">
			<table>
				<tr>
					<th>I D </th>
					<td><input type="text" name="id"></td>
				</tr>
				<tr>
					<th>P W </th>
					<td><input type="text" name="pw"></td> <!-- 실제로는 안보이게 타입을 pw로! -->
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="login">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>