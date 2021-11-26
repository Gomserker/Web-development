package com.bg.format;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.bg.jstl.Menu;

public class DataMaker {

	public static void make(HttpServletRequest request) {
		
		int a = 123456789;
		request.setAttribute("a", a);
		
		double b = 0.45;
		request.setAttribute("b", b);
		
		double c = 123123.456456;
		request.setAttribute("c", c);
		
		Date d = new Date();
		request.setAttribute("d", d);
		
		//����(��ü) ������ ����
		//3�� ������ �̸�, ����, ������
		
		ArrayList<Snack> snacks = new ArrayList<Snack>();
		
		snacks.add(new Snack("�ɰԶ�", 1200, new Date()));
		snacks.add(new Snack("�����", 1000, new Date()));
		snacks.add(new Snack("������", 1100, new Date()));
		
		request.setAttribute("snacks", snacks);
	}

	

}
