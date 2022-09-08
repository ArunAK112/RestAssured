package crudOperationUsingDataDrivenTesting;

import org.hamcrest.Matchers;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.lexnod.genericLib.ExcelFileLibrary;

import io.restassured.http.ContentType;
import pojoClass.Project;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class PostCreateProjectUsingExcelTest {
	@Test(dataProvider = "data")
	public void createProjec(String createdBy, String projectName, String status, int teamSize)
	{
		baseURI="http://localhost";
		port=8084;
		
		Project proj = new Project(createdBy,projectName,status,teamSize);
		given()
		.body(proj)
		.contentType(ContentType.JSON)
		.when()
		.post("/addProject")
		.then()
		.assertThat().statusCode(201).contentType(ContentType.JSON).time(Matchers.lessThan(2000L)).log().all();
	}
	
	@DataProvider
	public Object[][] data() throws Throwable
	{
		Random random = new Random();
		int randomNumber = random.nextInt(100);
		
		Object[][] obj = new Object[5][4];
		
		ExcelFileLibrary elib = new ExcelFileLibrary();
		
		//to convert anyData to integer use Integer.parseInt();
		
		obj[0][0]=elib.readExcelData("Data", 1, 0);
		obj[0][1]=elib.readExcelData("Data", 1, 1)+randomNumber;
		obj[0][2]=elib.readExcelData("Data", 1, 2);
		obj[0][3]=Integer.parseInt(elib.readExcelData("Data", 1, 3));
		
		obj[1][0]=elib.readExcelData("Data", 2, 0);
		obj[1][1]=elib.readExcelData("Data", 2, 1)+randomNumber;
		obj[1][2]=elib.readExcelData("Data", 2, 2);
		obj[1][3]=Integer.parseInt(elib.readExcelData("Data", 2, 3));
		
		obj[2][0]=elib.readExcelData("Data", 3, 0);
		obj[2][1]=elib.readExcelData("Data", 3, 1)+randomNumber;
		obj[2][2]=elib.readExcelData("Data", 3, 2);
		obj[2][3]=Integer.parseInt(elib.readExcelData("Data", 3, 3));
		
		obj[3][0]=elib.readExcelData("Data", 4, 0);
		obj[3][1]=elib.readExcelData("Data", 4, 1);
		obj[3][2]=elib.readExcelData("Data", 4, 2);
		obj[3][3]=Integer.parseInt(elib.readExcelData("Data", 4, 3));
		
		obj[4][0]=elib.readExcelData("Data", 5, 0);
		obj[4][1]=elib.readExcelData("Data", 5, 1)+randomNumber;
		obj[4][2]=elib.readExcelData("Data", 5, 2);
		obj[4][3]=Integer.parseInt(elib.readExcelData("Data", 5, 3));
		
		return obj;
	}

}
