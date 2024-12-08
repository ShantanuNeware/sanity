Feature: Validation of check if bdd setup is done right
  
  Background: Prelogin to the iPru website
	Given user has passed valid credentials on pre login page
  
  @UserRegistration
  Scenario Outline: User is Registering in the iPru website when cams is up
	Given user is already passed the pre login page and is on homepage
	Then user clicks on Sign in button
	Then user clicks on registers button on signin  register page
	Then user clicks on register button  and is shown a register page
	Then user provides his name as "<fullname>"
	Then user provides his email id as "<emailid>"
	Then user clicks on send OTP button
	Then user provides six digit OTP on page
	Then user sets his "<mobile>" phone number
	Then user clicks on send OTP button
	Then user provides six digit OTP on page
	Then accepts terms and conditions
	Then user clicks on continue button
	When user sees set password screen
	Then user enters his desired new password
	Then user confirms his password
	Then user clicks on continue
 
	@QA
	Examples:
	  | fullname   | emailid                 | mobile     |
	  | Automation | sendemailotp2@gmail.com | 7381670585 |
  
	@UAT
	Examples:
	  | fullname   | emailid                 | mobile     |
	  | Automation | sendemailotp2@gmail.com | 7381670585 |
  
  
  @UserRegistrationAndFolioCreation
  Scenario Outline: User is Registering in the iPru website when cams is up
	Given user is already passed the pre login page and is on homepage
	Then user clicks on Sign in button
	Then user clicks on registers button on signin  register page
	Then user clicks on register button  and is shown a register page
	Then user provides his name as "<fullname>"
	Then user provides his email id as "<emailid>"
	Then user clicks on send OTP button
	Then user provides six digit OTP on page
	Then user sets his "<mobile>" phone number
	Then user clicks on send OTP button
	Then user provides six digit OTP on page
	Then accepts terms and conditions
	Then user clicks on continue button
	When user sees set password screen
	Then user enters his desired new password
	Then user confirms his password
	Then user clicks on continue
	Then user updates his contact details belongs to "<contactDetails>"
	Then user provides Primary Pan Number as "<primaryPanNumber>" on the page
	Then user clicks on verifyPan button
	Then user clicks on get otp to verify the primary pan number
	Then user provides six digit OTP on page
	Then user clicks on continue
	Then user is redirected to KYC Register Homepage after verification and clicks on proceed
	Then user clicks on continue on setup your account page
	Then user selects bank as "<bankName>" on bank detail page
	Then user enters account number on bank detail page
	Then user confirms account number on bank detail page
	Then user provides ifsc code as "<ifscCode>" on bank detail page
	Then user clicks on proceed button present in Bank details page
	Then nominee page is displayed
	Then user enters his "<nomineeName>"
	Then user enters his relation with nominee as "<relation>"
	Then users sets birth date of nominee as "<birthDate>"
	Then user clicks on proceed button on nominee page
	Then user clicks on continue button after verifying his submitted details
	Then user verify that Folio Number is generated successfully
	Then user clicks proceed to checkout button
	Then user is in transaction screen
 
	@QA
	Examples:
	  | fullname   | emailid                | mobile     | primaryPanNumber | contactDetails | bankName       | ifscCode    | nomineeName | relation | birthDate  |
	  | Automation | sendemailotp@gmail.com | 9535785676 | VUGPR8049L       | Spouse         | ICICI BANK LTD | ICIC0002447 | data        | Daughter | 20/03/1999 |
  
	@UAT
	Examples:
	  | fullname   | emailid                | mobile     | primaryPanNumber | contactDetails | bankName       | ifscCode    | nomineeName | relation | birthDate  |
	  | Automation | sendemailotp@gmail.com | 9535785676 | VUGPR8049L       | Spouse         | ICICI BANK LTD | ICIC0002447 | data        | Daughter | 20/03/1999 |
  
  
  @SignInAndTransact
  Scenario Outline: User SignIn to iPru website using email and password and does lump sum with UPI transaction
	Given user is already passed the pre login page and is on homepage
	Then user clicks on Sign in button
	Then user provides userId as "<userId>"
	Then user clicks on Next button
	Then user provides password as "<password>"
	Then user clicks on SignIn button after entering username and password
#	Then user verifies SignIn successfully
	Then user is redirected to transaction page
	When user is in transaction page
	Then user selects his PAN as "<PAN>" , Folio as "<folio>"
	Then user selects lumpsum transaction
	When user is in schemes page
	Then user is selects "<allCategories>","<selectFund>","<selectSchemeOption>","<payout>" , provides amount as "<amount>"
	Then user clicks on proceed button on investment details page
	When user is in otp page
	Then user provides otp and checks terms and condition
	When user is in payment page
	Then user proceeds to do UPI transaction using UPI id as "<UPI_ID>"
	Then user is in transaction receipt page for verification of folio number as "<folio>" and payment method as "<payment>"
	
	@UAT
	Examples:
	  | userId                      | password   | PAN        | folio   | allCategories | selectFund  | selectSchemeOption | payout | amount | UPI_ID           | payment |
	  | saurav.behera@capgemini.com | Demo@12345 | VUGPR8049L | 7678096 | Liquid Funds  | Liquid Fund | Growth             |        | 1000   | success@razorpay | UPI     |
  
  
  @SignInAndTransact
  Scenario Outline: User SignIn to iPru website using email and password and does lump sum with a new mandate creation
	Given user is already passed the pre login page and is on homepage
	Then user clicks on Sign in button
	Then user provides userId as "<userId>"
	Then user clicks on Next button
	Then user provides password as "<password>"
	Then user clicks on SignIn button after entering username and password
