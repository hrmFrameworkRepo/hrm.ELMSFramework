package assignment;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Webtablesdata {
	@Test
	public void fetchdatafor() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoapps.qspiders.com/ui/table?scenario=1");
		List<WebElement> tablerows = driver.findElements(By.xpath("//tr"));

		for (int i = 0; i < tablerows.size(); i++) {
			String text = tablerows.get(i).getText();
			System.out.println(text);
		}

	}

	@Test
	public void fetchdataforeach() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoapps.qspiders.com/ui/table?scenario=1");
		List<WebElement> tablerows = driver.findElements(By.xpath("//tr"));

		for (WebElement rows : tablerows) {
			String text = rows.getText();
			System.out.println(text);

		}

	}
	@Test
	public void fetchdataiterator()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoapps.qspiders.com/ui/table?scenario=1");
		List<WebElement> tablerows = driver.findElements(By.xpath("//tr"));
	Iterator<WebElement> ite=tablerows.iterator();
	while(ite.hasNext())
	{
		String text=ite.next().getText();
		System.out.println(text);
	}
	}
	@Test
	public void fetchdataformultiplerows() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoapps.qspiders.com/ui/table?scenario=1");
		List<WebElement> tablerows = driver.findElements(By.xpath("//td[position() mod 2=0]"));

		for (WebElement rows : tablerows) {
			String text = rows.getText();
			System.out.println(text);

		}
		
		

	}
	

}
