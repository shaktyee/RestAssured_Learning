package restAssured_Example;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import io.restassured.specification.RequestSpecification;

public class TC_03_POST_Example_BDD {
	
	RequestSpecification httpRequest;
	
	@Test
	public void verifyPostMessage() {
		
		JSONObject obj = new JSONObject();
		obj.put("name", "shakti");
		obj.put("job", "Architect");
		
		baseURI = "https://reqres.in/";
		
		given().
				header("Content-Type", "application/json").
				
		when().
				body(obj).
				post("/api/users").
				
		then().
				statusCode(201).
				body("name", equalTo("shakti")).
				log().all();
		
	}

}
