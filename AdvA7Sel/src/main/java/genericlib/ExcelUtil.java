package genericlib;

import java.io.FileInputStream;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author Raghav Maheshwari
 *
 */

public class ExcelUtil {
	
	/**
	 * Method to read data from property file.
	 * @param key
	 * @return
	 * @throws IOException
	 */
	
	public String getDataFromPropertyFile(String key) throws IOException{
	FileInputStream fis = new FileInputStream(IConstant.propertyfilepath);
	 
	 Properties prop = new Properties();
	 prop.load(fis);
	 return prop.getProperty(key);
	} 
	
	
	/**
	 * Method to read data from excel.
	 * @param sheetName
	 * @param rowNum
	 * @param ColNum
	 * @return
	 * @throws IOException
	 */
	
	public String getDataFromExcel(String sheetName, int rowNum, int ColNum) throws IOException
	
	{
		Workbook wb = WorkbookFactory.create(new FileInputStream(IConstant.Excelfilepath));
		return wb.getSheet(sheetName).getRow(rowNum).getCell(ColNum).getStringCellValue();
	}
	
	/**
	 * DataFormatter method to read data from excel.
	 * @param sheetName
	 * @param rowNum
	 * @param ColNum
	 * @return
	 * @throws IOException
	 */
	
	public String getDataFromExcelDF(String sheetName, int rowNum, int ColNum) throws IOException
	{
    FileInputStream fis = new FileInputStream(IConstant.Excelfilepath);
	Workbook wb = WorkbookFactory.create(fis);
	Cell data = wb.getSheet(sheetName).getRow(rowNum).getCell(ColNum);
	DataFormatter result= new DataFormatter();
	return result.formatCellValue(data);
	
}
	
	/**
	 * Method that will return current date and time in specified format that can be saved as file name
	 * @return
	 */
	public static String getcurrentDateTime()
	{
	return  LocalDateTime.now().toString().replace(":","_");
		
	}
	}