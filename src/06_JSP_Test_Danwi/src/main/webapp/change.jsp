<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="style.css" rel="stylesheet">
</head>
<body>

<%
double x = Double.parseDouble(request.getParameter("number"));
String convert = request.getParameter("convert");

double inch = x / 2.54;
double pyeong = x / 3.33;
double faren = (x * 9 / 5) + 32;
double mile = x / 1.609;
%>


	<section>
		<div class="header">
			<h1>변환 결과</h1>
		</div>
		<div class="content">
			<h2>입력한 값</h2>
			<h2><%= x%></h2>
			<h2>결과</h2>
			<%if(convert.equals("cm → inch")) {%>
			<h2><%= inch%> 인치</h2>
			<%} else if (convert.equals("㎡ → 평")) {%>
			<h2><%= pyeong%> 평</h2>
			<%} else if (convert.equals("℃ → ℉")) {%>
			<h2>화씨 <%= faren%> 도</h2>
			<%} else {%>
			<h2>시속 <%= mile%> 마일</h2>
			<%} %>
			
		</div>
	</section>
</body>
</html>