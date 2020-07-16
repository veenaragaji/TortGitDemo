Feature: Test Login page feature 
Scenario: Verify login scenario. 

	Given user launch the url 
	When user enters following and click login 
		| username | password |
		| admin | admin |
		| user1 | passowrd1 |
	Then verify login is successful 
	
