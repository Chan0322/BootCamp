<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload=function(){
		let id = opener.document.getElementsByName("id")[0].value;
		document.getElementsByName("id")[0].value = id;
	}
	
	function confirm(bool){
		if(bool == "true"){
			opener.document.getElementsByName("id")[0].title="y";
			opener.document.getElementsByName("pw")[0].focus();
		}else{
			opener.document.getElementsByName("id")[0].value="";
			opener.document.getElementsByName("id")[0].focus();
		}
		self.close();
	}
</script>
</head>
<body>
	<table>
		<tr>
			<td><input type="text" name="id" readonly="readonly"></td>
		</tr>
		<tr>
			<td>${param.idnotused eq 'true' ? "사용가능한 아이디입니다." : "중복된 아이디입니다." }</td>
		</tr>
		<tr>
			<td><button onclick="confirm('${param.idnotused}');">확인</button></td>
		</tr>
	</table>
</body>
</html>