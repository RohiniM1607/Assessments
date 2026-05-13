Feature: Address Book Functionality

  Description:
    Address Book Feature adds the new address in the address book of tutorials ninja application

  Background:
    Given user is on TutorialsNinja home page

  Scenario: Login and add new address using data table
    When user clicks on My Account menu
    And user clicks on Login option
    And user enters valid login credentials
    And user clicks on Login button
    Then user should be navigated to My Account page

    When user clicks on My Account menu
    And user clicks on Address Book option
    And user clicks on New Address button
    And user enters mandatory address details
      | First Name   | John            |
      | Last Name    | Doe             |
      | Address 1    | 123 Main Street |
      | City         | Chennai         |
      | Post Code    | 600001          |
      | Country      | India           |
      | Region/State | Tamil Nadu      |
    And user clicks on Continue button
    Then address should be added successfully