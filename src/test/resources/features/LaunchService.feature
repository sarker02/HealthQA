Feature: Launch service environment

  @Smoke
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
