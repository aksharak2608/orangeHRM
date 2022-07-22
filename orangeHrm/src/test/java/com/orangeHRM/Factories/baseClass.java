package com.orangeHRM.Factories;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.orangeHRM.utility.helper;


public class baseClass {
	public static WebDriver driver;
	public static ExtentReports rep;
	public static ExtentSparkReporter sp;
	public static ExtentTest logger;

	@BeforeSuite
	public void statusReport() {
		rep = new ExtentReports();
		String ts = helper.timeStamp();
		sp = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/Report_"+ ts +".html");
		rep.attachReporter(sp);
	
	}

	@AfterMethod
	public void resultReport(ITestResult r) {
		int status = r.getStatus();
		if (status == ITestResult.SUCCESS) {
			System.out.println("test passed");
			logger.log(Status.PASS,"TestPassed",MediaEntityBuilder.createScreenCaptureFromPath(helper.TakeScreenshot(driver)).build());
		} else if (status == ITestResult.FAILURE) {
			System.out.println("test failed");
			System.out.println("Exception is " + r.getThrowable().getMessage());
		} else if (status == ITestResult.SKIP) {
			System.out.println("test skip");
		}
		rep.flush();
	}
	@BeforeClass
	public void startSession()
	{
	String browser=dataProvider.getConfigData().getProperty("Browser");
			
	String url=dataProvider.getConfigData().getProperty("url");
	driver=BroserFactory.launchChromeBrowser(url, browser);
	
	}
	@AfterClass
	public void EndSession()
	{
BroserFactory.closeBrowser(driver);
	}
}
