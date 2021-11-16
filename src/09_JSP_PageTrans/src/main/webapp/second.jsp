<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	int a = Integer.parseInt(request.getParameter("a"));
	int b = Integer.parseInt(request.getParameter("b"));
	int c = a + b;

	/*
	값
	
	(1). parameter
	html에서 만든 값이다.(onclick을 쓰든 a태그를 쓰든 name을 주든 뭐든)
	그 자료형은 String, String[]
	그 값들이 request 객체에 실려서 전송되는데
	
	second에서 만든 c를 third로 전송하고 싶음. 그런데 자동으로 이동하는 방법이 있다. ※(1.1) 확인
	
	(1.1) 자동이동 3종 세트
	1. redirect
	response.sendRedirect("third.jsp")
	
	2. forward
	RequestDispatcher rd = request.getRequestDispatcher("third.jsp");
	rd.forward(request, response);
	forward에 arguments로 request가 포함되어 있기 때문에 first.html에 있던 파라미터가 끌려간다.
	first에서 second로 넘어올때 요청한 정보를 third까지 넘겨줌
	
	forward를 많이 쓰는데 first에서 second로 넘어온 request까지 third로 보내준다.
	redirect는 그냥 넘긴다는 점에서 차이가 있음
	forward는 request에 값이 실려서 넘어오는건데 해당 request를 같이 넘기기 때문에 third에서도 그 값을 쓸 수 있다.
	
	3. include (어떤 jsp 속에 다른 jsp를 포함하고 싶을때)
	include : 위치조절이 안됨(무조건 제일 위에 나옴) -> 그래서 잘 안쓴다. 나중에 위치조절이 가능한 다른 include가 있다. = jsp:include라고.
	
	
	(2). attribute(속성)
	java에서 만든 값으로 Object(객체)면 다 가능하다. request에 실려서 전송된다.
	*/
	request.setAttribute("ccc", c);
	
	RequestDispatcher rd = request.getRequestDispatcher("third.jsp");
	rd.forward(request, response);
%>

<h1>Welcome to Second Page</h1>
<%=c%>

<%
	//rd.include(request, response);

%>
</body>
</html>