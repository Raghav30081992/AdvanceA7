package HelperAttributes;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class WorkWithDepends {
	
	/**
	 * dependsOnMethods is used to run the test case only after the test case mentioned in the
	 * @throws InterruptedException
	 * Menthod on which dependency is should have been executed successfully 
	 * priority is used to set the priority of the test case to run first
	 */

	@Test (priority=-1)
	public void Login() throws InterruptedException
	{
	  Reporter.log("Login",true);
	  int i=1/0;
	}

	@Test (priority=1, dependsOnMethods="Login")
	public void Logout() throws InterruptedException
	{
	  Reporter.log("Logout",true);
	}
	

	@Test (priority=0 , dependsOnMethods="Logout")
	public void AddtoCart() throws InterruptedException
	{
	  Reporter.log("AddtoCart",true);
	}
}
