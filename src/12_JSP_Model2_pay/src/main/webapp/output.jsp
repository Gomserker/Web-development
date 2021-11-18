<%@page import="com.bg.pay.Remain"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	Remain r = (Remain) request.getAttribute("rr");
%>
</head>
<body>
	<table>
			<tr>
				<td>income : <%=r.getI() %></td>
			</tr>
			<tr>
				<td>expense : <%=r.getE() %> </td>
			</tr>
			<tr>
				<td> left : <%=r.getResult() %></td>
			</tr>	
		</table>
</body>
</html>