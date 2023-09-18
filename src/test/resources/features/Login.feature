Feature: Login Feature Tests

  @Smoke @heal-01
  Scenario: Valid Login Credentials Scenario
    Given I am on the the login page
    When I enter valid username and valid password
    And I click on sign in button
    Then I expect to be signed on

  @Smoke
  Scenario: Invalid Login Credentials Scenario
    Given I am on the the login page
    When I enter invalid username and invalid password
    And I click on sign in button
    Then I expect to be see an invalid login text

  @functional
  Scenario: Forgot Password Scenario
    Given I am on the the login page
    When I navigate to the forgot password link
    Then I expect their to be a Forgot Password Header
    And I enter in my username
    When I click on Submit button
    Then I expect to be see a confirmation that password was sent to email