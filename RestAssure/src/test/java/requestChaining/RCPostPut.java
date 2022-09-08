package requestChaining;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.lexnod.genericLib.JavaUtility;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClass.Project;

import static io.restassured.RestAssured.*;

public class RCPostPut {
	@Test
	public void rcPostAndPut() {
		baseURI = "http://localhost";
		port = 8084;

		JavaUtility jlib = new JavaUtility();
		Project proj = new Project("ArunK", "CMP" + jlib.getRandonNumber(100), "Created", 40);

		// Post
		Response resp = given().body(proj).contentType(ContentType.JSON).when().post("/addProject");

		// capturing project id
		String projId = resp.jsonPath().get("projectId");
		System.out.println("<======Project CREATED sucessfully======>");
		System.out.println(projId);
		resp.then().assertThat().statusCode(201).contentType(ContentType.JSON).time(Matchers.lessThan(2000L)).log().all();
		
		
		//Put
		Project projPut = new Project("Arun", "CM P"+jlib.getRandonNumber(200), "Created", 30);

		given()
		.body(projPut)
		.contentType(ContentType.JSON)
		.pathParam("PID", projId)
		.when()
		.put("/projects/{PID}")
		.then()
		.assertThat().statusCode(200).contentType(ContentType.JSON).log().all();
		System.out.println("<======Project UPDATED Sucessfully======>");
	}

}
