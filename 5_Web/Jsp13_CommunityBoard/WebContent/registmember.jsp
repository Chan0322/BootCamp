<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function idChkConfirm(){
		let chk = document.getElementsByName("id")[0].title;
		if(chk=="n"){
			alert("아이디 중복체크를 해주세요!!");
			document.getElementsByName("id")[0].focus();
		}
	}
	
	function idChk(){
		let doc = document.getElementsByName("id")[0];
		if(doc.value.trim()=="" || doc.value==null){
			alert("아이디를 입력하세요!!");
		}else{
			let target = "member?command=idchk&id="+doc.value.trim();
			open(target,"","width=200,height=200");
		}
	}
</script>
</head>
<body>
	<h1>회원가입</h1>
	<form action="member" method="post">
		<input type="hidden" name="command" value="insertmember">
		<table>
			<tr>
				<th>아이디</th>
				<td>
					<input type="text" name="id" title="n" required="required">
					<input type="button" value="중복확인" onclick="idChk();">
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>
					<input type="text" name="pw" required="required" onclick="idChkConfirm();">
				</td>
			</tr>
			<tr>
				<th>이 름</th>
				<td><input type="text" name="name" required="required" onclick="idChkConfirm();"></td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td><input type="text" name="phone" required="required" onclick="idChkConfirm();"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="가입">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>