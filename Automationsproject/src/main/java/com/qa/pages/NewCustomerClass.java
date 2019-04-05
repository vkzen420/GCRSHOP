package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;



public class NewCustomerClass {

	WebDriver driver;
	com.qa.Utilities.GetdatafromExcel data = new com.qa.Utilities.GetdatafromExcel("C:\\Users\\vkjai\\eclipse-workspace\\Automationsproject\\Testdata\\TestData.xlsx");

	@FindBy(how = How.XPATH, using = "//a[@id = 'tdb2' and @role ='button' ]")
	WebElement NewCust_Continue;

	@FindBy(how = How.XPATH, using = "//input[@value = 'm']")
	WebElement NewCust_Gender;

	@FindBy(how = How.XPATH, using = "//input[@name = 'firstname']")
	WebElement NewCust_Firstname;

	@FindBy(how = How.XPATH, using = "//input[@name = 'lastname']")
	WebElement NewCust_Lastname;

	@FindBy(how = How.XPATH, using = "//input[@name = 'dob']")
	WebElement NewCust_DOB;

	@FindBy(how = How.XPATH, using = "//input[@name = 'email_address']")
	WebElement NewCust_Email;

	@FindBy(how = How.XPATH, using = "//input[@name = 'street_address']")
	WebElement NewCust_Address;

	@FindBy(how = How.XPATH, using = "//input[@name = 'postcode']")
	WebElement NewCust_PostalCode;

	@FindBy(how = How.XPATH, using = "//input[@name = 'city']")
	WebElement NewCust_City;

	@FindBy(how = How.XPATH, using = "//input[@name = 'state']")
	WebElement NewCust_State;

	@FindBy(how = How.NAME, using = "country")
	WebElement NewCust_Country;

	@FindBy(how = How.XPATH, using = "//input[@name = 'telephone']")
	WebElement NewCust_Telnum;

	@FindBy(how = How.XPATH, using = "//input[@name = 'password']")
	WebElement NewCust_Password;

	@FindBy(how = How.XPATH, using = "//input[@name = 'confirmation']")
	WebElement NewCust_passwordconfirm;

	@FindBy(how = How.XPATH, using = "//span[text() = 'Continue']")
	WebElement NewCust_Custcreation_continue;

	// Initialisation of pagefactory element
	public NewCustomerClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	/*
	 * declaring the pagefactory methods by using the pagefactory elements
	 */

	public void Navigate_NewCust() {

		NewCust_Continue.click();
	}

	public void gender_Selection() {
		NewCust_Gender.click();
	}

	public void First_name() {
		NewCust_Firstname.sendKeys(data.getdata(0, 1, 1));
		;
	}

	public void Last_name() {
		NewCust_Lastname.sendKeys(data.getdata(0, 1, 2));
		;
	}

	public void DOB() {
		NewCust_DOB.sendKeys(data.getdata(0, 1, 3));

		;
	}

	public void Email() {
		NewCust_Email.sendKeys(data.getdata(0, 1, 4));
		;
	}

	public void Street_address() {
		NewCust_Address.sendKeys(data.getdata(0, 1, 5));
		;
	}

	public void PostalCode() {
		NewCust_PostalCode.sendKeys(data.getdata(0, 1, 6));
		;
	}

	public void City() {
		NewCust_City.sendKeys(data.getdata(0, 1, 7));
		;
	}

	public void State() {
		NewCust_State.sendKeys(data.getdata(0, 1, 8));
		;
	}

	public void Country() {
		Select country = new Select(NewCust_Country);
	     
		//country.selectByValue("99");
		country.selectByVisibleText("India");
	}

	public void Telenum() {
		NewCust_Telnum.sendKeys(data.getdata(0, 1, 9));
		;
	}

	public void Password() {
		NewCust_Password.sendKeys(data.getdata(0, 1, 10));
		;
	}

	public void Password_confirmation() {
		NewCust_passwordconfirm.sendKeys(data.getdata(0, 1, 11));
		;
	}

	public void Contiune_btn() {
		NewCust_Custcreation_continue.click();
	}

}
