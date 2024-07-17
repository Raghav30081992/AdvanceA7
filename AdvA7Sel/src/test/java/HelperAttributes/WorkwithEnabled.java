package HelperAttributes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class WorkwithEnabled {
	/**
	 * If enabled is set to false, the test case will not run.
	 */
	
	@Test ( enabled=false)
	public void Launch() throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		Thread.sleep(2000);
		driver.quit();
	}
	
	@Test 
	public void Logout() throws InterruptedException
	{
	  Reporter.log("Logout",true);
	}
	
	

}
