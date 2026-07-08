Feature: Register in DemoWebshop

    Background:
    Given The user launched the DemoWebShop Application
    When The user navigated to the registration page

    Scenario: Valid Registration
    When The user enters the valid personal details
    And The user enters the valid password details
    And The user clicks the Register button
    Then The user successfully created the account