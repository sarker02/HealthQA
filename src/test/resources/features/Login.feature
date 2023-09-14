Feature: Login Feature Tests

	@smoke @heal-01
  Scenario: Valid Login Credentials Scenario
    Given I am on the the login page
    When I enter username and password
    And I click on sign in button
    Then I expect to be signed on
