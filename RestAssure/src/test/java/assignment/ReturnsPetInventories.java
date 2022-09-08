package assignment;
import static io.restassured.RestAssured.*;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class ReturnsPetInventories {
	@Test
	public void returnsPetInv()
	{
		baseURI="https://petstore.swagger.io/v2";
		
		when()
		.get("/store/inventory")
		.then()
		.assertThat().statusCode(200).time(Matchers.lessThan(5000L)).contentType(ContentType.JSON).log().all();
	}

}
