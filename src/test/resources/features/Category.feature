Feature: Category 

@skipTest 
Scenario: Create category test 
	Given I login as an admin using api call 
	And I create a category using api call 
	And I open home page 
	And I login as an admin user 
	
@skipTest 
Scenario: Success scenario 
	Given I login as an admin using api call 
	And I pass the scenario 
	
@skipTest 
Scenario: Fail scenario 
	Given I login as an admin using api call 
	And I fail the scenario 
	 