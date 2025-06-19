<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<%@page import="com.board.dto.BoardDto"%>
<%@page import="com.board.dao.BoardDao"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#updateform{
		display:none;
	}
</style>
<script type="text/javascript">
	function updateFormView(){
		document.getElementById("updateform").style.display = "block";
		document.getElementById("detailform").style.display = "none";
	}
	//detailform을 보여주고, updateform을 숨긴다.
	function detailFormView(){
		document.getElementById("updateform").style.display = "none";
		document.getElementById("detailform").style.display = "block";
	}
</script>
</head>
<body>
	<!-- parameter로 넘어오는 seq를 받아 db에서 일치하는 게시글을 조회하여 화면에 출력 -->
<%
	int seq = Integer.parseInt(request.getParameter("seq"));	// 넘어오는 seq 값을 받음
	
	BoardDao dao = new BoardDao();
	BoardDto dto = dao.selectOne(seq);	// 일치하는 게시글 하나를 조회해 받아온다.
%>
<div id="detailform">
	<h1>Detail</h1>
	<table>
		<tr>
			<th>SEQ</th>
			<td><%=dto.getSeq() %></td>
		</tr>
		<tr>
			<th>WRITER</th>
			<td><%=dto.getWriter() %></td>
		</tr>
		<tr>
			<th>DATE</th>
			<td><%=dto.getRegdate() %></td>
		</tr>
		<tr>
			<th>TITLE</th>
			<td><%=dto.getTitle() %></td>
		</tr>
		<tr>
			<th>CONTENT</th>
			<td><textarea rows="10" cols="40" readonly="readonly"><%=dto.getContent() %></textarea></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" value="수정" onclick="updateFormView();">
				<input type="button" value="삭제" onclick="location.href='boarddelete.jsp?seq=<%=dto.getSeq()%>'">
				<input type="button" value="목록" onclick="location.href='boardlist.jsp'">
			</td>
		</tr>
	</table>
</div>
<!-- ---------------------------------------------------------------- -->
<div id="updateform">
	<h1>Update</h1>
	<!-- 이미 detail 폼에서 받은 dto 객체 이용 -->
	<form action="boardupdate_res.jsp" method="post">	<!-- 이 페이지로 데이터를 넘겨줄 것. -->
		<input type="hidden" name="seq" value="<%=dto.getSeq() %>">		<!-- seq 값을 넘겨주기 위해 히든으로 처리 -->
		<table>
			<tr>
				<th>SEQ</th>
				<td><%=dto.getSeq() %></td>
			</tr>
			<tr>
				<th>WRITER</th>
				<td><%=dto.getWriter() %></td>
			</tr>
			<tr>
				<th>DATE</th>
				<td><%=dto.getRegdate() %></td>
			</tr>
			<tr>
				<th>TITLE</th>
				<td><input type="text" name="title" value="<%=dto.getTitle() %>"></td>
			</tr>
			<tr>
				<th>CONTENT</th>
				<td><textarea rows="10" cols="40" name="content"><%=dto.getContent() %></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정완료">
					<input type="button" value="취소" onclick="detailFormView();">
				</td>
			</tr>
		</table>
	</form>
</div>

</body>
</html>