package ddt;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class InsertIntoPropertyFile {
	public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
		
		Properties prop = new Properties();
		FileOutputStream fos = new FileOutputStream("./src/test/resources/Property.properties");
		prop.setProperty("key3", "test1");
		prop.setProperty("key4", "test2");
		prop.store(fos, "Data is inserted");
		
		//Note it will not append the data, it will overwrite the data
		System.out.println("Values are inserted");

    }	

}
