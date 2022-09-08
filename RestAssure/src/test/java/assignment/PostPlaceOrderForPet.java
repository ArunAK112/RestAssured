package assignment;
import static io.restassured.RestAssured.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.lexnod.genericLib.ExcelFileLibrary;

import io.restassured.http.ContentType;
import pojoClass.PetPojoClass;

public class PostPlaceOrderForPet {
	@Test(dataProvider = "dataDriven")
	public void placeOrder(String id, String petId, String quantity, String shipDate, String status, String complete)
	{
		baseURI="https://petstore.swagger.io/v2";
		
		PetPojoClass pet = new PetPojoClass(id, petId, quantity, shipDate, status, complete);
		
		given()
		.body(pet)
		.contentType(ContentType.JSON)
		.when()
		.post("/store/order")
		.then()
		.assertThat().statusCode(200).contentType(ContentType.JSON).log().all();
	}
	
	@DataProvider
	public Object[][] dataDriven() throws Throwable
	{
		ExcelFileLibrary elib = new ExcelFileLibrary();
		Object[][] obj = new Object[5][6];
		
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<6;j++)
			{
				obj[i][j]=elib.readExcelData("Pet", i+1, j);
			}
		}
		
		return obj;
	}

}
