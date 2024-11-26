package day2;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class CookiesSample {

	@Test
	public void getCookie() {
		
		Response response = when()
			.get("https://www.google.com");
		
		String cookie =response.getCookie("NID");
		//System.out.println(cookie);
		
		Map<String, String> cookies = response.getCookies();
		
			for(String cookie1: cookies.keySet()) {
				
				System.out.println(cookie1+" "+response.getCookie(cookie1));
			}
		
			
//		.then()
//			.log().cookies()
//			.cookie("AEC", "AZ6Zc-WTrijtfDQxp_nTy9vwqtCV94oqAcDdD4MjhEQO4XlbRMP5eGOgKQ");
	}
	
}
