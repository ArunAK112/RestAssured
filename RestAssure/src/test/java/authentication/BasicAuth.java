package authentication;
import static io.restassured.RestAssured.*;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class BasicAuth {
	
	@Test
	public void basicAuth()
	{
		baseURI="http://localhost";
		port=8084;
		
		given()
		.auth().basic("rmgyantra", "rmgy@9999")
		.when()
		.get("/login")
		.then()
		.assertThat().statusCode(202).contentType(ContentType.JSON).time(Matchers.lessThan(2000L)).log().all();
		
	}
	
	@Test
	public void preemptiveAuth()
	{
		baseURI="http://localhost";
		port=8084;
		
		given()
		.auth().preemptive().basic("rmgyantra", "rmgy@9999")
		.when()
		.get("/login")
		.then().assertThat().statusCode(202).contentType(ContentType.JSON).time(Matchers.lessThan(2000L)).log().all();
	}
	
	@Test
	public void digestiveAuth()
	{
		baseURI="http://localhost";
		port=8084;
		
		given()
		.auth().digest("rmgyantra", "rmgy@9999")
		.when()
		.get("/login")
		.then()
		.assertThat().statusCode(202).contentType(ContentType.JSON).time(Matchers.lessThan(2000L)).log().all();
		
	}

}
