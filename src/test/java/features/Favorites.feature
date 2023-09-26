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

  #HEAL-14
  @Demo
  Scenario: Launch service environment
    Given I am an authenticated user
    When Click on the Surveillance NBS link
    Then Check NBS page is displayed
    When Click on the Surveillance ESSENCE link
    Then Check ESSENCE page is displayed
    When Click on the Surveillance EpiTrax link
    Then Check EpiTrax page is displayed
    When Click on the Surveillance Respond point of care link
    Then Check Respond point of care page is displayed

  #HEAL-17
  @Demo
  Scenario: After logout system will be on landing page
    Given I am an authenticated user
    When Click on the profile icon from the top right corner
    Then Check All menu option is visible
    When Click on the logout option
    Then Check logout popup is displayed
    When Click on the yes button
    Then Check landing page is displayed

  #HEAL-18
  @Demo
  Scenario: After logout system will be on home page
    Given I am an authenticated user
    When Click on the profile icon from the top right corner
    Then Check All menu option is visible
    When Click on the logout option
    Then Check logout popup is displayed
    When Click on the keep working button
    Then Check home page is displayed