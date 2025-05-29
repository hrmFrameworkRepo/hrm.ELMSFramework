package dws_testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import webpages.dwshomepage;
import webpages.dwsregisterpage;

public class dws_RegisterTest {
	
	@Test
	public void TC2()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// navigate to the link
		driver.get("https://demowebshop.tricentis.com/");
		//create an object of homepage and call the methods
		dwshomepage homepage=new dwshomepage(driver);
        homepage.clickregisterlink();
		 dwsregisterpage registration =new dwsregisterpage(driver);
		 
		 registration.clickgender();
		 registration.enterfirstname("ganesh");
		 registration.enterlastname("KTM");
		 registration.enteremail("asxcd@gmail.com");
		 registration.enterpassword("password");
		 registration.enterconfirmpassword("password");
		 registration.clickregisterbutton();
		 driver.close();
	}

}
