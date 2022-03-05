Feature: feature to test google search functionality
  Background:
    Given go to main page

  Scenario Outline: validate google search is working

    Given user is on search page
    When user enters a <text> in search box
    And hits enter
    Then user is navigated ti search results

    Examples:
      | text                    |
      | Automation step by step |
      | Selenium                |