Feature: Category 

@run 
Scenario: Create category test 
	Given I login as an admin using api call 
	And I create a category using api call 
	And I open home page 
	And I login as an admin user 
 