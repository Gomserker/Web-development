package com.bg.mb;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SelectMain4 {
	public static void main(String[] args) {
		
		try {
			String resource = "config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession ss = sqlSessionFactory.openSession();
			
			System.out.println("success");
			
			Scanner input = new Scanner(System.in);
			
			System.out.print("얼마 이상?");
			int price1 = input.nextInt();
			
			System.out.print("얼마 이하?");
			int price2 = input.nextInt();
			
			Price p = new Price(price1, price2);
			
			List<Coffee> coffees = ss.selectList("bgqqq.coffeeSearchByPrice2", p);

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
