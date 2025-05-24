package com.crm.Baseclass;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.genericdatabaseutility.Databaseutility;
import com.crm.genericfileutility.Fileutility_ExcelVtiger;
import com.crm.genericfileutility.Fileutility_Propertyfilevtiger;
import com.crm.genericwebdriverutility.Javautility;
import com.crm.genericwebdriverutility.Utilityclass_object;
import com.crm.genericwebdriverutility.Webdriverutility;

import vtiger_Webpages.HomePage;
import vtiger_Webpages.LoginPage;

public class Base_class {
	WebDriver driver = null;
	
	// creating object for utility files
	Fileutility_Propertyfilevtiger flib = new Fileutility_Propertyfilevtiger();
	Fileutility_ExcelVtiger elib = new Fileutility_ExcelVtiger();
	Javautility jlib = new Javautility();
	Webdriverutility wlib = new Webdriverutility();
	Databaseutility dlib = new Databaseutility();
	public static WebDriver sdriver = null;
	


	@BeforeSuite
	public void config_BS() throws SQLException {
		System.out.println("connect to database");
		dlib.getDbconnection();
	}
	// @Parameters("BROWSER")
	@BeforeClass
	public void config_BC(String browser) throws Exception {
		System.out.println("launch the browser");
		String BROWSER = flib.getdataFromPropertiesFile("browser");
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}
		sdriver=driver;
		Utilityclass_object.setDriver(driver);
	}

	@BeforeMethod
	public void config_BM() throws Exception {
		System.out.println("login");
		String URL = flib.getdataFromPropertiesFile("URL");
		String USERNAME = flib.getdataFromPropertiesFile("USERNAME");
		String PASSWORD = flib.getdataFromPropertiesFile("PASSWORD");
		LoginPage lp = new LoginPage(driver);
		lp.LoginToApp(URL, USERNAME, PASSWORD);

	}

	@AfterMethod
	public void config_AM() {
		System.out.println("logout");
		HomePage hp = new HomePage(driver);
		hp.logout();
	}

	@AfterClass
	public void config_AC() {
		System.out.println("Close the browser");
		driver.quit();

	}

	@AfterSuite
	public void config_AS() {
		System.out.println("close the database");
		dlib.closeDbconnection();
		
	}

}
