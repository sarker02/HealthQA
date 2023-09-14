Feature: Functionality of search bar

  @smoke @heal-03
  Scenario: search the following in search bar
    Given I am an Authenticated User
    And I navigate to the Solutions Portal
    When I search up results in the Quick Search Results more than 3 Characters
    Then I see list of Expected result queries
    And I click on the first user queried in the search list

  @smoke @heal-04
  Scenario: Valid Search Query
    Given I am an Authenticated User
    When I Select the Quick Search Bar
    And I search for the following (People, Investigation, Lab Reports (ALL SEPARATELY)
    Then I Expect to see the results populated accordingly above 1 search

  @smoke @heal-05
  Scenario: invalid Search Query
    Given I am an Authenticated User
    When I Select the Quick Search Bar
    And I search for the following (People, Investigation, Lab Reports (ALL SEPARATELY) {ENTER RANDOM CHARACTER STRING}
    Then I Expect to see the �No Result Found� in quick search query
