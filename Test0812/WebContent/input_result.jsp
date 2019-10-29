<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	

<h1>선호도 조사 결과</h1>
		<table border="1px solider">	
			<tr>
			<td> 이름 </td>
			<td> <%=request.getParameter("name") %></td>
			</tr>
			
			<tr>
			<td>좋아하는 과일</td>
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