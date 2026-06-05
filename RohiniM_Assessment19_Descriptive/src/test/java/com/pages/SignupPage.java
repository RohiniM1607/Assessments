package com.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage extends BasePage{

	public SignupPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//a[normalize-space()='Signup / Login']")
	WebElement signup;
	
	@FindBy(xpath="//input[@data-qa='signup-name']")
	WebElement signupName;
	
	@FindBy(xpath="//input[@data-qa='signup-email']")
	WebElement signupMail;
	
	@FindBy(xpath="//button[@data-qa='signup-button']")
	WebElement signupSubmit;
	
	@FindBy(xpath = "//p[text()='Email Address already exist!']")
	WebElement emailAlreadyExistMsg;
	
	public void clickSignupLogin() {
        signup.click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(signupName));
    }
	
	public void signup(String name, String mail) {
		
		signupName.sendKeys(name);
		signupMail.sendKeys(mail);
	}
	
	public String getEmailAlreadyExistText() {
	    wait.until(ExpectedConditions.visibilityOf(emailAlreadyExistMsg));
	    return emailAlreadyExistMsg.getText();
	}
	
	public void clickSignupSubmit() {
        signupSubmit.click();
    }
}
