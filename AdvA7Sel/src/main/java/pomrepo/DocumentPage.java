package pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocumentPage {
	
	public DocumentPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(xpath = "//a[text()='Documents']")
	private WebElement documentLink;

	public WebElement getdocumentLink() {
		return documentLink;
	}

}

