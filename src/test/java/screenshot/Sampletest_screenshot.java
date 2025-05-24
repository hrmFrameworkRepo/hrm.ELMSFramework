package screenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import org.testng.annotations.Test;

public class Sampletest_screenshot {
	@Test
	public void amazontest() throws IOException {
		
		WebDriver driver =new ChromeDriver();
		driver.get("https://www.sreedharscce.com/authenticate");
		//Step 1:create an object to EventFiringWebDriver
		EventFiringWebDriver edriver=new EventFiringWebDriver(driver);
		//step 2:use getscreenshotas method to get  file type screenshot
		File src=edriver.getScreenshotAs(OutputType.FILE);
		//step 3 store the image in local space
		FileUtils.copyFile(src, new  File("./Screenshots/Sreedhars.png"));
	}

}
