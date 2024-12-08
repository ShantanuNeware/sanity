Feature: Sanity Test for New Website

@Login_With_Password
	Scenario Outline: User is trying to perform Login
	Given User pastes the link in the browser and clicks on enter
		Then User click on Log In button
		Then User Click on UserID field
		Then Enter "<User ID>" userid
		Then Click On Next button
		Then Enter "<Password>" password
		Then Click On SignIn button

		
	Examples:
  | User ID 										| Password  	|
  | shantanu.neware04@GMAIL.COm | Password@190|

  