Feature: complete Message Flow

  @Smoke @messageflow-01
  Scenario: Message Flow with ELR Report
    Given I am an Authenticated User
    When I navigate to the <Selected Chart ELR Report>
    When I Click the download button
    Then I expect their to be options to choose

  @Smoke @messageflow-02
  Scenario: Message Flow with ELR Report
    Given I am an Authenticated User
    When I navigate to the <Selected Chart ELR Data Quality>
    When I Click the download button
    Then I expect their to be options to choose
