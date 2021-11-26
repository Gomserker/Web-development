<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<fmt:formatNumber value="${a}" type="currency"/>
	<hr>
	<fmt:formatNumber value="${a}" type="currency" currencySymbol="$"/>
	<hr>
	<fmt:formatNumber value="${b}" type="percent"/>	
	<hr>
	<fmt:formatNumber value="${b}" pattern="0.000"/>	
	<hr>
	<fmt:formatNumber value="${c}" pattern="#,###.00"/>	
	<hr>
	<fmt:formatDate value="${d}" type="date" dateStyle="long"/>
	<hr>
	<fmt:formatDate value="${d}" type="date" dateStyle="short"/>
	<hr>
	<fmt:formatDate value="${d}" type="time" timeStyle="long"/>
	<hr>
	<fmt:formatDate value="${d}" type="time" timeStyle="short"/>
	<hr>
	<fmt:formatDate value="${d}" type="both" dateStyle="long" timeStyle="long"/>
	<hr>
	<fmt:formatDate value="${d}" type="both" dateStyle="short" timeStyle="short"/>
	<hr>
	<fmt:formatDate value="${d}" pattern="yyyy. MM. dd / hh:mm"/>
	<hr>
	<fmt:formatDate value="${d}" pattern="yyyy-MM-dd / hh:mm"/>
	<hr>
	<table border="1" width="500px">
		<tr>
			<th>과자명</th>	
			<th>가격</th>	
			<th>제조일</th>	
		</tr>
		<c:forEach var="snacks" items="${snacks}">
		<tr>
			<td>${snacks.name}</td>
			<td><fmt:formatNumber value="${snacks.price}" type="currency"/></td>
			<td><fmt:formatDate value="${snacks.date}" pattern="yyyy-MM-dd / hh:mm"/></td>
		</tr>
		</c:forEach>
	</table>
	
</body>
</html>