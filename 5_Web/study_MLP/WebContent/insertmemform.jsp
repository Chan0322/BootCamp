<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function idChkConfirm(){
		let chk = document.getElementsByName("memid")[0].title;
		if(chk=="n"){
			alert("아이디 중복체크를 해주세요!!");
			document.getElementsByName("memid")[0].focus();
		}
	}
	
	function idChk(){
		let doc = document.getElementsByName("memid")[0];
		if(doc.value.trim()=="" || doc.value==null){
			alert("아이디를 입력하세요!!");
		}else{
			let target = "member?command=idchk&memid="+doc.value.trim();
			open(target,"","width=200,height=200");
		}
	}
</script>
</head>
<body>
	<div>
		<h1 align="center">회원가입</h1>
	</div>
	<div>
		<form action="member" method="post">
		<input type="hidden" name="command" value="insertmem">
			<table>
				<tr>
					<th><h2>필수 항목</h2></th>
				</tr>
				<tr>
					<th>조직</th>
					<td><input type="text" name="memgroup" required></td>
				</tr>
				<tr>
					<th>부서</th>
					<td><input type="text" name="memdepart" required></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" name="memname" required></td>
				</tr>
				<tr>
					<th>영문이름</th>
					<td><input type="text"></td>
				</tr>
				<tr>
					<th>아이디</th>
					<td>
						<input type="text" name="memid" title="n" required>
						<input type="button" value="중복확인" onclick="idChk();">
					</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="text" name="mempw" required onclick="idChkConfirm();"></td>
				</tr>
				<tr>
					<th>이메일주소</th>
					<td><input type="email" name="mememail" required onclick="idChkConfirm();"></td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td><input type="text" name="memphone" required onclick="idChkConfirm();"></td>
				</tr>
				<tr>
					<td colspan="2" align="right">
						<input type="button" value="취소" onclick="location.href='history.back();'">
						<input type="submit" value="가입">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>