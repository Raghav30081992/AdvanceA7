package ddt;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadMultipleDataFromExcel {
	public static void main (String[] args) throws EncryptedDocumentException, IOException
	{
	FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	//XSSFWorkbook wb = new XSSFWorkbook(fis);

    Sheet sheet = wb.getSheet("Sheet3");
    int rowCount = sheet.getPhysicalNumberOfRows();
    int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
	
	DataFormatter datas = new DataFormatter();
	
	for(int i = 0; i<rowCount; i++)	
	{
		for (int j=0; j<colCount; j++)    
		{
            Cell cell = sheet.getRow(i).getCell(j);
            System.out.println(datas.formatCellValue(cell));
            
        }
	}
	


	
	}
}
