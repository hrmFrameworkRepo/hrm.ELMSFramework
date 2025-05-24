package ContactTest;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.genericfileutility.Fileutility_ExcelVtiger;
import com.crm.genericfileutility.Fileutility_Propertyfilevtiger;
import com.crm.genericwebdriverutility.Javautility;
import com.crm.genericwebdriverutility.Webdriverutility;

import vtiger_Webpages.LoginPage;

public class Createcontact_Test {
	WebDriver driver;

	@Test
	public void creating_contact_Test() throws Exception {
		// creating object for utility files
		Fileutility_Propertyfilevtiger flib = new Fileutility_Propertyfilevtiger();
		Fileutility_ExcelVtiger elib = new Fileutility_ExcelVtiger();
		Javautility jlib = new Javautility();
		Webdriverutility wlib = new Webdriverutility();

		// read common data from property file
		String URL = flib.getdataFromPropertiesFile("URL");
		String browser = flib.getdataFromPropertiesFile("BROWSER");
		String USERNAME = flib.getdataFromPropertiesFile("USERNAME");
		String PASSWORD = flib.getdataFromPropertiesFile("PASSWORD");

		// read testscript data from excel file
		String lastname = elib.getdataFromExcel("mobile_brands", 4, 2) + jlib.getRandomNumber();
		;
		WebDriver driver = null;
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}

//	1. Login to Application

		wlib.waitForPagetoLoad(driver);
		driver.get(URL);

		LoginPage lp = new LoginPage(driver);
		lp.LoginToApp(USERNAME, PASSWORD);

		// navigate to the organisation module
		driver.findElement(By.linkText("Contacts")).click();
		// step 3 click on create oragnisation buton
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		// step 4 enter the details and create new organisation
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		// verify header phone number info expected result
		String actlastname = driver.findElement(By.xpath("//span[@id='dtlview_Last Name']")).getText();
		if (actlastname.equals(lastname)) {
			System.out.println(lastname + "is created and ------->PASS");
		} else {
			System.out.println(lastname + "is  not created and ------->FAIL");
		}
		driver.close();

	}
}
