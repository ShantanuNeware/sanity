Feature: Sanity Test for New Website

@Transactions-LUMPSUM_with_UPI
	Scenario Outline: User Is on Dashboard and performing Lumpsum transaction
	Given User pastes the link in the browser and clicks on enter
	#	Then User click on Log In button
		Then User Click on UserID field
		Then Enter "<User ID>" userid
		Then Click On Next button
		Then Enter "<Password>" password
		Then Click On SignIn button
		Then Navigate to Transactions page
		Then Select Pan "<PAN>" Folio "<FOLIO>"
		Then click Invest tab
		Then Click Lumpsum Start
		Then Select Category "<Category>"
		Then Select Fund "<FUND>"
		Then Select Scheme Option "<Scheme Option>"
		Then Enter Amount "<Amount>"
		Then Click Proceed To Payment Lumpsum
#		Then Enter OTP for Lumpsum
	#	Then Click on Terms and condition
	#	Then Click on Continue
	#	Then Lumpsum Enter UPI ID "<UPI_ID>" and click on verify
	#	Then Click Proceed To Payment
		
	Examples:
  | User ID 										| Password  	| PAN 				| FOLIO  		|Category  |FUND 			|Scheme Option|Amount |UPI_ID|
  | shantanu.neware04@GMAIL.COm | Password@190| AKZPN5540R | 23665608 	|Debt Funds|Liquid Fund |Growth 		|100		|shantanu.neware04@okhdfcbank|

	@Transactions-SIP
	Scenario Outline: User Is on Dashboard and performing SIP transaction
	Given User pastes the link in the browser and clicks on enter
	#	Then User click on Log In button
	Then User Click on UserID field
	Then Enter "<User ID>" userid
	Then Click On Next button
	Then Enter "<Password>" password
	Then Click On SignIn button
	Then Navigate to Transactions page
	Then Select Pan "<PAN>" Folio "<FOLIO>"
	Then click Invest tab
	Then Click SIP Start
	Then Select Category "<Category>"
	Then Select Fund "<FUND>"
	Then Select Scheme Option "<Scheme Option>"
	Then Enter Amount "<Amount>"
	Then Click Proceed To Payment SIP
#	Then Enter OTP for SIP
#	Then Click on Terms and condition
#	Then Click on Continue
#	Then SIP Enter UPI ID "<UPI_ID>" and click on verify
#	Then Click Proceed To Payment
	
	Examples:
  | User ID 										| Password  	| PAN 				| FOLIO  		|Category  |FUND 			|Scheme Option|Amount |UPI_ID|
  | shantanu.neware04@gmail.com | Password@190| AKZPN5540R  | 23665608 	|Debt Funds|Liquid Fund |Growth 		|100		|shantanu.neware04@okhdfcbank|

@Transactions-REDEEM
	Scenario Outline: User Is on Dashboard and performing Redeem transaction
	Given User pastes the link in the browser and clicks on enter
	#	Then User click on Log In button
	Then User Click on UserID field
	Then Enter "<User ID>" userid
	Then Click On Next button
	Then Enter "<Password>" password
	Then Click On SignIn button
	Then Navigate to Transactions page
	Then Select Pan "<PAN>" Folio "<FOLIO>"
	Then click Withdraw tab
	Then Click Redeem Start
	Then user selects his fund as "<fund>"
	Then user selects Redeemmode "<redemptionMode>", "<redeemValue>" from cart menu and clicks on proceed
	Then user checks his bank details and clicks continue
	
		Examples:
  | User ID 										| Password  	| PAN 				| FOLIO  		|fund 																							| redemptionMode | redeemValue | payment |
  | shantanu.neware04@gmail.com | Password@190| AKZPN5540R  | 23665608 	|ICICI Prudential Liquid Fund - Direct Plan - Growth| amount          | 100        | ---     |
	
	@Transactions-SWITCH
	Scenario Outline: User Is on Dashboard and performing Switch transaction
	Given User pastes the link in the browser and clicks on enter
	#	Then User click on Log In button
	Then User Click on UserID field
	Then Enter "<User ID>" userid
	Then Click On Next button
	Then Enter "<Password>" password
	Then Click On SignIn button
	Then Navigate to Transactions page
	Then Select Pan "<PAN>" Folio "<FOLIO>"
	Then click Switch tab
	Then Click Switch Start
	Then user selects his fund as "<fund>"
	Then user selects mode for switch "<redemptionMode>" "<redeemValue>"
	Then user selects Category for switch "<Category>"
	Then user selects Category for switch "<FUND>"
	Then user selects Category for switch "<Scheme Option>"
	Then User Enters amount for switch "<redemptionMode>" "<redeemValue>"
	Then Click Continue for switch
	
		Examples:
	  | User ID                    | Password   | PAN        | FOLIO   			| fund                                                | redemptionMode| redeemValue | Category  |FUND 			 |Scheme Option|
	  | shantanu.neware04@gmail.com | Password@190| AKZPN5540R  | 23665608 	| ICICI Prudential Bluechip Fund - Direct Plan - Growth | amount				|100          |Debt Funds	|Liquid Fund |Growth |
