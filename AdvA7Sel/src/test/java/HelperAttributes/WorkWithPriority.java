package HelperAttributes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class WorkWithPriority {

	@Test (priority=-1)
	public void Login() throws InterruptedException
	{
	  Reporter.log("Login",true);
	}

	@Test (priority=1)
	public void Logout() throws InterruptedException
	{
	  Reporter.log("Logout",true);
	}
	

	@Test (priority=0)
	public void AddtoCart() throws InterruptedException
	{
	  Reporter.log("AddtoCart",true);
	}
}
