package requestChaining;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.lexnod.genericLib.JavaUtility;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClass.Project;

public class RCPostGet {
	
	@Test
	public void rcPostAndGet()
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
	}

}
