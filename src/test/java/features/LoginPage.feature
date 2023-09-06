Feature: Test login functionality

  @Demo
  Scenario: Login with valid data
    When User enter valid username and password in login form
    And Clicks on Log in button

  @Demo
  Scenario: Login with invalid data
    When User enter invalid username and password in login form
    And Clicks on Log in button
    Then Verify that the username or password is invalid

