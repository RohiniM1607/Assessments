Feature: Search Product Functionality

  Description:
    This feature verifies the search functionality of the TutorialsNinja application.

  Background:
    Given user is on TutorialsNinja home page

  Scenario Outline: Search product with different keywords
    When user searches for product "<keyword>"
    Then search result should "<result_status>" matching products

    Examples:
      | keyword | result_status |
      | iPhone  | contain       |
      | Samsung | contain       |
      | Nikdsg     | not contain   |