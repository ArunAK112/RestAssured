package assignment;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class DeletePurchaseOrderByID {
	@Test
	public void deletePurchaseOrder() {
		baseURI="https://petstore.swagger.io/v2";
		
		given()
		.pathParam("orderId", 1)
		.when()
		.delete("/store/order/{orderId}")
		.then()
		.assertThat().log().all();
	}
}
