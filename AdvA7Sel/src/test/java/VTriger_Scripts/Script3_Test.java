package VTriger_Scripts;

import java.io.IOException;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericlib.BaseClass;
import pomrepo.OrganisationPage;

public class Script3_Test extends BaseClass {
	
	@Test
	public void Script3_Test() throws IOException, InterruptedException
	{
		OrganisationPage obj = new OrganisationPage(driver);
	     obj.getOrganisationLink().click();
	     test.log(Status.INFO, "Organisation link is clicked");
	     obj.getCreateOrganisation().click();
	     test.log(Status.INFO, "Create new Organisation icon is clicked");
	     
	     int randNo = jv.getRandomNo();
	     obj.getNameTxtBox().sendKeys(eu.getDataFromExcel("Sheet2", 0, 0)+randNo);
	     test.log(Status.INFO, "organsiation name is entered");
	     Select select = new Select(obj.getIndustryDropdown());
	     select.selectByVisibleText("Healthcare");
	     obj.getSaveButton().click();
	     Thread.sleep(2000);
	    
		
	}
	

}
