package genericlib;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author Raghav Maheshwari
 *
 */


public class WebDriverUtil {
	/**
	 * Method to maximize the browser window.
	 * @return 
	 * @return
	 */
     WebDriver driver;
	
	public static void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
     * Method to close the browser window.
     * @param driver
     */
	
	public static void moveForward(WebDriver driver)
	{
		driver.navigate().forward();
	}
	/**
	 * Method to move backward in browser window.
	 * @param driver
	 */
	
	public static void moveBackward(WebDriver driver)
	{
		driver.navigate().back();
	}
	
	/**
	 * Method to refresh the browser window.
	 * @param driver
	 */
	
	public static void Refresh(WebDriver driver)
	{
		driver.navigate().refresh();
	}
	
	/**
	 * Implicit wait method with duration of 20 seconds.
	 * @param driver
	 */
	
	
	public void ImplicitWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	
	
	/**
	 * Explicit wait method for element to be clickable.
	 * @param driver
	 * @param element
	 */
	
	public void ElementToBeClickableWait(WebDriver driver , WebElement element)
	{
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	 wait.until(ExpectedConditions.elementToBeClickable(element));	  
	}
	
	/** 
	 * Switch to frame method using WebElement.
	 * @param driver
	 * @param element
	 */
	
	public void SwitchToFrame(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	/**
     * Switch to parent frame from child frame.
     * @param driver
     * @param index
	 */
	public void switchToParentFrame(WebDriver driver)
	{
	driver.switchTo().parentFrame();
	// or driver.switchTo().defaultContent();
    }
	/**
	 * Select dropdown by Value
	 * @param element
	 * @param value
	 */
	
	public void selectDropdownValue(WebElement element, String value)
	{
		Select select = new Select(element);
		select.selectByValue(value);
	}

	/**
	 * Select dropdown by visible text.
	 * @param element
	 * @param visibletext
	 */
	
	public void selectDropdownVisibleText(WebElement element, String visibletext)
	
	{
		Select select = new Select(element);
		select.selectByVisibleText(visibletext);
	}
	
	/**
	 * Accept alert.
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
     * Dismiss alert.
     * @param driver
     */
	
	public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
     * Get Clickable element.
     * @param driver
     * @return
     */
	
	public void clickOnElement(WebElement element)
	{
		Actions action = new Actions(driver);
		action.click(element).perform();
	}
	
	/**
	 * Double click on element.
	 * @param element
	 */
	
	public void doubleclickOnElement(WebElement element)
	{
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
	}
	
	/**
     * Right click on element.
     * @param element
     */
	public void rightclickOnElement(WebElement element)
	{
		Actions action = new Actions(driver);
        action.contextClick(element).perform();
	}
	
	/**
     * Window scroll up using JavascriptExecutor.
     * @param element
     */
	
	public void WindowScrollUp()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-500);");
		
		
	}
	
	/**
     * Window scroll down using JavascriptExecutor.
     * @param element
     */
	
	public void WindowScrolldown()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500);");
		
		
	}
	
	public void CloseBrowser(WebDriver driver)
	{
		driver.quit();
	}
	
	
	
}
