<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%!
//메소드 정의는 <% >안에 쓸 수 없다. %! 안에 써야한다.
	public int getMulti(int a, int b){
		return a * b;
	}
%>
<%

	//1. 값 받기
	int x = Integer.parseInt(request.getParameter("x"));
	int y = Integer.parseInt(request.getParameter("y"));

	int plus = x + y;
	int minus = x - y;
	int multi = getMulti(x,y);

%>

<%=x%> + <%=y%> = <%=plus%><br>
<%=x %> * <%=y %> = <%=getMulti(x,y) %>
</body>
</html>