package crudOperationUsingPojoclass;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import pojoClass.Project;

public class PostAddProjectTest {
	
	@Test
	public void addProject()
	{
		Project proj = new Project("Sunitha","Vihan","Created",20);
		given()
		.body(proj)
		.contentType(ContentType.JSON)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().time(Matchers.lessThan(2000L)).contentType(ContentType.JSON).statusCode(201).log().all();
		
	}

}
