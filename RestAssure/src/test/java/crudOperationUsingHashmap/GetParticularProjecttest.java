package crudOperationUsingHashmap;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class GetParticularProjecttest {
	@Test
	public void particularProject() {
		
		baseURI="http://localhost";
		port=8084;
		
		when()
		.get("/projects/TY_PROJ_2204")
		.then()
		.assertThat().contentType(ContentType.JSON).statusCode(200).time(Matchers.lessThan(2000L)).log().all();
		
	}

}
