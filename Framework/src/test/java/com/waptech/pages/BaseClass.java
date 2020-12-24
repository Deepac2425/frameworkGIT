package com.waptech.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.waptech.utility.BrowserFactory;
import com.waptech.utility.ConfigDataProvider;
import com.waptech.utility.ExcelDataProvider;

public class BaseClass {
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;

	@BeforeSuite
	public void setUpSuite() {
		Reporter.log("Setting up test data, config files and reports", true);
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();
		
		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/login_"+HelperClass.getCurrentDateTime()+".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
		Reporter.log("Setting Done! Test data, config files and reports are initialized", true);

	}

	@BeforeClass
	public void setUp() {
		Reporter.log("Starting the browser and getting the Application ready", true);
		driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getAppURL());
		Reporter.log("Browser and application is Up and running", true);
	}

	@AfterClass
	public void tearDown() {
		BrowserFactory.quitBrowser(driver);
	}
	
	@AfterMethod
	public void testExecutionStatus(ITestResult result) throws IOException {
		Reporter.log("Test is about to End", true);
		if(result.getStatus()==ITestResult.FAILURE) {
			
			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(HelperClass.captureScreenShot(driver)).build());
		}
		
		else if(result.getStatus()==ITestResult.SUCCESS) {
			
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(HelperClass.captureScreenShot(driver)).build());
		} 
		else if(result.getStatus()==ITestResult.SKIP) {
			
			logger.skip("Test Skipped", MediaEntityBuilder.createScreenCaptureFromPath(HelperClass.captureScreenShot(driver)).build());
		}
		
		report.flush();
		Reporter.log("Test execution is comppleted and reports generated", true);
		
	}

}
