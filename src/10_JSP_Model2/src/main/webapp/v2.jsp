<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	여기는 값만 받는 곳. 계산은 하지 않는다. M에서 다 하고 왔으니까.
	<%
	String a = request.getParameter("a");
	String b = request.getParameter("b");
	Object c = request.getAttribute("ccc");
	%>
	
	<h1>Calculation Result</h1>
	<%=a%> + <%=b%> = <%= c %>
</body>
</html>