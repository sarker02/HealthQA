Feature: Logout Feature Tests

  @Smoke 
  Scenario: After logout system will be on landing page
    Given I am an authenticated user
    When Click on the profile icon from the top right corner
    Then Check All menu option is visible
    When Click on the logout option
    Then Check logout popup is displayed
    When Click on the yes button
    Then Check landing page is displayed

  @Smoke 
  Scenario: After logout system will be on home page
    Given I am an authenticated user
    When Click on the profile icon from the top right corner
    Then Check All menu option is visible
    When Click on the logout option
    Then Check logout popup is displayed
    When Click on the keep working button
    Then Check home page is displayed
