<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body{
		font-family: 'Segoe UI', sans-serif;
		background-color: #f8f9fa;
		margin: 0;
		padding: 40px;
	}
	
	h1{
		text-align: center;
		color: #2c3e50;
		margin-bottom: 30px;
	}
	
	form{
		max-width: 600px;
		margin: 0 auto;
		background-color: white;
		border-radius: 8px;
		box-shadow: 0 0 10px rgba(0,0,0,0.1);
	}
	table{
		width: 100%;
		border-collapse: collapse;
	}
	th{
		text-align: left;
		padding: 10px;
		background-color: #ecf0f1;
		color: #34495e;
		width: 120px;
	}
	td{
		padding: 10px;
	}
	textarea{
		width: 90%;
		padding: 10px;
		font-size: 14px;
		resize: vertical;
		border: 1px solid #ccc;
		border-radius: 4px;
	}
	
	input[type="submit"]{
		float: right;
		background-color: #3498db;
		color: white;
		padding: 10px 20px;
		border: none;
		border-radius: 6px;
		font-size: 16px;
		cursor: pointer;
		transition: background-color 0.3s;
	}
	
	input[type="submit"]:hover{
		background-color: #2980b9;
	}
</style>
</head>
<body>
	<h1>댓글 수정</h1>
	<form action="feed" method="post">
		<input type="hidden" name="commentno" value="${dto.commentno}">
		<input type="hidden" name="command" value="commentUpdate">
		<table>
			<tr>
				<th>작성자</th>
				<td>${dto.writer }</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td>${dto.regdate }</td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="5" cols="50" name="content">${dto.content }</textarea></td>
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