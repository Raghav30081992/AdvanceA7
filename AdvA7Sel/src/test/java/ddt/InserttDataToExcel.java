package ddt;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class InserttDataToExcel {
	public static void main (String[] args) throws EncryptedDocumentException, IOException
	{
	FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	//XSSFWorkbook wb = new XSSFWorkbook(fis);

	FileOutputStream fos = new FileOutputStream("./src/test/resources/TestData.xlsx");
	wb.getSheet("Sheet2").createRow(1).createCell(0).setCellValue("Test");
	
	wb.getSheet("Sheet2").createRow(2).createCell(2).setCellValue("https://demoblaze.com/");
	wb.getSheet("Sheet2").createRow(2).createCell(3).setCellValue("test");
	
	wb.write(fos);
	wb.close();
	System.out.println("Data Inserted Successfully");
	
	

	
	}
}
