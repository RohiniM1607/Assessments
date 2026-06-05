package com.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.AccountInformationPage;

public class AccountInformationTest extends BaseTest{
	@Test(dependsOnMethods = "com.test.SignupTest.testSignup")
    public void testAccountInformation() {

        AccountInformationPage ap = new AccountInformationPage(driver);
        ap.AccountDetails("Rohini_16", "Rohini", "M", "ABC Street", "TamilNadu", "Salem", "637501", "9876543210" );
        ap.clickCreateAccount();
        Assert.assertTrue(ap.isAccountCreated(), "Account creation failed!");
        System.out.println("Account Created Status: " + ap.isAccountCreated());
	}
}
