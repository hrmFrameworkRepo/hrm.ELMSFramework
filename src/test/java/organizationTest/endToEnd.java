package organizationTest;

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

import vtiger_Webpages.CreatenewOrganizationPage;
import vtiger_Webpages.HomePage;
import vtiger_Webpages.LoginPage;
import vtiger_Webpages.OrganisationsPage;
import vtiger_Webpages.OrganizationinfoPage;

public class endToEnd {

	@Test
	public void contact_Test() throws Exception {
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
		String orgname = elib.getdataFromExcel("mobile_brands", 4, 2) + jlib.getRandomNumber();
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

		// 1. Login to Application

		wlib.waitForPagetoLoad(driver);
		driver.get(URL);

		LoginPage lp = new LoginPage(driver);
		lp.LoginToApp(USERNAME, PASSWORD);

		// Step 2 :navigate to organisation module
		HomePage op = new HomePage(driver);
		op.getOrgLink().click();

		// Step 3 : click on "create organization " button
		OrganisationsPage co = new OrganisationsPage(driver);
		co.getCreatenewOrgbtn().click();
		// Step 4 :enter all the details and create new organization

		CreatenewOrganizationPage cnop = new CreatenewOrganizationPage(driver);
		cnop.createorg(orgname);

		// verify header message expected result
		OrganizationinfoPage oip = new OrganizationinfoPage(driver);
		String actorgname = oip.getHeaderMsg().getText();
		try {

			if (actorgname.contains(orgname)) {
				System.out.println(orgname + "name is verified==> PASS");
			} else {
				System.out.println(orgname + "name is  NOT verified==> FAIL");
			}
		} catch (Exception e) {

		}

		// go back to organizations page
		op.getOrgLink().click();
		// search for organization
		co.getSearchedit().sendKeys(orgname);
		wlib.select(co.getSearchdd(), "Organization Name");
		co.getSearchbtn().click();

		// In dynamic webtable select & delete organization
		driver.findElement(By.xpath("//a[text()='" +orgname+ "']/../../td[8]/a[text()='del']")).click();
		wlib.switchToAlertandAccept(driver);
		// step 5 logout

		//  op.logout();

		driver.quit();
	}
}
