package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;



public class Loginpageclass {

	WebDriver driver;
	com.qa.Utilities.GetdatafromExcel data = new com.qa.Utilities.GetdatafromExcel("C:\\Users\\vkjai\\eclipse-workspace\\Seleniumnew\\TestData.xlsx");

	
	@FindBy(how = How.XPATH, using = "//input[@name = 'email_address']")
	WebElement Login_Email;

	
	@FindBy(how = How.XPATH, using = "//input[@name = 'password']")
	WebElement Login_Password;

	@FindBy(how = How.XPATH, using = "//span[text() = 'Sign In']")
	WebElement Login_Signbtn;

	
	
	
	
	// Initialisation of pagefactory element
	public Loginpageclass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	/*
	 * declaring the pagefactory methods by using the pagefactory elements
	 */
	public void Email() {
		Login_Email.sendKeys(data.getdata(0, 1, 4));
		System.out.println(Login_Email.getAttribute("name"));
		//Alert alert = driver.switchTo().alert();
		
	}

	
	public void Password() {
		Login_Password.sendKeys(data.getdata(0, 1, 10));
		
	}
	
	public void SignIN() {
		Login_Signbtn.click();;
		;
	}
	
	
}
