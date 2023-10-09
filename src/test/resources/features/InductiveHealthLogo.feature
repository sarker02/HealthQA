Feature: Inductive Health Feature Tests

  @Smoke 
  Scenario: Navigate to InductiveHealth Tutorials Page
    Given I am an authenticated user
    When Click on the profile icon from the top right corner
    Then Check All menu option is visible
    When Click on the Video Tutorials option
    Then Check InductiveHealth tutorials page is displayed
