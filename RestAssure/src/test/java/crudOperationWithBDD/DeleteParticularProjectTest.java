package crudOperationWithBDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DeleteParticularProjectTest {
	
	@Test
	public void deleteProject()
	{
		when()
		.delete("http://localhost:8084/projects/TY_PROJ_2005")
		.then()
		.assertThat().statusCode(204).log().all();
	}

}
