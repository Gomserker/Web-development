<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Third</h1>

Parameter : ${param.a }<p>
Attribute :	${b}<p>

<h2> Session : ${sessionScope.c}</h2>
<h2> Cookie : ${cookie.d.value}</h2>
</body>
</html>