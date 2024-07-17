package Hardcode;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import genericlib.ExcelUtil;
import genericlib.WebDriverUtil;

public class Script5 {
	public static void main(String[] args) throws IOException, InterruptedException {
		
	
        WebDriver driver = new ChromeDriver();
        ExcelUtil eu = new ExcelUtil();
        WebDriverUtil d = new WebDriverUtil();
        driver.get(eu.getDataFromPropertyFile("URL"));
		Thread.sleep(2000);
		driver.findElement(By.name("user_name")).sendKeys(eu.getDataFromPropertyFile("username"));
		 Thread.sleep(2000);
		 driver.findElement(By.name("user_password")).sendKeys(eu.getDataFromPropertyFile("password"));
		 Thread.sleep(2000);
		 driver.findElement(By.id("submitButton")).click();
		 Thread.sleep(2000);
		 
		 driver.quit();
        
        
        	

}
}