package com.bg.attr;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ExController")
public class ExController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Exchange.makePositive(request);
		request.getRequestDispatcher("attr/output3.jsp").forward(request, response);
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//추가 처리할 게 없음. 바로 결과 페이지로 보내주기만 하면 된다.
		request.getRequestDispatcher("attr/output3.jsp").forward(request, response);
	}

}
