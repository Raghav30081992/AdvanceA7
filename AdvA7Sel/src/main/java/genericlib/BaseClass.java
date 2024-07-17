package genericlib;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import pomrepo.LoginPage;

@Listeners(ListnersImplementation.class)
public class BaseClass {
	
	public static WebDriver driver;// driver is static here so u can't run parallel execution but if you remove static on test case fail screenshot will not capture
	public static ExcelUtil eu = new ExcelUtil();
	public static WebDriverUtil  wdu = new WebDriverUtil();
	public static JavaUtil jv = new JavaUtil();
	public LoginPage lp ;
	public static ExtentSparkReporter reporter;
	public static  ExtentReports reports;
	public static  ExtentTest test;
	
	@BeforeSuite (alwaysRun= true)
	public void beforeSuite()
	{
		Reporter.log("Reporte generation started",true);
		
		reporter = new ExtentSparkReporter(IConstant.reportPath);
		reports = new ExtentReports();
		reports.attachReporter(reporter);
	}
	
	@Parameters("browser")
	@BeforeClass (alwaysRun= true)
	public void beforeClass(@Optional("chrome") String bname) throws IOException, InterruptedException
	{
		if(bname.equalsIgnoreCase("chrome")) {driver=new ChromeDriver();}
		else if(bname.equalsIgnoreCase("firefox")) {driver=new FirefoxDriver();}
	
	Thread.sleep(2000);
	wdu.maximizeWindow(driver);
	//test.log(Status.INFO, "Window is maximized");
	wdu.ImplicitWait(driver);
	driver.get(eu.getDataFromPropertyFile("URL"));
	//test.log(Status.INFO, "Opening the URL");
	
	}
	
	@BeforeMethod (alwaysRun= true)
	public void beforeMethod(Method method) throws IOException {
		//test= reports.createTest(method.getName());
	    lp = new LoginPage(driver);
		lp.getUserTxtBox().sendKeys(eu.getDataFromPropertyFile("username"));
		lp.getPswdTxtBox().sendKeys(eu.getDataFromPropertyFile("password"));
		lp.getLoginButton().click();
	}
	
	
	  @AfterMethod (alwaysRun= true)
	  public void afterMethod() { lp.getAdminButton().click();
	  lp.getSignoutButton().click(); }
	 
	
	
	 @AfterClass  (alwaysRun= true)
	 public void afterClass()
	 
	 { wdu.CloseBrowser(driver); } 
	 
	
	@AfterSuite(alwaysRun= true)
	public void afterSuite() {
		Reporter.log("Report",true);
		reports.flush();

}}
