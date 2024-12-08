Feature: cases related to prelogin are written here

  Background: Pre login to the iPru website
    Given user has passed valid credentials on pre login page for Distributor as "TriPod2266" and "lm10@24061987"


  @DistributorPreLogin
  Scenario Outline: user is navigating to ICICI website using pre login
    Given User is in Distributor Signin Page
    Then distributor clicks home tab
    Then Distributor verifies if he is in homepage tab and clicks on services tab
    Then Distributor verifies if he is in initiate new transaction page
    When Distributor provides IFA as "<username>" and folio as "<folio>" and clicks on continue
    Then user selects lumpsum transaction
    When user is in schemes page
    Then user is selects "<allCategories>","<selectFund>","<selectSchemeOption>","<payout>" , provides amount as "<amount>"
    Then user clicks on proceed button on investment details page
    When user is in payment page
    Then user proceeds to do UPI transaction using UPI id as "<UPI_ID>"
    Then distributor checks terms and condition and hits send to investor
    Then user is in transaction receipt page for verification of folio number as "<folio>" and payment method as "<payment>"

   # @UAT
   # Examples:
   #   | username | password  |
   #   | 1000     | Demo@1988 |

   # @QA
   # Examples:
   #   | username | password   |
   #   | 7890     | Swift@1990 |

    @SecureUAT
    Examples:
      | username | password | folio   | allCategories | selectFund  | selectSchemeOption | payout | amount | UPI_ID           | payment |
      | 44026    | Demo@123 | 6919667 | Liquid Funds  | Liquid Fund | Growth             |        | 1000   | success@razorpay | UPI     |


