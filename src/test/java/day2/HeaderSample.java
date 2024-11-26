package day2;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class HeaderSample {

	@Test
	public void validateHeader() {
		
		when()
		.get("https://www.google.com")
		
		.then()
			.log().all()
			.header("Content-Type", "text/html; charset=ISO-8859-1") 
			.and()
			.header("Content-Encoding", "jzip");
	}
	
	@Test
	public void getHeaderInfo() {
		
		Response response = when()
			.get("https://www.google.com");
		
		String header = response.getHeader("Content-Type");
		//System.out.println(header);
		
		Headers headers = response.getHeaders();
		for(Header header1: headers) {
			
			System.out.println(header1.getName()+"==>"+header1.getValue());
		}
	}
}
