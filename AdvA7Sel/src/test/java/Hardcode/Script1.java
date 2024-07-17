package Hardcode;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Script1 {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		 FileInputStream fis = new FileInputStream("./src/test/resources/CommonTestData.properties");
		 
		 Properties prop = new Properties();
		 prop.load(fis);
		 
		 String username = prop.getProperty("username");
		 String password = prop.getProperty("password");
		 
		 WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get(prop.getProperty("URL"));
		 Thread.sleep(2000);
		 
		 driver.findElement(By.name("user_name")).sendKeys(username);
		 Thread.sleep(2000);
		 driver.findElement(By.name("user_password")).sendKeys(password);
		 Thread.sleep(2000);
		 driver.findElement(By.id("submitButton")).click();
		 Thread.sleep(2000);
		 
		 driver.quit();
		 

	}

}
