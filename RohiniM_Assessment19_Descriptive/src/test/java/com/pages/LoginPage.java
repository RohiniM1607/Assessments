package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//a[normalize-space()='Signup / Login']")
	WebElement login;
	
	@FindBy(xpath = "//input[@data-qa='login-email']")
    WebElement email;

    @FindBy(xpath = "//input[@data-qa='login-password']")
    WebElement password;

    @FindBy(xpath = "//button[@data-qa='login-button']")
    WebElement loginBtn;
    
    @FindBy(xpath = "//a[contains(text(),'Logged in as')]")
    WebElement loggedUser;

    @FindBy(xpath = "//p[text()='Your email or password is incorrect!']")
    WebElement errorMsg;
    
    @FindBy(xpath = "//a[text()=' Logout']")
    WebElement logoutBtn;

    public void clickLogin() {
        login.click();
    }

    public void login(String mail, String pass) {
        email.sendKeys(mail);
        password.sendKeys(pass);
        loginBtn.click();
    }

    public String getLoggedInUser() {
        wait.until(ExpectedConditions.visibilityOf(loggedUser));
        return loggedUser.getText();
    }

    public String getErrorMessage() {
        wait.until(ExpectedConditions.visibilityOf(errorMsg));
        return errorMsg.getText();
    }
    
    public void logout() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutBtn)).click();
    }
}
