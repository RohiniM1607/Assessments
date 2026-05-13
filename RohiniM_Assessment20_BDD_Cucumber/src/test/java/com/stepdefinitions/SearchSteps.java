package com.stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchSteps {
	WebDriver driver = Hooks.driver;
    @When("user searches for product {string}")
    public void user_searches_for_product(String keyword) {
        driver.findElement(By.xpath("//input[@name='search']")).clear();
        driver.findElement(By.xpath("//input[@name='search']")).sendKeys(keyword);
        driver.findElement(By.xpath("//button[contains(@class,'btn-default')]")).click();

        System.out.println("Searched product: " + keyword);
    }

    @Then("search result should {string} matching products")
    public void search_result_should_matching_products(String resultStatus) {
        int productCount = driver.findElements(By.xpath("//div[@class='product-thumb']")).size();

        if (resultStatus.equalsIgnoreCase("contain")) 
        	Assert.assertTrue(productCount > 0,"Expected matching products, but no products found");
        
        else if (resultStatus.equalsIgnoreCase("not contain")) 
        	Assert.assertEquals(productCount, 0, "Expected no matching products, but products were found");
         
        System.out.println("Product count: " + productCount);
    }
}