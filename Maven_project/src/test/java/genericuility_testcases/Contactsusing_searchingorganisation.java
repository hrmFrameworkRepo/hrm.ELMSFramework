package genericuility_testcases;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Contactsusing_searchingorganisation {
	@Test
	public void testcase1() throws Exception {
		FileInputStream fis = new FileInputStream("./Property/Vtiger.properties");
		Properties p = new Properties();
		p.load(fis);

		String browser = p.getProperty("BROWSER");
		String url = p.getProperty("URL");
		String username = p.getProperty("USERNAME");
		String password = p.getProperty("PASSWORD");

		// generate random number
		Random random = new Random();
		int randomint = random.nextInt(1000);

//		Reading Test Script data(Excel Data) from excel file
		FileInputStream fis1 = new FileInputStream("./Excell/Vtiger.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("mobile_brands");
		Row row = sh.getRow(3);
		String orgname = row.getCell(2).toString() + randomint;
		String lastname = row.getCell(2).toString();
		wb.close();

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

//		1. Login to Application
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(url);

		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		// 2. Navigate to Organization Module
		driver.findElement(By.linkText("Organizations")).click();

//		3. Click on Create Organization button
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

//		4. Enter all details and create new organization
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		// verify header phone number info expected result
		String header = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (header.contains(orgname)) {
			System.out.println(orgname + "is created and ------->PASS");
		} else {
			System.out.println(orgname + "is  not created and ------->FAIL");
		}
		// step 5 navigate to the contact module
		driver.findElement(By.linkText("Contacts")).click();
		// step 6
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

		// step 7 enter the details and create new organisation
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
		// switch to child window
		Set<String> set = driver.getWindowHandles();

		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String windowid = it.next();
			driver.switchTo().window(windowid);
			String acturl = driver.getCurrentUrl();
			if (acturl.contains("module=Accounts")) {
				break;
			}

		}

		driver.findElement(By.name("search_text")).sendKeys(orgname);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='" + orgname + "']")).click();

		// switch to parent window
		Set<String> set1 = driver.getWindowHandles();

		Iterator<String> it1 = set1.iterator(); 
		while (it1.hasNext()) {
			String windowid = it1.next();
			driver.switchTo().window(windowid);
			String acturl = driver.getCurrentUrl();
			if (acturl.contains("Contacts&action")) {
				break;
			}

		}
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//verify  header message expected result
		String header1=	driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(header1.contains(orgname))
		{
			System.out.println(orgname + "is created and ------->PASS");
		}
		else {
			System.out.println(orgname + "is  not created and ------->FAIL");
		}
		
		String actorgname=driver.findElement(By.id("mouseArea_Organization Name")).getText();
		if (actorgname.trim().equals(orgname))
		{
			System.out.println(orgname + "information is created==PASS");
		}
		else {
			System.out.println(orgname + "information is not created==FAIL");
		}
		driver.quit();
		

	}
}
