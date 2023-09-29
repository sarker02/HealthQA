Feature: Favorite- intracting chart

 
  @smoke @insight-3
  Scenario: Favorite-intracting with charts
    Given I am an Authenticated User
    When I navigate to the "<Selected Chart>" "<Selected Insights>"
    And I select the about this data option
    Then I expect their to be a text about the chart
    When I Click the download button
    Then I expect their to be options to choose
    
     Examples: 
    | Selected Chart |                 | Selected Insights | 
    | Disease Analytics and Trends |   | Disease Surveillance | 
    | Investigation Management |       | Disease Surveillance | 
    | Utilization Dashboard |          | Disease Surveillance |
    | User Activity |                  | Management | 
		| Investigation Resolution |       | Management |
		| ESSENCE Alerts |                  | Syndromic Analytics |
		| ELR Flow Report |       | Message Flow |
		| ELR Data Quality |                  | Message Flow |
		
		
		
		