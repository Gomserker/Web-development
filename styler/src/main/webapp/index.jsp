<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/reviewDetail.css">
</head>
<body>

	<table id="tbl" border="1">
		<tr>

			<td colspan="3">
			<jsp:include page="${loginPage}"></jsp:include> 
			<jsp:include page="${contentPage}"></jsp:include>
			</td>
		</tr>
		<tr>
			<td onclick="location.href='HomeController'">로고</td>
			<td>footer</td>
			<td>footer</td>
		</tr>
	</table>
</body>
</html>