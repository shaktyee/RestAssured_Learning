package restAssured_Example;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_01_GET {
	
	Response resp;
	
	@BeforeTest
	public void setUp() {
		
		RestAssured.baseURI = "https://reqres.in/";
		RequestSpecification httpReq = RestAssured.given();
		
		resp = httpReq.request(Method.GET, "/api/users?page=2");
		
	}
	
	@Test
	public void verifyResponse() {
		
		int code = resp.getStatusCode();
		
		Assert.assertEquals(code, 200);
	}
	
	@Test
	public void verifyHeader() {
		
		String header = resp.getHeader("Vary");
		Assert.assertTrue(header.contains("Accept"));
	}
	
	@Test
	public void viewResponse() {
		
		System.out.println(resp.asPrettyString());
	}

}
