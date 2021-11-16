package com.bg.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 C for Controller
 ��Ȳ�� �Ǵ��ؼ� �ʿ��� ������ ������.
 
 ������Ʈ�� ������
 */

@WebServlet("/C")
public class C extends HttpServlet {
	//�ּҸ� �Է��ؼ� �����ϰų� Ŭ���ؼ� �����ϴ� ���. -> � ����Ʈ�� ó������ ���� ���� get ��� ��û
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get ��� ������ v.html�� ������
		
		request.getRequestDispatcher("v.html").forward(request, response);
//		response.sendRedirect("v.html");
//		Redirect�� ��� ó�� �����Ҷ��� ����ص� ������ �ᱹ ���߿� forward�� ó���Ѵ�.
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		����� ������ �ڹ� Ŭ������ ���� �Ѵ�.
		
//		M m = new M(); // M ��ü ����
//		m.calc(request);
		
		M.calc(request);
		
			request.getRequestDispatcher("v2.jsp").forward(request, response);
		
		
		
			}

}
