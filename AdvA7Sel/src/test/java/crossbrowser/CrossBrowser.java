package crossbrowser;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import genericlib.ExcelUtil;
import genericlib.WebDriverUtil;

public class CrossBrowser {
	
	WebDriver driver;
	
	WebDriverUtil wdu = new WebDriverUtil();
	ExcelUtil eu = new ExcelUtil();
	
	@Parameters("browser")
	@Test
	public void launchBrowser(String bname) throws IOException {
		
		if(bname.equalsIgnoreCase("chrome")) 
		{
			
			driver = new ChromeDriver();
			driver.get(eu.getDataFromPropertyFile("URL"));
		}
		
		else if(bname.equalsIgnoreCase("Firefox")) 
		{
			
			driver = new FirefoxDriver();
			driver.get(eu.getDataFromPropertyFile("URL"));
		}
	
	}
	

}
