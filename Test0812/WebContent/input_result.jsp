<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	

<h1>��ȣ�� ���� ���</h1>
		<table border="1px solider">	
			<tr>
			<td> �̸� </td>
			<td> <%=request.getParameter("name") %></td>
			</tr>
			
			<tr>
			<td>�����ϴ� ����</td>
			<td>
			
			<% 
			request.setCharacterEncoding("EUC-KR");
			String[] str= request.getParameterValues("check");
			for (int i=0; i< str.length ; i++){
			%>
					<%= str[i] %>
			<%}%>
			</td>
			</tr>
		</table>
		
</body>
</html>