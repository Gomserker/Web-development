package com.bg.hc;

import javax.servlet.http.HttpServletRequest;

public class Exchange {

	public static void calc(HttpServletRequest request) {
		
		int price = Integer.parseInt(request.getParameter("p"));
		int money = Integer.parseInt(request.getParameter("m"));
		
		String say = null;
		int ex = 0;
		
		if (price < money) {
			ex = money - price;
			say = "Here is your change";
		} else if (price > money) {
			ex = money - price;
			say = "You cannot afford this shit.";
		} else {
			say = "Thank you for coming";
		}
		
//		request.setAttribute("exchange", ex);
//		request.setAttribute("say", say);
//		request.setAttribute("price", price);
//		request.setAttribute("money", money);
		
		//위와같이 필요한 것들을 따로 실어서 보내도 되지만
		//한번에 뭉탱이로 보내자는거 (객체)
		
		Result r = new Result(price, money, ex, say);
		request.setAttribute("rr", r);
		
		
	}

}
