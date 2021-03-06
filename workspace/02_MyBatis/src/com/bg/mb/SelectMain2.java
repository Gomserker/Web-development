package com.bg.mb;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SelectMain2 {
	public static void main(String[] args) {
		//이름으로 검색
		try {
			String resource = "config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession ss = sqlSessionFactory.openSession();
			
			System.out.println("success");
			
			Scanner input = new Scanner(System.in);
			
			System.out.print("검색할 커피: ");
			String name = input.next();
			
			Coffee cc = new Coffee(name, 0);
			
			List<Coffee> coffees = ss.selectList("bgqqq.getCoffee", cc);
			
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
