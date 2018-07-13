Feature: Login Action

Scenario Outline: Successful Login with Valid Credentials
	Given user is on Home page
	When User Navigate to LogIn Page
	And User enters "<customer>" UserName and Password
	Then Message displayed Login Successfully
	
 Examples:
		|customer|
		|Lakshay|
Scenario Outline: Successful LogOut
	When User LogOut from the Application
	Then Message displayed LogOut Successfully
	
 Examples:
		|customer|
		|Lakshay|	