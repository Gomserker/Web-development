package com.bg.mb;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

// 외부 파일이 어떤 형식이 있으면 좋겠다 : xml

// xml : 각종 설정파일에서 사용
// json : 네트워크 상에서 데이터 주고 받을때 사용

//DB

//서버 정보                                                       SQL
//JDBC                DBManager.java  DAO.java
//ConnectionPool            .xml      DAO.java
//myBatis                   .xml
public class Connection {
	public static void main(String[] args) {
		try {
			String resource = "config.xml"; //서버 정보가 담긴 파일
			InputStream is = Resources.getResourceAsStream(resource);
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder(); //공장 빌더
			SqlSessionFactory ssf = ssfb.build(is); //공장
			SqlSession ss = ssf.openSession(); //공장 문 열음
			
			System.out.println("success");
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
