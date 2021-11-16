package com.bg.main;

import javax.servlet.http.HttpServletRequest;

/*
 M for model -> 비즈니스 로직을 구현
 쉽게 말해 계산한다고. DB도 여기
 */

public class M {

	public static void calc(HttpServletRequest request) {
		
		//받아온 a,b가 request에 담겨있음.
		int aa = Integer.parseInt(request.getParameter("a"));
		int bb = Integer.parseInt(request.getParameter("b"));
		System.out.println(aa);
		System.out.println(bb);
		int cc = aa + bb;
		
		//여기서 나온 cc를 v2로 보낼 수 있게
		request.setAttribute("ccc", cc);
	}
}
