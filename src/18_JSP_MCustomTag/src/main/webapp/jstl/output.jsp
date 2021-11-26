<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!--
20살이 넘으면 어서오세요
20살 미만이면 안녕

저런거 하려면 if문이 필요한데 사용하려면?

Custom Tag
1. JSP 표준액션태그 : include

2. CustomTag

JSTL (JSP Standard Tag Library)

  -->
<h4>당신은 ${age}살입니다.</h4>
<!-- 20살이 넘으면 안녕하세요 -->
<c:if test="${age > 19}">
	<h1>안녕하세요</h1>
</c:if>

<!-- if와 else if in JSTL -->

<c:choose>
	<c:when test="${age>19}">
		<h1>어서오세요</h1>
	</c:when>
	<c:when test="${age>9}">
		<h1>안녕</h1>
	</c:when>
	<c:otherwise>
		<h1>잼민이 어서오고</h1>
	</c:otherwise>
</c:choose>

<hr>

<!-- 반복문 -->
<!-- 단점 : 역순이 안됨(step에 음수가 안 들어감) -->
<c:forEach var="a" begin="1" end="${age}" step="3">
	${a }
</c:forEach>
<hr>
<c:forEach var="c" items="${ar }">
	${c }
</c:forEach>
<hr>
<c:forEach var="m" items="${menus }">
	${m.name}
	${m.price}
	<br>
</c:forEach>
<hr>
<!-- 게시판  -->
<table border="1">
	<tr>
	<td>메뉴명</td>
	<td>가격</td>
	</tr>
	<c:forEach var="m" items="${menus }">
	<tr>
		<td>${m.name}</td>
		<td>${m.price}</td>
	</tr>
	</c:forEach>

</table>







</body>
</html>