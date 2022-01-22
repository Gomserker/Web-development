package com.bg.mb;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class UpdateMain2 {
	public static void main(String[] args) {
		try {
			String resource = "config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession ss = sqlSessionFactory.openSession();
			
			System.out.println("success");
			
			// 등록(insert)
			
			Scanner k = new Scanner(System.in);
			System.out.println("--커피 가격 수정");
			System.out.print("수정할 얼마 이상의 가격: ");
			int price1 = k.nextInt();
						
			
			System.out.print("얼마로 수정?: ");
			int price2 = k.nextInt();
			
			//int 2개 담아서 보내기 -> 근데 어떻게?
//			Price p = new Price(price1, price2);
			
			//개인마다 다르게 적용할 수 있는 상태를 저장하지 않을땐 빈을 따로 만든다.
			//근데 안하는 방법도 있음
			//맵을 쓰면 된다.
			
			Map<String, Integer> val = new HashMap<String, Integer>();
			
			val.put("price1", price1);
			val.put("price2", price2);
			
			if(ss.update("bgqqq.updatePriceFromPrice", val) >= 1) {
				System.out.println("price updated");
				ss.commit();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
