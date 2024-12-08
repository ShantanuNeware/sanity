Feature: Post Login Folio Creation

  
@Login_FolioCreation
	Scenario Outline: User is trying to perform folio creation post Login
	Given User pastes the link in the browser and clicks on enter
	#	Then User click on Log In button
				Then User Click on UserID field
				Then Enter "<User ID>" userid
				Then Click On Next button
				Then Enter "<Password>" password
				Then Click On SignIn button
				When check user is on new dashboard page
				When user selects yes "<ZeroBalance>" for zero balance folio 
				Then Click on create folio button
				Then User Enters Mobile Number "<MobileNumber>" and click on Send OTP
#				Then User Enters Mobile Number OTP Manually
				Then User Enters Email "<Email>" and click on Send OTP
#				Then User Enters Email OTP Manually
				Then Enter PAN number "<PAN>" of Individual folio creation for resident Indian
				Then Click on verify link
				Then Click on Proceed Button
				Then Enter Account Number "<Account Number>" for Savings account
				Then Confirm Account Number "<Account Number>" for Savings account
				Then User enters IFSC code "<IFSC>"
				Then Click on Proceed Button for confirm bank details
				Then Select OptOut for Nominee
				Then Accept Terms for Opt Out Nominee
				Then Click on Nominee proceed buton
				Then click on Continue button for review details screen
								
Examples:
| User ID 										| Password  	|ZeroBalance|MobileNumber|Email|PAN|Account Number|IFSC|
|shantanu.neware04@GMAIL.Com|Password@190|YES|9860785071|shantanu.neware04@gmail.com|AKZPN5540R|50100081235401|HDFC0000501|
