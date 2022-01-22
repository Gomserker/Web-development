package com.bg.mb;

import java.io.InputStream;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DeleteMain {
	public static void main(String[] args) {
		try {
			String resource = "config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession ss = sqlSessionFactory.openSession();
			
			System.out.println("success");
			
			// 등록(insert)
			
			Scanner k = new Scanner(System.in);
			System.out.println("--커피 삭제");
			System.out.print("삭제할 커피명: ");
			String name = k.next();
			
			
//			Coffee c = new Coffee(name);
			
//			변수가 많을 경우엔 이것도 나쁘지 않은 선택
			Coffee c = new Coffee();
			c.setC_name(name);
			
			//객체로 만들어서 사용해야함
			if(ss.insert("bgqqq.delCoffee", c) == 1) {
				System.out.println("coffee delete success");
				//commit까지 해줘야한다.
				ss.commit();
			} else {
				System.out.println("coffee delete failed");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
	

