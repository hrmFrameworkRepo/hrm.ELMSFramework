package advanced_selenium_basics;

import java.io.FileReader;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class Adminlogin_using_XML {
@Test
public void xmlfile(XmlTest test) throws Exception {
	

	//step 1 : parse  json physical file into java object using Json parser class
			JSONParser parser=new JSONParser();
			Object obj=parser.parse(new FileReader("./JSON/adminlogin.json"));
			
			//step 2: converting the java object into JSON object using downcating
			
			JSONObject map=(JSONObject) obj;
			
			 
			String password=test.getParameter("password");

			 String url= test.getParameter("url");

			String browser =test.getParameter("browser"); 
			String username=test.getParameter("username");
			
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

			 driver=new ChromeDriver();

			driver.get(url);
			driver.manage().window().maximize();

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			// 1.identify webelement-dropdown
			driver.findElement(By.xpath("//a[text()='Admin Login']")).click();
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
			Thread.sleep(1000);
			 driver.findElement(By.xpath("//input[@name='signin']")).click();
			Thread.sleep(2000);
			
}
}
