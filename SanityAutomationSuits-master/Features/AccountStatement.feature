Feature: Account Statement sanity test

  
@Login_AccountStatement
	Scenario Outline: User Is on Dashboard
	    Given User pastes the link in the browser and clicks on enter
    #	Then User click on Log In button
			Then User Click on UserID field
			Then Enter "shantanu.neware04@GMAIL.COm" userid
			Then Click On Next button
			Then Enter "Password@190" password
			Then Click On SignIn button
			Then check user is on dashboard page
			Then User click on Investor Services
			When check user is on InvestorServices Label
			Then User click on Get Account Statement Button
#			Then Select Pan "<PAN>" from Drop Down
#			Then Select Folio "<FOLIO>" From Drop Down
#			Then Select Download radio button for Statement
#			Then Click on Submit  Button
#			Then Click on Return To homepage button
			
			
Examples:
|PAN 			|FOLIO  |Category  |FUND 			|Scheme Option|Amount |UPI_ID|
|AKZPN5540R|18892758|Debt Funds|Liquid Fund |Growth 		|100		|shantanu.neware04@okhdfcbank|

