package vtiger_Webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationsPage {
	WebDriver driver;

	public OrganisationsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createnewOrgbtn;
	
	@FindBy(name="search_text")
	private WebElement searchedit;
	
	@FindBy(name="search_field")
	private WebElement searchdd;
	
	@FindBy(name="submit")
	private WebElement searchbtn;

	public WebElement getSearchbtn() {
		return searchbtn;
	}

	public WebElement getSearchedit() {
		return searchedit;
	}

	public WebElement getSearchdd() {
		return searchdd;
	}

	public WebElement getCreatenewOrgbtn() {
		return createnewOrgbtn;
	}

	

}
