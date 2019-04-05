package com.qa.test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.Utilities.Browser;
import com.qa.Utilities.Configproperties;
import com.qa.Utilities.ExtentReport_Util;
import com.qa.Utilities.GetdatafromExcel;
import com.qa.Utilities.ScreenShot;
import com.qa.pages.NewCustomerClass;
import com.relevantcodes.extentreports.LogStatus;



public class TC1_NewCustomer_Creation extends ExtentReport_Util{

	private WebDriver driver;
	Configproperties conf = new Configproperties();
	Browser b = new Browser();

	ScreenShot ss = new ScreenShot();
	GetdatafromExcel excel = new GetdatafromExcel("C:\\Users\\vkjai\\eclipse-workspace\\Automationsproject\\Testdata\\TestData.xlsx");
	NewCustomerClass CC;
	String Acc_Creation_text = "Your Account Has Been Created!";

	@BeforeMethod
	public void beforeClass() throws IOException, InterruptedException {

		String Exceldata = excel.getdata(0, 1, 0);
		driver = b.browsersetup(Exceldata, driver);

		driver.get(conf.Configuration());
		Thread.sleep(5000);
		 ss.Takescreenshot(driver, "NewCuspage");
		CC = new NewCustomerClass(driver);
		
	}

	@Test
	public void Creation_NewCustomer() throws InterruptedException, IOException {
		CC.Navigate_NewCust();
		logger.log(LogStatus.INFO, "Navigation to Customer");
		Thread.sleep(2000);
		ss.Takescreenshot(driver, "NewCustpage");

		
		
		CC.gender_Selection();
		logger.log(LogStatus.INFO, "Fill the fileds");
		Thread.sleep(2000);

		CC.First_name();
		Thread.sleep(2000);

		CC.Last_name();
		Thread.sleep(2000);

		CC.DOB();

		Thread.sleep(2000);

		CC.Email();
		Thread.sleep(2000);

		CC.Street_address();
		Thread.sleep(2000);

		CC.PostalCode();
		Thread.sleep(2000);

		CC.City();
		Thread.sleep(2000);

		CC.State();
		Thread.sleep(2000);

		CC.Country();
		Thread.sleep(2000);

		CC.Telenum();
		Thread.sleep(2000);

		CC.Password();
		Thread.sleep(2000);

		CC.Password_confirmation();
		Thread.sleep(2000);
		ss.Takescreenshot(driver, "newcc_pagedetails");

		CC.Contiune_btn();
		Thread.sleep(2000);

		WebElement Existingcust_error = driver.findElement(By.xpath("//tr[@class = 'messageStackError']//img"));
		String Existingcust_error_msg = Existingcust_error.getText();
		System.out.println(Existingcust_error_msg);

		if (Existingcust_error_msg != null) {

			System.out.println("Email id is already registered");
			logger.log(LogStatus.INFO, "Email id is already registered");
			ss.Takescreenshot(driver, "Existingcust_error");
		}

		else {
			WebElement NewCC_Creation_text_acctual = driver
					.findElement(By.xpath("//h1[text() = 'Your Account Has Been Created!']"));
			Assert.assertEquals(Acc_Creation_text, NewCC_Creation_text_acctual.getText());
			ss.Takescreenshot(driver, "Acc_Creation_page");
			Reporter.log("New Customer Created sussfully ");
		}

	}

	

	@AfterMethod
	public void afterClass() {
		driver.quit();
	}

}
