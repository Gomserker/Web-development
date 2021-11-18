package com.bg.pay;

import javax.servlet.http.HttpServletRequest;

public class M {

	public static void calc(HttpServletRequest request) {
		int i = Integer.parseInt(request.getParameter("i"));
		int e = Integer.parseInt(request.getParameter("e"));
		
		int result = i - e;
		
		System.out.println(i);
		System.out.println(e);
		System.out.println(result);
		
		Remain r = new Remain();
		r.setE(e);
		r.setI(i);
		r.setResult(result);
		request.setAttribute("rr", r);
	}

}
