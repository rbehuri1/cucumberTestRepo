Feature: Automate End2End Tests
Description: The purpose of this feature is to test  End 2 End integration

		
		
Scenario Outline: Customer place an order by purchasing an item from search
		Given user is on Home page
		When user search for "dress"
		And choose "<customer>" to buy the first item
		And moves to  checkout  from mini cart
		And enter "<customer>" personal details on checkout page
		And select same delivery address
		And select payment as "check" payment
		And place an order
		Then verify the order details

		
Examples:
		|customer|
		|Lakshay|
		
