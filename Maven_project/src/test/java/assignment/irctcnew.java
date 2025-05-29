package assignment;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class irctcnew {
	@Test
        public void irctccheck()
{
		

	ChromeOptions option=new ChromeOptions();
	option.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.irctc.co.in/nget/booking/train-list");
		
		
		
		driver.findElement(By.xpath("//input[contains(@class,'ng-tns-c57-8 ui-inputtext')]")).sendKeys(" HYDERABAD DECAN - HYB ");
		//Thread.sleep(3000);
		driver.findElement(By.xpath("//input[contains(@class,'ng-tns-c57-9 ui-input')]")).sendKeys(" KSR BENGALURU - SBC ");
		
		//Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Search']")).click();
	List<WebElement> ele=driver.findElements(By.xpath(" //div[@class='ui-panel-content ui-widget-content ng-tns-c78-210']//descendant::td "));
	
	for(WebElement box:ele) {
		
		System.out.println(box.getText());
		
	}
}

}
