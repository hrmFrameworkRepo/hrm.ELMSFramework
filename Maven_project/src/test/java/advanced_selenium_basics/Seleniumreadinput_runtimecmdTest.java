package advanced_selenium_basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Seleniumreadinput_runtimecmdTest {
	@Test
	public void seleniumTest() throws Exception {
		String url = System.getProperty("url");

		String browser = System.getProperty("browser");
		String Admin = System.getProperty("Admin");
		String Password = System.getProperty("Password");

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
		driver.close();

	}
}
