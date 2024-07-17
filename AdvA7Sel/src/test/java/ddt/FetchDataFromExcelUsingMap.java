package ddt;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FetchDataFromExcelUsingMap {
	public static void main (String[] args) throws EncryptedDocumentException, IOException
	{
	FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	
	int row = wb.getSheet("Sheet5").getLastRowNum();

	System.out.println(row);
	LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
	
	for(int i = 0; i<=row; i++)
	{
	 String Key = wb.getSheet("Sheet5").getRow(i).getCell(0).getStringCellValue();
	 String Value = wb.getSheet("Sheet5").getRow(i).getCell(1).getStringCellValue();
	 map.put(Key, Value);
	}
	
	for (Entry<String, String> entry : map.entrySet())
	{
		System.out.println(entry.getKey() + "	:" + entry.getValue());
	}
	
	
	
	}
}
