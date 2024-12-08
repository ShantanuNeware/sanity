Feature: Validation of check if bdd setup is done right

  Background: Pre login to the iPru website
    Given User pastes the link in the browser and clicks on enter
		Then User click on Log In button
		Then User Click on UserID field
		Then Enter "<User ID>" userid
		Then Click On Next button
		Then Enter "<Password>" password
		Then Click On SignIn button


  @DistributorLogin
  Scenario Outline: user is navigating to ICICI website using pre login
    Given User is in Distributor Signin Page
    Then distributor enters his "<username>" and "<password>" and clicks on login
    Given that the Distributor is on the dashboard page and his details like "<username>" are displayed


    @UAT
    Examples:
      | username | password  |
      | 1000     | Demo@1988 |

    @QA
    Examples:
      | username | password   |
      | 7890     | Swift@1990 |

    @SecureUAT
    Examples:
      | username | password |
      | 44026    | Demo@123 |


  @DistributorLogin
  Scenario Outline: user is navigating to ICICI website using pre login and verifies AUM tab
    Given User is in Distributor Signin Page
    Then distributor enters his "<username>" and "<password>" and clicks on login
    Given that the Distributor is on the dashboard page and his details like "<username>" are displayed
    Then distributor verifies details AUM tab displayed page
    Then after verification distributor clicks on view latest details on dashboard page
    Then distributor verifies field and other details on Business summary

    @UAT
    Examples:
      | username | password  |
      | 1000     | Demo@1988 |

    @QA
    Examples:
      | username | password   |
      | 7890     | Swift@1990 |

    @SecureUAT
    Examples:
      | username | password |
      | 44026    | Demo@123 |


  @DistributorLogin
  Scenario Outline: user is navigating to ICICI website using pre login and verifies SIP Book tab
    Given User is in Distributor Signin Page
    Then distributor enters his "<username>" and "<password>" and clicks on login
    Given that the Distributor is on the dashboard page and his details like "<username>" are displayed
    Then distributor clicks on SIP Book Tab
    When SIP book tab is displayed then he verifies if Graph parameters is displayed
    @UAT
    Examples:
      | username | password  |
      | 1000     | Demo@1988 |

    @QA
    Examples:
      | username | password   |
      | 7890     | Swift@1990 |

    @SecureUAT
    Examples:
      | username | password |
      | 44026    | Demo@123 |


  @DistributorLogin
  Scenario Outline: user is navigating to ICICI website using pre login and verifies SIP Book tab
    Given User is in Distributor Signin Page
    Then distributor enters his "<username>" and "<password>" and clicks on login
    Given that the Distributor is on the dashboard page and his details like "<username>" are displayed
    Then distributor clicks on SIP Book Tab
    When SIP book tab is displayed then he verifies if Graph parameters is displayed
    Then Distributor verifies if all types of fund breakdown are shown in Dashboard

    @UAT
    Examples:
      | username | password  |
      | 1000     | Demo@1988 |

    @QA
    Examples:
      | username | password   |
      | 7890     | Swift@1990 |

    @SecureUAT
    Examples:
      | username | password |
      | 44026    | Demo@123 |


  @DistributorLogin
  Scenario Outline: user is navigating to ICICI website using pre login and verifies SIP Book tab
    Given User is in Distributor Signin Page
    Then distributor enters his "<username>" and "<password>" and clicks on login
    Given that the Distributor is on the dashboard page and his details like "<username>" are displayed
    Then distributor clicks on SIP Book Tab
    When SIP book tab is displayed then he verifies if Graph parameters is displayed
    Then Distributor verifies if all types of fund breakdown are shown in Dashboard
    Then Distributor clicks on view latest details page
    When user is redirected to next page he validates if business summary is shown on the page

    @UAT
    Examples:
      | username | password  |
      | 1000     | Demo@1988 |

    @QA
    Examples:
      | username | password   |
      | 7890     | Swift@1990 |

    @SecureUAT
    Examples:
      | username | password |
      | 44026    | Demo@123 |


  @DistributorLogin
  Scenario Outline: user is navigating to ICICI website using pre login and verifies SIP Book tab
    Given User is in Distributor Signin Page
    Then distributor enters his "<username>" and "<password>" and clicks on login
    Given that the Distributor is on the dashboard page and his details like "<username>" are displayed
    Then distributor clicks on SIP Book Tab
    When SIP book tab is displayed then he verifies if Graph parameters is displayed
    Then Distributor verifies if all types of fund breakdown are shown in Dashboard
    Then Distributor clicks on view latest details page
    When user is redirected to next page he validates if business summary is shown on the page
    Then distributor verifies field and other details on Business summary for SIP Book
    @UAT
    Examples:
      | username | password  |
      | 1000     | Demo@1988 |

    @QA
    Examples:
      | username | password   |
      | 7890     | Swift@1990 |

    @SecureUAT
    Examples:
      | username | password |
      | 44026    | Demo@123 |


  @DistributorLogin
  Scenario Outline: user is navigating to ICICI website using pre login and verifies net sales tab
    Given User is in Distributor Signin Page
    Then distributor enters his "<username>" and "<password>" and clicks on login
    Given that the Distributor is on the dashboard page and his details like "<username>" are displayed
    Then distributor clicks on net sales Tab
    When net sales tab is displayed then he verifies if Graph parameters is displayed
    Then Distributor verifies if all types of fund breakdown are shown in Dashboard for net sales
    Then Distributor clicks on view latest details page
    When user is redirected to next page he validates if business summary is shown on the page for net sales
    Then distributor verifies field and other details on Business summary for net sales

    @UAT
    Examples:
      | username | password  |
      | 1000     | Demo@1988 |

    @QA
    Examples:
      | username | password   |
      | 7890     | Swift@1990 |

    @SecureUAT
    Examples:
      | username | password |
      | 44026    | Demo@123 |

  @DistributorLogin
  Scenario Outline: user is navigating to ICICI website using pre login and verifies clients tab
    Given User is in Distributor Signin Page
    Then distributor enters his "<username>" and "<password>" and clicks on login
    Given that the Distributor is on the dashboard page and his details like "<username>" are displayed
    Then distributor clicks on clients Tab
    When clients tab is displayed then he verifies if Graph parameters is displayed
    Then Distributor verifies if all types of client breakup are shown in Dashboard for client
    Then Distributor clicks on view latest details page
    When user is redirected to next page he validates if business summary is shown on the page for client


    @UAT
    Examples:
      | username | password  |
      | 1000     | Demo@1988 |

    @QA
    Examples:
      | username | password   |
      | 7890     | Swift@1990 |

    @SecureUAT
    Examples:
      | username | password |
      | 44026    | Demo@123 |


  @DistributorServices
  Scenario Outline: user is navigating to ICICI website using pre login and verifies Account statement via pan and eamil id
    Given User is in Distributor Signin Page
    Then distributor enters his "<username>" and "<password>" and clicks on login
    Given that the Distributor is on the dashboard page and his details like "<username>" are displayed
    Then distributor clicks on distributor services


    @UAT
    Examples:
      | username | password  |
      | 1000     | Demo@1988 |

    @QA
    Examples:
      | username | password   |
      | 7890     | Swift@1990 |

    @SecureUAT
    Examples:
      | username | password | PAN        | typeOfStatement   | email                     | initiatingRequest |
      | 44026    | Demo@123 | AGMPC4224G | Account Statement | chandra.abhisek@gmail.com | RIA               |

  @DistributorServices
  Scenario Outline: user is navigating to ICICI website using pre login and verifies Account statement via pan and eamil id
    Given User is in Distributor Signin Page
    Then distributor enters his "<username>" and "<password>" and clicks on login
    Given that the Distributor is on the dashboard page and his details like "<username>" are displayed
    Then distributor clicks on distributor services
    When Distributor verifies all details displayed in distributor services

    @UAT
    Examples:
      | username | password  |
      | 1000     | Demo@1988 |

    @QA
    Examples:
      | username | password   |
      | 7890     | Swift@1990 |

    @SecureUAT
    Examples:
      | username | password | PAN        | typeOfStatement   | email                     | initiatingRequest |
      | 44026    | Demo@123 | AGMPC4224G | Account Statement | chandra.abhisek@gmail.com | RIA               |

  @DistributorServices
  Scenario Outline: user is navigating to ICICI website using pre login and verifies Account statement via pan and eamil id
    Given User is in Distributor Signin Page
    Then distributor enters his "<username>" and "<password>" and clicks on login
    Given that the Distributor is on the dashboard page and his details like "<username>" are displayed
    Then distributor clicks on distributor services
    When Distributor verifies all details displayed in distributor services
    Then Distributor selects "<PAN>" and clicks on "<typeOfStatement>"
    Then Distributor verifies if he is in statement processing page


    @UAT
    Examples:
      | username | password  |
      | 1000     | Demo@1988 |

    @QA
    Examples:
      | username | password   |
      | 7890     | Swift@1990 |

    @SecureUAT
    Examples:
      | username | password | PAN        | typeOfStatement   | email                     | initiatingRequest |
      | 44026    | Demo@123 | AGMPC4224G | Account Statement | chandra.abhisek@gmail.com | RIA               |

  @DistributorServices
  Scenario Outline: user is navigating to ICICI website using pre login and verifies Account statement via pan and eamil id
    Given User is in Distributor Signin Page
    Then distributor enters his "<username>" and "<password>" and clicks on login
    Given that the Distributor is on the dashboard page and his details like "<username>" are displayed
    Then distributor clicks on distributor services
    When Distributor verifies all details displayed in distributor services
    Then Distributor selects "<PAN>" and clicks on "<typeOfStatement>"
    Then Distributor verifies if he is in statement processing page
    Then distributor clicks on "<initiatingRequest>" and statement type as PAN level and provides other details as "<PAN>" and "<email>"
    Then distributor verifies if continue button is enabled
    Then Distributor clicks on continue

    @UAT
    Examples:
      | username | password  |
      | 1000     | Demo@1988 |

    @QA
    Examples:
      | username | password   |
      | 7890     | Swift@1990 |

    @SecureUAT
    Examples:
      | username | password | PAN        | typeOfStatement   | email                     | initiatingRequest |
      | 44026    | Demo@123 | AGMPC4224G | Account Statement | chandra.abhisek@gmail.com | RIA               |



  @DistributorGrowYourBusiness
  Scenario Outline: user is navigating to ICICI website using pre login and verifies grow your business
    Given User is in Distributor Signin Page
    Then distributor enters his "<username>" and "<password>" and clicks on login
    Given that the Distributor is on the dashboard page and his details like "<username>" are displayed
    Then Distributor verifies details on grow your business card if those are not null


    @UAT
    Examples:
      | username | password  |
      | 1000     | Demo@1988 |

    @QA
    Examples:
      | username | password   |
      | 7890     | Swift@1990 |

    @SecureUAT
    Examples:
      | username | password |
      | 44026    | Demo@123 |

  @DistributorGrowYourBusiness
  Scenario Outline: user is navigating to ICICI website using pre login and verifies grow your business
    Given User is in Distributor Signin Page
    Then distributor enters his "<username>" and "<password>" and clicks on login
    Given that the Distributor is on the dashboard page and his details like "<username>" are displayed
    Then Distributor verifies details on grow your business card if those are not null
    Then Distributor clicks view details button and is transferred to grow your business page
    Then Distributor verifies if he is in Grow your business page
    Then Distributor verifies numbers and other details from dashboard and compares them

    @UAT
    Examples:
      | username | password  |
      | 1000     | Demo@1988 |

    @QA
    Examples:
      | username | password   |
      | 7890     | Swift@1990 |

    @SecureUAT
    Examples:
      | username | password |
      | 44026    | Demo@123 |


  @DistributorServices
  Scenario Outline: user is navigating to ICICI website using pre login and Account statement via folio number
    Given User is in Distributor Signin Page
    Then distributor enters his "<username>" and "<password>" and clicks on login
    Given that the Distributor is on the dashboard page and his details like "<username>" are displayed
    Then distributor clicks on distributor services
    When Distributor verifies all details displayed in distributor services
    Then Distributor selects "<PAN>" and clicks on "<typeOfStatement>"
    Then Distributor verifies if he is in statement processing page

    @UAT
    Examples:
      | username | password  |
      | 1000     | Demo@1988 |

    @QA
    Examples:
      | username | password   |
      | 7890     | Swift@1990 |

    @SecureUAT
    Examples:
      | username | password | PAN        | typeOfStatement   | folioNumber               | initiatingRequest |
      | 44026    | Demo@123 | AGMPC4224G | Account Statement | chandra.abhisek@gmail.com | RIA               |

  @DistributorServices
  Scenario Outline: user is navigating to ICICI website using pre login and Account statement via folio number
    Given User is in Distributor Signin Page
    Then distributor enters his "<username>" and "<password>" and clicks on login
    Given that the Distributor is on the dashboard page and his details like "<username>" are displayed
    Then distributor clicks on distributor services
    When Distributor verifies all details displayed in distributor services
    Then Distributor selects "<PAN>" and clicks on "<typeOfStatement>"
    Then Distributor verifies if he is in statement processing page
    Then distributor clicks on "<initiatingRequest>" and statement type as PAN level and provides other details as "<folioNumber>"
    Then distributor verifies if continue button is enabled
    Then Distributor clicks on continue

    @UAT
    Examples:
      | username | password  |
      | 1000     | Demo@1988 |

    @QA
    Examples:
      | username | password   |
      | 7890     | Swift@1990 |

    @SecureUAT
    Examples:
      | username | password | PAN        | typeOfStatement   | folioNumber               | initiatingRequest |
      | 44026    | Demo@123 | AGMPC4224G | Account Statement | chandra.abhisek@gmail.com | RIA               |


  @SignInAndTransactDistributor
  Scenario Outline: Distributor SignIn to iPru website using email and password and does lump sum with a new mandate creation
    Given User is in Distributor Signin Page
    Then distributor enters his "<username>" and "<password>" and clicks on login
    Given that the Distributor is on the dashboard page and his details like "<username>" are displayed

    Then distributor goes to My clients section and clicks on view all clients
    When distributor clicks on client search and send "<PAN>" details to search pan
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

    @SecureUAT
    Examples:
      | username | password | PAN        | folio   | allCategories | selectFund | selectSchemeOption | payout | amount | payment         |
      | 44026    | Demo@123 | AGMPC4224G | 6919667 | Debt Funds    | Gilt Fund  | Growth             |        | 5000   | Autopay Mandate |

  @SignInAndTransactDistributor
  Scenario Outline: User SignIn to iPru website using email and password and does sip with mandate
    Given User is in Distributor Signin Page
    Then distributor enters his "<username>" and "<password>" and clicks on login
    Given that the Distributor is on the dashboard page and his details like "<username>" are displayed

    Then distributor goes to My clients section and clicks on view all clients
    When distributor clicks on client search and send "<PAN>" details to search pan
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

    @SecureUAT
    Examples:
      | username | password | PAN        | folio   | allCategories | selectFund | selectSchemeOption | payout | amount | mAmount | payment         |
	#  | testuiautomation@gmail.com | Dzire@2020 | VUGPR8049L | 49539755 | Equity Funds  | Fmcg Fund  | Dividend           | Payout | 12345  | success@razorpay | UPI     |
      | 44026    | Demo@123 | AGMPC4224G | 6919667 | Debt Funds    | Gilt Fund  | Growth             | Payout | 12345  | 80000   | Autopay Mandate |


  @SignInAndTransactDistributor
  Scenario Outline: User SignIn to iPru website using email and password and does Booster sip with mandate
    Given User is in Distributor Signin Page
    Then distributor enters his "<username>" and "<password>" and clicks on login
    Given that the Distributor is on the dashboard page and his details like "<username>" are displayed

    Then distributor goes to My clients section and clicks on view all clients
    When distributor clicks on client search and send "<PAN>" details to search pan
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

    @SecureUAT
    Examples:
      | username | password | PAN        | folio   | allCategories | selectFund           | selectSchemeOption | payout | amount | mAmount | selectFundCategory | selectFund2     | schemeOption | multiplier | targetAmount | payment         |
	#  | testuiautomation@gmail.com | Dzire@2020 | VUGPR8049L | 49539755 | Equity Funds  | Fmcg Fund  | Dividend           | Payout | 12345  | success@razorpay | UPI     |
      | 44026    | Demo@123 | AGMPC4224G | 6919667 | Equity Funds  | Large & Mid Cap Fund | Growth             |        | 1000   | 80000   | Debt Funds         | Short Term Fund | Growth       | 8x         | 12000        | Autopay Mandate |


  @SignInAndTransactDistributor
  Scenario Outline: User SignIn to iPru website using email and password and does Freedom sip with mandate
    Given User is in Distributor Signin Page
    Then distributor enters his "<username>" and "<password>" and clicks on login
    Given that the Distributor is on the dashboard page and his details like "<username>" are displayed

    Then distributor goes to My clients section and clicks on view all clients
    When distributor clicks on client search and send "<PAN>" details to search pan
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

    @SecureUAT
    Examples:
      | username | password | PAN        | folio   | allCategories | selectFund           | selectSchemeOption | payout | amount | mAmount | selectFundCategory | selectFund2   | schemeOption | targetAmount | payment         |
	#  | testuiautomation@gmail.com | Dzire@2020 | VUGPR8049L | 49539755 | Equity Funds  | Fmcg Fund  | Dividend           | Payout | 12345  | success@razorpay | UPI     |
      | 44026    | Demo@123 | AGMPC4224G | 6919667 | Equity Funds  | Large & Mid Cap Fund | Growth             |        | 1000   | 80000   | Equity Funds       | Multicap Fund | Growth       | 960          | Autopay Mandate |


  @SignInAndTransactDistributor
  Scenario Outline: User SignIn to iPru website using email and password and does Switch Booster STP
    Given User is in Distributor Signin Page
    Then distributor enters his "<username>" and "<password>" and clicks on login
    Given that the Distributor is on the dashboard page and his details like "<username>" are displayed

    Then distributor goes to My clients section and clicks on view all clients
    When distributor clicks on client search and send "<PAN>" details to search pan

    Then user is redirected to transaction page
    When user is in transaction page
    Then user selects his PAN as "<PAN>" , Folio as "<folio>"
    Then user clicks on start button on switch Booster STP transaction
    Then user selects his fund as "<fund>","<amount>","<frequency>","<STPFromdate>","<specificEndDate>","<numberofInst>","<selectFundCategory>", "<selectFund2>","<schemeOption>" from cart menu and clicks on proceed for switch STP
    When user is in redeem otp page
    Then user is in transaction receipt page for verification of folio number as "<folio>" and payment method as "<payment>"

    @SecureUAT
    Examples:
      | username | password | PAN        | folio   | fund                                                     | amount | frequency | STPFromdate | specificEndDate | numberofInst | selectFundCategory | selectFund2      | schemeOption | payment |
      | 44026    | Demo@123 | AGMPC4224G | 6919667 | ICICI Prudential Credit Risk Fund - Direct Plan - Growth | 1000   | Monthly   |             |                 | 8            | Hybrid Funds       | Multi-Asset Fund | Growth       | ---     |
