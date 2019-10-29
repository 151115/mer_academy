<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
div{ss
	width : 500px;
	height: 220px;
	background-color: yellow;
	margin :0px auto;
	text-align: center;
	border: 10px dotted black;
	box-sizing: border-box;
}
table{
 	margin : 0px auto;
}
</style>
</head>
<body>
	<div>
	<form action="joinService" method = "post">
		<table>
			<tr><td colspan = "2">회원가입</td></tr>
			<tr>
				<td>ID</td>
				<td><input type = "text" name = "id"></td>
			</tr>
			<tr>
				<td>PW</td>
				<td><input type = "password" name = "pw"></td>
			</tr>
			<tr>
				<td>NAME</td>
				<td><input type = "text" name = "name"></td>
			</tr>
			<tr><td colspan = "2"><input type = "submit"></td></tr>		
		</table>
	</form>
	</div>
</body>
</html>