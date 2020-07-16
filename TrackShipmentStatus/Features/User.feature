#Please Do not change Feature Templet
Feature: Track shipment status.
#Please Do not change Scenario Outline Templet
Scenario: Validate Shipment status and details with enrolled User Details.
    #Please Do not change Given Templet
	Given User loads the application and navigate to home page
	When User enters "Shamili" on the tracking page
    Then following should be displayed
    | Name | Shipment Id | Phone Number | E-mail |
    | Shamili | SHIP1236 | 9224158877 | shamili93@gamil.com |