package reqRes.In;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class GetAllUser {
	
	@Test
	public void getAllUser()
	{
		baseURI="https://reqres.in";
		
		when()
		.get("/api/users?page=2")
		.then()
		.assertThat().statusCode(200).contentType(ContentType.JSON).time(Matchers.lessThan(2000L)).log().all();
	}

}
