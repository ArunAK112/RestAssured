package reqRes.In;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PostCreateUser {
	
	@Test
	public void createUser()
	{
		JSONObject jsob = new JSONObject();
		jsob.put("name", "morpheus");
		jsob.put("job", "leader");
		
		baseURI="https://reqres.in/";
		
		given()
		.body(jsob)
		.contentType(ContentType.JSON)
		.when()
		.post("api/users")
		.then()
		.assertThat().statusCode(201).contentType(ContentType.JSON).time(Matchers.lessThan(2000L)).log().all();
		
	}

}
