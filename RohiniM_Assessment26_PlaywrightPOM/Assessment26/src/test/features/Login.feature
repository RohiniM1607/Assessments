Feature: Login into Demo Web Shop

  Background:
    Given The user launched the DemoWebShop Application
    And The user navigated to the Login page

  Scenario Outline: Login with valid and invalid credentials
    When The user enters "<email>" and "<password>"
    And The user clicks the Login button
    Then The user should see "<result>"

    Examples:
      | email                 | password | result  |
      | demo.1@gmail.com   | Demo@123 | success |
      | invalid@gmail.com     | Test@123 | failure |
      