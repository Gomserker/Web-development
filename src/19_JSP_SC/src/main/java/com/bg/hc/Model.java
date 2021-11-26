package com.bg.hc;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Model {

	public static void print1(HttpServletRequest request) {
		
		//parameter = View���� ���� ��
		// String or String[]
		//�װ� request�� �Ƿ� �Ѿ���� ��.
		
		//���� ������
		// java = request.getparameter("");
		//EL = ${param.�Ķ���͸�}
		
		String aa = request.getParameter("a");
		
		//attribute = Model���� ���� ��(Java����)
		//Object (�ڷ����� ������ ����)
		//request�� �Ƿ��� ����
		
		//���� ������
		//java = request.getAttribute("");
		//EL = ${��Ʈ����Ʈ��}
		
		String bb = (String) request.getAttribute("b");
	}
	
	
	public static void make1(HttpServletRequest request, HttpServletResponse response) {
		String bbb = "������";
		request.setAttribute("b", bbb);
		
		// ����ϴ� �� (�� 4����)
		// parameter, attribute
		// Ư¡�� third���� ����
		
		//session�� cookie
		
		//session
		//session.attribute (������ ��Ʈ����Ʈ)
		
		String ccc = "thisissession";
		HttpSession hs = request.getSession();
		hs.setMaxInactiveInterval(5); // ���� �����ð� ~��
		hs.setAttribute("c", ccc);
		
		//������ Ŭ���̾�Ʈ�� �������
		//������ Ŭ���̾�Ʈ�� ���Ḹ ���������
		//�� ����Ʈ ��𿡼��� ��� �����ϴ�.
		//������ �������� �� ����.(���� ����/������ ����)
		//���� �����ð� (�⺻ 30��)
		//�ð� ���� '��û'�� �Ͼ�� ������(request) ����.
		//�ð� ���� '��û' ���� �۾��� �ϸ� ����(�����ð� �ʱ�ȭ)
		
		//cookie
		//����� ��ǻ�Ϳ� ���� ����
		//������ ��� ������� �ص� ����ִ�.
		
		String ddd = "Thisiscookie";
		Cookie coo = new Cookie("d", ddd);
		coo.setMaxAge(5*60); //~*60 = ~��
		
		response.addCookie(coo);
	}
	
	public static void print2(HttpServletRequest req) {
		//session.attr (������ ��Ʈ����Ʈ)
		//Model���� ���� ��
		//������ Ŭ���̾�Ʈ���� ���� ���¿� ����.
		//�ð������� �ִµ� ������ Object
		
		//�� ��������
		//java = request.getSession().getAttribute("��Ʈ����Ʈ��");
		//EL = ${sessionScope.��Ʈ����Ʈ��}
		
		String ccc = (String) req.getSession().getAttribute("c");
		//���� ������� �ִ� ��Ű��
		Cookie[] cookies = req.getCookies();
		
		for (Cookie c : cookies) {
			System.out.println(c);
			if(c.getName().equals("d")) {
				System.out.println(c.getValue());
			}
		}
		
		// EL : ${cookie.��Ű�̸�.value}
		
		
		
	}
}
