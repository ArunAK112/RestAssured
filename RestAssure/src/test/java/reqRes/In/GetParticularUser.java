package reqRes.In;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class GetParticularUser {
	
	@Test
	
	public void getSingleUser()
	{
		baseURI="https://reqres.in/";
		
		when()
		.get("api/users/2")
		.then()
		.assertThat().statusCode(200).contentType(ContentType.JSON).time(Matchers.lessThan(3000L)).log().all();
	}

}
