package com.semi.review;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/WritePost")
public class WritePost extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//글조회
		ReviewDAO.getAllReview(request);
		request.setAttribute("loginPage", "login/login.jsp");
		request.setAttribute("contentPage", "review/reviewWrite.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//글입력
		//글조회
		
		ReviewDAO.writeReview(request);
		ReviewDAO.getAllReview(request);
		request.setAttribute("loginPage", "login/login.jsp");
		request.setAttribute("contentPage", "review/review.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	
	}

}
