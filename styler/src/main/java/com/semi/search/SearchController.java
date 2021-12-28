package com.semi.search;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.login.AccountDAO;

@WebServlet("/SearchController")
public class SearchController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AccountDAO.loginCheck(request);
		//����Ʈ�� �Խ��� �޾Ƽ� ��Ʈ����Ʈ �����ϴ� ��
		//����Ʈ�� ���� �޾Ƽ� ��Ʈ����Ʈ �����ϴ� ��
		//��ü ��ȸ
		request.setAttribute("loginPage", "login/login.jsp");
		request.setAttribute("contentPage", "home/home.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
