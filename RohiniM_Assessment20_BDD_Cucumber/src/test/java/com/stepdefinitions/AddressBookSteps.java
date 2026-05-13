package com.stepdefinitions;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddressBookSteps {

    WebDriver driver = Hooks.driver;
    WebDriverWait wait = Hooks.wait;

    @When("user clicks on Address Book option")
    public void user_clicks_on_address_book_option() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Address Book']"))).click();
    }

    @When("user clicks on New Address button")
    public void user_clicks_on_new_address_button() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='New Address']"))).click();
    }

    @When("user enters mandatory address details")
    public void user_enters_mandatory_address_details(DataTable dataTable) {
    	List<List<String>> addressData = dataTable.asLists(String.class);

        String firstName = addressData.get(0).get(1);
        String lastName = addressData.get(1).get(1);
        String address = addressData.get(2).get(1);
        String city = addressData.get(3).get(1);
        String postCode = addressData.get(4).get(1);
        String country = addressData.get(5).get(1);
        String state = addressData.get(6).get(1);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='content']")));
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(firstName);
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastName);
        driver.findElement(By.xpath("//input[@name='address_1']")).sendKeys(address);
        driver.findElement(By.xpath("//input[@name='city']")).sendKeys(city);
        
        Select countryDropdown = new Select(driver.findElement(By.xpath("//select[@id='input-country']")));
        countryDropdown.selectByVisibleText(country);

        Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='input-zone']")));
        stateDropdown.selectByVisibleText(state);
    }

    @When("user clicks on Continue button")
    public void user_clicks_on_continue_button() {
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    @Then("address should be added successfully")
    public void address_should_be_added_successfully() {
        String expectedMessage = "Your address has been successfully added";
        String actualMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'alert-success')]"))).getText();
        Assert.assertTrue(actualMessage.contains(expectedMessage));
        System.out.println("Address Added successfully");
    }
}