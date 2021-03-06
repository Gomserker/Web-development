package com.bg.mb;

import java.io.InputStream;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class UpdateMain {
	public static void main(String[] args) {
		try {
			String resource = "config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession ss = sqlSessionFactory.openSession();

			System.out.println("success");
			
			//1. 커피 가격 수정
			//입력한 그 커피만 가격 수정
			
			//2. UpdateMain2 만들어서 작업
			//커피 가격 수정인데 입력받은 값 이상의 커피 가격을 00으로
			Scanner input = new Scanner(System.in);
			System.out.print("가격 수정할 커피: ");
			String name = input.next();
			
			System.out.print("얼마로 수정?: ");
			int price = input.nextInt();
			
			Coffee c = new Coffee(name, price);
			
			if(ss.update("bgqqq.updatePrice", c) == 1) {
				System.out.println("update complete");
				ss.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
