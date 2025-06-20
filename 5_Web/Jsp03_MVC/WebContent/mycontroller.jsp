<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 한글 깨짐 방지 인코딩 설정 -->
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>ㄴㄴ

<!-- import -->
<%@page import="com.mvc.dao.MVCBoardDao"%>
<%@page import="com.mvc.dto.MVCBoardDto" %>
<%@page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 요청이 들어오면 확인하고, 그에 맞는 작업을 수행 후 응답헤준다. -->
<%
	//view에서 요청한 내용인 무엇인지 확인 할 수 있는 parameter 값.
	String command = request.getParameter("command");

	System.out.println("[command: "+command+"]");
	MVCBoardDao dao = new MVCBoardDao();
	
	if(command.equals("boardlist")){
		//필요 데이터 준비하고 해당하는 페이지로 전환
		
		//1. 데이터 준비
		List<MVCBoardDto> res = dao.selectAll();
		
		//2. list 페이지로 이동(준비된 데이터와 함께)
		request.setAttribute("allList", res);		//request 객체 안에 allList라는 이름으로 res를 담아준다. => 다음 페이지에서 받아볼 수 있음.
		
		pageContext.forward("boardlist.jsp");		// 해당하는 페이지로 페이지를 이동하겠다.
		//화면의 흐름을 제어하는 방법, 페이지 이동하는 방법
		// forward : request에 담긴 값이 유지된다. req, res 객체가 유지.
		//			 <jsp:foward>, pageContext.forward(jsp 내에서), requestDispatcher객체(서블릿)
		// redirect : 클라이언트가 새로운 페이지로 요청한 것과 같은 방식으로 페이지 이동
		//			  response.sendRedirect
		
	}else if(command.equals("boarddetail")){
		// 필요 데이터 준비 후 화면 전환
		
		int seq = Integer.parseInt(request.getParameter("seq"));
		MVCBoardDto res = dao.selectOne(seq);
		
		request.setAttribute("dto", res);
		pageContext.forward("boarddetail.jsp");
		
	}else if(command.equals("boardinsertform")){
		// 지금은 넘겨줄 값이 딱히 없다. request,response 객체 유지할 필요 없으므로 redirect 사용.
		response.sendRedirect("boardinsert.jsp");
		
	}else if(command.equals("boardinsert")){
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		MVCBoardDto dto = new MVCBoardDto(0, writer, title, content, null);
		int res = dao.insert(dto);
		
		String msg = "";
		String url = "";
		
		if(res>0){
			msg="글 작성 성공";
			url="?command=boardlist";
		}else{
			msg="글 작성 실패";
			url="?command=boardinsertform";
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		pageContext.forward("result.jsp");
		
	}else if(command.equals("boardupdateform")){
		int seq = Integer.parseInt(request.getParameter("seq"));
		MVCBoardDto dto = dao.selectOne(seq);
		
		request.setAttribute("dto", dto);
		pageContext.forward("boardupdate.jsp");
		
	}else if(command.equals("boardupdate")){
		//넘어오는 parameter를 받아
		int seq = Integer.parseInt(request.getParameter("seq"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		//dao에 update를 진행하고 (" UPDATE MVCBOARD SET TITLE=?, CONTENT=? WHERE SEQ=? ")
		MVCBoardDto dto = new MVCBoardDto(seq, null, title, content, null);
		int res = dao.update(dto);
		
		//실행 결과에 따라 result 페이지를 통해 화면처리한다.
		String msg="";
		String url="";
		if(res>0){
			msg="게시글 수정 성공";
			url="?command=boarddetail&seq="+seq;
		}else{
			msg="게시글 수정 실패";
			url="?command=boardupdateform&seq="+seq;
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		pageContext.forward("result.jsp");
		
	}else if(command.equals("boarddelete")){
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		int res = dao.delete(seq);
		
		String msg = "";
		String url = "";
		if(res>0){
			msg = "게시글 삭제 성공";
			url = "?command=boardlist";
		}else{
			msg = "게시글 삭제 실패";
			url = "?command=boarddetail&seq="+seq;
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		pageContext.forward("result.jsp");
	}
%>

</body>
</html>