package com.bg.bg;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Test")
public class Test extends HttpServlet{
	
	// �ǹ� : ���� servlet�� ��� �� ������ �ְ�
	// ���� �������̵��ؼ� ���� �߰��ؼ� ���ڴ�.
	
	// servlet class : �⺻���ΰ� �� ������ش�.
	
	
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		System.out.println("test");
		super.service(arg0, arg1);
	}
}
