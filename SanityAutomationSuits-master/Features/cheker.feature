Feature: Validation of check if bdd setup is done right
  
	
  @Pre-login
  Scenario: user is navigating to ICICI website using pre login
	Given User pastes the link in the browser according to the environment clicks on enter
	Then user provides username
	Then user provides password
	Then user clicks on sign in
	Then user is redirected to ICICI homepage	