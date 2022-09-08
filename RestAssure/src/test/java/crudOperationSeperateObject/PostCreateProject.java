package crudOperationSeperateObject;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import jsonOBJ.JsonObjectFile;

public class PostCreateProject {
	@Test
	public void createProject()
	{
		JsonObjectFile jsob = new JsonObjectFile();
		Object j = jsob.jsonObjectFile();
		
		given()
		.body(j)
		.contentType(ContentType.JSON)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().contentType(ContentType.JSON).statusCode(201).time(Matchers.lessThan(2000L)).log().all();
	}

}
