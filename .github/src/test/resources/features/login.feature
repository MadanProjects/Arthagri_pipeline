Feature: Login Functionality

@smoke
  Scenario: User logs in with valid credentials
    Given user is on login page
    When user enters valid username and password
    Then user should be logged in successfully

@regression
Scenario: Invalid login
