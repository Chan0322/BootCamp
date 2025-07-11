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
		<tr>
			<td colspan="2" align="right">
				<input type="button" value="수정" onclick="location.href='updateform.do?myno=${dto.myno}'">
				<input type="button" value="삭제" onclick="location.href='delete.do?myno=${dto.myno}'">
				<!-- 
					삭제 구현
					detail페이지에서 확인하는 해당 게시글 삭제 진행.
					요청 url : delete.do
					성공 : list 페이지로
					실패 : detail 페이지로
				 -->
			</td>
		</tr>
	</table>
</body>
</html>