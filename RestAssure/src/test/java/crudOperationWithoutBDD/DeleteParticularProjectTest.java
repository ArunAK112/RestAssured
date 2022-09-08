package crudOperationWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class DeleteParticularProjectTest {
	@Test
	public void deleteParticularProject()
	{
		//sending request
		Response response = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_1803");
		
		//validation
		ValidatableResponse validate = response.then();
		validate.assertThat().statusCode(204);
		validate.log().all();
	}

}
