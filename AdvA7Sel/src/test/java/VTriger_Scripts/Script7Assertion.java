package VTriger_Scripts;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import genericlib.BaseClass;
import pomrepo.OrganisationPage;

public class Script7Assertion extends BaseClass{
	   @Test(groups = "organisation")
		public void Script7Assertion() throws EncryptedDocumentException, IOException, InterruptedException {
			OrganisationPage op= new pomrepo.OrganisationPage(driver);
			Thread.sleep(2000);
			op.getOrganisationLink().click();
			assertEquals(driver.getTitle(), "Administrator - Organizations - vtiger CRM 5 - Commercial Open Source CRM","Actual & expected condition not matching");
			op.getCreateOrganisation().click();
			assertEquals(op.getCreateOrgTxt().isDisplayed(), true,"not displayed the text");
			int ranNum = jv.getRandomNo();
			String data = eu.getDataFromExcel("Sheet2", 0, 0)+ranNum;
			WebElement ele = op.getNameTxtBox();
			ele.sendKeys(eu.getDataFromExcel("Sheet2", 0, 0)+ranNum);
			assertEquals(ele.getAttribute("value"), data,"data are not matching");
			op.getSaveButton().click();
			assertEquals(driver.getTitle(), "Administrator - Organizations - vtiger CRM 5 - Commercial Open Source CRM","not matching");
			Thread.sleep(2000);
		}
	}


