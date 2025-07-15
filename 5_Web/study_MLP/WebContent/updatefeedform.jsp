<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/editFeedStyle.css">
</head>
<body>
	<h1>피드 수정</h1>
	<form action="feed" method="post">
		<input type="hidden" name="command" value="update">
		<input type="hidden" name="feedno" value="${dto.feedno }">
		<table>
			<tr>
				<th>글 번호</th>
				<td>${dto.feedno }</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${dto.memname }</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td>${dto.regdate }</td>
			</tr>
			<tr>
				<th>제 목</th>
				<td><input type="text" name="feedtitle" value="${dto.feedtitle }"></td>
			</tr>
			<tr>
				<th>내 용</th>
				<td><textarea rows="10" cols="40" name="feedcontent">${dto.feedcontent} </textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>