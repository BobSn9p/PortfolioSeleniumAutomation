Feature: Search for item test
  Scenario: User tries to search for an item

    Given user is on the landing page
    When user enters product name in searchbar
    And clicks on the search button
    Then valid product is displayed on search result list