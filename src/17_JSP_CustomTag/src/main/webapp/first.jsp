<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
jsp 파일에 자바를 쓰는 경우.
1. 값을 읽기 위해 -> EL로 해결.
------아래 3개는 Custom Tag로 해결----------
2. 출력형식 때문에
3. 조건문, 반복문 사용하려고
4. 다음 페이지로 이동하기 위해

Custom Tag
- DOM 객체 모양(쉽게 말해 html형태) - 실행때 자바코드로 바뀌어서 실행
- .jsp에서만 사용할 수 있다.
형태는 아래와 같다.
<접두어 : xxx></접두어 : xxx>

Custom Tag에는 2종류가 있는데,
1. JSP 표준 액션 태그(정품)

2. JSTL(싸제...?)

 -->
<h1>First</h1>
redirect는 표준 액션태그에 없다. forward로 처리.
<jsp:include page="second.jsp"></jsp:include>
</body>
</html>