#Please Do not change Feature Templet
Feature: Calculating Trasportation cost
#Please Do not change Scenario Outline Templet

Scenario: Calculate Shipping Cost by air
#Please Do not change Given Templet
Given I have navigated to shipping application home page
When I enter "100" and select "Air" Transport mode
Then I validate the message with total shipping cost

Scenario: Calculate Shipping Cost by ship
#Please Do not change Given Templet
Given I have navigated to shipping application home page
When I enter "100" and select "Ship" Transport mode
Then I validate the message with total shipping cost

Scenario: Calculate Shipping Cost by road
#Please Do not change Given Templet
Given I have navigated to shipping application home page
When I enter "100" and select "Road" Transport mode
Then I validate the message with total shipping cost