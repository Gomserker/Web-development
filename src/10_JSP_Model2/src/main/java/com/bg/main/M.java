package com.bg.main;

import javax.servlet.http.HttpServletRequest;

/*
 M for model -> ����Ͻ� ������ ����
 ���� ���� ����Ѵٰ�. DB�� ����
 */

public class M {

	public static void calc(HttpServletRequest request) {
		
		//�޾ƿ� a,b�� request�� �������.
		int aa = Integer.parseInt(request.getParameter("a"));
		int bb = Integer.parseInt(request.getParameter("b"));
		System.out.println(aa);
		System.out.println(bb);
		int cc = aa + bb;
		
		//���⼭ ���� cc�� v2�� ���� �� �ְ�
		request.setAttribute("ccc", cc);
	}
}
