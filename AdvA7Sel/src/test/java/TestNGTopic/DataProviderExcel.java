package TestNGTopic;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericlib.ExcelUtil;
import pomrepo.LoginPage;
import pomrepo.OrganisationPage;


public class DataProviderExcel {
	

		@DataProvider
		public String[][] testData() throws  IOException
		{
			FileInputStream fis= new FileInputStream("./src/test/resources/TestData.xlsx");
			 Workbook wb = WorkbookFactory.create(fis);
			  Sheet sheet = wb.getSheet("Sheet7");
			 int rowNum = sheet.getPhysicalNumberOfRows();
			 int colNum = sheet.getRow(0).getPhysicalNumberOfCells();
			 String[][] data= new String[rowNum][colNum];
			 for(int i=0;i<rowNum;i++) {
				 for(int j=0;j<colNum;j++) {
					 data[i][j]= sheet.getRow(i).getCell(j).toString();
				 }
			 }
			 return data;
		}
		
		@Test(dataProvider = "testData")
		public void details(String[] testData) throws IOException, InterruptedException {
			WebDriver  driver= new ChromeDriver();
			ExcelUtil um= new ExcelUtil();
			driver.get(um.getDataFromPropertyFile("URL"));
			LoginPage lp= new LoginPage(driver);
			lp.getUserTxtBox().sendKeys(um.getDataFromPropertyFile("username"));
			lp.getPswdTxtBox().sendKeys(um.getDataFromPropertyFile("password"));
			lp.getLoginButton().click();
			OrganisationPage op= new OrganisationPage(driver);
			
			op.getOrganisationLink().click();
			op.getCreateOrganisation().click();
			op.getNameTxtBox().sendKeys(testData[0]);
			Thread.sleep(2000);
			op.getPhoneTxtBox().sendKeys(testData[1]);
			Thread.sleep(2000);
			op.getEmailTxtBox().sendKeys(testData[2]);
		}
	

    }


