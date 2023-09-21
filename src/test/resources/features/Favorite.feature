Feature: Favorite- intracting chart

  @smoke @favorites-01
  Scenario: Favorite-intracting with charts disease Analytic trends
    Given I am an Authenticated User
    When I navigate to the <Selected Chart>
    And I select the about this data option
    Then I expect their to be a text about the chart
    When I Click the download button
    Then I expect their to be options to choose

  @smoke @favorites-02
  Scenario: Favorite charts with Investigation Managment
    Given I am an Authenticated User
    When I navigate to the <Selected Chart Investigation Managment>
    And I select the about this data option
    Then I expect their to be a text about the chart
    When I Click the download button
    Then I expect their to be options to choose

    
     @smoke @favorites-03
  Scenario: Favorite charts with Investigation Managment
    Given I am an Authenticated User
    When I navigate to the <Selected Chart utilization dashboard>
    And I select the about this data option
    Then I expect their to be a text about the chart
    When I Click the download button
    Then I expect their to be options to choose