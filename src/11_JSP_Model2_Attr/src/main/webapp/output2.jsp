<%@page import="com.bg.hc.Result"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Result r = (Result) request.getAttribute("rr");
%>

		<table>
			<tr>
				<td>상품 가격 : <%= r.getPrice() %></td>
			</tr>
			<tr>
				<td>지불한 돈 : <%= r.getMoney()%></td>
			</tr>
			<tr>
				<td>잔돈 : <%= r.getExchange()%></td>
			</tr>
			<tr>
				<td>텍스트 : <%= r.getSay()%></td>
			</tr>	
		</table>
	
	
</body>
</html>