package vtiger_Webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.genericwebdriverutility.Webdriverutility;
/**
 * @author KTM
 * Contains Login page elements and business libraries like login(
 */
public class LoginPage extends Webdriverutility {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "user_name")
	private WebElement Username;

	@FindBy(name = "user_password")
	private WebElement Password;

	@FindBy(id = "submitButton")
	private WebElement Loginbtn;

	public WebElement getUsername() {
		return Username;
	}

	public WebElement getPassword() {
		return Password;
	}

	public WebElement getLoginbtn() {
		return Loginbtn;
	}
/**
 * login to application based on username,password,url arguments
 * @param url
 * @param username
 * @param password
 */
	public void LoginToApp(String url,String username, String password) {
        waitForPagetoLoad(driver);
        driver.get(url);
		Username.sendKeys(username);
		Password.sendKeys(password);
		Loginbtn.click();
	}
	/** login to application based on username,password arguments
	 * 
	 * @param username
	 * @param password
	 */
	public void LoginToApp(String username, String password) {
      //  waitForPagetoLoad(driver);
        
		Username.sendKeys(username);
		Password.sendKeys(password);
		Loginbtn.click();
	}

}
