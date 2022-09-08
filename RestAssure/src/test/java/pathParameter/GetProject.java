package pathParameter;

import static io.restassured.RestAssured.*;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GetProject {
	
	@Test
	public void fetchProject()
	{
		baseURI="http://localhost";
		port=8084;
		given()
		.pathParam("pathID", "TY_PROJ_1204")
		.when()
		.get("/projects/{pathID}")
		.then()
		.assertThat().contentType(ContentType.JSON).statusCode(200).time(Matchers.lessThan(2000L)).log().all();
	}

}
