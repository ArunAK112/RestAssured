package end2End;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.lexnod.genericLib.BaseClass;

public class LoginToAppTest extends BaseClass {
	@Test
	public void login() 
	{
		// launching the browser
		// entering url

		// entering the details in the field
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();

	}

}
