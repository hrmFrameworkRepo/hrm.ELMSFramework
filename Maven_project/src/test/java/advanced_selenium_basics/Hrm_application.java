package advanced_selenium_basics;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class Hrm_application {
	

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
		
		
		FileInputStream fis1=new FileInputStream("./Excell/HRM_adminlogin.xlsx");
		
		// create workbook where the testdata is stored
		Workbook workbook = WorkbookFactory.create(fis1);
		
		// Access the sheet where the testdata is present
		Sheet sheet = workbook.getSheet("AddEmployee");
		
		int rowscount = sheet.getPhysicalNumberOfRows();
		System.out.println(rowscount);
		int colcount = sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println(colcount);
		
		Object[][] data=new Object[rowscount-1][colcount-1];
		
		for(int i=1;i<=rowscount-1;i++)
		{
			for(int j=1;j<=colcount-1;j++)
			{
				
				data[i-1][j-1]=sheet.getRow(i).getCell(j).toString();
				System.out.print(data[i-1][j-1]+" ");
				
				
			}
			System.out.println(" ");
			
		}
		
		
		
		 driver.findElement(By.xpath("//a[text()='Employees']")).click();
		 driver.findElement(By.linkText("Add Employee")).click();
		 //driver.findElement(By.xpath("//label[text()='Employee Code(Must be unique)']")).sendKeys();
		
		 driver.findElement(By.name("empcode")).sendKeys(data[0][0].toString());
		 
		 driver.findElement(By.name("firstName")).sendKeys(data[0][1].toString());
		 
		 driver.findElement(By.name("lastName")).sendKeys(data[0][2].toString());
		 
		 driver.findElement(By.name("email")).sendKeys(data[0][3].toString());
		 
		 driver.findElement(By.name("password")).sendKeys(data[0][4].toString());
		 
		 driver.findElement(By.name("confirmpassword")).sendKeys(data[0][5].toString());
		 driver.findElement(By.name("mobileno")).sendKeys(data[0][6].toString());
		 Thread.sleep(3000);
		 driver.close();
	}
	
	
}


