package assignment;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Sendingkeys_indifferentways {
	@Test
	public void Hrmsendkeys() throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://49.249.28.218:8081/AppServer/Simple_Employee_Leave_Management_System/");
		driver.findElement(By.xpath("//a[text()='Admin Login']")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Test@12345");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='signin']")).click();
		Thread.sleep(2000);
	}

	@Test
	public void Hrmjavascriptexecutor() throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://49.249.28.218:8081/AppServer/Simple_Employee_Leave_Management_System/");
		driver.findElement(By.xpath("//a[text()='Admin Login']")).click();
		Thread.sleep(1000);
		WebElement ele1 = driver.findElement(By.xpath("//input[@id='username']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='admin'", ele1);
		WebElement ele2 = driver.findElement(By.xpath("//input[@id='password']"));

		js.executeScript("arguments[0].value='Test@12345'", ele2);
		

	}

	@Test
	public void Hrmusingactionclass() throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://49.249.28.218:8081/AppServer/Simple_Employee_Leave_Management_System/");
		driver.findElement(By.xpath("//a[text()='Admin Login']")).click();
		Thread.sleep(1000);
		Actions act = new Actions(driver);
		WebElement ele1 = driver.findElement(By.xpath("//input[@id='username']"));
		act.sendKeys(ele1, "admin").perform();
		WebElement ele2 = driver.findElement(By.xpath("//input[@id='password']"));
		act.sendKeys(ele2, "Test@12345").perform();

	}

	@Test
	public void HrmusingRobotclass() throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://49.249.28.218:8081/AppServer/Simple_Employee_Leave_Management_System/");

		driver.findElement(By.xpath("//a[text()='Admin Login']")).click();
		Thread.sleep(1000);
		Robot hrm = new Robot();
		hrm.keyPress(KeyEvent.VK_TAB);
		hrm.delay(1000);
		hrm.keyRelease(KeyEvent.VK_TAB);
		hrm.keyPress(KeyEvent.VK_A);

		hrm.keyRelease(KeyEvent.VK_A);
		hrm.keyPress(KeyEvent.VK_D);

		hrm.keyRelease(KeyEvent.VK_D);
		hrm.keyPress(KeyEvent.VK_M);

		hrm.keyRelease(KeyEvent.VK_M);
		hrm.keyPress(KeyEvent.VK_I);

		hrm.keyRelease(KeyEvent.VK_I);
		hrm.keyPress(KeyEvent.VK_N);

		hrm.keyRelease(KeyEvent.VK_N);

		
		hrm.keyPress(KeyEvent.VK_TAB);
		hrm.delay(1000);
		hrm.keyRelease(KeyEvent.VK_TAB);
		
	}

}
