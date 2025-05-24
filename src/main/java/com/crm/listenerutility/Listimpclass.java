package com.crm.listenerutility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.events.EventFiringWebDriver;
//import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.Baseclass.Base_class;
import com.crm.genericwebdriverutility.Utilityclass_object;

public class Listimpclass implements ITestListener, ISuiteListener {
	public ExtentSparkReporter spark;
	public static ExtentReports report;
	public ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("Report configuration");
		// sparkreport config
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		spark = new ExtentSparkReporter("./AdvancedReports/report_"+time+".html");
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.STANDARD);

		// add env information and create test
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "WINDOWS-10");
		report.setSystemInfo("BROWSER", "CHROME");
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("Report backup");
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getMethod().getMethodName() + "Start");
		test = report.createTest(result.getMethod().getMethodName());
		Utilityclass_object.setTest(test);
		test.log(Status.INFO, result.getMethod().getMethodName() + "STARTED ");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getMethod().getMethodName() + "End");
		test.log(Status.PASS, result.getMethod().getMethodName() + "COMPLETED");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		//WebDriver driver = null;
		// TODO Auto-generated method stub
		String testname = result.getMethod().getMethodName();

		TakesScreenshot eDriver = (TakesScreenshot) Base_class.sdriver;
		String filepath = eDriver.getScreenshotAs(OutputType.BASE64);
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		test.addScreenCaptureFromBase64String(filepath, testname + "_" + time);
		test.log(Status.FAIL, result.getMethod().getMethodName() + "FAILED");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.SKIP, result.getMethod().getMethodName() + "SKIPPED");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
