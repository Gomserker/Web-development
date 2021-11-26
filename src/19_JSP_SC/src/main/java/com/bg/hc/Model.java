package com.bg.hc;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Model {

	public static void print1(HttpServletRequest request) {
		
		//parameter = View에서 만든 값
		// String or String[]
		//그게 request에 실려 넘어오는 것.
		
		//값을 읽을때
		// java = request.getparameter("");
		//EL = ${param.파라미터명}
		
		String aa = request.getParameter("a");
		
		//attribute = Model에서 만든 값(Java에서)
		//Object (자료형에 제한이 없음)
		//request에 실려서 전달
		
		//값을 읽을때
		//java = request.getAttribute("");
		//EL = ${어트리뷰트명}
		
		String bb = (String) request.getAttribute("b");
	}
	
	
	public static void make1(HttpServletRequest request, HttpServletResponse response) {
		String bbb = "ㅋㅋㅋ";
		request.setAttribute("b", bbb);
		
		// 사용하는 값 (총 4가지)
		// parameter, attribute
		// 특징상 third에선 못씀
		
		//session과 cookie
		
		//session
		//session.attribute (세션의 어트리뷰트)
		
		String ccc = "thisissession";
		HttpSession hs = request.getSession();
		hs.setMaxInactiveInterval(5); // 세션 유지시간 ~초
		hs.setAttribute("c", ccc);
		
		//서버와 클라이언트의 연결상태
		//서버와 클라이언트의 연결만 살아있으면
		//이 사이트 어디에서든 사용 가능하다.
		//연결이 끊어지면 못 쓴다.(접속 종료/브라우저 종료)
		//세션 유지시간 (기본 30분)
		//시간 내에 '요청'이 일어나지 않으면(request) 죽음.
		//시간 내에 '요청' 등의 작업을 하면 갱신(유지시간 초기화)
		
		//cookie
		//사용자 컴퓨터에 파일 저장
		//접속을 끊어도 재부팅을 해도 살아있다.
		
		String ddd = "Thisiscookie";
		Cookie coo = new Cookie("d", ddd);
		coo.setMaxAge(5*60); //~*60 = ~분
		
		response.addCookie(coo);
	}
	
	public static void print2(HttpServletRequest req) {
		//session.attr (세션의 어트리뷰트)
		//Model에서 만든 값
		//서버와 클라이언트간의 연결 상태에 담긴다.
		//시간제한이 있는데 유형은 Object
		
		//값 읽을때는
		//java = request.getSession().getAttribute("어트리뷰트명");
		//EL = ${sessionScope.어트리뷰트명}
		
		String ccc = (String) req.getSession().getAttribute("c");
		//현재 만들어져 있는 쿠키들
		Cookie[] cookies = req.getCookies();
		
		for (Cookie c : cookies) {
			System.out.println(c);
			if(c.getName().equals("d")) {
				System.out.println(c.getValue());
			}
		}
		
		// EL : ${cookie.쿠키이름.value}
		
		
		
	}
}
