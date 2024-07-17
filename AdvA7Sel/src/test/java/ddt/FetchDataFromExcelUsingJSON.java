package ddt;


import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

public class FetchDataFromExcelUsingJSON {
	public static void main (String[] args) throws EncryptedDocumentException, IOException
	{
	
	File file = new File("./src/test/resources/jsonData.json");
	ObjectMapper json = new ObjectMapper();
	JsonNode data = json.readTree(file);
	
	System.out.println(data.get("url").asText());
	
	
	}
}
