package com.bg.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Calc")
public class Calc extends HttpServlet {
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int x = Integer.parseInt(request.getParameter("x"));
		int y = Integer.parseInt(request.getParameter("y"));
		String[] cc = request.getParameterValues("c");
		
		response.setCharacterEncoding("euc-kr");
		PrintWriter out = response.getWriter();
		
		
		out.print("<html>");
		out.print("<head>");
		out.print("<meta charset=\"euc-kr\">");
		out.print("</head>");
		out.print("<body>");
		out.print("<h1>Calc file</h1>");
		

		out.print("<table border=\"3\" style=\"width: 400px; height: 300px\">");

//		개선 버전
 		for (String s : cc){
 			if (s.equals("+")) {
 				out.printf("<tr><td>%d + %d = %d</td></tr>", x, y, x+y);
 			} else if (s.equals("-")) {
 				out.printf("<tr><td>%d - %d = %d</td></tr>", x, y, x-y);
 			} else if (s.equals("x")) {
 				out.printf("<tr><td>%d X %d = %d</td></tr>", x, y, x*y);
 			} else {
 				out.printf("<tr><td>%d / %d = %.1f</td></tr>", x, y, (double)x/y);
 			}
 		}
 		
// 		내가 처음 한것
//		for (int i = 0; i < cc.length; i++) {
//			if(cc[i].equals("1")) {
//				out.printf("<tr><td>%d + %d = %d</td></tr>", x, y, x+y);
//			} else if (cc[i].equals("2")) {
//				out.printf("<tr><td>%d - %d = %d</td></tr>", x, y, x-y);
//			} else if (cc[i].equals("3")) {
//				out.printf("<tr><td>%d X %d = %d</td></tr>", x, y, x*y);
//			} else if (cc[i].equals("4")) {
//				out.printf("<tr><td>%d / %d = %d</td></tr>", x, y, x/y);
//			}
//		}
		
		out.print("</table>");
		
		out.print("</body>");
		out.print("</html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
