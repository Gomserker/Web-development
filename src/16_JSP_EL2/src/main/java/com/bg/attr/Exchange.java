package com.bg.attr;

import javax.servlet.http.HttpServletRequest;

public class Exchange {

	public static void calc(HttpServletRequest request) {
		
		int price = Integer.parseInt(request.getParameter("p"));
		int money = Integer.parseInt(request.getParameter("m"));
		
		String say = null;
		int ex = 0;
		int ex2 = 0;
		
		if (price < money) {
			ex = money - price;
			say = "Here is your change";
		} else if (price > money) {
			ex = money - price;
			ex2 = price - money;
			say = "You cannot afford this shit.";
		} else {
			say = "Thank you for coming";
		}
		
//		request.setAttribute("exchange", ex);
//		request.setAttribute("say", say);
//		request.setAttribute("price", price);
//		request.setAttribute("money", money);
		
		//���Ͱ��� �ʿ��� �͵��� ���� �Ǿ ������ ������
		//�ѹ��� �����̷� �����ڴ°� (��ü)
		
		request.setAttribute("ex2", ex2);
		Result r = new Result(price, money, ex, say);
		request.setAttribute("rr", r);
		
		
	}

	public static void makePositive(HttpServletRequest request) {
		int how = Integer.parseInt(request.getParameter("how"));
		how *= -1;
		request.setAttribute("how", how);
	}

}
