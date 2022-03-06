Feature: Adding ad to memo as a favourite

  Background:
    Given Go to main page

  Scenario Outline: adding to favorite in inside the record

    Given Go to <text> category
    When Click by <jobName> job in <industry> industry
    And Open <adName> details
    And Add ad to favorite
    Then Check that ad added to favorite increase favorite count
    And Go to vacancies page
    When Click by <newJob> job in <newIndustry> industry
    And Open <newAdName> details
    And Add ad to favorite
    And Go to Favorite
    Then Check that ad added to favorite

    Examples:
      | text     | jobName   | industry                     | adName  | newJob | newIndustry     | newAdName         |
      | Вакансии | Операторы | Производство, промышленность | SIA A&A | Другое | Здравоохранение | RWS Life Sciences |

  Scenario Outline: adding ad to favorite by icon

    Given Go to <text> category
    When Click by <jobName> job in <industry> industry
    And Hover to <adName> record
    And Click to favorite icon
    Then Check that ad added to favorite increase favorite count
    And Open <adName> details
    And Go to Favorite
    Then Check that <jobName> ad one record added to favorite

    Examples:
      | text     | jobName   | industry                     | adName  |
      | Вакансии | Операторы | Производство, промышленность | SIA A&A |

  Scenario Outline: searching ad and add to favorite by icon

    Given Set <jobName> to search input
    And Hover to <jobName> record
    And Click to favorite icon
    Then Check that ad added to favorite increase favorite count
    And Open <jobName> details
    And Go to Favorite
    Then Check that <jobName> ad one record added to favorite

    Examples:
      | jobName                 |
      | Операторы               |
      | Участники анкетирования |