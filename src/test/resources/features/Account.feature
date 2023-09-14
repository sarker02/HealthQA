Feature: Functionality of Forgot Password


@smoke @heal-02
Scenario: check the forgot password functionality
Given I am on the the landing page
When I navigate to the forgot password link
Then I expect their to be a Forgot Password Header
And I enter in my username
When I select Submit
Then  I expect to see