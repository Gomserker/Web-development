package com.bg.mb;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class DAO {

	public static void getAllProduct(HttpServletRequest request) {

		try {
			SqlSession ss = DBManager_new.connect();
			request.setAttribute("products", ss.selectList("bgqqq.getAllProduct"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void doSearch(HttpServletRequest request) {

		try {
			SqlSession ss = DBManager_new.connect();

			String name = request.getParameter("name");
			Product p = new Product();
			p.setP_name(name);
			request.setAttribute("products", ss.selectList("bgqqq.searchProduct", p));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void regProduct(HttpServletRequest request) {

		try {
			SqlSession ss = DBManager_new.connect();

			String saveDirectory = request.getSession().getServletContext().getRealPath("img");

			MultipartRequest mr = new MultipartRequest(request, saveDirectory, 30 * 1024 * 1024, "utf-8",
					new DefaultFileRenamePolicy());

			String name = mr.getParameter("name");
			int price = Integer.parseInt(mr.getParameter("price"));
			String img = mr.getFilesystemName("img");
			String strDate = mr.getParameter("date");

			System.out.println(name);
			System.out.println(price);
			System.out.println(img);
			System.out.println(strDate);

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = sdf.parse(strDate);
			
			Product p = new Product();
			p.setP_name(name);
			p.setP_price(price);
			p.setP_img(img);
			p.setP_exp(date);

			if (ss.insert("bgqqq.regProduct", p) == 1) {
				System.out.println("reg complete");
				ss.commit();
			} else {
				System.out.println("reg failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("db error");
		}
	}

	public static void deleteByNumber(HttpServletRequest request) {
		try {
			SqlSession ss = DBManager_new.connect(); 

			int num = Integer.parseInt(request.getParameter("number"));

			Product p = new Product();
			p.setP_no(num);

			if (ss.insert("bgqqq.delProduct", p) == 1) {
				System.out.println("delete complete");
				ss.commit();
			} else {
				System.out.println("delete failed");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void searchByPrice(HttpServletRequest request) {
		try {
			SqlSession ss = DBManager_new.connect();

			int price = Integer.parseInt(request.getParameter("price"));

			Product p = new Product();
			p.setP_price(price);

			request.setAttribute("products", ss.selectList("bgqqq.searchByPrice", p));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void priceRangeSearch(HttpServletRequest request) {
		try {
			SqlSession ss = DBManager_new.connect();

			int price1 = Integer.parseInt(request.getParameter("price1"));
			int price2 = Integer.parseInt(request.getParameter("price2"));

			Price p = new Price();
			p.setPrice1(price1);
			p.setPrice2(price2);

			request.setAttribute("products", ss.selectList("bgqqq.priceRangeSearch", p));

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void priceUpdate(HttpServletRequest request) {
		try {
			SqlSession ss = DBManager_new.connect();

			int price1 = Integer.parseInt(request.getParameter("price1"));
			int price2 = Integer.parseInt(request.getParameter("price2"));
			
			Map<String, Integer> val = new HashMap<String, Integer>();

			val.put("price1", price1);
			val.put("price2", price2);
			
			if(ss.update("bgqqq.priceUpdate", val) >= 1) {
				System.out.println("price updated");
				ss.commit();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
