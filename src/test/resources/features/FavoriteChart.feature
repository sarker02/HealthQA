Feature: Favorite Charts

  @Smoke 
  Scenario: Verify no Charts are in Favorite Page
    Given I am an authenticated user
    When I navigate to the Favorite Page
    Then I expect there are no favorite charts and the system display a text

  @Smoke
  Scenario: Verify Charts are in Favorite Page
    Given I am an authenticated user
    When I navigate to Selected Chart page and click on the favorite Icon
    Then I expect the Favorite Start icon to be highlighted
    When I navigate to the Favorite home page
    Then I see the favorite chart that was previously favorite to be visible on the favorites page

  @Smoke
  Scenario: Verify that Remove all Favorite charts from the Favorite Page
    Given I am an authenticated user
    When I navigate to the Favorite Page
    And Remove all favorite charts from the favorites page
    Then I expect there are no favorite charts and the system display a text
