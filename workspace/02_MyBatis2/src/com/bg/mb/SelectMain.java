package com.bg.mb;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SelectMain {
	public static void main(String[] args) {
		
		try {
			String resource = "config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession ss = sqlSessionFactory.openSession();
			
			System.out.println("success");
			
			//myBatis로 셀렉트하면
			//jsp에서 했던 execute 실행해서 rs에 담고, Bean, 객체, ArrayList에 add 등등 하는 작업들
			//이걸 전부 myBatis가 자동으로 해준다. 대신 규칙을 따라야함.
			//자바빈 멤버변수명 = db 필드명
			
			//mapper.xml
			//자바 객체로 만들어서 주는데 뭘로 만들지 결정하는 것. -> resultType
												//namespace.태그에 부여한 id
			List<Coffee> coffees = ss.selectList("bgqqq.getAllCoffee");
			
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
