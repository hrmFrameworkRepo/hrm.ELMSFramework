package webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class dwshomepage {
	// constructor
	public dwshomepage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Webelements
	@FindBy(id = "small-searchterms")
	WebElement searchtext;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement searchbutton;

	@FindBy(linkText = "Register")
	WebElement registerlink;

	@FindBy(linkText = "Log in")
	WebElement loginlink;

	// actions or methods of webelements
	public void entersearchtext(String value) {
		searchtext.sendKeys(value);
	}

	public void clicksearchbutton() {
		searchbutton.click();
	}

	public void clickregisterlink() {
		registerlink.click();
	}

	public void clickloginlink() {
		loginlink.click();
	}

}