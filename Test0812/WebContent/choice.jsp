<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<% 
	int num = Integer.parseInt(request.getParameter("num") ); 
	
	%>
	
	
	<form action="result_4.jsp" >	
		<table border="1px solider"  method="post">
		
			<tr align="center">
			<td colspan="2"> <h1> 이름과 결과를 입력하세요 </h1></td>
			</tr>
			
			<% for (int i=0; i< num ; i++) { %>
				
			<tr>
			<td><input type="text" name="name"+i ></td>
			<td><input type="text" name="money"+i></td>
			
			<%}
			%>
			</tr>
			<tr>
			<td align="center" colspan="2"><input type="submit" value="확인하기" ></td>
			</tr>
			
		</table>
		</form>
</body>
</html>