#	Then user verifies SignIn successfully
	Then user is redirected to transaction page
	When user is in transaction page
	Then user selects his PAN as "<PAN>" , Folio as "<folio>"
	Then user selects lumpsum transaction
	When user is in schemes page
	Then user is selects "<allCategories>","<selectFund>","<selectSchemeOption>","<payout>" , provides amount as "<amount>"
	Then user clicks on proceed button on investment details page
	When user is in otp page
	Then user provides otp and checks terms and condition
	When user is in payment page
	Then user selects Create New Auto Mandate from mandate section and creates a mandate of "<amount>"
	Then user is redirected to ICICI payment page
	Then user is in transaction receipt page for verification of folio number as "<folio>" and payment method as "<payment>"
 
	@UAT
	Examples:
	  | userId                      | password   | PAN        | folio   | allCategories | selectFund  | selectSchemeOption | payout | amount | payment         |
	  | saurav.behera@capgemini.com | Demo@12345 | VUGPR8049L | 7678096 | Liquid Funds  | Liquid Fund | Growth             |        | 1      | Autopay Mandate |
  
  @SignInAndTransact
  Scenario Outline: User SignIn to iPru website using email and password and does lump sum with already created mandate
	Given user is already passed the pre login page and is on homepage
	Then user clicks on Sign in button
	Then user provides userId as "<userId>"
	Then user clicks on Next button
	Then user provides password as "<password>"
	Then user clicks on SignIn button after entering username and password
#	Then user verifies SignIn successfully
	Then user is redirected to transaction page
	When user is in transaction page
	Then user selects his PAN as "<PAN>" , Folio as "<folio>"
	Then user selects lumpsum transaction
	When user is in schemes page
	Then user is selects "<allCategories>","<selectFund>","<selectSchemeOption>","<payout>" , provides amount as "<amount>"
	Then user clicks on proceed button on investment details page
	When user is in otp page
	Then user provides otp and checks terms and condition
	When user is in payment page
	Then user selects already Mandate from mandate section and selects "<amount>"
	Then user is in transaction receipt page for verification of folio number as "<folio>" and payment method as "<payment>"
 
	@UAT
	Examples:
	  | userId                      | password   | PAN        | folio   | allCategories | selectFund  | selectSchemeOption | payout | amount | payment         |
	#  | testuiautomation@gmail.com | Dzire@2020 | VUGPR8049L | 49539755 | Equity Funds  | Fmcg Fund  | Dividend           | Payout | 12345  |
	  | saurav.behera@capgemini.com | Demo@12345 | VUGPR8049L | 7678096 | Liquid Funds  | Liquid Fund | Growth             |        | 1      | Autopay Mandate |
  
  @SignInAndTransact
  Scenario Outline: User SignIn to iPru website using email and password and does lump sum with net banking
	Given user is already passed the pre login page and is on homepage
	Then user clicks on Sign in button
	Then user provides userId as "<userId>"
	Then user clicks on Next button
	Then user provides password as "<password>"
	Then user clicks on SignIn button after entering username and password
#	Then user verifies SignIn successfully
	Then user is redirected to transaction page
	When user is in transaction page
	Then user selects his PAN as "<PAN>" , Folio as "<folio>"
	Then user selects lumpsum transaction
	When user is in schemes page
	Then user is selects "<allCategories>","<selectFund>","<selectSchemeOption>","<payout>" , provides amount as "<amount>"
	Then user clicks on proceed button on investment details page
	When user is in otp page
	Then user provides otp and checks terms and condition
	When user is in payment page
	Then user selects net banking as payment mode
	Then user is redirected to ICICI payment page
	Then user is in transaction receipt page for verification of folio number as "<folio>" and payment method as "<payment>"
 
	@UAT
	Examples:
	  | userId                      | password   | PAN        | folio   | allCategories | selectFund  | selectSchemeOption | payout | amount | payment     |
	#  | testuiautomation@gmail.com | Dzire@2020 | VUGPR8049L | 49539755 | Equity Funds  | Fmcg Fund  | Dividend           | Payout | 12345  |
	  | saurav.behera@capgemini.com | Demo@12345 | VUGPR8049L | 7678096 | Liquid Funds  | Liquid Fund | Growth             |        | 1      | Net Banking |
  
  @SignIn
  Scenario Outline: User SignIn to iPru website using email and otp
	Given user is already passed the pre login page and is on homepage
	Then user clicks on Sign in button
	Then user provides userId as "<userId>"
	Then user clicks on Next button
	Then user clicks on SignIn using Otp
	Then user selects email radiobutton for otp
	Then user clicks on sendOTP button on SignIn Page
	Then user enters six digit OTP
	Then user clicks on SignIn button after entering username and otp
#	Then user verifies SignIn successfully
 
	@UAT
	Examples:
	  | userId                     |
	  | testuiautomation@gmail.com |
  
  @SignIn
  Scenario Outline: User SignIn to iPru website using mobile otp
	Given user is already passed the pre login page and is on homepage
	Then user clicks on Sign in button
	Then user provides userId as "<userId>"
	Then user clicks on Next button
	Then user clicks on SignIn using Otp
	Then user selects mobile radiobutton for otp
	Then user clicks on sendOTP button on SignIn Page
	Then user enters six digit OTP
	Then user clicks on SignIn button after entering username and otp
