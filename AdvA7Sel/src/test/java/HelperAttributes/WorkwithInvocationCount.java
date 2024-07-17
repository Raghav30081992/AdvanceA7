package HelperAttributes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class WorkwithInvocationCount {
	/**
	 * InvocationCount is used to run the same test case multiple times.
	 * @throws InterruptedException
	 */
	
	@Test (invocationCount = 3)
	public void Launch() throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		Thread.sleep(2000);
		driver.quit();
	}
	
	@Test (invocationCount=2)
	public void AddtoCart() throws InterruptedException
	{
	  Reporter.log("AddtoCart",true);
	}

}
