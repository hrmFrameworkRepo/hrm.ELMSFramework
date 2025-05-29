package assignment;

import org.testng.annotations.Test;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Waysto_Refreshing_page {
	@Test
	public void using_navigateto() throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.sreedharscce.com/authenticate");
		Thread.sleep(3000);
		driver.navigate().to(driver.getCurrentUrl());
	}

	@Test
	public void using_curenturl() throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://49.249.28.218:8081/AppServer/Simple_Employee_Leave_Management_System/admin/addemployee.php");
		Thread.sleep(3000);
		driver.get(driver.getCurrentUrl());
	}
	@Test
	public void using_refresh() throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://web.whatsapp.com/");
		Thread.sleep(3000);
		driver.navigate().refresh();
	}
	
	@Test
	public void using_robotclass() throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://web.whatsapp.com/");
		Thread.sleep(3000);
		Robot refresh=new Robot();
		
		refresh.keyPress(KeyEvent.VK_F5);
		
	}

}
