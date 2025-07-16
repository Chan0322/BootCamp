<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 작성</h1>
	<form action="insert.do" method="post">
		<input type="hidden" name="memno" value="${login.memno }">
		<table>
			<tr>
				<td colspan="2" align="center">
					내용을 입력하세요.
				</td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="testname" value="${login.memname }" readonly="readonly"></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="testtitle"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="10" cols="40" name="testcontent"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="작성완료">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>