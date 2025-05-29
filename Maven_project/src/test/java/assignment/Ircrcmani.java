package assignment;

	import java.time.Duration;
	import java.util.List;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
	import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

	public class Ircrcmani {
	
		@Test
		public void checkbox() throws Exception {
			

		
			ChromeOptions option=new ChromeOptions();
			option.addArguments("--disable-notifications");
			WebDriver driver=new ChromeDriver(option);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://www.irctc.co.in/nget/train-search");
			
					
			driver.findElement(By.xpath("//input[contains(@class,'ng-tns-c57-8 ui-inputtext')]")).sendKeys(" HYDERABAD DECAN - HYB ");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[contains(@class,'ng-tns-c57-9 ui-input')]")).sendKeys(" RAMAGUNDAM - RDM ");

			driver.findElement(By.xpath("//label[text()='Train with Available Berth ']")).click();
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			/* WebElement options = driver.findElement(By.xpath("//span[@class='ng-tns-c78-48 fa fa-angle-down']"));
			Select select = new Select(options);
			List<WebElement> elements = select.getAllSelectedOptions();
			System.out.println("count of options:"+ elements.size());
			for(int i=0;i<elements.size();i++)
			{
				String text=elements.get(i).getText();
				System.out.println(text);
			}*/
			
			List<WebElement> e=driver.findElements(By.xpath("//table[@class=\"ng-tns-c78-48\"]//tr//td"));
			int count=e.size();
			System.out.println(count);
			for(int i=0;i<=count-1;i++)
			{
				String text=e.get(i).getText();
				System.out.println(text);
				//div[@class='ui-panel-content ui-widget-content ng-tns-c78-48']
				
			}
		}
	}


