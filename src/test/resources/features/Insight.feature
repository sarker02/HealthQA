Feature: Insight Managment


@Smoke @insight-1  @Heal-16
Scenario: Insights - Investigation Management

Given I am an Authenticated User
When I navigate to Disease Analytics & Trends
Then I expect to see all filter selections visible
And I select filtering with Event Date within Last Week
Then I expect to see populated fields for every day
Then I expect to see matching investigation count same as matching count for Data Table
When I am on Data Table I expect to see dates same as dates provided in filter


