package restAssured_Example;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import io.restassured.specification.RequestSpecification;

public class TC_03_POST_GitHub {
	
	RequestSpecification httpRequest;
	
	@Test
	public void verifyPostMessage() {
		
		JSONObject obj = new JSONObject();
		obj.put("name", "apiRepo");
		
		baseURI = "https://api.github.com/";
		
		given().
				header("Content-Type", "application/json").
				auth().oauth2("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").
				
		when().
				body(obj).
				post("/user/repos").
//				get("/user/repos").
				
		then().
				statusCode(201).			
				log().all();
		
	}

}
