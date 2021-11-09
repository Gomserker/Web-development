package com.bg.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Reg")
public class Reg extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String gender = request.getParameter("gender");
		String addr = request.getParameter("addr");
		String[] hobby = request.getParameterValues("hobby");
		String intro = request.getParameter("intro");
		
		
		
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<head>");
		out.print("<meta charset=\"utf-8\">");
		out.print("<link rel=\"stylesheet\" href=\"reg.css\">");
		out.print("</head>");
		out.print("<body>");
		
		out.print("<table border=\"1px solid black\">\r\n"
				+ "			<tr>\r\n"
				+ "			<td colspan=\"2\">가입완료</td>\r\n"
				+ "			</tr>\r\n"
				+ "			<tr>\r\n"
				+ "			<td>이름</td>\r\n"
				+ "			<td>" + name + "</td>\r\n"
				+ "			</tr>	\r\n"
				+ "			<tr>\r\n"
				+ "			<td>ID</td>\r\n"
				+ "			<td>" + id + "</td>\r\n"
				+ "			</tr>	\r\n"
				+ "			<tr>\r\n"
				+ "			<td>PW</td>\r\n"
				+ "			<td>" + pw + "</td>\r\n"
				+ "			</tr>	\r\n"
				+ "			<tr>\r\n"
				+ "			<td>성별</td>\r\n"
				+ "			<td>" + gender + "</td>\r\n"
				+ "			</tr>	\r\n"
				+ "			<tr>\r\n"
				+ "			<td>주소</td>\r\n"
				+ "			<td>" + addr + "</td>\r\n"
				+ "			</tr>\r\n"
				+ "			<tr>\r\n"
				+ "			<td>관심사</td>\r\n"
				+ "			<td>\r\n"
				
				+ "			</td>\r\n"
				+ "			</tr>\r\n"
				+ "			<tr>\r\n"
				+ "			<td>자기소개</td>\r\n"
				+ "			<td><textarea name=\"intro\"></textarea></td>\r\n"
				+ "			</tr>\r\n"
				+ "			<tr>\r\n"
				+ "			<td colspan=\"2\"><button>가입</button></td>\r\n"
				+ "			</tr>			\r\n"
				+ "		</table>");
		
		out.print("</body>");
		out.print("</html>");
		
				
			}
	}


