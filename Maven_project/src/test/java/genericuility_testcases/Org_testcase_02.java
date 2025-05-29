package genericuility_testcases;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Org_testcase_02 {
	@Test
	public void testcase1() throws Exception {
		FileInputStream fis = new FileInputStream("./Property/Vtiger.properties");
		Properties p = new Properties();
		p.load(fis);

		String browser = p.getProperty("BROWSER");
		String url = p.getProperty("URL");
		String username = p.getProperty("USERNAME");
		String password = p.getProperty("PASSWORD");

//		Reading Test Script data(Excel Data) from excel file
		FileInputStream fis1 = new FileInputStream("./Excell/Vtiger.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("mobile_brands");
		String orgname = sh.getRow(4).getCell(2).toString();
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

//		2. Navigate to Organization Module
		driver.findElement(By.linkText("Organizations")).click();

//		3. Click on Create Organization button
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

//		4. Enter all details and create new organization
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		WebElement ele1 = driver.findElement(By.name("industry"));

		Select dd1 = new Select(ele1);
		dd1.selectByValue("Chemicals");
		WebElement ele2 = driver.findElement(By.name("accounttype"));

		Select dd2 = new Select(ele2);
		dd2.selectByVisibleText("Analyst");
		

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		// verify header message expected result
		String header = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (header.contains(orgname)) {
			System.out.println(orgname + "is created and ------->PASS");
		} else {
			System.out.println(orgname + "is  not created and ------->FAIL");
		}
		// verify the organisation name
		String actualorgname = driver.findElement(By.id("dtlview_Organization Name")).getText();
		if (actualorgname.equals(orgname)) {
			System.out.println(orgname + "is created and ------->PASS");
		} else {
			System.out.println(orgname + "is  not created and ------->FAIL");
		}
//		5. Logout from application
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		driver.findElement(By.linkText("Sign Out")).click();

		driver.close();
	}
}
