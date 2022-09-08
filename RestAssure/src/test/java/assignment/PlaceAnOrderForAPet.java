package assignment;
import static io.restassured.RestAssured.*;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import pojoClass.PetPojoClass;

public class PlaceAnOrderForAPet {
	@Test
	public void placeOrder()
	{
		baseURI="https://petstore.swagger.io/v2";
		
		PetPojoClass petPojo = new PetPojoClass("1","1","10", "2022-09-06", "placed", "true");
		
		given()
		.body(petPojo)
		.contentType(ContentType.JSON)
		.when()
		.post("/store/order")
		.then()
		.assertThat().statusCode(200).contentType(ContentType.JSON).time(Matchers.lessThan(3000L)).log().all();
	}

}
