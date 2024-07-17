package genericlib;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.Status;

/**
 * Connection will be made in Baseclass and Listeners will be implemented here.
 * @author Raghav Maheshwari
 *
 */

public class ListnersImplementation extends BaseClass implements ITestListener {
    
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		Reporter.log("Test case started: " ,true);	
		test = reports.createTest(result.getMethod().getMethodName());
	}

	
	public void onTestSuccess(ITestResult result) {
		Reporter.log("Test case Success: " ,true);
		Reporter.log("Test case success: " + result.getName(), true);
	
	}
   

	public void onTestFailure(ITestResult result) {
		Reporter.log("Test case Failed: "+result.getName() ,true);
		test.log(Status.FAIL, "Test case Failed: " + result.getThrowable());
		TakesScreenshot screenshot = (TakesScreenshot)driver;
				File Source = screenshot.getScreenshotAs(OutputType.FILE);	
				File destination = new File(IConstant.Screenshotpath);
				try {
					FileHandler.copy(Source, destination);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
	}
	
	
	

}
