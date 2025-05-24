package com.crm.Baseclass;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import vtiger_Webpages.LoginPage;

public class Createcontact_usingdate extends Base_class {
	@Test 
	public void testcase1() throws Exception {

		// read common data from property file
		String URL = flib.getdataFromPropertiesFile("URL");

		String USERNAME = flib.getdataFromPropertiesFile("USERNAME");
		String PASSWORD = flib.getdataFromPropertiesFile("PASSWORD");

		wlib.waitForPagetoLoad(driver);
		driver.get(URL);

		LoginPage lp = new LoginPage(driver);
		lp.LoginToApp(USERNAME, PASSWORD);
		String lastname = elib.getdataFromExcel("mobile_brands", 4, 2) + jlib.getRandomNumber();
		
		// navigate to the organisation module
		driver.findElement(By.linkText("Contacts")).click();
		// step 3 click on create oragnisation buton
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

		// enter the details and create new organisation
		Date date = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		String currentdate = sim.format(date);

		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, 30);
		String enddate = sim.format(cal.getTime());

		driver.findElement(By.name("lastname")).sendKeys(lastname);
		driver.findElement(By.name("support_start_date")).clear();
		driver.findElement(By.name("support_start_date")).sendKeys(currentdate);
		driver.findElement(By.name("support_end_date")).clear();
		driver.findElement(By.name("support_end_date")).sendKeys(enddate);
		driver.quit();

	}

}
