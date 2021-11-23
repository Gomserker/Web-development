<%@page import="bg.com.main.Danwi"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="NewFile.css">
</head>
<body>
	<%
	Danwi danwi = (Danwi) request.getAttribute("danwi");
	%>
	
	
	<table id="<%=danwi.getCn()%>">
		<tr>
			<td id="td1">변환결과</td>
		</tr>
		<tr>
			<td><%=danwi.getNum()%> <span class="<%= danwi.getCn()%>2"><%= danwi.getUnit()%></span></td>
		</tr>
		<tr>
			<td>↓</td>
		</tr>
		<tr>
			<td><%=danwi.getResult2()%> <span class="<%= danwi.getCn()%>2"><%= danwi.getDanwi2()%></span></td>
		</tr>
		<tr>
		<td><button>돌아가기</button></td>
		</tr>
	</table>
	
</body>
</html>