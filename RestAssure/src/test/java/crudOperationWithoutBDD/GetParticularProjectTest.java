package crudOperationWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GetParticularProjectTest {
	@Test
	public void getParticularProject()
	{
		//sending request
		Response response = RestAssured.get("http://localhost:8084/projects/TY_PROJ_1802");
		
		//validate
		ValidatableResponse validate = response.then();
		validate.assertThat().contentType(ContentType.JSON);
		validate.assertThat().statusCode(200);
		validate.log().all();
	}

}
