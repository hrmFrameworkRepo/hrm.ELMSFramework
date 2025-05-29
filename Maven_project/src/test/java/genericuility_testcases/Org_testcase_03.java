package genericuility_testcases;


	
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.time.Duration;
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
	import org.openqa.selenium.support.ui.Select;

	public class Org_testcase_03 {

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
		Sheet sh = wb.getSheet("org");
		Row row = sh.getRow(7);
		String orgName = row.getCell(2).toString()+ran_Num;
		String phoneNo = row.getCell(3).toString();
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
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.id("phone")).sendKeys(phoneNo);
		
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		
		
		//Verying the headerinfo and org name and phone number
		 String headerinfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		 if(headerinfo.contains(orgName)) {
			 System.out.println(orgName + " header verified===PASS");
		 }
		 else {
			 System.out.println(orgName + " header verified===FAIL");
		 }
		//Verying Header Message & Header orgName info Expected Result with the Actual Result
		String actualOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
		if(actualOrgName.equals(orgName)) {
			System.out.println(orgName + " information is created===PASS");
		}
		else {
			System.out.println(orgName + " information is created===FAIL");
		}
		
	    String actualphNo = driver.findElement(By.id("dtlview_Phone")).getText();
	    if(actualphNo.equals(phoneNo)) {
	    	System.out.println(phoneNo + " phone Number has entered===PASS");
	    }
	    else {
	    	System.out.println(phoneNo + " phone Number has not entered===FAIL");
	    }
		Actions act=new Actions(driver);
		WebElement adminImg = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
		act.moveToElement(adminImg).click().perform();
		driver.findElement(By.partialLinkText("Sign Out")).click();
		driver.close();
		}
		 
	}


