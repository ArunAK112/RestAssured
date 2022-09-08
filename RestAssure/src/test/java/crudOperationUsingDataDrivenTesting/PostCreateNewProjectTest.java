package crudOperationUsingDataDrivenTesting;

import org.hamcrest.Matchers;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import pojoClass.Project;

public class PostCreateNewProjectTest {
	
	@Test(dataProvider = "data")
	public void createProjectUsingDataDriven(String createdBy, String projectName, String status, int teamSize)
	{
		baseURI="http://localhost";
		port=8084;
		Project proj = new Project(createdBy, projectName, status, teamSize);
		given()
		.body(proj)
		.contentType(ContentType.JSON)
		.when()
		.post("/addProject")
		.then()
		.assertThat().time(Matchers.lessThan(2000L)).contentType(ContentType.JSON).statusCode(201).log().all();
		
		
	}
	
	@DataProvider
	public Object[][] data()
	{
		Object[][] obj = new Object[2][4];
		
		obj[0][0]="Nirmala";
		obj[0][1]="Annanya";
		obj[0][2]="Created";
		obj[0][3]=2;
		
		obj[1][0]="Bindura";
		obj[1][1]="Pragathi";
		obj[1][2]="Created";
		obj[1][3]=2;
		
		return obj;
	}

}
