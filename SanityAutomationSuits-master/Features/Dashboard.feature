Feature: Dashboard sanity test

  
@Login_Dashboard
	Scenario Outline: User Is on Dashboard
	    Given User pastes the link in the browser and clicks on enter
    	Then User click on Log In button
			Then User Click on UserID field
			Then Enter "shantanu.neware04@GMAIL.COm" userid
			Then Click On Next button
			Then Enter "Password@190" password
			Then Click On SignIn button
			When user is on dashboard page
			Then Click on view portfolio button
			Then Click on view showScheme button
			Then Click on view expandScheme button
			Then check Values for investedamount
