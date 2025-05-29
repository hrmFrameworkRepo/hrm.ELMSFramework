package webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dwsloginpage {
	public Dwsloginpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//webelements in login page
	@FindBy(id="Email")
	WebElement email;
	@FindBy(id="Password")
	WebElement password;
	@FindBy(xpath="(//input[@type='submit'])[2]")
    WebElement logibutton;
	
	//actions or methods of webelments
	public void enteremail(String value)
	{
		email.sendKeys(value);
	}
	public void enterpassword(String value)
	{
		password.sendKeys(value);
	}
	public void login()
	{
		logibutton.click();
	}
	
}
