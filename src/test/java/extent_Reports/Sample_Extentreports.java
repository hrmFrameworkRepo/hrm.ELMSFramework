package extent_Reports;

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

public class Sample_Extentreports {
	ExtentReports report;

	@BeforeSuite
	public void configBS() {
		// sparkreport config
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvancedReports/report2.html");
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.STANDARD);

		// add env information and create test
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "WINDOWS-10");
		report.setSystemInfo("BROWSER", "CHROME");
	}

	@AfterSuite
	public void configAS() {
		report.flush();

	}

	@Test
	public void createaccountTest() {
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		TakesScreenshot eDriver=(TakesScreenshot) driver;
		String filepath=eDriver.getScreenshotAs(OutputType.BASE64);
		
		ExtentTest test = report.createTest("createContactTest");
		test.log(Status.INFO, "login to app");
		test.log(Status.INFO, "navigate to contact page");
		test.log(Status.INFO, "create contact");
		if ("text".equals("teaxt")) {
			test.log(Status.PASS, "contact is created");
		} else {

			//test.log(Status.FAIL, "contact is not created");
			test.addScreenCaptureFromBase64String(filepath,"Errorfile");

		}
		
		System.out.println("login to app");
		driver.close();

	}
}
