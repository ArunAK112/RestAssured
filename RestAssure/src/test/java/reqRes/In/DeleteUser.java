package reqRes.In;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
public class DeleteUser {
	
	@Test
	public void deleteUser()
	{
		when()
		.delete("https://reqres.in/api/users/2")
		.then()
		.assertThat().statusCode(204).time(Matchers.lessThan(3000L)).log().all();
	}

}
