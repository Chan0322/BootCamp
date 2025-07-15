<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script type="text/javascript">
	const login = ()=>{
		let memid = $("#memid").val().trim();
		let mempw = $("#mempw").val().trim();
		
		let loginVal = {
				"memid":memid,
				"mempw":mempw
		}
		
		if(memid=="" || mempw==""){
			alert("ID와 PW를 입력하세요");
		}else{
			$.ajax({
				url:"ajlogin.do",
				type:"post",
				data:JSON.stringify(loginVal),
				contentType: "application/json",
				dataType: "json",
				success:function(msg){
					if(msg.chk == true){
						location.href="list.do";
					}else{
						$("#loginChk").html("ID 또는 PW가 잘못 되었습니다.")
					}
				},
				error:function(){
					alert("로그인 실패");
				}
			});
		}
	}
</script>
</head>
<body>
	<h1>Login</h1>
	<table>
		<tr>
			<th>ID</th>
			<td><input type="text" id="memid"></td>
		</tr>
		<tr>
			<th>PW</th>
			<td><input type="text" id="mempw"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="button" value="로그인" onclick="login();"></td>
		</tr>
		<tr>
			<td colspan="2" align="center" id="loginChk"></td>
		</tr>
	</table>
</body>
</html>