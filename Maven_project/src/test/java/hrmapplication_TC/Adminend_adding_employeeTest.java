package hrmapplication_TC;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Adminend_adding_employeeTest {
	@Test
	public void addingemployee() throws Exception {
		FileInputStream fis = new FileInputStream("./Property/Employeelogin.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String Admin = prop.getProperty("USERNAME");
		String Password = prop.getProperty("PASSWORD");

		String url = prop.getProperty("URL");

		String browser = prop.getProperty("BROWSER");
		WebDriver driver = null;
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}

		driver.get(url);
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// 1.identify webelement-dropdown
		driver.findElement(By.xpath("//a[text()='Admin Login']")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(Admin);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(Password);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='signin']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Employees']")).click();
		driver.findElement(By.linkText("Add Employee")).click();

		FileInputStream fis1 = new FileInputStream("./Excell/HRM_ADDING_EMPLOYEES.xlsx");

		// create workbook where the testdata is stored
		Workbook workbook = WorkbookFactory.create(fis1);

		// Access the sheet where the testdata is present
		Sheet sheet = workbook.getSheet("NEW_EMPLOYEES");
		String empid = sheet.getRow(1).getCell(1).toString();
		String firstname = sheet.getRow(1).getCell(2).toString();
		String lastname = sheet.getRow(1).getCell(3).toString();
		String email = sheet.getRow(1).getCell(4).toString();
		String password = sheet.getRow(1).getCell(5).toString();
		String confirmpassword = sheet.getRow(1).getCell(6).toString();
		String mobile = sheet.getRow(1).getCell(7).toString();
		String address = sheet.getRow(1).getCell(8).toString();
		String city = sheet.getRow(1).getCell(9).toString();
		String country = sheet.getRow(1).getCell(10).toString();
		

		workbook.close();
		
		driver.findElement(By.name("empcode")).sendKeys(empid);
		driver.findElement(By.id("firstName")).sendKeys(firstname);
		driver.findElement(By.id("lastName")).sendKeys(lastname);
		driver.findElement(By.name("email")).sendKeys(email);

		driver.findElement(By.name("password")).sendKeys(password);

		driver.findElement(By.name("confirmpassword")).sendKeys(confirmpassword);
		driver.findElement(By.name("mobileno")).sendKeys(mobile);
		driver.findElement(By.name("address")).sendKeys(address);
		driver.findElement(By.name("city")).sendKeys(city);
		driver.findElement(By.name("country")).sendKeys(country);

		WebElement add = driver.findElement(By.id("add"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", add);
	}
}