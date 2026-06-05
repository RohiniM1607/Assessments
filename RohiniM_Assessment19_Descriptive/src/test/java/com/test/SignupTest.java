package com.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.AccountInformationPage;
import com.pages.SignupPage;

public class SignupTest extends BaseTest{
	 @Test(priority = 1)
	    public void registerNewUser() {

	        SignupPage sp = new SignupPage(driver);
	        sp.clickSignupLogin();
	        sp.signup("Rohini", "rohinim16@gmail.com");
	        sp.clickSignupSubmit();
	        Assert.assertTrue(driver.getCurrentUrl().contains("signup"),"Signup page not loaded properly");
	    }

	    @Test(priority = 2)
	    public void registerExistingUser() {

	        SignupPage sp = new SignupPage(driver);
	        sp.clickSignupLogin();
	        sp.signup("Rohini", "rohini123@gmail.com");
	        sp.clickSignupSubmit();
	        String msg = sp.getEmailAlreadyExistText();
	        Assert.assertEquals(msg, "Email Address already exist!");
	    }
}
