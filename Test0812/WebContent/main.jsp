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
		Cookie[] cookies = request.getCookies();
	
	%>
	
	
	<table border="1px solider" >
		
			<tr>
			<td>
				<%
				for (int i=0 ; i< cookies.length ; i++) {
					if (cookies[i].getName().equals("id")){
						out.print(cookies[i].getValue() +"�� ȯ���մϴ�" );
					}
				}
					%></td>
			</tr>
			<tr>
			<td align="center"><a href="Logout">�α׾ƿ�</a>  </td></tr>
		</table>
	
	
</body>
</html>