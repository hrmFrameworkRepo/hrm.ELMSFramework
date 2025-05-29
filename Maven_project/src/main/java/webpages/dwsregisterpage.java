package webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class dwsregisterpage {
	//constructor
		public dwsregisterpage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		//Webelements
		
		@FindBy(id="gender-male")
		WebElement gender;
		@FindBy(id="FirstName")
		WebElement firstname;
		@FindBy(id="LastName")
		WebElement lastname;
		@FindBy(id="Email")
		WebElement email;
		@FindBy(id="Password")
		WebElement password;
		@FindBy(id="ConfirmPassword")
		WebElement confirmpassword;
		@FindBy(id="register-button")
		WebElement registerbutton;
		//actions or methods of webelements
		public void clickgender() {
			gender.click();
		}
		public void enterfirstname(String value) {
			firstname.sendKeys(value);
		}
		public void enterlastname(String value) {
			lastname.sendKeys(value);
		}
		public void enteremail(String value) {
			email.sendKeys(value);
		}
		public void enterpassword(String value) {
			password.sendKeys(value);
		}
		public void enterconfirmpassword(String value) {
			confirmpassword.sendKeys(value);
		}
		public void clickregisterbutton() {
			registerbutton.click();
		}
		
}
