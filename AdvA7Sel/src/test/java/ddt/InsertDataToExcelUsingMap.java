package ddt;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class InsertDataToExcelUsingMap {
	public static void main (String[] args) throws EncryptedDocumentException, IOException
	{
	FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	
    Sheet sheet = wb.getSheet("Sheet6");

	LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
	
	map.put("raghav1", "Maheshwari1");
	map.put("raghav2", "Maheshwari2");
	map.put("raghav3", "Maheshwari3");
	map.put("raghav4", "Maheshwari4");
	
	int rowno =0 ;
	
	for (Entry<String, String> entry : map.entrySet())
	{
      Row row = sheet.createRow(rowno++);
      row.createCell(0).setCellValue((String)entry.getKey()) ;
      row.createCell(1).setCellValue((String)entry.getValue()) ;
      
	}
	
	FileOutputStream fos = new FileOutputStream("./src/test/resources/TestData.xlsx");
	wb.write(fos);
	wb.close();
	System.out.println("Data Inserted");
	
	
	}
}
