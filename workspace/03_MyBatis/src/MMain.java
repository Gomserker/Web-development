import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URL;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bg.mb.Weather;

public class MMain {
	public static void main(String[] args) {
		
		try {
			SqlSession ss = DBManager_new.connect();
			
			HttpsURLConnection huc = null;
			Scanner k = new Scanner(System.in);
			
			System.out.print("city: ");
			String str = k.next();
			
			//api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}
			//e7b1a57cd2158c8d195bfb24b7597bad
			
			String url = "https://api.openweathermap.org/data/2.5/weather?q=" + str + "&units=metric&appid=e7b1a57cd2158c8d195bfb24b7597bad";
			URL u = new URL(url);
			huc = (HttpsURLConnection) u.openConnection();
			
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			
			//json parsing need json parser
			
			JSONParser jp = new JSONParser();
			
			//만든 객체로 isr 넣어서 파싱 준비
			
			JSONObject weatherData = (JSONObject) jp.parse(isr);
			System.out.println(weatherData);
			
			//원하는 데이터 추출
			
			//온도
			JSONObject main = (JSONObject) weatherData.get("main");
			System.out.println("현재온도 : " + main.get("temp"));
			//국가
			JSONObject sys = (JSONObject) weatherData.get("sys");
			System.out.println("국가 : " + sys.get("country"));
			//도시
			System.out.println("도시 : " + weatherData.get("name"));
			System.out.println("도시 : " + str);
			//설명
			JSONArray weather = (JSONArray) weatherData.get("weather");
			JSONObject wObj = (JSONObject) weather.get(0);
			String desc = (String) wObj.get("description");
			System.out.println("날씨 : " + desc);
			
			//mybatis에 저장
			
			Weather w = new Weather();
			w.setW_temp(new BigDecimal(main.get("temp") + ""));
			w.setW_country((String)sys.get("country"));
			w.setW_city(weatherData.get("name") + "");
			w.setW_description(desc);
			
			
			if(ss.insert("bgqqq.regCurWeather", w) == 1) {
				System.out.println("success");
				ss.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
