Feature: Positive Login Tests
  Scenario: User tries to log in with correct login and password

    Given user is on the login page
    When user enters correct login and password
    And clicks on the login button
    Then account welcome headline is displayed