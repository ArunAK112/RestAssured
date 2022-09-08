package staticResponseAndDynamicResponse;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class StaticResponse {

	@Test
	
	public void staticResp()
	{
		String expData = "TY_PROJ_1204";
		
		baseURI="http://localhost";
		port=8084;
		
		Response resp = when().get("/projects");
		
		String actData = resp.jsonPath().get("[3].projectId");
		Assert.assertEquals(expData, actData);
		System.out.println("DataVerified");
		
		resp.then().log().all();
		
	}
}
