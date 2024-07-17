package ddt;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcelUse {
	public static void main (String[] args) throws EncryptedDocumentException, IOException
	{
	FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	//XSSFWorkbook wb = new XSSFWorkbook(fis);

	System.out.println(wb.getSheet("Sheet1").getRow(0).getCell(0).getStringCellValue());
	System.out.println(wb.getSheet("Sheet1").getRow(2).getCell(1).getNumericCellValue());
	System.out.println(wb.getSheet("Sheet1").getRow(2).getCell(2).getBooleanCellValue());
	
	//to avoid mentioning which type of value we  want to find
	
	
	Cell cell1 = wb.getSheet("Sheet2").getRow(0).getCell(0);
	Cell cell2 = wb.getSheet("Sheet2").getRow(2).getCell(1);
	Cell cell3 = wb.getSheet("Sheet2").getRow(2).getCell(2);
	
	DataFormatter data = new DataFormatter();
	System.out.println(data.formatCellValue(cell1));
	System.out.println(data.formatCellValue(cell2));
	System.out.println(data.formatCellValue(cell3));

	
	}
}
