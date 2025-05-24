package vtiger_Webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatenewOrganizationPage {
	WebDriver driver;

	public CreatenewOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="accountname")
	private WebElement orgnameEdit;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	
	@FindBy(name="industry")
	private WebElement industrydd;
	

	public WebElement getOrgnameEdit() {
		return orgnameEdit;
	}

	public WebElement getsavebtn() {
		return savebtn;
	}
	

	
	public void createorg(String orgname)
	{
		orgnameEdit.sendKeys(orgname);
		savebtn.click();
	}
	
	public void createorg(String orgname,String industry)
	{
		orgnameEdit.sendKeys(orgname);
		Select sel=new Select(industrydd);
		sel.selectByVisibleText(industry);
		savebtn.click();
	}
	

}
