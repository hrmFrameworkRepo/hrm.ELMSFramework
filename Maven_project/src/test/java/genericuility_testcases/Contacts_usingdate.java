package genericuility_testcases;

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

public class Contacts_usingdate {
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
		String lastname = sh.getRow(4).getCell(2).toString();
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
		//navigate to the organisation module
		driver.findElement(By.linkText("Contacts")).click();
		//step 3 click on create oragnisation buton
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		//enter the details and create new organisation
		Date date = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		String currentdate = sim.format(date);
		
		Calendar cal=sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,30);
		String enddate=sim.format(cal.getTime());
		
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		driver.findElement(By.name("support_start_date")).clear();
		driver.findElement(By.name("support_start_date")).sendKeys(currentdate);
		driver.findElement(By.name("support_end_date")).clear();
		driver.findElement(By.name("support_end_date")).sendKeys(enddate);

	}
}
