package genericuility_testcases;


	

	import org.openqa.selenium.interactions.Actions;

	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.text.SimpleDateFormat;
	import java.time.Duration;
	import java.util.Calendar;
	import java.util.Date;
	import java.util.Properties;
	import java.util.Random;
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
	import org.openqa.selenium.interactions.Actions;

	public class Contacts_supportdate {

		public static void main(String[] args) throws Exception {
			//Fetching the common data from the property file
			FileInputStream fis=new FileInputStream("C:\\Users\\Administrator\\Desktop\\commondata.properties");
			Properties prop= new Properties();
			prop.load(fis);
			String Browser=	prop.getProperty("browser");
			String Url=prop.getProperty("url");
			String Username=prop.getProperty("username");
			String Password=prop.getProperty("password");

			//creating Random Number
			Random ran=new Random();
			int ran_Num = ran.nextInt();

			//Fetching the testScript data
			FileInputStream fis1=new FileInputStream("C:\\Users\\Administrator\\Desktop\\TestScriptdata.xlsx");
			Workbook wb=WorkbookFactory.create(fis1);
			Sheet sh = wb.getSheet("contact");
			Row row = sh.getRow(1);
			String lastName = row.getCell(2).toString()+ran_Num;
			System.out.println(lastName);
			wb.close();

			//Achieving polymorphism because during runtime we can able to select the particular browser
			WebDriver driver=null;
			if(Browser.equals("chrome")) {
				driver= new ChromeDriver();
			}
			else if (Browser.equals("firefox")) {
				driver=new FirefoxDriver();
			}
			else if (Browser.equals("edge")) {
				driver=new EdgeDriver();
			}
			else {
				driver=new ChromeDriver();
			}

			//Actual Script Creating Orgnasation
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			driver.get(Url);
			driver.findElement(By.name("user_name")).sendKeys(Username);
			driver.findElement(By.name("user_password")).sendKeys(Password);
			driver.findElement(By.id("submitButton")).click();

			driver.findElement(By.linkText("Contacts")).click();
			driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();
			driver.findElement(By.name("lastname")).sendKeys(lastName);

			Date dateObj=new Date();

			SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
			String startDate = sim.format(dateObj);
			
			Calendar calender = sim.getCalendar();
			calender.add(calender.DAY_OF_MONTH,30);
			String afterDate = sim.format(calender.getTime());
			//with support date
			driver.findElement(By.name("support_start_date")).clear();
			driver.findElement(By.name("support_start_date")).sendKeys(startDate);
			driver.findElement(By.name("support_end_date")).clear();
			driver.findElement(By.name("support_end_date")).sendKeys(afterDate);

			driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();


			//Verying Header Message Expected Result with the Actual Result

			String actualLastName = driver.findElement(By.id("dtlview_Last Name")).getText();

			if(actualLastName.equals(lastName)) {
				System.out.println(lastName + " is entered===PASS");
			}
			else {
				System.out.println(lastName + " is not entered===FAIL");
			}
			String ActstartDate = driver.findElement(By.id("dtlview_Support Start Date")).getText();

			if(ActstartDate.equals(startDate)) {
				System.out.println(startDate + " is entered===PASS");
			}
			else {
				System.out.println(startDate + " is not entered===FAIL");
			}
			String ActendDate = driver.findElement(By.id("dtlview_Support End Date")).getText();

			if(ActendDate.equals(afterDate)) {
				System.out.println(afterDate + " is entered===PASS");
			}
			else {
				System.out.println(afterDate + " is not entered===FAIL");
			}
			Actions act=new Actions(driver);
			WebElement adminImg = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
			act.moveToElement(adminImg).click().perform();
			driver.findElement(By.partialLinkText("Sign Out")).click();
			driver.close();
		}
	}


