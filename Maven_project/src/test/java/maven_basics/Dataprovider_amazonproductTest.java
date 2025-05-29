package maven_basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


	public class Dataprovider_amazonproductTest {
		@Test(dataProvider="getdata")
		public void getproductinfoTest(String brandname,String product)
		{
			WebDriver driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
			driver.get("https://www.amazon.com/");
			//search product
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandname,Keys.ENTER);
			
			//capture product info
			String x="//span[.='"+product +"']/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']/descendant::span[@class='a-price']";
			String price=driver.findElement(By.xpath(x)).getText();
			System.out.println(price);
		}
		@DataProvider
		public Object [][] getdata()
		{
			Object[][] obj=new Object[3][2];
			
			obj[0][0]="iphone";
			obj[0][1]="Apple iPhone 14 Pro Max, 128GB, Space Black - Unlocked (Renewed)";
			
			obj[1][0]="iphone";
			obj[1][1]="Apple iPhone 12, 64GB, Black - Fully Unlocked (Renewed)";
			
			obj[2][0]="iphone";
			obj[2][1]="Apple iPhone 13 Pro Max, 512GB, Graphite - Unlocked (Renewed)";
			
			return obj;
			
		}
		

	}



