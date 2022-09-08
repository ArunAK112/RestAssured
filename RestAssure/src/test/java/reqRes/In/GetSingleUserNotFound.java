package reqRes.In;

import javax.annotation.meta.When;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetSingleUserNotFound {
	
	@Test
	public void singleUserNotFound()
	{
		when()
		.get("https://reqres.in/api/users/25")
		.then()
		.assertThat().statusCode(404).time(Matchers.lessThan(3000L)).log().all();
	}

}
