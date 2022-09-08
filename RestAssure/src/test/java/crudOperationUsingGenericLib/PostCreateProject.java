package crudOperationUsingGenericLib;

import org.hamcrest.Matchers;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.lexnod.genericLib.BaseAPIClass;
import com.lexnod.genericLib.EndPointsLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClass.Project;

import static io.restassured.RestAssured.*;

public class PostCreateProject extends BaseAPIClass{
	@Test
	public void createProject() throws Throwable
	{
		String endP = EndPointsLibrary.createProject;
		int randomNumb = jLib.getRandonNumber(500);
		Project proj = new Project("AK","akP"+randomNumb, "Created", 30);
		
		//post a request
		Response response = given()
		.body(proj)
		.contentType(ContentType.JSON)
		.when()
		.post(endP);
		
		response.then()
		.assertThat().statusCode(201).contentType(ContentType.JSON).time(Matchers.lessThan(2000L)).log().all();
		
		
		//store projectId
		String projectID = rLib.getJsonData(response, "projectId");
		
		//verify in database
		Reporter.log("<=====DataBase Verification Starts=====>", true);
		dLib.executeQuery("select * from project", 1, projectID);
		
	}

}
