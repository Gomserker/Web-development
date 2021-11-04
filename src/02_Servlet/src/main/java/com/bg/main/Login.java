package com.bg.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Login")
public class Login extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		
		
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<head>");
		out.print("<meta charset=\"utf-8\">");
		out.print("</head>");
		out.print("<body>");
		
		out.print("ID: " + id + "<br>");
		out.print("PW: " + pw + "<br>");
		
		
		if(id.equals("bg")) {
			if(pw.equals("1004")) {
				out.print("<hr><h1>login</h1>");
			} else {
				out.print("<hr><h1>false pw</h1>");
			}
		} else {
			out.print("<hr><h1> invalid id</h1>");
		}
		
		
		out.print("</body>");
		out.print("</html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		//post 방식 한글처리할때 필요한 코드
		request.setCharacterEncoding("utf-8");
		
		
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<head>");
		out.print("<meta charset=\"utf-8\">");
		out.print("</head>");
		out.print("<body>");
		
		out.print("ID: " + id + "<br>");
		out.print("PW: " + pw + "<br>");
		
		
		if(id.equals("bg")) {
			if(pw.equals("1004")) {
				out.print("<hr><h1>login</h1>");
			} else {
				out.print("<hr><h1>false pw</h1>");
			}
		} else {
			out.print("<hr><h1> invalid id</h1>");
		}
		
		
		out.print("</body>");
		out.print("</html>");
	}

	

}
