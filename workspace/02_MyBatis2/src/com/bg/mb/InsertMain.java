package com.bg.mb;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class InsertMain {
	public static void main(String[] args) {
		
		try {
			String resource = "config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession ss = sqlSessionFactory.openSession();
			
			System.out.println("success");
			
			// 등록(insert)
			
			Scanner k = new Scanner(System.in);
			System.out.println("--커피 등록");
			System.out.print("커피명: ");
			String name = k.next();
			
			System.out.print("가격: ");
			int price = k.nextInt();
			
			Coffee c = new Coffee(name, price);
			
			//객체로 만들어서 사용해야함
			if(ss.insert("bgqqq.regCoffee", c) == 1) {
				System.out.println("coffee register success");
				//commit까지 해줘야한다.
				ss.commit();
			} else {
				System.out.println("coffee register failed");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
