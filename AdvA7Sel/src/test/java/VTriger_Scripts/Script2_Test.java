package VTriger_Scripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericlib.BaseClass;
import pomrepo.OrganisationPage;

public class Script2_Test extends BaseClass {
	
	@Test (groups="Organisation")

	public void Script2_Test() throws IOException, InterruptedException
	{
		OrganisationPage obj = new OrganisationPage(driver);
	     obj.getOrganisationLink().click();
	     test.log(Status.INFO, "organsiation link is clicked");
	     obj.getCreateOrganisation().click();
	     int randNo = jv.getRandomNo();
	     obj.getNameTxtBox().sendKeys(eu.getDataFromExcel("Sheet2", 0, 0)+randNo);
	   // Assert.assertEquals(driver.getTitle(),"test","title not matched");
	     obj.getSaveButton().click();
	   
	     Thread.sleep(2000);
	    
		
	}
	

}
