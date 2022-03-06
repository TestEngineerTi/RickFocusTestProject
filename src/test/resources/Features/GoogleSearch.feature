Feature: Adding ad to memo as a favourite
  Background:
    Given Go to main page

  Scenario: validate google search is working

    Given Go to category
    When click by jobs name
#    When user enters a <text> in search box
    And open details
#    Then user is navigated ti search results
    And add ad to favorite
    Then check that ad added to favorite increase favorite count

#    Examples:
#      | text     |
#      | Вакансии |