package crudOperationWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class PostAddProjectTest 
{
	@Test
	public void create() 
	{
		//Json body creation
		JSONObject jsonOb = new JSONObject();
		jsonOb.put("createdBy", "Gayathri");
		jsonOb.put("projectName", "GProject");
		jsonOb.put("status", "Created");
		jsonOb.put("teamSize", 20);

		//Request body and content type
		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.body(jsonOb);
		reqSpec.contentType(ContentType.JSON);
		
		//entering uri
		Response response = reqSpec.post("http://localhost:8084/addProject");
		//validation
		ValidatableResponse validate = response.then();
		validate.assertThat().contentType(ContentType.JSON);
		validate.assertThat().statusCode(201);
		validate.log().all();
		
		
	}
}
