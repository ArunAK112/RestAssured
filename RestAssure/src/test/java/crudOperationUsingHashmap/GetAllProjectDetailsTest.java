package crudOperationUsingHashmap;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class GetAllProjectDetailsTest {
	@Test
	public void allProjects()
	{
		baseURI="http://localhost";
		port = 8084;
		when()
		.get("/projects")
		.then()
		.assertThat().contentType(ContentType.JSON).statusCode(200).time(Matchers.lessThan(2000L)).log().all();
	}

}
