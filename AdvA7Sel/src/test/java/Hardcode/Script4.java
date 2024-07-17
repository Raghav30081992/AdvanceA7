package Hardcode;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class Script4 {

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
		 
		 FileInputStream fis2 = new FileInputStream("./src/test/resources/VTiger.xlsx");
		 
	     Workbook wb = WorkbookFactory.create(fis2);
	     
	     driver.findElement(By.linkText("Contacts")).click();
	     driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	     String lastname =   wb.getSheet("Sheet2").getRow(0).getCell(0).getStringCellValue();
	     Random rand = new Random();
	     int num = rand.nextInt(100);
	     String data = lastname + num ;
	     driver.findElement(By.name("lastname")).sendKeys(data);
	    
	     Thread.sleep(2000);
	     driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
	   
		 String parentid = driver.getWindowHandle();
		 
		 Set<String> allid = driver.getWindowHandles();
		 allid.remove(parentid);
		 
		 for(String childid : allid)
			 
		 {
			 driver.switchTo().window(childid);
			 Select sel = new Select(driver.findElement(By.name("search_field")));
			 sel.selectByVisibleText("Organization Name");
			 driver.findElement(By.xpath("//a[text()='nike34']")).click();
		 }
	     Thread.sleep(2000);
	     driver.switchTo().window(parentid);
	     driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	     Thread.sleep(3000);
	     driver.close();
	     

		 

	}

}
