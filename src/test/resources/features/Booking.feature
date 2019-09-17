Feature: Booking 


@run 
Scenario: Create a booking when we have a single item 2 
	Given I login as an admin using api call 
	And I create a category using api call 
	And I create an item inside the category using api call 
	And I open home page 
	And I login as an admin user 
	When I book the items from last category
	#Then I validate the booked items 
	

@skipTest 
Scenario: Create a booking when we have multiple items 
	Given I login as an admin using api call 
	And I create a category using api call 
	And I create an item inside the category using api call 
	And I create a category using api call 
	And I create an item inside the category using api call 
	And I open home page 
	And I login as an admin user 
	When I book the items from last category 
	Then I validate the booked items 
	
@skipTest 
Scenario: Create a booking when we have a single item 1 
	Given I login as an admin using api call 
	And I create a category using api call 
	And I create an item inside the category using api call 
	And I open home page 
	And I login as an admin user 
	When I book the items from last category 
	Then I validate the booked items 
	
	
@skipTest 
Scenario: Create a booking when we have multiple items 
	Given I login as an admin using api call 
	And I create a category using api call 
	And I create an item inside the category using api call 
	And I create a category using api call 
	And I create an item inside the category using api call 
	And I open home page 
	And I login as an admin user 
	When I book the items from last category 
	Then I validate the booked items 
	 