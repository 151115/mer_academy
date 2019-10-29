<%@page import="com.sun.xml.internal.ws.api.pipe.NextAction"%>
<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<table border="1px solider"  method="post">
		
	<% 
	int num = Integer.parseInt(request.getParameter("num") ); 
	
	String name[] = request.getParameterValues("name");
	String str_money[] = request.getParameterValues("money");
	int[] money =new int[str_money.length];
	
	for (int i=0; i< num ; i++) {
		money[i] = Integer.parseInt(str_money[i]);
	}
	 
	 
	
	
	Random r = new Random();
	int total =0;
	
	int rand = r.nextInt();
	
	%>
			<tr align="center">
			<td> <h1> 점심비 결과 ! </h1></td>
			</tr>
			
			<% for (int i=0; i< num ; i++) { 
			out.print("<td>"+ name[i]  +"</td><td>");
				total+= money[i];
				
			}
			%></td>
			
			}
			%>
			
			<td>총금액 : <%=total %></td>
			</tr>
			
		</table>

</body>
</html>