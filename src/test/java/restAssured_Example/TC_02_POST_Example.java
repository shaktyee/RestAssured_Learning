package restAssured_Example;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_02_POST_Example {
	
	RequestSpecification httpRequest;
	
	@Test
	public void verifyPostMessage() {
		
		JSONObject obj = new JSONObject();
		obj.put("name", "shakti");
		obj.put("job", "Architect");
		
		System.out.println(obj.toJSONString());
		
		RestAssured.baseURI = "https://reqres.in/";
		httpRequest = RestAssured.given();
		
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(obj);
		
		Response resp = httpRequest.request(Method.POST, "/api/users");
		
		System.out.println(resp.asPrettyString());
		System.out.println(resp.getStatusCode());
		
		
	}

}
