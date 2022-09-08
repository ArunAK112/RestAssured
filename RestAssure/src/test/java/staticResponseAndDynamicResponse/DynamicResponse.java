package staticResponseAndDynamicResponse;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;



public class DynamicResponse {
	@Test
	public void dynamicResp()
	{
		String expData="TY_PROJ_850";
		
		baseURI="http://localhost";
		port=8084;
		
		Response resp = when().get("/projects");
		
		boolean temp = false;
		
		List<String> pID = resp.jsonPath().get("projectId");
		
		for(String projectId:pID)
		{
			if(projectId.equalsIgnoreCase(expData))
			{
				temp=true;   
			}
		}
		
		Assert.assertTrue(temp);
		System.out.println("Data Verified");
		
		resp.then().log().all();
		
	}

}
