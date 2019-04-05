package com.qa.test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.Utilities.Browser;
import com.qa.Utilities.ExtentReport_Util;
import com.qa.Utilities.GetdatafromExcel;
import com.qa.Utilities.ScreenShot;
import com.qa.pages.Loginpageclass;
import com.relevantcodes.extentreports.LogStatus;




public class TC2_Login_To_Customer extends ExtentReport_Util {

	
	

	public WebDriver driver;
	public String url = "http://www.gcreddy.com/project1/login.php";
	Browser b = new Browser();
	//ExtentReport_Util extent = new ExtentReport_Util(driver) ;
	
	ScreenShot ss = new ScreenShot();
	GetdatafromExcel excel = new GetdatafromExcel("C:\\Users\\vkjai\\eclipse-workspace\\Automationsproject\\Testdata\\TestData.xlsx");
	Loginpageclass CC;
	String Login_Page_Title = "Welcome to GCR Shop";
	
	@BeforeClass
	public void beforeClass() throws IOException, InterruptedException {

		String Exceldata = excel.getdata(0, 1, 0);
		driver = b.browsersetup(Exceldata, driver);
	   
		
		//extent.logger = extent.report.startTest("login to the application");
		driver.get(url);
		//extent.logger.log(LogStatus.INFO, "Browner started and enter the link");
		Thread.sleep(5000);
		 
		CC = new Loginpageclass(driver);
	}

	@Test
	public void LoginTOExistingcust()
			
			throws InterruptedException, IOException {
		CC.Email();
		
		
		logger.log(LogStatus.INFO, "Enter the Email");
		Thread.sleep(3000);

		CC.Password();
		logger.log(LogStatus.INFO, "Enter the Password");
		Thread.sleep(3000);

		CC.SignIN();
		logger.log(LogStatus.INFO, "Click on the Sign button");
		Thread.sleep(3000);

		WebElement PageTitle = driver.findElement(By.xpath("//h1[text() = 'Welcome to GCR Shop' ]"));
		System.out.println("Login page Tilte is :" + PageTitle.getText());
		logger.log(LogStatus.INFO, "Getting the login page homepage title");
		Assert.assertEquals(Login_Page_Title, PageTitle.getText(), "Successfully login in to the application got failed");
		logger.log(LogStatus.INFO, "Successfully to the application");
		System.out.println("Successfully login in to the application ");
		//ss.Takescreenshot(driver, "welcomePage");

	}

	/*@Test
	public void NewProductvarification() throws InterruptedException {

		List<WebElement> list = driver.findElements(By.xpath("//div[@class = 'contentText' ]//td"));
		int size = list.size();
		System.out.println(size);

		ArrayList<String> productdetails = new ArrayList<String>();
		for (int i = 0; i < size; i++) {
			productdetails.add(list.get(i).getText());
		}
		System.out.println(productdetails);

		//ArrayList<Object> productname = new ArrayList<Object>();
		//ArrayList<Object> productprice = new ArrayList<Object>();

		driver.findElement(By.xpath("//*[@id=\"columnLeft\"]/div[1]/div[2]/a[1]")).click();
		Thread.sleep(3000);
		//List<WebElement> Hlist = driver.findElements(By.xpath("//div[@class = 'contentContainer']//td"));
		//int size1 = Hlist.size();
		for (int i = 0; i < size1; i++) {
      			//productname[i] = Hlist.get(i).getText();

		}

	}
*/
	/*@AfterMethod
	public void reportgeneration(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			extent.logger.log(LogStatus.FAIL, result.getName());
			extent.logger.log(LogStatus.FAIL, result.getThrowable());
			String Screenshotpath = ss.Takescreenshot(driver, "Login_to_application");
			extent.logger.log(LogStatus.FAIL, extent.logger.addScreenCapture(Screenshotpath));

		}
		extent.report.endTest(extent.logger);

		
	}*/
	
	
	
	
	
	
	@AfterClass
	public void afterClass() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
		
		//extent.report.flush();
		//extent.report.close();

	}
	
	@AfterSuite
	public void reportgeneration()
	{
		
		
		report.flush();
		report.close();
		
	}


}
