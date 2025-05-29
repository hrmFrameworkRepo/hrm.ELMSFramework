package assignment;

import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class google_hambuger {
	@Test
	public void text() throws Exception
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//div[@class='gb_J gb_cd gb_0']")).click();
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[name='app']")));
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='LVal7b ']//descendant::li"));
        int count=elements.size();
        System.out.println("no of apps :-" + count);
		for (WebElement apps : elements)
		{

			System.out.println(apps.getText());

		}
		Thread.sleep(2000);
		driver.close();
	}
		
		
		
	}

