
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <%  Result r = (Result) request.getAttribute("result");  --%>


<%-- 	~.jsp에 자바를 쓰는 경우는?
	1. 값(어트리뷰트든 파라미터든)을 읽으려고.
	2. 출력 형식(포맷) 때문에.
	3. 조건문, 반복문
	
	EL (Express Language)란?
	1. 값을 읽을때 사용하는 것. MVC 중 V에서 Java 코드를 제거해보자.
	2. 연산자 사용 가능 -> ${a + b} 가능
	3. import 필요 없음 ->
	4. 값이 없으면 그냥 넘어감(개꿀)
	
	EL로 parameter 읽기 -> ${param.파라미터명}
	EL로 attribute 읽기 -> ${attribute객체명.이름}
	EL로 객체 읽기 -> ${attribute객체명. 멤버변수} --%>





<%-- 이름 : <%=r.getName() %> <p>
중간 : <%=request.getParameter("mid") %> <p>
기말 : <%=request.getParameter("last") %> <p>
평균 : <%=r.getAvg2() %> <p>
등급 : <%=r.getGrade() %> <p> --%>
<hr>
이름 :  ${result.name}<p>
중간 :  ${result.mid}<p>
기말 :  ${result.last}<p>
평균 :  ${result.avg2}<p>
등급 :  ${result.grade}<p>
<hr>
a : ${a } <p> 
b : ${b } <p> 
c : ${c[1] } <p>
<hr>
d1 : ${d[0].name} <p>
d2 : ${d[1].grade}
<hr>
e1 : ${e[0].name }<p>
e2 : ${e[1].name }<p>
e3 : ${e[2].name }<p>

</body>
</html>