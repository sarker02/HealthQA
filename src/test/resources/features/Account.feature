Feature: Account Management Feature Tests

  Scenario: check the forgot password functionality
    Given I am on the the login page
    When I navigate to the forgot password link
    Then I expect their to be a Forgot Password Header
    And I enter in my username
    When I click on Submit button
    Then I expect to be see a confirmation that password was sent to email
