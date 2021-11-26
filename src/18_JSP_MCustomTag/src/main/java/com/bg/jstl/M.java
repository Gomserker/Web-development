package com.bg.jstl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class M {

	public static void calc(HttpServletRequest request) {
		
		int year = Integer.parseInt(request.getParameter("year"));
		
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		int curYear = Integer.parseInt(sdf.format(d));
		int age = (curYear - year) + 1;
		
		request.setAttribute("age", age);
		
		
		int[] ar = {1,3,5,7,9};
		request.setAttribute("ar", ar);
		
		ArrayList<Menu> menus = new ArrayList<Menu>();
		
		menus.add(new Menu("��ġ�", 6000));
		menus.add(new Menu("���", 9000));
		menus.add(new Menu("���ø�", 12000));
		menus.add(new Menu("�ҹ�� �Ұ��", 8000));
		
		request.setAttribute("menus", menus);
	}

}
