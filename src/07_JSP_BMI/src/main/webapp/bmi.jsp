<%@page import="java.io.PrintWriter"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BMI Test Result</title>
<link href="style.css" rel="stylesheet">
</head>
<body>

<%
String path = request.getSession().getServletContext().getRealPath("img");

MultipartRequest mr = new MultipartRequest(request, path, 30 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());

String file = mr.getFilesystemName("pic");
response.setCharacterEncoding("utf-8");

String name = mr.getParameter("name");



double height  = Double.parseDouble(mr.getParameter("height"));
double weight  = Double.parseDouble(mr.getParameter("weight"));

height /= 100;
double bmi = weight / (height * height);

String result = "비만";

if (bmi < 20) {
	result = "저체중";
} else if (bmi < 25) {
	result = "정상";
} else if (bmi < 30){
	result = "과체중";
}

String bmi2 = String.format("%.2f", bmi);
%>
<form action="bmi.jsp" method="post" onsubmit="return call();">
	<section>
		<div class="header">
			<h1>BMI 결과</h1>
		</div>
		<div class="content_name">
			<span> 이름 </span>
			<span> <%=name %> </span>
		</div>
		<div class="content_height">
			<span> 키 </span>
			<span> <%=height * 100%> cm</span>
		</div>
		<div class="content_weight">
			<span> 체중 </span>
			<span> <%=weight %> Kg</span>
		</div>
		<div class="content_weight">
			<span> BMI </span>
			<span> <%=bmi2 %> </span>
		</div>
		<div class="content_weight">
			<span> 결과 </span>
			<span> <%=result %> </span>
		</div>
		<div class="content_weight">
			<span> 사진 </span>
			<span> <img src='img/<%=file%>' width=50px height=50px></span>
		</div>
	</section>
</form>
</body>
</html>