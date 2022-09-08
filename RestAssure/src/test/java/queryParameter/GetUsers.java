package queryParameter;
import static io.restassured.RestAssured.*;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GetUsers {
	
	@Test
	public void getUser()
	{
		baseURI="https://reqres.in";
		given()
		.queryParam("page", 2)
		.when()
		.get("/api/users")
		.then()
		.assertThat().contentType(ContentType.JSON).statusCode(200).time(Matchers.lessThan(2000L)).log().all();
		
	}

}
