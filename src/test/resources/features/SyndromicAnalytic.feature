Feature: Check Syndromic Analytics

  @smoke @Analytics-01
  Scenario: complete The Syndronic Analytics with ESSENCE Alerts
    Given I am an Authenticated User
    When I navigate to the <Selected Chart ESSENCE Alerts>
    When I Click the download button
    Then I expect their to be options to choose
