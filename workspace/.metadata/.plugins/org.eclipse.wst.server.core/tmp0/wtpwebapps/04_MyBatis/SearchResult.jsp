<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" style="width: 500px">
		<tr>
			<th>상품번호</th>
			<th>품명</th>
			<th>가격</th>
			<th>상품이미지</th>
			<th>기한</th>
		</tr>

		<c:forEach var="p" items="${searchProducts}">
			<tr>
				<td align="center">${p.p_no}</td>
				<td align="center">${p.p_name }</td>
				<td align="center"><fmt:formatNumber value="${p.p_price}"
						type="currency" /></td>
				<td align="center"><img src="${p.p_img}"
					style="max-width: 200px"></td>
				<td align="center"><fmt:formatDate value="${p.p_exp}"
						type="date" dateStyle="short" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>