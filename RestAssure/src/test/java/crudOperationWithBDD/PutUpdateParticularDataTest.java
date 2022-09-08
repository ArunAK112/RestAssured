package crudOperationWithBDD;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PutUpdateParticularDataTest {
	
	@Test
	public void updateProject()
	{
		JSONObject jsob = new JSONObject();
		jsob.put("createdBy", "Nischitha");
		jsob.put("projectName", "Child Parthiv Shivani");
		jsob.put("status", "Created");
		jsob.put("teamSize", 30);
		
		given()
		.body(jsob)
		.contentType(ContentType.JSON)
		.when()
		.put("http://localhost:8084/projects/TY_PROJ_2003")
		.then()
		.assertThat().statusCode(200).contentType(ContentType.JSON).time(Matchers.lessThan(2000L)).log().all();
	}

}
