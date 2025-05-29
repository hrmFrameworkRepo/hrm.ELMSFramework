package advanced_selenium_basics;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Crossbrowser_testingTest {

	@Test
	public void TC() throws Exception {
		String path = "./Property/crossbrowser.properties";
		FileInputStream fis = new FileInputStream(new File(path));

		// create anobject for property class
		Properties prop = new Properties();
		prop.load(fis);

		// to retrieve the values from the property file

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

		driver.get(url);
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys(prop.getProperty("USERNAME"));
		driver.findElement(By.id("Password")).sendKeys(prop.getProperty("PASSWORD"));
		driver.findElement(By.xpath("(//input[@type='submit'])[2]")).click();

		Thread.sleep(3000);
		
		driver.close();

	}

}
