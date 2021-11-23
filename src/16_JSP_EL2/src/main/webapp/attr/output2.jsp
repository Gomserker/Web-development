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
		
	<!-- 
	1. 모자랄때만 아래 버튼이 나왔으면 좋겠다. 
	2. 버튼을 누르면 얼마가 모자랍니다 표시하고 싶다. (음수 x)
	3. 위 조건에 해당하면 output3.jsp로
	-->
<%
	String warning = null;
	if (r.getExchange() < 0){
		int how = (Integer) request.getAttribute("ex2");
		warning = "You need to pay " + how + " more";
%>
		<a href="output3.jsp?">
			<button>How much more do you need? with a tag</button><p>
		</a>
		
		<button onclick="location.href='output3.jsp'">How much more do you need? with JS</button>
		
		<form action="output3.jsp?">
			<button>How much more do you need? with form tag (get)</button><p>
		</form>
		
		<form action="output3.jsp?" method="post">
			<button name="how" value="<%=how %>">How much more do you need? with form tag (post)</button><p>
		</form>
		
		<form action="ExController" method="post">
			<button name="how" value="<%=how%>">How much more do you need? with form tag (mvc)</button><p>
		</form>
		
		<form action="ExController">
			<button name="how" value="<%=how%>">How much more do you need? with form tag (mvc2)</button><p>
		</form>
		
		
		

<%
}	
	request.setAttribute("warning", warning);
%>
	
</body>
</html>