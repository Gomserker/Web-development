package com.semi.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SignOutC")
public class SignOutC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ȸ??Ż?? ???????? ?̵??ϴ? get?Դϴ?.
		AccountDAO.loginCheck(request);
		request.setAttribute("loginPage", "login/loginOk.jsp");
		request.setAttribute("contentPage", "login/signOut.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ȸ??Ż??????
		AccountDAO.loginCheck(request);
		request.setAttribute("loginPage", "login/loginOk.jsp");
		request.setAttribute("contentPage", "home/home.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
