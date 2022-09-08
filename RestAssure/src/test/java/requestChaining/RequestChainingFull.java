package requestChaining;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.lexnod.genericLib.JavaUtility;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClass.Project;

import static io.restassured.RestAssured.*;
public class RequestChainingFull {
	
	@Test
	public void requestChaining()
	{
		baseURI="http://localhost";
		port=8084;
		
		JavaUtility jlib = new JavaUtility();
		Project proj = new Project("ArunK", "AK Project"+jlib.getRandonNumber(100), "Created", 40);
		
		//Post
		Response resp = given()
		.body(proj)
		.contentType(ContentType.JSON)
		.when()
		.post("/addProject");
		
		//capturing project id
		String projId = resp.jsonPath().get("projectId");
		System.out.println("<======Project CREATED sucessfully======>");
		System.out.println(projId);
		resp.then().assertThat().statusCode(201).contentType(ContentType.JSON).time(Matchers.lessThan(2000L)).log().all();
		
		//Get
		given()
		.pathParam("pId", projId)
		.when()
		.get("/projects/{pId}")
		.then()
		.assertThat().statusCode(200).contentType(ContentType.JSON).time(Matchers.lessThan(2000L)).log().all();
		System.out.println("<======Project FETCHED sucessfully======>");
		
		//Put
		Project projPut = new Project("ArunK", "AK "+jlib.getRandonNumber(100), "Created", 39);
		given()
		.pathParam("pId", projId)
		.body(projPut)
		.contentType(ContentType.JSON)
		.when()
		.put("/projects/{pId}")
		.then()
		.assertThat().statusCode(200).contentType(ContentType.JSON).time(Matchers.lessThan(2000L)).log().all();
		System.out.println("<======Project UPDATED sucessfully======>");
		
		//Delete
		given()
		.pathParam("pId", projId)
		.when()
		.delete("projects/{pId}")
		.then()
		.assertThat().statusCode(204).time(Matchers.lessThan(2000L)).log().all();
		System.out.println("<======Project DELETED sucessfully======>");
		
		
	}

}
