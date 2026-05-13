package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		plugin = {"pretty",
				"html:target/cucumber-reports.html",
				"json:target/cucumber.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		},
	    features = "src/test/resources/features",
	    glue = "com.stepdefinitions"
	    
	)
	
public class TestNG_Runner extends AbstractTestNGCucumberTests {

}