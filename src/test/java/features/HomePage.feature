Feature: Home Page activities
  Background:
    When User enter valid username and password in login form
    And Clicks on Log in button

  @Demo
  Scenario: Navigate to Home Page
    Given User opens chrome browser and navigates to the url
    Then Home page should be loaded

  @Demo
  Scenario: Verify Charts are in Favorite Page
    Given I am an authenticated user
    Then Home page should be loaded
    And Verify that initially there are no favorites charts displayed
