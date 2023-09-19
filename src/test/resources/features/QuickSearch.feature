Feature: Quick Search Feature Tests

  @Smoke
  Scenario: Search the following in search bar
    Given I am an Authenticated User
    And I navigate to the Solutions Portal
    When I perform search with keyword having more than three chracters
    Then I see list of expected records in search results
    And I click on the first user queried in the search list

  @Smoke 
  Scenario: Valid Search Query
    Given I am an Authenticated User
    When I select the quick search bar
    And I perform a search with a valid keyword
    Then I expect to see the correct results populated

  @Smoke
  Scenario: Invalid Search Query
    Given I am an Authenticated User
    When I select the quick search bar
    And I perform search with invalid keyword
    Then I expect to see no results found
