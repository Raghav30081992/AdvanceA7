package ddt;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InsertMultipleDataToExcel {
	public static void main (String[] args) throws EncryptedDocumentException, IOException
	{
	FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	//XSSFWorkbook wb = new XSSFWorkbook(fis);

	FileOutputStream fos = new FileOutputStream("./src/test/resources/TestData.xlsx");
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://demowebshop.tricentis.com/");
	List<WebElement> links = driver.findElements(By.xpath("//a"));	
	for (int i = 0; i<links.size(); i++)    
	{
	
	wb.getSheet("Sheet4").createRow(i).createCell(0).setCellValue(links.get(i).getAttribute("href"));
	
	

	}
	wb.write(fos);
	wb.close();
	System.out.println("Data Inserted Successfully");
	}
}
