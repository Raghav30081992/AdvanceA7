package code;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import genericlib.ExcelUtil;
import genericlib.WebDriverUtil;
import pomrepo.LoginPage;

public class ScriptUsingPOM {

	public static void main(String[] args) throws IOException {
		
		
		WebDriver driver = new ChromeDriver();
		ExcelUtil excel = new ExcelUtil();
		WebDriverUtil wbu = new WebDriverUtil();
		LoginPage lp = new LoginPage(driver);
		wbu.maximizeWindow(driver);
		wbu.ImplicitWait(driver);
		driver.get(excel.getDataFromPropertyFile("URL"));	
        lp.getUserTxtBox().sendKeys(excel.getDataFromPropertyFile("username"));	
        lp.getPswdTxtBox().sendKeys(excel.getDataFromPropertyFile("password"));	
        lp.getLoginButton().click();
        // TODO Auto-generated method stub

	}

}
