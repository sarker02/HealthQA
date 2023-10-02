Feature: Complete Analytics function

  @Smoke @insight-2
  Scenario: check Deasies Aynalytic trends
    
    Given I am an Authenticated User
    When I navigate to Disease Analytics & Trends
    Then I expect to see all filter selections visible
    And I select filtering with Event Date within Last Week
    Then I expect to see populated fields for every day
