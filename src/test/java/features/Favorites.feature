Feature: Home Page activities
  Background:
    When User enter valid username and password in login form
    And Clicks on Log in button

  @Demo
  Scenario: Navigate to Home Page
    Given User opens chrome browser and navigates to the url
    Then Home page should be loaded

  #HEAL-10-1
  @Demo
  Scenario: Verify no Charts are in Favorite Page
    Given I am an authenticated user
    When I navigate to the Favorite Page
    Then I expect there are no favorite charts and the system display a text

    #HEAL-10-2
  @Demo
  Scenario: Verify Charts are in Favorite Page
    Given I am an authenticated user
    When I navigate to Selected Chart page and click on the favorite Icon
    Then I expect the Favorite Start icon to be highlighted
    When I navigate to the Favorite home page
    Then I see the favorite chart that was previously favorite to be visible on the favorites page

  #HEAL-11
  @Demo
  Scenario: Verify that Remove all Favorite charts from the Favorite Page
    Given I am an authenticated user
    When I navigate to the Favorite Page
    And Remove all favorite charts from the favorites page
    Then I expect there are no favorite charts and the system display a text

  #HEAL-13
  @Demo
  Scenario: Verify Alerts Interface is visible in bell icon
    Given I am an authenticated user
    When Create at least one alert
    And I navigate to the Favorite Page
    And Click on the notification button
    Then Verify alert interface is visible