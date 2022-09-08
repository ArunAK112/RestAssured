package authentication;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class BearerTockenTest {
	@Test
	public void bearerTocken()
	{
		baseURI="https://api.github.com";
		
		JSONObject jObj = new JSONObject();
		jObj.put("name", "sdet31restAssured");
		
		given()
		.auth().oauth2("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")
		.body(jObj)
		.contentType(ContentType.JSON)
		.when()
		.post("/user/repos")
		.then()
		.log().all();
	}

}
