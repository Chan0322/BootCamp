<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 임포트 --%>
<%@ page import="com.my.dao.MyBoardDao" %>
<%@ page import="java.util.List" %>
<%@ page import="com.my.dto.MyBoard" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	MyBoardDao dao = new MyBoardDao();
	List<MyBoard> list = dao.selectAll();
%>
</head>
<body>
	<!-- db에 저장된 데이터를 조회하여 목록으로 보여줄 페이지 -->
	<h1>LIST PAGE</h1>
	
	<table border="1">
		<col width="50px"><col width="100px"><col width="200px"><col width="200px">
		<tr>
			<th>NO</th>
			<th>NAME</th>
			<th>TITLE</th>
			<th>DATE</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
<%
		for(int i=0; i<list.size(); i++){	
%>
		<tr>
			<td><%=list.get(i).getMyno() %></td>
			<td><%=list.get(i).getMyname() %></td>
			<td><a href="selectone.jsp?myno=<%=list.get(i).getMyno()%>"><%=list.get(i).getMytitle() %></a></td>
			<td><%=list.get(i).getMydate() %></td>
			<td><button onclick="location.href='myupdate.jsp?myno=<%=list.get(i).getMyno() %>'">수정</button></td>
			<td><button onclick="location.href='mydelete.jsp?myno=<%=list.get(i).getMyno() %>'">삭제</button></td>
		</tr>
<%
		}
%>
<%-- 순수 HTML로 작성한다면 위처럼 간단한 코드가 아닌, 출력할 내용을 하나하나 다 적어야 한다...... JSP를 통해 이렇게 편하게 가능. --%>
<%-- 자바 코드를 서버에서 컴파일하여 처리가 완료된 후에, HTML 코드로만 구성된 채로 페이지에 응답이 되어 동적이 처리가 가능해짐! --%>

		<tr>
			<td colspan="4" align="right">
				<button onclick="location.href='myinsert.jsp';">글쓰기</button>
			</td>
		</tr>
	</table>
<%--	<script type="text/javascript">
		function write(){
			location.href='myinsert.jsp'
		}
		</script>
 --%>
</body>
</html>