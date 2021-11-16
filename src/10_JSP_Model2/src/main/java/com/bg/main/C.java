package com.bg.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 C for Controller
 상황을 판단해서 필요한 쪽으로 보낸다.
 
 웹사이트의 진입점
 */

@WebServlet("/C")
public class C extends HttpServlet {
	//주소를 입력해서 접속하거나 클릭해서 접속하는 경우. -> 어떤 사이트에 처음으로 들어가는 경우는 get 방식 요청
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get 방식 들어오면 v.html로 포워드
		
		request.getRequestDispatcher("v.html").forward(request, response);
//		response.sendRedirect("v.html");
//		Redirect의 경우 처음 접속할때는 사용해도 되지만 결국 나중엔 forward로 처리한다.
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		계산은 별도의 자바 클래스를 만들어서 한다.
		
//		M m = new M(); // M 객체 생성
//		m.calc(request);
		
		M.calc(request);
		
			request.getRequestDispatcher("v2.jsp").forward(request, response);
		
		
		
			}

}
