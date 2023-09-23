Feature: Complete Managment

  @smoke @Managment-01
  Scenario: Managment with User Activity
    Given I am an Authenticated User
    When I navigate to the <Selected Chart User Activity>
    When I Click the download button
    Then I expect their to be options to choose

    
     @smoke @Managment-02
  Scenario: Managment with Investigation Resolution
    Given I am an Authenticated User
    When I navigate to the <Selected Chart Investigation Resolution>
    When I Click the download button
    Then I expect their to be options to choose