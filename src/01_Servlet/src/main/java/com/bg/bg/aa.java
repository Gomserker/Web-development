package com.bg.bg;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// ������ ��� �� ���·� ����� ��.
/*
 servlet 2.x�� url�� ����ؼ� ����ؾ� ������, 3.0 ���ķδ� @WebServlet ������̼����� ��밡��
 Tomcat 5.0 ���� : ��Ĺ �������Ͽ� ���� ����ؾ� �ߴ�.
 */


@WebServlet("/aa") // ���ͳ� �ּ�â �� �޺κ�. ��ġ�� ���α׷��� �� ��������� �𸥴�.
public class aa extends HttpServlet {
//	������̼� ���ǻ���
//	1. �����ص� �ȹٲ�� ����ó�� ������Ѵ�.
//	2. �����ͷε� �ٲ��� �ʴ´�.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Test again");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
