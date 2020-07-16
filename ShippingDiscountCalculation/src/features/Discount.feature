#Please Do not change Scenario Outline Templet
Feature: DATAX Shipping Discount calculation.
#Please Do not change Scenario Outline Templet
Scenario Outline: Validate Shipping company offers discount for different weights and Distances.
    #Please Do not change Given Templet
	Given User loads the application and navigate to DATAX shipping company home
	When User enters "<Weight>" and "<Distance>" on Company Offers Discount page
	Then The text "Datax shipping company offers discount" should be displayed
	Examples:
	| Weight | Distance |
	| 100 | 200 |
	| 80 | 500 |
	| 120 | 520 |
	| 300 | 200 |