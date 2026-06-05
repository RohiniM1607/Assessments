package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountInformationPage extends BasePage{
	
	public AccountInformationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//input[@data-qa='password']")
	WebElement accPassword;
	
	@FindBy(xpath="//input[@id='first_name']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@id='last_name']")
	WebElement lastName;

	@FindBy(xpath="//input[@id='address1']")
	WebElement address;
	
	@FindBy(xpath="//option[@value='India']")
	WebElement country;
	
	@FindBy(xpath="//input[@id='state']")
	WebElement state;
	
	@FindBy(xpath="//input[@id='city']")
	WebElement city;
	
	@FindBy(xpath="//input[@id='zipcode']")
	WebElement pincode;
	
	@FindBy(xpath="//input[@id='mobile_number']")
	WebElement mobilenumber;
	
	@FindBy(xpath="//button[@data-qa='create-account']")
	WebElement createAccount;
	
	@FindBy(xpath="//h2[@data-qa='account-created']")
	WebElement accountCreated;
	
	public void AccountDetails(String password, String fname, String lname, String add,
			String State, String City, String PinCode, String MobileNumber) {
		accPassword.sendKeys(password);
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		address.sendKeys(add);
		country.click();
		state.sendKeys(State);
		city.sendKeys(City);
		pincode.sendKeys(PinCode);
		mobilenumber.sendKeys(MobileNumber);
	}
	
	public void clickCreateAccount() {
		createAccount.click();
	}
	 
	public boolean isAccountCreated() {
		wait.until(ExpectedConditions.visibilityOf(accountCreated)); 
		return accountCreated.isDisplayed();
	}
}
