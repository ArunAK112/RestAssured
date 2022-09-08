package reqRes.In;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PostLoginSucessfull {
	@Test
	public void loginSucessfull()
	{
	
		JSONObject jsob = new JSONObject();
		jsob.put("email", "eve.holt@reqres.in");
		jsob.put("password", "cityslicka");
		
		baseURI="https://reqres.in/";
		
		given()
		.body(jsob)
		.contentType(ContentType.JSON)
		.when()
		.post("api/login")
		.then()
		.assertThat().statusCode(200).contentType(ContentType.JSON).time(Matchers.lessThan(3000L)).log().all();
	}

}
