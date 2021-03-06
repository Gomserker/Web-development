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
<style>
	div {
		position: fixed;
		right: 50px;
		top: 50px;
	}
</style>
<body>
	<table border="1" style="width: 500px">
		<tr>
			<th>상품번호</th>
			<th>품명</th>
			<th>가격</th>
			<th>상품이미지</th>
			<th>기한</th>
		</tr>

		<c:forEach var="p" items="${products}">
			<tr>
				<td align="center">${p.p_no}</td>
				<td align="center">${p.p_name }</td>
				<td align="center"><fmt:formatNumber value="${p.p_price}"
						type="currency" /></td>
				<td align="center"><img src="img/${p.p_img}"
					style="max-width: 200px"></td>
				<td align="center"><fmt:formatDate value="${p.p_exp}"
						type="date" dateStyle="short" /></td>
			</tr>
		</c:forEach>
	</table>
	
	<div>
		<h3>상품 등록</h3>
		<form action="RegController" enctype="multipart/form-data" method="post">
			품명: <input name="name"> <br>
			가격: <input name="price"> <br>
			사진: <input name="img" type="file"> <br>
			기한: <input name="date" type="date"> <br>
			<button>등록</button>
		</form>
	</div>
	
	<h3>품명으로 검색</h3>
	<form action="SearchController">
		품명 : <input name="name"><button>검색</button>
	</form>
	<h3>번호로 삭제</h3>
	<form action="DeleteByNumberController">
		품명 : <input name="number"><button>삭제</button>
	</form>
	<h3>가격으로 검색</h3>
	<form action="PriceSearchController">
		 <input name="price">이하 검색 <button>검색</button>
	</form>
	<h3>가격대 설정 검색</h3>
	<form action="PriceRangeSearchController">
		<input name="price1"> ~ <input name="price2">
		<button>검색</button>
	</form>
	<h3>가격 인상</h3>
	<form action="PriceUpdateController">
		<input name="price1">이하인거 <input name="price2">으로 인상
		<button>수정</button>
	</form>
</body>
</html>