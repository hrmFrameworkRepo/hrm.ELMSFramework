package dws_testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import webpages.Dwsloginpage;
import webpages.dwshomepage;

public class dws_LoginTest {

	@Test
	public void TC3() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// navigate to the link
		driver.get("https://demowebshop.tricentis.com/");
		// create an object of homepage and call the methods
		dwshomepage homepage = new dwshomepage(driver);
		homepage.clickloginlink();
		Dwsloginpage loginpage = new Dwsloginpage(driver);
		loginpage.enteremail("asxcd@gmail.com");
		loginpage.enterpassword("password");
		loginpage.login();
		driver.close();

	}
}
