package ddt;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FetchingDataFromProperty {

public static void main(String[] args) throws IOException 
{
	
	FileInputStream fis = new FileInputStream("./src/test/resources/Property.properties");
	Properties prop = new Properties();
	prop.load(fis);
	// colon , Equals, space are three seperators we can use in property file
	// Key should be unique in property file
	System.out.println(prop.getProperty("url"));
	System.out.println(prop.getProperty("phonenumber"));
	System.out.println(prop.getProperty("name"));
	WebDriver driver = new ChromeDriver();
	driver.get(prop.getProperty("url"));
	

}
}	