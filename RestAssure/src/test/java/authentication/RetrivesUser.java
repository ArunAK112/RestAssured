package authentication;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class RetrivesUser {
	
	@Test
	public void retrivesUser()
	{
		Response resp = given()
				.formParam("client_id", "AK")
				.formParam("client_secret", "3cf6e8db119b374a738eb3e76c051c23")
				.formParam("grant_type", "client_credentials")
				.formParam("redirect_uri", "https://example.com")
				.formParam("code", "authorization_code") 
				.when()
				.post("http://coop.apps.symfonycasts.com/token");
				
				//getting code from the response
				String tocken = resp.jsonPath().get("access_token");
				System.out.println(tocken);
				given()
				.auth().oauth2(tocken)
				.when()
				.get("http://coop.apps.symfonycasts.com/api/me")
				.then()
				.assertThat().statusCode(200).contentType(ContentType.JSON).time(Matchers.lessThan(2000L)).log().all();
	}

}
