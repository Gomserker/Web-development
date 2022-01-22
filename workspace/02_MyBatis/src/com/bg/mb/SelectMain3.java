package com.bg.mb;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SelectMain3 {
	public static void main(String[] args) {

		// 입력한 가격 이하의 커피 검색

		try {
			String resource = "config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession ss = sqlSessionFactory.openSession();

			System.out.println("success");

			Scanner input = new Scanner(System.in);

			System.out.print("얼마까지 알아보셨어요? : ");
			int price = input.nextInt();

//			Coffee ccc = new Coffee(null, price);
			Coffee cccc = new Coffee();
			cccc.setC_price(price);

			List<Coffee> coffees = ss.selectList("bgqqq.coffeeSearchByPrice", cccc);

			for (Coffee c : coffees) {
				System.out.println(c.getC_name());
				System.out.println(c.getC_price());
				System.out.println("--------------");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
