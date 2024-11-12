Feature: Negative Login Tests
  Scenario: User tries to log in with incorrect login and password

    Given user is on the login page
    When user enters incorrect login and password
    And clicks on the login button
    Then invalid login message is displayed

  Scenario: User tries to log in without entering a username

    Given user is on the login page
    When user enters only a valid password
    And clicks on the login button
    Then invalid login message is displayed

  Scenario: User tries to log in without entering a password
    
    Given user is on the login page
    When user enters only a valid username
    And clicks on the login button
    Then invalid login message is displayed

