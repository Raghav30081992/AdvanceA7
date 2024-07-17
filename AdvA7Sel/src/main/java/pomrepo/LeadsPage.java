package pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsPage {
	
	public LeadsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(xpath = "//a[text()='Leads']")
	private WebElement leadsLink;

	public WebElement getLeadsLink() {
		return leadsLink;
	}

}

