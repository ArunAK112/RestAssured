package crudOperationUsingHashmap;

import java.util.HashMap;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PostCreateProjectTest {
	@Test
	public void createProject()
	{
		HashMap hash = new HashMap();
		hash.put("createdBy", "sowmya");
		hash.put("projectName", "No Project");
		hash.put("status", "On Going");
		hash.put("teamSize", 1);
		
		baseURI="http://localhost";
		port=8084;
		
		given()
		.body(hash)
		.contentType(ContentType.JSON)
		.when()
		.post("/addProject")
		.then()
		.assertThat().contentType(ContentType.JSON).statusCode(201).time(Matchers.lessThan(2000L)).log().all();
	}

}
