package vtiger_Webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationinfoPage {
	WebDriver driver;

	public OrganizationinfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="dvHeaderText")
	private WebElement headerMsg;

	public WebElement getHeaderMsg() {
		return headerMsg;
	}

}
