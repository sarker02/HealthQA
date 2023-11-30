Feature: Alert Interface Test

  @Smoke 
  Scenario: Verify Alerts Interface is visible in bell icon
    Given I am an authenticated user
    When Create at least one alert
    And  I navigate to the Favorite Page
    When Click on the notification button
    Then Verify alert interface is visible
