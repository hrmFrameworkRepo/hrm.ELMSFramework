package dataProvider;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.genericfileutility.Fileutility_ExcelVtiger;

public class Dataprovider_amazonproductTest {
	@Test(dataProvider = "getdata")
	public void getproductinfoTest(String brandname, String product) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		driver.get("https://www.amazon.com/");
		// search product
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys(brandname, Keys.ENTER);

		// capture product info
		String x = "//span[.='" + product
				+ "']/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']/descendant::span[@class='a-price']";
		String price = driver.findElement(By.xpath(x)).getText();
		System.out.println(price);
	}

	@DataProvider
	public Object[][] getdata() throws IOException, Throwable {
		Fileutility_ExcelVtiger elib = new Fileutility_ExcelVtiger();
		int rowcount = elib.getRowcount1("iphone");
		Object[][] obj = new Object[rowcount][2];
		for (int i = 0; i < rowcount; i++) {

			obj[i][0] = elib.getdataFromExcel1("iphone", i+1, 0);
			obj[i][1] = elib.getdataFromExcel1("iphone ", i+1, 1);

			
		}

		return obj;

	}

}
