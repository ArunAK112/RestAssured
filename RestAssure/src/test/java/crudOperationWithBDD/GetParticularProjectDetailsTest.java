package crudOperationWithBDD;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class GetParticularProjectDetailsTest {
	
	@Test
	public void getParticularProject()
	{
		when()
		.get("http://localhost:8084/projects/TY_PROJ_2005")
		.then()
		.assertThat().statusCode(200).contentType(ContentType.JSON).time(Matchers.lessThan(2000L)).log().all();
	}

}
