package com.bg.reg;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Test2")
public class Test2 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("euc-kr");
		PrintWriter out = response.getWriter();
		
		//아래 작업들이 귀찮긴하지만
		//서블렛도 결국 Java이기 때문에, Java 문법을 사용할 수 있다는 큰 장점이 있다.
		out.print("<html>");
		out.print("<head>");
		out.print("<meta charset=\"euc-kr\">");
		out.print("</head>");
		out.print("<body>");
		for (int i = 1; i < 501; i++) {
				out.print("<h1>Servlet Test Success " + i + "</h1>");
				if (i % 10 == 0) {
					out.print("<h1 style =\"color: tomato\"> 10개씩 나눔</h1>");
				}
			}
		out.print("</body>");
		out.print("</html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
