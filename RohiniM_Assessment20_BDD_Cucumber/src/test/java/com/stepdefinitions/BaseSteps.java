package com.stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;

public class BaseSteps {
	WebDriver driver = Hooks.driver;

    @Given("user is on TutorialsNinja home page")
    public void user_is_on_tutorials_ninja_application() {
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains("Your Store"));
        System.out.println("TutorialsNinja Application Opened");
    }
}
