package crudOperationUsingGenericLib;
import static io.restassured.RestAssured.*;

import org.hamcrest.Matchers;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.lexnod.genericLib.BaseAPIClass;
import com.lexnod.genericLib.EndPointsLibrary;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClass.Project;

public class DeleteProject extends BaseAPIClass{
	@Test
	public void creatingAndDeletingProject() throws Throwable
	{
		int randNumb = jLib.getRandonNumber(100);
		Project proj = new Project("NewProject", "NewP"+randNumb,"Created", 30);
		
		//posting a data
		Response response = given()
		.body(proj)
		.contentType(ContentType.JSON)
		.when()
		.post(EndPointsLibrary.createProject);
		
		//verifying the data
		response.then()
		.assertThat().statusCode(201).contentType(ContentType.JSON).time(Matchers.lessThan(2000L)).log().all();
		Reporter.log("Project Created Sucessfully", true);
		
		//getting project id from response
		String projectID = rLib.getJsonData(response, "projectId");
		
		//deleting the created project
		when()
		.delete(EndPointsLibrary.deleteProject+projectID)
		.then()
		.assertThat().statusCode(204).contentType(ContentType.JSON).time(Matchers.lessThan(2000L)).log().all();
		Reporter.log("Project deleted sucessfully",true);
		
		//checking project is deleted in database or not
		Reporter.log("Database Verification started", true);
		dLib.executeQuery("select * from project",1, projectID);
		
	}

}
