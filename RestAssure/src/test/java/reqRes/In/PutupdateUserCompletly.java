package reqRes.In;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PutupdateUserCompletly {
	
	@Test
	public void updateUser()
	{
		JSONObject jsob = new JSONObject();
		jsob.put("name", "morpheus");
		jsob.put("job", "zion resident");
		
		baseURI="https://reqres.in/";
		
		given()
		.body(jsob)
		.contentType(ContentType.JSON)
		.when()
		.put("api/users/2")
		.then()
		.assertThat().statusCode(200).contentType(ContentType.JSON).time(Matchers.lessThan(2000L)).log().all();
	}

}
