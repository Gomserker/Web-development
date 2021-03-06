package com.bg.mb;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class MMain2 {
	public static void main(String[] args) {
		
		//콘솔에 db 정보 전부 출력
		
		try {
			SqlSession ss = DBManager_new.connect();
			
			List<Weather> weathers = ss.selectList("bgqqq.getAllWeather");
			
			
//			for (Weather w : weathers) {
//				System.out.println(w.getW_city());
//				System.out.println("-----------");
//			}
			
		FileOutputStream fos = new FileOutputStream("C:\\Users\\MSI\\Desktop\\result2.csv", true);
		//fos 보다는 두꺼운 빨대를 꽂아야함 가는거부터 두꺼운 순서대로 꽂아야 들어간다
		OutputStreamWriter osw = new OutputStreamWriter(fos, "euc-kr");
		BufferedWriter bw = new BufferedWriter(osw);
		
		for (Weather w : weathers) {
			bw.write(w.getW_city() + ",");
			bw.write(w.getW_country() + ",");
			bw.write(w.getW_temp() + ",");
			bw.write(w.getW_description() + "\r\n");
		}
		
		System.out.println("success");
		//쓰고나면 닫아줘야함
		bw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
