package assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Webtabledata {
	@Test
	public void fetchonlydataforeach() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoapps.qspiders.com/ui/table?scenario=1");
		List<WebElement> tablerows = driver.findElements(By.xpath("//td[1]"));

		for (WebElement rows : tablerows) {
			String text = rows.getText();
			System.out.println(text);

		}

	}

}
