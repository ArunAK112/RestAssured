package reqRes.In;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class LoginUnsucessfull {

	@Test
	public void loginUnsucessfull()
	{
		JSONObject jsob = new JSONObject();
		jsob.put("email", "peter@klaven");
		
		given()
		.body(jsob)
		.contentType(ContentType.JSON)
		.when()
		.post("https://reqres.in/api/login")
		.then()
		.statusCode(400).contentType(ContentType.JSON).time(Matchers.lessThan(3000L)).log().all();
	}
}
