package assignment;
import static io.restassured.RestAssured.*;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class FindPurchaseOrderById {
	
	@Test
	public void findPurchaseOrder()
	{
		baseURI="http://petstore.swagger.io/v2";
		
		given()
		.pathParam("orderId", 1)
		.when()
		.get("/store/order/{orderId}")
		.then()
		.assertThat().statusCode(200).contentType(ContentType.JSON).time(Matchers.lessThan(5000L)).log().all();
	}

}
