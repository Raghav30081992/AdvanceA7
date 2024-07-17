package HelperAttributes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class WorkwithThreadPoolSize {
	/**
	 * InvocationCount is used to run the same test case multiple times.
	 * ThreadPoolSize is used to run the same test case in multiple threads.
	 * Invocation count should be greater than threadPoolSize.
	 * Invocation count should be used when you use threadpoolSize.
	 * @throws InterruptedException
	 */
	
	@Test (invocationCount = 3, threadPoolSize=3)
	public void Launch() throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		Thread.sleep(2000);
		driver.quit();
	}
	
	

}
