<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<%@ page import="com.login.dao.MyMemberDao" %>
<%@ page import="com.login.dto.MyMemberDto" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String command = request.getParameter("command");
	System.out.println("[command: " + command + "]");
	
	MyMemberDao dao = new MyMemberDao();
	
	if(command.equals("login")){
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		MyMemberDto dto = dao.login(id,pw);
		
		if(dto.getMyid() != null){
			// 로그인 성공
			// session객체 : 브라우저 당 1개의 session 객체가 생성. 페이지가 바뀌는 것과 상관 없이, 브라우저가 닫히지만 않으면 계속 살아 있음.
			session.setAttribute("dto", dto);
			// request와 session 객체의 공유되는 범위 (살아있는 범위)가 다르다.
			session.setMaxInactiveInterval(60*60); // 객체를 얼마동안 살려 놓을 것인가.  60초 * 60 = 1시간.  이 설정을 하지 않을 경우, Default 값은 30분.
			// 객체들의 공유 범위
			// Scope
			// jsp에서는 아래와 같은 영역으로 나뉨
			// 1. page영역 : 하나의 jsp 페이지 내에서만 객체를 공유한다. ex)pageContext
			// 2. request 영역 : foward를 통해 request 객체가 공유된다.
			// 3. session 영역 : 같은 브라우저 내에서의 페이지들은 같은 session 객체를 공유한다.
			// 4. application 영역 : 하나의 어플리케이션 당 1개의 application 객체 생성되고 공유된다.
			
			if(dto.getMyrole().equals("ADMIN")){
				response.sendRedirect("adminmain.jsp");
			}
		}else{
			// 로그인 실패
			request.setAttribute("msg", "login 실패");
			request.setAttribute("url", "index.jsp");
			pageContext.forward("result.jsp");
		}
	}
%>
</body>
</html>