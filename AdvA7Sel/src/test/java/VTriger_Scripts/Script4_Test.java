package VTriger_Scripts;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericlib.BaseClass;
import pomrepo.ContactPage;
import pomrepo.OrganisationPage;

public class Script4_Test extends BaseClass 
{
	
	@Test (groups="Organisation")
	public void Script4_Test() throws IOException, InterruptedException
	{
		
		ContactPage contactobj = new ContactPage(driver);
		contactobj.getContactLink().click();
		contactobj.getCreateContactButton().click();
		int ranNo = jv.getRandomNo();
		contactobj.getLastnameTxtBox().sendKeys(eu.getDataFromExcel("Sheet2", 0, 0)+ranNo);
		
		  contactobj.getSelectorganisation().click(); 
			/*
			 * Select select = new Select (contactobj.getSearch_dropdown());
			 * select.selectByVisibleText("Organization Name");
			 */
		 
		
		String parentid = driver.getWindowHandle();
		 
		 Set<String> allid = driver.getWindowHandles();
		 allid.remove(parentid);
		 
		 for(String childid : allid)
			 
		 {   
			 
			 driver.switchTo().window(childid);
			
			 Select sel = new Select(contactobj.getSearch_dropdown());
			 sel.selectByVisibleText("Organization Name");
			 driver.findElement(By.xpath("//a[text()='nike34']")).click();
		 }
		 
	     Thread.sleep(2000);
	     driver.switchTo().window(parentid);
	     Thread.sleep(2000);

		contactobj.getSaveButton().click();
		
		
	}
	
	

}
