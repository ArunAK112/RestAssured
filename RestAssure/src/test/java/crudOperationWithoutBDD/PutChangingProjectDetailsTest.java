package crudOperationWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class PutChangingProjectDetailsTest {
	@Test
	public void changingProjectDetail()
	{
		//creating json object
		JSONObject jsonOb = new JSONObject();
		jsonOb.put("createdBy", "Gayathri");
		jsonOb.put("projectName", "yazhisai");
		jsonOb.put("status", "Created");
		jsonOb.put("teamSize", 25);
		
		//requestbody and content type
		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.body(jsonOb);
		reqSpec.contentType(ContentType.JSON);
		
		//sending request
		Response response = reqSpec.put("http://localhost:8084/projects/TY_PROJ_1803");
		
		//validation
		ValidatableResponse validate = response.then();
		validate.assertThat().contentType(ContentType.JSON);
		validate.assertThat().statusCode(200);
		validate.log().all();
		

	}

}
