#Please Do not change Scenario Outline Templet
Feature: DATAX Shipping Discount calculation.
#Please Do not change Scenario Outline Templet
Scenario Outline: Validate Shipping company doesn't offers discount for different weights and Distances.
    #Please Do not change Given Templet
	Given User navigates to DATAX shipping company home
	When User enters "<Weight>" and "<Distance>"
	Then The text "Datax shipping offers no discount" should be present
	Examples:
	| Weight | Distance |
	| 60 | 110 |
	| 50 | 150 |