#	Then user verifies SignIn successfully
 
 
	@UAT
	Examples:
	  | userId                     |
	  | testuiautomation@gmail.com |
  
  @Tools
  Scenario Outline: User is verifying goal planner on Tools page
	Given user is already passed the pre login page and is on homepage
	Then user clicks on Tools button
	Then user is already in tools tab
	Then user verifies that goal planner is visible
	Then user is in GoalPlanner
	Then user enters his full name as "<fullName>"
	Then the user clicked on the Next button
	Then user enters his Annual income as "<annualIncome>"
	Then the user clicked on the Next button
	Then user enters his Goal Cost as "<goalCost>"
	Then the user clicked on the Next button
	Then user enters his Age as "<hisAge>"
	Then the user clicked on the Next button
	Then user enters his Target Age as "<hisTargetAge>"
	Then the user clicked on the Next button
	Then user enters his saved Amount as "<amountSaved>"
	Then the user clicked on the Next button
	Then user entered HighRisk
	Then the user clicked on the Next button
	Then user clicked Done
 
	Examples:
	  | fullName     | annualIncome | goalCost | hisAge | hisTargetAge | amountSaved |
	  | UIAutomation | 650000       | 6000000  | 26     | 60           | 100         |
  
  @Tools
  Scenario: User is verifying Returns calculator on tools page
	Given user is already passed the pre login page and is on homepage
	Then user clicks on Tools button
	Then user is already in tools tab
	Then user verifies that basic calculator button is visible
	Then user clicked BasicCalculator
	Then user clicked BackButton
  
  @Tools
  Scenario: User is verifying Investment Simulator calculator on tools page
	Given user is already passed the pre login page and is on homepage
	Then user clicks on Tools button
	Then user is already in tools tab
	Then user verifies that advanced calculator button is visible
	Then user clicked AdvancedCalculator
	Then user clicked BackButton
  
  
  @Tools
  Scenario: User is verifying calculate button on tools page
	Given user is already passed the pre login page and is on homepage
	Then user clicks on Tools button
	Then user is already in tools tab
	Then user verifies that calculate button is visible
	Then user clicked Calculate
	Then user enters his first thought
	Then user clicked ContinueCalculate
	Then user enters his view on risk
	Then user clicked ContinueCalculate
	Then user clicked on Salaried Employee
	Then user clicked ContinueCalculate
	Then user enters his Risk percentage
	Then user clicked ContinueCalculate
	Then user enters his Performance Expectation
	Then user clicked ContinueCalculate
	Then user clicked on UnderPerformed
	Then user clicked ContinueCalculate
	Then user clicked on DemographicScore
	Then user clicked ContinueCalculate
	Then user clicked on AssetAllocation
	Then user clicked Done
  
  @Tools
  Scenario Outline: User is verifying customized goal on tools page
	Given user is already passed the pre login page and is on homepage
	Then user clicks on Tools button
	Then user is already in tools tab
	Then user verifies that customize goal button is visible
	Then user clicked on CustomizeGoal
	Then user enters his full name as "<fullName>"
	Then the user clicked on the Next button
	Then user enters his Annual income as "<annualIncome>"
	Then the user clicked on the Next button
	Then user enters his Goal Cost as "<goalCost>"
	Then the user clicked on the Next button
	Then user enters his Age as "<hisAge>"
	Then the user clicked on the Next button
	Then user enters his Target Age as "<hisTargetAge>"
	Then the user clicked on the Next button
	Then user enters his saved Amount as "<amountSaved>"
	Then the user clicked on the Next button
	Then user entered HighRisk
	Then the user clicked on the Next button
	Then user clicked Done
	Examples:
	  | fullName     | annualIncome | goalCost | hisAge | hisTargetAge | amountSaved |
	  | UIAutomation | 650000       | 6000000  | 26     | 60           | 100         |
  
  @Tools
  Scenario: User is verifying investment plans on tools page
	Given user is already passed the pre login page and is on homepage
	Then user clicks on Tools button
	Then user is already in tools tab
	Then user clicked on Child Education
	Then user clicks on CloseIcon
	Then user clicked on Child Marriage
	Then user clicks on CloseIcon
	Then user clicked on Holiday
	Then user clicks on CloseIcon
	Then user clicked on Home
	Then user clicks on CloseIcon
	Then user clicked on WealthCreation
	Then user clicks on CloseIcon
	Then user clicked on Retirement
	Then user clicks on CloseIcon
  
  @Tools
  Scenario: User is verifying risk appetite calculator on tools page
	Given user is already passed the pre login page and is on homepage
	Then user clicks on Tools button
	Then user is already in tools tab
	Then user verifies that risk appetite calculator button is visible
	Then user clicked ButtonCalculate
	Then user enters his first thought
	Then user clicked ContinueCalculate
	Then user enters his view on risk
	Then user clicked ContinueCalculate
	Then user clicked on Salaried Employee
	Then user clicked ContinueCalculate
	Then user enters his Risk percentage
	Then user clicked ContinueCalculate
	Then user enters his Performance Expectation
	Then user clicked ContinueCalculate
	Then user clicked on UnderPerformed
	Then user clicked ContinueCalculate
	Then user clicked on DemographicScore
	Then user clicked ContinueCalculate
	Then user clicked on ShowFunds
  
  @Insights
  Scenario Outline: User navigation in Insights page
	Given user is already passed the pre login page and is on homepage
	Then on homepage user clicks on section - Learn
	Then under Knowledge Center user clicks on option - Explore ALL
	When user is on Knowledge Center page
	Then user clicks on section - Videos, Podcasts & Articles
	Then user navigates back to Learn section by clicking on section - Learn
	When user is on Learn page
	Then user navigates to FAQ page by clicking option - VIEW ALL
	Then user navigates back to Learn section by clicking on section - Learn
	When user is on Learn page
	Then user is able to consult an expert by providing "<Mobile>" & clicking on option - ASK EXPERT
	
	Examples:
	  | Mobile     |
	  | 6161616161 |
  
  @Support
  Scenario: User is verifying customer care on Support page
	Given user is already passed the pre login page and is on homepage
	Then user clicks on support button
	Then user is already in support tab
	Then user clicked on customer care tab
	Then user verifies that details of customer care button are visible
  
  @Support
  Scenario: User is verifying our offices on Support page
	Given user is already passed the pre login page and is on homepage
	Then user clicks on support button
	Then user is already in support tab
	Then user clicked on our offices tab
	Then user verifies that details of our offices tab are visible
  
  @Support
  Scenario: User is verifying escalations on Support page
	Given user is already passed the pre login page and is on homepage
	Then user clicks on support button
	Then user is already in support tab
	Then user clicked on escalations tab
	Then user verifies that details of escalations tab are visible
  
  @Support
  Scenario: User is verifying corporate information on Support page
	Given user is already passed the pre login page and is on homepage
	Then user clicks on support button
	Then user is already in support tab
	Then user clicked on corporate information tab
	Then user verifies that details of corporate information tab are visible
  
  @Support
  Scenario: User is verifying pre login on Support page
	Given user is already passed the pre login page and is on homepage
	Then user clicks on support button
	Then user is already in support tab
	Then user verifies that pre login card is visible
  
  @Support
  Scenario: User is verifying post login on Support page
	Given user is already passed the pre login page and is on homepage
	Then user clicks on support button
	Then user is already in support tab
	Then user verifies that post login card is visible
  
  @Support
  Scenario: User is verifying third party on Support page
	Given user is already passed the pre login page and is on homepage
	Then user clicks on support button
	Then user is already in support tab
	Then user verifies that third party card is visible
  
  @Support
  Scenario: User is verifying branch locator on Support page
	Given user is already passed the pre login page and is on homepage
	Then user clicks on support button
	Then user is already in support tab
	Then user clicks on branch locator button
	Then user verifies that branch locator button is visible
  
  @Support
  Scenario: User is verifying calculators on Support page
	Given user is already passed the pre login page and is on homepage
	Then user clicks on support button
	Then user is already in support tab
	Then user clicks on calculators button
	Then user verifies that calculators button details are visible
  
  @Support
  Scenario Outline: User is verifying contact us button on Support page
	Given user is already passed the pre login page and is on homepage
	Then user clicks on support button
	Then user is already in support tab
	Then user clicks on existing customer checkbox
	Then user entered his full Name as "<hisFullName>"
	Then user enters his email id as "<email>"
	Then user clicked on send OTP button
	Then user provides six digits OTP on page
	Then user verifies the successful OTP verification one
	Then user enters his contact number as "<contactNumber>"
	Then user clicked on send OTP button
	Then user provides six digits OTP on page
	Then user verifies the successful OTP verification two
	Then user selects his city and state
	Then user selects reason for contact
	Then user selects his subject
	Then user enters his message "<hisMessage>"
	Then user clicks in the terms and conditions
	Then user clicks on submit
	Then user verifies the submitted request
	Examples:
	  | hisFullName  | email              | contactNumber | hisMessage                   |
	  | uiAutomation | sendmail@gmail.com | 9876543210    | verifyingtheuiautomationtask |
  
  @Support
  Scenario: User is verifying download on Support page
	Given user is already passed the pre login page and is on homepage
	Then user clicks on support button
	Then user is already in support tab
	Then user clicks on download button
	Then user verifies that download button details are visible
	Then user clicks on forms
	Then user clicks on each sub tabs of forms
	Then user verifies the apply button applicability
	Then user clicks on sidkimsai
	Then user clicks on each sub tabs of sidkimsai
	Then user verifies the apply button applicability
	Then user clicks on others
	Then user verifies others tab is displayed
  
  @Support
  Scenario: User is verifying our funds on Support page
	Given user is already passed the pre login page and is on homepage
	Then user clicks on support button
	Then user is already in support tab
	Then user clicks on our funds button
	Then user verifies that our funds button details are visible
  
  @Support
  Scenario: User is verifying knowledge center on Support page
	Given user is already passed the pre login page and is on homepage
	Then user clicks on support button
	Then user is already in support tab
	Then user clicks on knowledge center button
	Then user verifies that knowledge center button details are visible
  
  @Support
  Scenario: User is verifying investor services on Support page
	Given user is already passed the pre login page and is on homepage
	Then user clicks on support button
	Then user is already in support tab
	Then user clicks on investor services button
	Then user verifies that investor services button details are visible
  
  @Support
  Scenario: User is verifying FAQs on Support page
	Given user is already passed the pre login page and is on homepage
	Then user clicks on support button
	Then user is already in support tab
	Then user clicks on FAQs button
  
  @Support
  Scenario Outline: User is verifying consult our experts on Support page
	Given user is already passed the pre login page and is on homepage
	Then user clicks on support button
	Then user is already in support tab
	Then user clicks on consult an expert by providing "<Mobile>" & clicking on option - ASK EXPERT
	Examples:
	  | Mobile     |
	  | 6161616161 |
  
  @Support
  Scenario: User is verifying explore services on Support page
	Given user is already passed the pre login page and is on homepage
	Then user clicks on support button
	Then user is already in support tab
	Then user clicks on explore button
	Then user verifies that explore button details are visible
  
  @SignInAndTransact
  Scenario Outline: User SignIn to iPru website using email and password and does sip with mandate
	Given user is already passed the pre login page and is on homepage
	Then user clicks on Sign in button
	Then user provides userId as "<userId>"
	Then user clicks on Next button
	Then user provides password as "<password>"
	Then user clicks on SignIn button after entering username and password
	Then user is redirected to transaction page
	When user is in transaction page
	Then user selects his PAN as "<PAN>" , Folio as "<folio>"
	Then user selects Sip transaction
	When user is in schemes page
	Then user is selects "<allCategories>","<selectFund>","<selectSchemeOption>","<payout>" , provides amount as "<amount>"
	#Then user selects "<frequency>" ,"<startDate>" ,"<endDate>" ,"<payRightAway>","<topUp>","<TopMode>","<percentage>","<topUpAmount>","<topUpFrequency>"
	Then user clicks on proceed button on investment details page
	When user is in otp page
	Then user provides otp and checks terms and condition
	When user is in payment page
	Then user selects already Mandate from mandate section and selects "<amount>"
	Then user is in transaction receipt page for verification of folio number as "<folio>" and payment method as "<payment>"
 
	@UAT
	Examples:
	  | userId                      | password   | PAN        | folio   | allCategories | selectFund | selectSchemeOption | payout | amount | mAmount | payment         |
	#  | testuiautomation@gmail.com | Dzire@2020 | VUGPR8049L | 49539755 | Equity Funds  | Fmcg Fund  | Dividend           | Payout | 12345  | success@razorpay | UPI     |
	  | saurav.behera@capgemini.com | Demo@12345 | VUGPR8049L | 7678096 | Equity Funds  | Fmcg Fund  | Dividend           | Payout | 12345  | 80000   | Autopay Mandate |
  
  
  @SignInAndTransact
  Scenario Outline: User SignIn to iPru website using email and password and does Booster sip with mandate
	Given user is already passed the pre login page and is on homepage
	Then user clicks on Sign in button
	Then user provides userId as "<userId>"
	Then user clicks on Next button
	Then user provides password as "<password>"
	Then user clicks on SignIn button after entering username and password
	Then user is redirected to transaction page
	When user is in transaction page
	Then user selects his PAN as "<PAN>" , Folio as "<folio>"
	Then user clicks on proceed button on Booster Sip transaction
	When user is in schemes page
	Then user is selects "<allCategories>","<selectFund>","<selectSchemeOption>","<payout>" , provides amount as "<amount>"
	#Then user selects "<frequency>" ,"<startDate>" ,"<endDate>" ,"<payRightAway>","<topUp>","<TopMode>","<percentage>","<topUpAmount>","<topUpFrequency>"
	Then user selects STP details "<selectFundCategory>", "<selectFund2>","<schemeOption>", "<multiplier>","<targetAmount>"
	Then user clicks on proceed button on investment details page
	When user is in otp page
	Then user provides otp and checks terms and condition
	When user is in payment page
	Then user selects already Mandate from mandate section and selects "<mAmount>"
	Then user is in transaction receipt page for verification of folio number as "<folio>" and payment method as "<payment>"
 
	@UAT
	Examples:
	  | userId                      | password   | PAN        | folio   | allCategories | selectFund           | selectSchemeOption | payout | amount | mAmount | selectFundCategory | selectFund2     | schemeOption | multiplier | targetAmount | payment         |
	#  | testuiautomation@gmail.com | Dzire@2020 | VUGPR8049L | 49539755 | Equity Funds  | Fmcg Fund  | Dividend           | Payout | 12345  | success@razorpay | UPI     |
	  | saurav.behera@capgemini.com | Demo@12345 | VUGPR8049L | 7678096 | Equity Funds  | Large & Mid Cap Fund | Growth             |        | 1000   | 80000   | Debt Funds         | Short Term Fund | Growth       | 8x         | 12000        | Autopay Mandate |
  
  
  @SignInAndTransact
  Scenario Outline: User SignIn to iPru website using email and password and does Freedom sip with mandate
	Given user is already passed the pre login page and is on homepage
	Then user clicks on Sign in button
	Then user provides userId as "<userId>"
	Then user clicks on Next button
	Then user provides password as "<password>"
	Then user clicks on SignIn button after entering username and password
	Then user is redirected to transaction page
	When user is in transaction page
	Then user selects his PAN as "<PAN>" , Folio as "<folio>"
	Then user clicks on proceed button on Freedom Sip transaction
	When user is in schemes page
	Then user is selects "<allCategories>","<selectFund>","<selectSchemeOption>","<payout>" , provides amount as "<amount>"
	#Then user selects "<frequency>" ,"<startDate>" ,"<endDate>" ,"<payRightAway>","<topUp>","<TopMode>","<percentage>","<topUpAmount>","<topUpFrequency>"
	Then user selects SWP details "<selectFundCategory>", "<selectFund2>","<schemeOption>", "<payout>","<targetAmount>"
	Then user clicks on proceed button on investment details page
	When user is in otp page
	Then user provides otp and checks terms and condition
	When user is in payment page
	Then user selects already Mandate from mandate section and selects "<mAmount>"
	Then user is in transaction receipt page for verification of folio number as "<folio>" and payment method as "<payment>"
 
	@UAT
	Examples:
	  | userId                      | password   | PAN        | folio   | allCategories | selectFund           | selectSchemeOption | payout | amount | mAmount | selectFundCategory | selectFund2   | schemeOption | targetAmount | payment         |
	#  | testuiautomation@gmail.com | Dzire@2020 | VUGPR8049L | 49539755 | Equity Funds  | Fmcg Fund  | Dividend           | Payout | 12345  | success@razorpay | UPI     |
	  | saurav.behera@capgemini.com | Demo@12345 | VUGPR8049L | 7678096 | Equity Funds  | Large & Mid Cap Fund | Growth             |        | 1000   | 80000   | Equity Funds       | Multicap Fund | Growth       | 960          | Autopay Mandate |
  
  
  @SignInAndTransact
  Scenario Outline: User SignIn to iPru website using email and password and does Redeem
	Given user is already passed the pre login page and is on homepage
	Then user clicks on Sign in button
	Then user provides userId as "<userId>"
	Then user clicks on Next button
	Then user provides password as "<password>"
	Then user clicks on SignIn button after entering username and password
	Then user is redirected to transaction page
	When user is in transaction page
	Then user selects his PAN as "<PAN>" , Folio as "<folio>"
	Then user clicks on proceed button on withdraw redeem transaction
	Then user selects his fund as "<fund>", "<redemptionMode>", "<redeemValue>" from cart menu and clicks on proceed
	Then user checks his bank details and clicks on continue
	When user is in redeem otp page
	Then user is in transaction receipt page for verification of folio number as "<folio>" and payment method as "<payment>"
 
	@UAT
	Examples:
	  | userId                      | password   | PAN        | folio   | fund                                                           | redemptionMode | redeemValue | payment |
	  | saurav.behera@capgemini.com | Demo@12345 | VUGPR8049L | 7678096 | ICICI Prudential Short Term Fund - Direct Plan - Growth Option | units          | 1000        | ---     |
	#  | saurav.behera@capgemini.com | Demo@12345| VUGPR8049L | 7678096 | ICICI Prudential Passive Strategy Fund(FOF) - Direct Plan - Growth |amount        |700        ||
  
  
  @SignInAndTransact
  Scenario Outline: User SignIn to iPru website using email and password and does Redeem freedom SWP
	Given user is already passed the pre login page and is on homepage
	Then user clicks on Sign in button
	Then user provides userId as "<userId>"
	Then user clicks on Next button
	Then user provides password as "<password>"
	Then user clicks on SignIn button after entering username and password
	Then user is redirected to transaction page
	When user is in transaction page
	Then user selects his PAN as "<PAN>" , Folio as "<folio>"
	Then user clicks on proceed button on withdraw redeem Freedom SWP transaction
	Then user selects his fund as "<fund>", "<amount>", "<topuppercent>", "<frequency>", "<StartAfter>","<enddate>" from cart menu and clicks on proceed
	Then user checks his bank details and clicks on continue
	When user is in redeem otp page
	Then user is in transaction receipt page for verification of folio number as "<folio>" and payment method as "<payment>"
 
	@UAT
	Examples:
	  | userId                      | password   | PAN        | folio   | fund                                                               | amount | topuppercent | frequency | StartAfter | enddate | payment |
	  | saurav.behera@capgemini.com | Demo@12345 | VUGPR8049L | 7678096 | ICICI Prudential Passive Strategy Fund(FOF) - Direct Plan - Growth | 1000   | 4            | monthly   | no         | no      | ---     |
	#  | saurav.behera@capgemini.com | Demo@12345| VUGPR8049L | 7678096 | ICICI Prudential Passive Strategy Fund(FOF) - Direct Plan - Growth |amount        |700        ||
  
  
  @SignInAndTransact
  Scenario Outline: User SignIn to iPru website using email and password and does Switch Switch
	Given user is already passed the pre login page and is on homepage
	Then user clicks on Sign in button
	Then user provides userId as "<userId>"
	Then user clicks on Next button
	Then user provides password as "<password>"
	Then user clicks on SignIn button after entering username and password
	Then user is redirected to transaction page
	When user is in transaction page
	Then user selects his PAN as "<PAN>" , Folio as "<folio>"
	Then user clicks on start button on switch switch transaction
	Then user selects his fund as "<fund>", "<redemptionMode>", "<selectFundCategory>", "<selectFund2>","<schemeOption>","<redeemValue>" from cart menu and clicks on proceed for switch
	When user is in redeem otp page
	Then user is in transaction receipt page for verification of folio number as "<folio>" and payment method as "<payment>"
 
	@UAT
	Examples:
	  | userId                      | password   | PAN        | folio   | fund                                                           | redemptionMode | redeemValue | selectFundCategory | selectFund2            | schemeOption | payment |
	  | saurav.behera@capgemini.com | Demo@12345 | VUGPR8049L | 7678096 | ICICI Prudential Short Term Fund - Direct Plan - Growth Option | Units          | 510         | Debt Funds         | Floating Interest Fund | Growth       | ---     |
  
  @SignInAndTransact
  Scenario Outline: User SignIn to iPru website using email and password and does Switch STP
	Given user is already passed the pre login page and is on homepage
	Then user clicks on Sign in button
	Then user provides userId as "<userId>"
	Then user clicks on Next button
	Then user provides password as "<password>"
	Then user clicks on SignIn button after entering username and password
	Then user is redirected to transaction page
	When user is in transaction page
	Then user selects his PAN as "<PAN>" , Folio as "<folio>"
	Then user clicks on start button on switch STP transaction
	Then user selects his fund as "<fund>","<amount>","<frequency>","<STPFromdate>","<specificEndDate>","<numberofInst>","<selectFundCategory>", "<selectFund2>","<schemeOption>" from cart menu and clicks on proceed for switch STP
	When user is in redeem otp page
	Then user is in transaction receipt page for verification of folio number as "<folio>" and payment method as "<payment>"
 
	@UAT
	Examples:
	  | userId                      | password   | PAN        | folio   | fund                                                          | amount | frequency | STPFromdate | specificEndDate | numberofInst | selectFundCategory | selectFund2          | schemeOption | payment |
	  | saurav.behera@capgemini.com | Demo@12345 | VUGPR8049L | 7678096 | ICICI Prudential US Bluechip Equity Fund - Direct Plan - IDCW | 1000   | Daily     |             |                 | 8            | Equity Funds       | Large & Mid Cap Fund | Growth       | ---     |
  
  @SignInAndTransact
  Scenario Outline: User SignIn to iPru website using email and password and does Switch Flex STP
	Given user is already passed the pre login page and is on homepage
	Then user clicks on Sign in button
	Then user provides userId as "<userId>"
	Then user clicks on Next button
	Then user provides password as "<password>"
	Then user clicks on SignIn button after entering username and password
	Then user is redirected to transaction page
	When user is in transaction page
	Then user selects his PAN as "<PAN>" , Folio as "<folio>"
	Then user clicks on start button on switch Flex STP transaction
	Then user selects his fund as "<fund>","<amount>","<frequency>","<STPFromdate>","<specificEndDate>","<numberofInst>","<selectFundCategory>", "<selectFund2>","<schemeOption>" from cart menu and clicks on proceed for switch STP
	When user is in redeem otp page
	Then user is in transaction receipt page for verification of folio number as "<folio>" and payment method as "<payment>"
 
	@UAT
	Examples:
	  | userId                      | password   | PAN        | folio   | fund                                                     | amount | frequency | STPFromdate | specificEndDate | numberofInst | selectFundCategory | selectFund2 | schemeOption | payment |
	  | saurav.behera@capgemini.com | Demo@12345 | VUGPR8049L | 7678096 | ICICI Prudential Credit Risk Fund - Direct Plan - Growth | 1000   | Daily     |             |                 | 8            | Equity Funds       | Fmcg Fund   | Growth       | ---     |
  
  @SignInAndTransact
  Scenario Outline: User SignIn to iPru website using email and password and does Switch Booster STP
	Given user is already passed the pre login page and is on homepage
	Then user clicks on Sign in button
	Then user provides userId as "<userId>"
	Then user clicks on Next button
	Then user provides password as "<password>"
	Then user clicks on SignIn button after entering username and password
	Then user is redirected to transaction page
	When user is in transaction page
	Then user selects his PAN as "<PAN>" , Folio as "<folio>"
	Then user clicks on start button on switch Booster STP transaction
	Then user selects his fund as "<fund>","<amount>","<frequency>","<STPFromdate>","<specificEndDate>","<numberofInst>","<selectFundCategory>", "<selectFund2>","<schemeOption>" from cart menu and clicks on proceed for switch STP
	When user is in redeem otp page
	Then user is in transaction receipt page for verification of folio number as "<folio>" and payment method as "<payment>"
 
	@UAT
	Examples:
	  | userId                      | password   | PAN        | folio   | fund                                                     | amount | frequency | STPFromdate | specificEndDate | numberofInst | selectFundCategory | selectFund2      | schemeOption | payment |
	  | saurav.behera@capgemini.com | Demo@12345 | VUGPR8049L | 7678096 | ICICI Prudential Credit Risk Fund - Direct Plan - Growth | 1000   | Monthly   |             |                 | 8            | Hybrid Funds       | Multi-Asset Fund | Growth       | ---     |
  
  @SignInAndTransact
  Scenario Outline: User SignIn to iPru website using email and password and does others Rollover
	Given user is already passed the pre login page and is on homepage
	Then user clicks on Sign in button
	Then user provides userId as "<userId>"
	Then user clicks on Next button
	Then user provides password as "<password>"
	Then user clicks on SignIn button after entering username and password
	Then user is redirected to transaction page
	When user is in transaction page
	Then user selects his PAN as "<PAN>" , Folio as "<folio>"
	Then user clicks on start button on Others Rollover transaction
	Then user clicks on proceed button on investment details page
	When user is in redeem otp page
	Then user is in transaction receipt page for verification of folio number as "<folio>" and payment method as "<payment>"
 
	@UAT
	Examples:
	  | userId                      | password   | PAN        | folio   | payment |
	  | saurav.behera@capgemini.com | Demo@12345 | VUGPR8049L | 7678096 | ---     |
  
  
  @SignInAndTransact
  Scenario Outline: User SignIn to iPru website using email and password and does others Rollover
	Given user is already passed the pre login page and is on homepage
	Then user clicks on Sign in button
	Then user provides userId as "<userId>"
	Then user clicks on Next button
	Then user provides password as "<password>"
	Then user clicks on SignIn button after entering username and password
	Then user is redirected to transaction page
	When user is in transaction page
	Then user selects his PAN as "<PAN>" , Folio as "<folio>"
	Then user clicks on start button on Others Trigger on Maturity transaction
	Then user selects his fund as "<fund>","<selectFundCategory>", "<selectFund2>","<schemeOption>" from cart menu and clicks on proceed for switch STP
	Then user clicks on proceed button on investment details page
	When user is in redeem otp page
	Then user is in transaction receipt page for verification of folio number as "<folio>" and payment method as "<payment>"
 
	@UAT
	Examples:
	  | userId                      | password   | PAN        | folio   | fund                                                     | selectFundCategory | selectFund2        | schemeOption | payment |
	  | saurav.behera@capgemini.com | Demo@12345 | CSBPM7775D | 7367304 | ICICI Prudential Credit Risk Fund - Direct Plan - Growth | Equity Funds       | Manufacturing Fund | Growth       | ---     |
  
  
  @SignInAndTransact
  Scenario Outline: User SignIn to iPru website using email and password and does others Close Ended Scheme Switch
	Given user is already passed the pre login page and is on homepage
	Then user clicks on Sign in button
	Then user provides userId as "<userId>"
	Then user clicks on Next button
	Then user provides password as "<password>"
	Then user clicks on SignIn button after entering username and password
	Then user is redirected to transaction page
	When user is in transaction page
	Then user selects his PAN as "<PAN>" , Folio as "<folio>"
	Then user clicks on start button on Others Close Ended Scheme Switch transaction
	Then user selects his fund as "<fund>","<selectFundCategory>", "<selectFund2>","<schemeOption>", "<amount>" from cart menu and clicks on proceed for switch
	Then user clicks on proceed button on investment details page
	Then user checks his bank details and clicks on continue
	When user is in redeem otp page
	Then user is in transaction receipt page for verification of folio number as "<folio>" and payment method as "<payment>"
 
	@UAT
	Examples:
	  | userId                      | password   | PAN        | folio   | fund                                                     | amount | selectFundCategory | selectFund2        | schemeOption | payment |
	  | saurav.behera@capgemini.com | Demo@12345 | CSBPM7775D | 7367304 | ICICI Prudential Credit Risk Fund - Direct Plan - Growth | 1000   | Equity Funds       | Manufacturing Fund | Growth       | ---     |
  
  
  @SignUpAndTransact
  Scenario Outline: User is Registering in the iPru website when cams is up
	Given user is already passed the pre login page and is on homepage
	Then user clicks on Sign in button
	Then user clicks on registers button on signin  register page
	Then user clicks on register button  and is shown a register page
	Then user provides his name as "<fullname>"
	Then user provides his email id as "<emailid>"
	Then user clicks on send OTP button
	Then user provides six digit OTP on page
	Then user sets his "<mobile>" phone number
	Then user clicks on send OTP button
	Then user provides six digit OTP on page
	Then accepts terms and conditions
	Then user clicks on continue button
	When user sees set password screen
	Then user enters his desired new password
	Then user confirms his password
	Then user clicks on continue
	Then user provides Primary Pan Number as "<primaryPanNumber>" on the page
	Then user clicks on verifyPan button
	Then user clicks on get otp to verify the primary pan number
	Then user provides six digit OTP on page
	Then user clicks on continue
	Then user is redirected to KYC Register Homepage after verification and clicks on proceed
	Then user selects bank as "<bankName>" on bank detail page
	Then user enters account number on bank detail page
	Then user confirms account number on bank detail page
	Then user provides ifsc code as "<ifscCode>" on bank detail page
	Then user clicks on proceed button present in Bank details page
	Then nominee page is displayed
	Then user enters his "<nomineeName>"
	Then user enters his relation with nominee as "<relation>"
	Then users sets birth date of nominee as "<birthDate>"
	Then user clicks on proceed button on nominee page
	Then user clicks on continue button after verifying his submitted details
	Then user verify that Folio Number is generated successfully
	Then user clicks proceed to checkout button
	Then user is in transaction screen
	Then user selects lumpsum transaction
	When user is in schemes page
	Then user is selects "<allCategories>","<selectFund>","<selectSchemeOption>","<payout>" , provides amount as "<amount>"
	Then user clicks on proceed button on investment details page
	When user is in otp page
	Then user provides otp and checks terms and condition
	When user is in payment page
	Then user proceeds to do UPI transaction using UPI id as "<UPI_ID>"
	Then user is in transaction receipt page for verification of folio number as "<folio>" and payment method as "<payment>"
 
 
	@UAT
	Examples:
	  | fullname   | emailid                | mobile     | contactDetails | primaryPanNumber | bankName       | ifscCode    | nomineeName | relation | birthDate  | allCategories | selectFund | selectSchemeOption | payout | amount | UPI_ID           | payment |
	  | Automation | sendemailotp@gmail.com | 9535785676 | Spouse         | VUGPR8049L       | ICICI BANK LTD | ICIC0002447 | data        | Wife     | 20/03/1999 | Equity Funds  | Fmcg Fund  | Dividend           | Payout | 12345  | success@razorpay | UPI     |
  
  @SignIn
  Scenario Outline: User SignIn to iPru website using email and password but username is wrong
	Given user is already passed the pre login page and is on homepage
	Then user clicks on Sign in button
	Then user provides userId as "<userId>"
	Then user clicks on Next button
	Then user provides password as "<password>"
	Then user clicks on SignIn button after entering username and password
	Then user gets an error message of "<errorMessage>"
 
	@UAT
	Examples:
	  | userId                         | password   | errorMessage                                                                                            |
	  | saurav.behera123@capgemini.com | Demo@12345 | User authentication failed.                                                                             |
	  | saurav.behera123               | Demo@12345 | User authentication failed.                                                                             |
	  | saurav.behera@capgemini.com    | Demo@1234  | User authentication failed. You have 2 more attempts before your account gets locked.                   |
	  | Shashwatx.pandey@gmail.com     | Demo@1234  | User ID locked as exceeded maximum attempts, use Forget Username / Password option below to unlock now. |
  
  
  @SignIn
  Scenario Outline: User SignIn to iPru website using mobile otp
	Given user is already passed the pre login page and is on homepage
	Then user clicks on Sign in button
	Then user provides userId as "<userId>"
	Then user clicks on Next button
	Then user clicks on SignIn using Otp
	Then user selects mobile radiobutton for otp
	Then user clicks on sendOTP button on SignIn Page
	Then user enters a wrong six digit OTP
	Then user clicks on SignIn button after entering username and otp
	Then user gets an error message of "<errorMessage>"
 
	@UAT
	Examples:
	  | userId                     | errorMessage                                                                                            |
	  | testuiautomation@gmail.com | User ID locked as exceeded maximum attempts, use Forget Username / Password option below to unlock now. |
  
  
  @SignIn
  Scenario Outline: User SignIn to iPru website using mobile otp
	Given user is already passed the pre login page and is on homepage
	Then user clicks on Sign in button
	Then user provides userId as "<userId>"
	Then user clicks on Next button
	Then user clicks on SignIn using Otp
	Then user selects mobile radiobutton for otp
	Then user clicks on sendOTP button on SignIn Page
	Then user gets an error message of "<errorMessage>"
 
	@UAT
	Examples:
	  | userId                        | errorMessage                |
	  | testuiautomation123@gmail.com | User authentication failed. |
  
  @SignIn
  Scenario Outline: User SignIn to iPru website using email and password but username is wrong
	Given user is already passed the pre login page and is on homepage
	Then user clicks on Sign in button
	Then user provides userId as "<userId>"
	Then user clicks on Next button
	Then user provides password as "<password>"
	Then user clicks on SignIn button after entering username and password
	Then user clicks on his profile name to display list of options
	Then user selects "<option>" option from drop down
	Then user sees his name displayed on the page
	Then quick links are displayed
	Then user is displayed with his portfolio summary
 
	@UAT
	Examples:
	  | userId                      | password   | option    |
	  | saurav.behera@capgemini.com | Demo@12345 | Dashboard |
  
  @Services
  Scenario: User is verifying Services page on home page
	Given user is already passed the pre login page and is on homepage
	Then user clicks on Services button
	Then user is already in Services tab
	Then user verifies if he is able to see the heading as Investor Services
	Then user verifies if he is able to see all the sub services
	Then user verifies if he all the details along with description are correct
	  
	
	
	
	
  