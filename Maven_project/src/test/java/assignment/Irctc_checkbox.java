package assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Irctc_checkbox {
@Test
public void irctc() throws Exception
{
	ChromeOptions option=new ChromeOptions();
	option.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(option);
	
	driver.manage().window().maximize();
	driver.get("https://www.irctc.co.in/nget/train-search");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.findElement(By.xpath("//input[@aria-controls='pr_id_1_list']")).sendKeys("HYDERABAD DECAN - HYB (SECUNDERABAD)");
	
	driver.findElement(By.xpath("//input[@aria-controls='pr_id_2_list']")).sendKeys("PITHAPURAM - PAP ");
	
	
	driver.findElement(By.xpath("//button[text()='Search']")).click();

	
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//label[.='AC 2 Tier (2A)']")).click();
	
	List<WebElement> elements=driver.findElements(By.xpath("//table[@class='ng-tns-c78-40']/child::tr//descendant::td"));
	
	int count=elements.size();
	System.out.println(count);
	for(int i=0;i<=count-1;i++)
	{
		String text=elements.get(i).getText();
		System.out.println(text);
		
	}
	
	driver.close();
	
	
}
}
