<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Second</h1>

Parameter : ${param.a }<p>
Attribute :	${b}<p>

<a href="ThirdC?a=${param.a}">ThirdC로 get 요청</a>

</body>
</html>