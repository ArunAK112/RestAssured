package pathParameter;
import static io.restassured.RestAssured.*;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.lexnod.genericLib.JavaUtility;

import io.restassured.http.ContentType;
import pojoClass.Project;

public class PutProject {
	@Test
	public void updateProject()
	{
		JavaUtility jlib = new JavaUtility();
		Project proj = new Project("ArunK", "AK Project"+jlib.getRandonNumber(100), "Created", 40);
		
		baseURI="http://localhost";
		port=8084;
		
		given()
		.body(proj)
		.contentType(ContentType.JSON)
		.pathParam("pathID","TY_PROJ_1204" )
		.when()
		.put("/projects/{pathID}")
		.then().assertThat().contentType(ContentType.JSON).statusCode(200).time(Matchers.lessThan(2000L)).log().all();
	}

}
