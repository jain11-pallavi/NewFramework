/**
 * 
 */
package com.ATT.pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.ATT.utility.BrowserFactory;
import com.ATT.utility.ConfigData;
import com.ATT.utility.ExcelDataProvider;
import com.ATT.utility.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

/**
 * @author pj558w
 *
 */
public class BaseClass {

	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigData config;
	public ExtentHtmlReporter extent;
	public ExtentReports report;
	public ExtentTest logger;
    
	
	@BeforeSuite
	public void startsuite()
	{
	  excel= new ExcelDataProvider();
	  config = new ConfigData();
	  extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports"+ Helper.getCurrentDateTime()+".html"));
	  report = new ExtentReports();
	  report.attachReporter(extent); 	
	}
	 

	@BeforeClass
	public void setup() {
		driver = BrowserFactory.startApplication(config.getBrowser(),config.getURL());
	}

	@AfterClass
	public void teardown() {
		BrowserFactory.quitApplication(driver);
	}
	
	@AfterMethod
	public void captureMethod(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String failScreen= Helper.captureScreenShot();
			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(failScreen));
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot()));
		}
		report.flush();
	}
	
	
	
	
}
