package com.stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	WebDriver driver = Hooks.driver;
	 WebDriverWait wait = Hooks.wait;
	 
	@When("user clicks on My Account menu")
	public void user_clicks_on_my_account_menu() {
		driver.findElement(By.xpath("//a[@title='My Account']")).click();
	}

	@When("user clicks on Login option")
	public void user_clicks_on_login_option() {
		driver.findElement(By.xpath("(//a[text()='Login'])[1]")).click();
	}

	@When("user enters valid login credentials")
	public void user_enters_valid_login_credentials() {
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("rohini123@gmail.com");
	    driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Rohini_16");
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	}

	@Then("user should be navigated to My Account page")
	public void user_should_be_navigated_to_my_account_page() {
		
	}
}
