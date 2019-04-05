package com.qa.Utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.qa.Utilities.ScreenShot;


public class ExtentReport_Util extends ScreenShot  {

	public ExtentReports report;
	public ExtentTest logger;
	public WebDriver driver;
	//ScreenShot ss;

	@BeforeSuite
	public void Extent_StartTC() {
		report = new ExtentReports("C:\\Users\\vkjai\\eclipse-workspace\\Automationsproject\\Reports\\extentreport.html",
				true);
		
		
		

		logger = report.startTest(getClass().getName());

	}

	@AfterMethod
	public void reportgeneration(ITestResult result) throws IOException {
		//ss = new ScreenShot();
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(LogStatus.FAIL, result.getName());
			logger.log(LogStatus.FAIL, result.getThrowable());
			String Screenshotpath = Takescreenshot(driver, "Login_to_application");
			logger.log(LogStatus.FAIL, logger.addScreenCapture(Screenshotpath));

		}
		
		else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(LogStatus.PASS, result.getName());
			//logger.log(LogStatus.FAIL, result.getThrowable());
			//String Screenshotpath = ss.Takescreenshot(driver, "Login_to_application");
			//logger.log(LogStatus.FAIL, logger.addScreenCapture(Screenshotpath));

		}
		report.endTest(logger);

		

	}
	
	
	
}
