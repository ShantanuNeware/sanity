Feature: Validation related to Our Funds Page

  @OurFunds
  Scenario: user verifies our funds page details
    Given user completes pre login and clicks on OurFund Tab
    Then user verifies that Our Fund Page loaded successfully
    Then user verifies that promo cards loaded successfully
    Then user verifies that explore funds categories and values are displayed


