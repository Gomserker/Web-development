package com.bg.bg;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 앞으로 계속 이 형태로 사용할 것.

//어노테이션 안의 "/ㅁㅁ"는 겹치면 안된다.
@WebServlet("/bb")
public class bb extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		response.setCharacterEncoding("euc-kr");
		PrintWriter out = response.getWriter();
		
		
		out.print("<html>");
		out.print("<head>");
		out.print("<meta charset=\"euc-kr\">");
		out.print("</head>");
		out.print("<body>");
		out.print("<h1>hi there</h1>");
		out.print("</body>");
		out.print("</html>");
		
		
		
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
