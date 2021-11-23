package com.bg.main;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class CalM {

	public static void calc(HttpServletRequest request) {
		
		try {
			request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("name");
		double mid = Double.parseDouble(request.getParameter("mid"));
		double last = Double.parseDouble(request.getParameter("last"));
		
		
		double avg = (mid + last) / 2;
		String grade = "F";
		
		if (avg >= 90) {
			grade = "A";
		} else if (avg >= 80 ) {
			grade = "B";
		} else if (avg >= 70) {
			grade = "C";
		} else if (avg >= 60) {
			grade = "D";
		}
		
		String avg2 = String.format("%.2f", avg);
		
		Result r = new Result(mid, last, grade, avg2, name);
		request.setAttribute("result", r);
		request.setAttribute("a", "せせ");
		request.setAttribute("b", "ぞぞ");
		
		int[] ar = {3,6,9};
		request.setAttribute("c", ar);
		
		Result[] ar2 = new Result[2];
		ar2[0] = new Result(80, 90, "A", "89.5", "jake");
		ar2[1] = new Result(80, 90, "B", "89.5", "mike");
		
		request.setAttribute("d", ar2);
		
		ArrayList<Result> al = new ArrayList<Result>();
		al.add(new Result(80, 80, "B", "80", "luke"));
		al.add(new Result(80, 80, "B", "80", "tina"));
		al.add(new Result(80, 80, "B", "80", "jenny"));
		
		request.setAttribute("e", al);
		
		
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
