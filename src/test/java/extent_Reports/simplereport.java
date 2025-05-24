package extent_Reports;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class simplereport {
	
		 ExtentReports report;
		
		@BeforeSuite
		public void beforeSuite()
		{
			System.out.println("Connect to DB");
			
			ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReport/report.xml");
			spark.config().setDocumentTitle("CRM Test Suite Results");
			spark.config().setReportName("CRM Report");
			spark.config().setTheme(Theme.DARK);
		
			
			//add env information & create a test
			 report=new ExtentReports();
			report.attachReporter(spark);
			report.setSystemInfo("OS", "Windows-10");
			report.setSystemInfo("BROWSER", "CHROME-100");
		}
		
			
		@Test
		public void simpleReport() throws IOException
		{
			
			WebDriver driver=new ChromeDriver();
			
			driver.get("https://testautomationpractice.blogspot.com/");
			
			
			//Add depenency
			TakesScreenshot ts=(TakesScreenshot)driver;
			
			String srcfile = ts.getScreenshotAs(OutputType.BASE64);
			
			//ts.getScreenshotAs("./Screenshort/reportScreenshort.png");
			
			//FileUtils.copyFile(srcfile,new File("./Screenshort/screenshort.png"));
			
			ExtentTest test=report.createTest("Create simple report");
			
			test.log(Status.INFO,"---Login To App");
			test.log(Status.INFO,"---navigate to contact page");
			test.log(Status.INFO,"---Create contact");
			if("HDFC".equals("HDFC"))
			{
				test.log(Status.PASS,"---pass");
			}
			else
			{
				test.addScreenCaptureFromBase64String(srcfile,"Errorfile");
			}
			
			
			
			test.log(Status.INFO,"---Close the App");
		}
	
		@AfterSuite
		public void afterSuite()
		{
			System.out.println("Disconnect to DB");
			
			report.flush();
		}
		
		}


