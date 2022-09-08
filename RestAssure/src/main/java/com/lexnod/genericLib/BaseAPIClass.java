package com.lexnod.genericLib;

import org.testng.annotations.AfterSuite;
import static io.restassured.RestAssured.*;
import org.testng.annotations.BeforeSuite;

public class BaseAPIClass {
	
	public DataBaseLibrary dLib = new DataBaseLibrary();
	public JavaUtility jLib = new JavaUtility();
	public RestAssuredLibrary rLib= new RestAssuredLibrary();

	@BeforeSuite
	public void bsConfig()
	{
		dLib.connectToDatabase("projects");
		baseURI="http://localhost";
		port=8084;
	}

	@AfterSuite
	public void asConfig()
	{
		dLib.closeBatabase();
		System.out.println("Data base closed");
	}
}
