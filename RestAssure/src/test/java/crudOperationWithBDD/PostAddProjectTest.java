package crudOperationWithBDD;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

//to import all the rest assure methods 

public class PostAddProjectTest {
	
	@Test
	public void addProject()
	{
		JSONObject jsob = new JSONObject();
		jsob.put("createdBy", "Nischitha");
		jsob.put("projectName", "Child Parthvi");
		jsob.put("status", "Created");
		jsob.put("teamSize", 30);
		
		 given()
		.body(jsob)
		.contentType(ContentType.JSON)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().contentType(ContentType.JSON).statusCode(201).time(Matchers.lessThan(2000L))
		.log().all();
		
	}
	

}
