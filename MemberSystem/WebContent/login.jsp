<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div>
		<form action="LoginService" method="post">	
		<!-- servlet 이라서 확장자 안적음 jsp만 적음  -->
		<table>
		
			<tr>
			<td colspan="2"> 로그인 </td>
			</tr>
			
			<tr>
			<td>ID</td>
			<td><input type="text" name="id"></td>
			</tr>
			<tr>
			<td>PW</td>
			<td><input type="text" name="pw"></td>
			</tr>
			<tr>
			<td> <input type="submit" value="로그인" ></td>
			
			</tr>
		</table>
		</form>

</div>

</body>
</html>