<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>index</h1>
	
	<!-- get방식 -->
	<h3><a href="restdto">1.selectList</a></h3>
	<h3><a href="restdto/1">2.selectOne</a></h3>
	<!-- post -->
	<form action="restdto" method="post">
		ID:<input type="text" name="restid"><br>
		PW:<input type="text" name="restpw"><br>
		NAME:<input type="text" name="restname"><br>
		<input type="submit" value="insert">
	</form>
	<hr>
	<!-- delete -->
	<!-- html에선 delete method 지원 안함. => 강제 변환 작업 필요 (web.xml 필터 추가)-->
	<form action="restdto/1" method="post">
		<input type="hidden" name="_method" value="delete">
		<input type="submit" value="delete">
	</form>
	
	<!-- put -->
	<!-- put method로 요청을 보내 2번 게시글의 pw 값을 db에서 수정하자. -->
	<!-- 
	<form action="restdto/2" method="post">
		<input type="hidden" name="_method" value="put">
		변경 할 비밀번호 : <input type="text" name="restpw"><br>
		<input type="submit" value="update">
	</form>
	-->
	<form action="restdto" method="post">
		<input type="hidden" name="_method" value="put">
		<input type="hidden" name="restno" value="2">
		변경 할 비밀번호 : <input type="text" name="restpw"><br>
		<input type="submit" value="update">
	</form>
</body>
</html>