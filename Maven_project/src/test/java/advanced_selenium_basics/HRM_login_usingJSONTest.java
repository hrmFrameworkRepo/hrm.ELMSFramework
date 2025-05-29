 package advanced_selenium_basics;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class HRM_login_usingJSONTest {

	@Test
	public void jsondata() throws Throwable, IOException, ParseException
	{
		//step 1 : parse  json physical file into java object using Json parser class
		JSONParser parser=new JSONParser();
		Object obj=parser.parse(new FileReader("./JSON/adminlogin.json"));
		
		//step 2: converting the java object into JSON object using downcasting
		
		JSONObject map=(JSONObject) obj;
		String Admin = (String) map.get("username");
		String Password =(String) map.get("password");

		String url = (String) map.get("url");

		String browser = (String) map.get("browser");
		
		
		
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
		
	}
}


