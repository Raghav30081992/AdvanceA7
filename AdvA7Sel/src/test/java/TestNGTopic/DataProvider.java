package TestNGTopic;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class DataProvider {
	
	@org.testng.annotations.DataProvider
	public String[][] getData() {
	
	String[][] data = new String[2][3];
	
	data[0][0]="Raghav";
			    data[0][1]="Maheshwari";
                data[0][2]="1234567890";;
                
                data[1][0]="Raghav1";
                data[1][1]="Maheshwari1";
                data[1][2]="1234567891";
                return data ;}
                
                @Test(dataProvider="getData")
                public void details(String name, String lastname, String phoneno) 
                {
                	Reporter.log(name,true);
                	Reporter.log(lastname,true);
                	Reporter.log(phoneno,true);
                }
	
	
}


