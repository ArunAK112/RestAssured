package crudOperationUsingJsonFIle;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;

public class PostCreateProject {
	@Test
	
	public void createProject()
	{
		File file = new File("D:\\SDET37\\PostmanJSONfile\\JSONFile.json");
		given()
		.body(file)
		.contentType(ContentType.JSON)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().contentType(ContentType.JSON).statusCode(201).time(Matchers.lessThan(2000L)).log().all();
	}

}
