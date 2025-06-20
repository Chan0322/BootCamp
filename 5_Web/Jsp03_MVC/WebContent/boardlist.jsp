<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8");%>
<% response.setContentType("text/html; charset=UTF-8"); %>

<%@ page import="java.util.List" %>
<%@ page import="com.mvc.dto.MVCBoardDto" %> <!-- Dao는 컨트롤러에서 접근하므로 여기서 필요 X -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	// 데이터 준비는 컨트롤러가 하므로 얘는 꺼내 쓰기만 하면 됨
	
	// Attribute의 타입은 Object로 저장되어 변환 필요
	List<MVCBoardDto> list = (List<MVCBoardDto>)request.getAttribute("allList");
%>
	<h1>List</h1>
	<!-- 준비한 데이터를 화면에 보여주면 됨. -->
	
	<table>
		<col width="50px"><col width="100px"><col width="300px"><col width="100px">
		<tr>
			<th>NO</th>
			<th>WRITER</th>
			<th>TITLE</th>
			<th>DATE</th>
		</tr>
<%
		if(list.size()==0){
%>
			<tr>
				<td colspan="4">-----글이 존재하지 않습니다-----</td>
			</tr>
<%
		}else{
			for(MVCBoardDto dto : list){
%>			
				<tr>
					<td><%=dto.getSeq() %></td>
					<td><%=dto.getWriter() %></td>
					<td><a href="mycontroller.jsp?command=boarddetail&seq=<%=dto.getSeq()%>"><%=dto.getTitle() %></a></td>
					<td><%=dto.getRegdate() %></td>
				</tr>
<%	
			}		
		}
%>
	</table>
	
</body>
</html>