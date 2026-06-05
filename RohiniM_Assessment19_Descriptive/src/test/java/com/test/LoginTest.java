package com.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pages.LoginPage;
import com.utils.ExcelUtils;

public class LoginTest extends BaseTest{
	 @Test(priority = 3, dataProvider = "loginData")
	    public void testLogin(String email, String password, String type, String expected) {

	        LoginPage lp = new LoginPage(driver);

	        lp.clickLogin();
	        lp.login(email, password);

	        if (type.equalsIgnoreCase("valid")) {
	            String user = lp.getLoggedInUser();
	            Assert.assertTrue(user.contains(expected));
	            lp.logout();
	        } else {
	            String error = lp.getErrorMessage();
	            Assert.assertEquals(error, expected);
	        }
	    }

	    @DataProvider(name = "loginData")
	    public Object[][] getData() throws Exception {
	        return ExcelUtils.getData("src/test/resources/TestData.xlsx", "Sheet1");
	    }
}
