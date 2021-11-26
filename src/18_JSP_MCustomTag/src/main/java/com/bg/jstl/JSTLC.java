package com.bg.jstl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/JSTLC")
public class JSTLC extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//파라미터가 있다는 뜻이고, !를 써서 not으로 뒤집었기 때문에 현재는 파라미터가 없을때라는 뜻이다.
		if(!request.getParameterNames().hasMoreElements()) {
			request.setAttribute("contentPage", "jstl/input.jsp");
		} else {
			M.calc(request);
			request.setAttribute("contentPage", "jstl/output.jsp");
			
		}
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
