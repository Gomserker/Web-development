package com.bg.bg;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 앞으로 계속 이 형태로 사용할 것.
/*
 servlet 2.x는 url을 등록해서 사용해야 했으나, 3.0 이후로는 @WebServlet 어노테이션으로 사용가능
 Tomcat 5.0 이전 : 톰캣 설정파일에 따로 등록해야 했다.
 */


@WebServlet("/aa") // 인터넷 주소창 맨 뒷부분. 겹치면 프로그램이 뭘 띄워야할지 모른다.
public class aa extends HttpServlet {
//	어노테이션 주의사항
//	1. 복붙해도 안바뀌니 수동처리 해줘야한다.
//	2. 리팩터로도 바뀌지 않는다.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Test again");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
