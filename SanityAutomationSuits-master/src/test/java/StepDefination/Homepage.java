package StepDefination;

import ApplicationHooks.AppHooks;
import com.driver.Factory;
import com.utility.Screenshot;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import org.openqa.selenium.WebDriverException;
import org.testng.Assert;
import pages.folio.BankDetails;
import pages.folio.FolioGeneration;
import pages.folio.KycRegister;
import pages.folio.NomineeDetails;
import pages.homepage.*;
import pages.preloginpage.PreLogin;
import pages.transactions.TransactionPage;

public class Homepage {
	private final PreLogin preLogin = new PreLogin(Factory.getDriver());
	private Home home;
	public Signin signin;
	private Learn learn;
	private Plan plan;

	private HelpCenter helpCenter;
	String username;
	private Register register;
	private KycRegister kycRegister;
	private FolioGeneration folioGeneration;
	private BankDetails bankDetails;
	private NomineeDetails nomineeDetails;
	private TransactionPage transactionPage;
	private Services serviceTab;
	String email;
	String mobileNumber;
	String passwd = "Qwerty@12345";
	private PasswordScreen passwordScreen;

	@Given("user has passed valid credentials on pre login page")
	public void userHasPassedValidCredentialsOnPreLoginPage() {
		home = preLogin.doPreLogin("https://" + AppHooks.InvestorBaseUrl() + "/home/sign-in", "TESTUSER11",
				"Sachin@11");
	}

	@Given("user is already passed the pre login page and is on homepage")
	public void userIsAlreadyPassedThePreLoginPageAndIsOnHomepage() {
		Assert.assertTrue(home.isSignInButtonClickable());
	}

	@Then("user clicks on Sign in button")
	public void userClicksOnSignInButton() {
		home.clickSignInButton();
	}

	@Then("user clicks on registers button on signin  register page")
	public void userClicksOnRegistersButtonOnSigninRegisterPage() {
		signin = home.goToSigninScreen();
		Assert.assertTrue(signin.isRegisterButtonClickable());
		Assert.assertTrue(signin.isSignInRegisterTitleDisplayed());
	}

	@Then("user clicks on register button  and is shown a register page")
	public void userClicksOnRegisterButtonAndIsShownARegisterPage() {
		register = signin.goToRegisterPage();
		Assert.assertTrue(register.isUserRegistrationTileDisplayed());
	}

	@Then("user provides his name as {string}")
	public void userProvidesHisNameAs(String arg0) {
		register.setFullName(arg0);
		username = arg0;
	}

	@Then("user provides his email id as {string}")
	public void userProvidesHisEmailIdAs(String arg0) {
		register.setEmail(arg0);
		email = arg0;
	}

	@Then("user clicks on send OTP button")
	public void userClicksOnSendOTPButton() {
		Assert.assertTrue(register.sendOtpDisplayed());
		register.clickSendOTP();
	}

	@Then("user provides six digit OTP on page")
	public void userProvidesSixDigitOTPOnPage() throws InterruptedException {
		register.setOTP();
	}

	@Then("user sets his {string} phone number")
	public void userSetsHisPhoneNumber(String arg0) {
		register.setMobileNumber(arg0);
		mobileNumber = arg0;
		Assert.assertEquals(register.getMobileNumber(), arg0);
	}

	@Then("accepts terms and conditions")
	public void acceptsTermsAndConditions() {
		register.clickTNC();
	}

	@Then("user clicks on continue button")
	public void userClicksOnContinueButton() throws InterruptedException {
		register.clickOnContinue();
		Assert.assertTrue(register.verifySetPasswordScreen());
	}

	@When("user sees set password screen")
	public void userSeesSetPasswordScreen() {
		passwordScreen = register.goToPasswordScreen();
		Assert.assertTrue(passwordScreen.userRegistrationScreen());
	}

	@Then("user enters his desired new password")
	public void userEntersHisDesiredNewPassword() {
		passwordScreen.setPassword(passwd);
	}

	@Then("user confirms his password")
	public void userConfirmsHisPassword() {
		passwordScreen.setConfirmPassword(passwd);
	}

	@Then("user clicks on continue")
	public void userClicksOnContinue() {
		passwordScreen.clickOnContinue();
		kycRegister = passwordScreen.goToKycRegisterPage();
		// Assert.assertTrue(passwordScreen.verifySetUpAccountPage());
	}

	@Then("user clicks on verifyPan button")
	public void userClicksOnVerifyPanButton() {
		kycRegister.clickOnVerifyButton();
	}

	@Then("user provides Primary Pan Number as {string} on the page")
	public void userProvidesPrimaryPanNumberAsOnThePage(String arg0) {
		kycRegister.setPrimaryPanNumber(arg0);
	}

	@Then("user clicks on get otp to verify the primary pan number")
	public void userClicksOnGetOtpToVerifyThePrimaryPanNumber() {
		kycRegister.clickOnGetOtpToVerify();
	}

	@Then("user is redirected to KYC Register Homepage after verification and clicks on proceed")
	public void userIsRedirectedToKYCRegisterHomepageAfterVerificationAndClicksOnProceed() {
		passwordScreen.clickOnProceedButton();

	}

	@Then("user selects bank as {string} on bank detail page")
	public void userSelectsBankAsOnBankDetailPage(String arg0) {
		bankDetails = kycRegister.goToBankDetailsPage();
		Assert.assertTrue(bankDetails.verifyBankDetailPage());
		bankDetails.bankPageLoadSuccessful();
		bankDetails.setBankNameDropdown(arg0);
	}

	@Then("user enters account number on bank detail page")
	public void userEntersAccountNumberOnBankDetailPage() {
		bankDetails.setAccountNumber("1123344556");
	}

	@Then("user confirms account number on bank detail page")
	public void userConfirmsAccountNumberOnBankDetailPage() {
		bankDetails.confirmAccountNumber("1123344556");
	}

	@Then("user clicks on proceed button present in Bank details page")
	public void userClicksOnProceedButtonPresentInBankDetailsPage() {
		bankDetails.clickOnContinue();
		nomineeDetails = bankDetails.goToNomineeDetailsPage();
	}

	@Then("user provides ifsc code as {string} on bank detail page")
	public void userProvidesIfscCodeAsOnBankDetailPage(String arg0) {
		bankDetails.enterIfscCode(arg0);
	}

	@Then("nominee page is displayed")
	public void nomineePageIsDisplayed() {
		Assert.assertTrue(nomineeDetails.checkIfInNomineePage());
	}

	@Then("user enters his {string}")
	public void userEntersHis(String arg0) throws IOException, InterruptedException {
		nomineeDetails.enterNomineeName(arg0);
	}

	@Then("user enters his relation with nominee as {string}")
	public void userEntersHisRelationWithNomineeAs(String arg0) {
		nomineeDetails.setNomineeRelation(arg0);
	}

	@Then("users sets birth date of nominee as {string}")
	public void usersSetsBirthDateOfNomineeAs(String arg0) {
		nomineeDetails.setNomineeDOB(arg0);
	}

	@Then("user clicks on proceed button on nominee page")
	public void userClicksOnProceedButtonOnNomineePage() {
		nomineeDetails.clickOnProceeed();
		Assert.assertTrue(nomineeDetails.verifyReviewYourInformationPage());
	}

	@Then("user clicks on continue button after verifying his submitted details")
	public void userClicksOnContinueButtonAfterVerifyingHisSubmittedDetails() {
		nomineeDetails.clickOnContinue();
		folioGeneration = nomineeDetails.goToFolioGenerationPage();
	}

	@Then("user verify that Folio Number is generated successfully")
	public void userVerifyThatFolioNumberIsGeneratedSuccessfully() throws WebDriverException, IOException {
		Assert.assertNotNull(folioGeneration.getFolioNumber());
		Assert.assertTrue(folioGeneration.verifyFolioNumberMessage());
		Screenshot.click("Folio Number Generation");
	}

	@Then("user clicks proceed to checkout button")
	public void userClicksProceedToCheckoutButton() {
		folioGeneration.clickOnProceedToCheckout();
	}

	@Then("user is in transaction screen")
	public void userIsInTransactionScreen() {
		transactionPage = folioGeneration.goToTransactionScreen();
		transactionPage.directToTransactionPage(AppHooks.InvestorBaseUrl());
	}

	@Then("user provides userId as {string}")
	public void userProvidesUserIdAs(String arg0) {
		signin = home.goToSigninScreen();
		signin.enterUserid(arg0);
	}

	@Then("user clicks on Next button")
	public void userClicksOnNextButton() {
		signin.clickOnNext();
	}

	@Then("user provides password as {string}")
	public void userProvidesPasswordAs(String arg0) {
		signin.enterPassword(arg0);
	}

	@Then("user verifies SignIn successfully")
	public void userVerifiesSignInSuccessfully() {
		String actualProfileName = signin.verifyProfileName();
		actualProfileName = actualProfileName.replace(".", "");
		String expectedProfileName = "TEST AUTOMATION";
		if (expectedProfileName.contains(actualProfileName)) {
			Assert.assertTrue(true, "User Signed in Successfully");
		} else {
			Assert.fail("User failed to signIn to the site");
		}
	}

	@Then("user clicks on SignIn button after entering username and password")
	public void userClicksOnSignInButtonAfterEnteringUsernameAndPassword() throws InterruptedException {
		signin.clickOnSignInButton();
	}

	@Then("user clicks on SignIn using Otp")
	public void userClicksOnSignInUsingOtp() {
		signin.clickOnSignInUsingOtp();
	}

	@Then("user selects email radiobutton for otp")
	public void userSelectsEmailRadiobuttonForOtp() {
		signin.selectEmailRadioButton();
	}

	@Then("user enters six digit OTP")
	public void userEntersSixDigitOTP() {
		signin.enterOtp();
	}

	@Then("user clicks on SignIn button after entering username and otp")
	public void userClicksOnSignInButtonAfterEnteringUsernameAndOtp() throws InterruptedException {
		signin.clickOnSignInButton();
	}

	@Then("user clicks on sendOTP button on SignIn Page")
	public void userClicksOnSendOTPButtonOnSignInPage() {
		signin.clickOnSendOtpButton();
	}

	@Then("user selects mobile radiobutton for otp")
	public void userSelectsMobileRadiobuttonForOtp() {
		signin.selectMobileRadioButton();
	}

	@Then("user is in GoalPlanner")
	public void userIsInGoalPlanner() {
		plan.clickOnGoalPlanner();
	}

	@Then("user click on BasicCalculator")
	public void userClickOnBasicCalculator() {
		plan.clickBasicCalculator();
	}

	@Then("user clicks on CloseIcon")
	public void userClicksOnCloseIcon() {
		plan.clickOnCloseIcon();
	}

	@Then("user entered HighRisk")
	public void userEnteredHighRisk() {
		plan.highRisk();
	}

	@Then("user clicked Done")
	public void userClickedDone() {
		plan.done();
	}

	@Then("user clicked BasicCalculator")
	public void userClickedBasicCalculator() {
		plan.clickBasicCalculator();
	}

	@Then("user clicked BackButton")
	public void userClickedBackButton() {
		plan.back();
	}

	@Then("user clicked AdvancedCalculator")
	public void userClickedAdvancedCalculator() {
		plan.clickAdvancedCalculator();
	}

	@Then("user clicked Calculate")
	public void userClickedCalculate() {
		plan.clickCalculate();
	}

	@Then("user clicked ContinueCalculate")
	public void userClickedContinueCalculate() {
		plan.continueCalculate();
	}

	@Then("user clicked on Holiday")
	public void userClickedOnHoliday() {
		plan.clickOnHoliday();
	}

	@Then("user clicked on Home")
	public void userClickedOnHome() {
		plan.clickHome();
	}

	@Then("user clicked on WealthCreation")
	public void userClickedOnWealthCreation() {
		plan.clickOnWealthCreation();
	}

	@Then("user clicked on Retirement")
	public void userClickedOnRetirement() {
		plan.clickOnRetirement();
	}

	@Then("user clicked on CustomizeGoal")
	public void userClickedOnCustomizeGoal() {
		plan.clickCustomizeGoal();
	}

	@Then("user clicked ButtonCalculate")
	public void userClickedButtonCalculate() {
		plan.clickOnBottomCalculate();
	}

	@Then("user enters his full name as {string}")
	public void userEntersHisFullNameAs(String arg0) {
		plan.enterName(arg0);
	}

	@Then("the user clicked on the Next button")
	public void theUserClickedOnTheNextButton() {
		plan.clickOnContinue();
	}

	@Then("user enters his Annual income as {string}")
	public void userEntersHisAnnualIncomeAs(String arg0) {
		plan.annualIncome(arg0);
	}

	@Then("user enters his Goal Cost as {string}")
	public void userEntersHisGoalCostAs(String arg0) {
		plan.goalCost(arg0);
	}

	@Then("user enters his Age as {string}")
	public void userEntersHisAgeAs(String arg0) {
		plan.enterAge(arg0);
	}

	@Then("user enters his Target Age as {string}")
	public void userEntersHisTargetAgeAs(String arg0) {
		plan.targetAge(arg0);
	}

	@Then("user enters his saved Amount as {string}")
	public void userEntersHisSavedAmountAs(String arg0) {
		plan.savedAmount(arg0);
	}

	@Then("user clicked on Child Education")
	public void userClickedOnChildEducation() throws InterruptedException {
		plan.clickOnEducation();
	}

	@Then("user clicked on Child Marriage")
	public void userClickedOnChildMarriage() {
		plan.clickOnMarriage();
	}

	@Then("user enters his first thought")
	public void userEntersHisFirstThought() {
		plan.clickFirstThought();
	}

	@Then("user enters his view on risk")
	public void userEntersHisViewOnRisk() {
		plan.clickOnUncertainty();
	}

	@Then("user clicked on Salaried Employee")
	public void userClickedOnSalariedEmployee() {
		plan.clickOnSalariedEmployee();
	}

	@Then("user enters his Risk percentage")
	public void userEntersHisRiskPercentage() {
		plan.clickOnRisk();
	}

	@Then("user enters his Performance Expectation")
	public void userEntersHisPerformanceExpectation() {
		plan.clickOnPerformance();
	}

	@Then("user clicked on UnderPerformed")
	public void userClickedOnUnderPerformed() {
		plan.clickOnUnderPerformed();
	}

	@Then("user clicked on DemographicScore")
	public void userClickedOnDemographicScore() {
		plan.clickOnDemographicScore();
	}

	@Then("user clicked on AssetAllocation")
	public void userClickedOnAssetAllocation() {
		plan.clickOnAssetAllocation();
	}

	@Then("user clicked on ShowFunds")
	public void userClickedOnShowFunds() {
		plan.clickOnShowFunds();
	}

	@Then("user verifies that goal planner is visible")
	public void userVerifiesThatGoalPlannerIsVisible() {
		Assert.assertTrue(plan.isGoalPlannerDisplayed());
	}

	@Then("user verifies that basic calculator button is visible")
	public void userVerifiesThatBasicCalculatorButtonIsVisible() {
		Assert.assertTrue(plan.isBasicCalculatorButtonDisplayed());
	}

	@Then("user verifies that advanced calculator button is visible")
	public void userVerifiesThatAdvancedCalculatorButtonIsVisible() {
		Assert.assertTrue(plan.isAdvancedCalculatorButtonDisplayed());
	}

	@Then("user verifies that calculate button is visible")
	public void userVerifiesThatCalculateButtonIsVisible() {
		Assert.assertTrue(plan.isCalculateButtonDisplayed());
	}

	@Then("user verifies that customize goal button is visible")
	public void userVerifiesThatCustomizeGoalButtonIsVisible() {
		Assert.assertTrue(plan.isCustomizedGoalButtonDisplayed());
	}

	@Then("user verifies that risk appetite calculator button is visible")
	public void userVerifiesThatRiskAppetiteCalculatorButtonIsVisible() {
		Assert.assertTrue(plan.isRiskAppetiteCalculatorButtonDisplayed());
	}

	@Then("on homepage user clicks on section - Learn")
	public void onHomepageUserClicksOnSectionLearn() {
		Assert.assertTrue(home.isLearnOptionEnabled(), "Learn section is not clickable");
		learn = home.clickLearnPage();
	}

	@Then("under Knowledge Center user clicks on option - Explore ALL")
	public void underKnowledgeCenterUserClicksOnOptionExploreALL() {
		learn.clickExploreAll();
	}

	@When("user is on Knowledge Center page")
	public void userIsOnKnowledgeCenterPage() {
		Assert.assertTrue(learn.isKnowledgeCenterDisplayed(), "Knowledge center page cannot be validated");
	}

	@Then("user clicks on section - Videos, Podcasts & Articles")
	public void userClicksOnSectionVideosPodcastsArticles() {
		learn.clickVideosPodcastArticles();
	}

	@Then("user navigates back to Learn section by clicking on section - Learn")
	public void userNavigatesBackToLearnSectionByClickingOnSectionLearn() {
		home.clickLearnPage();
	}

	@When("user is on Learn page")
	public void userIsOnLearnPage() {
		Assert.assertTrue(learn.isLearnPageDisplayed());
	}

	@Then("user navigates to FAQ page by clicking option - VIEW ALL")
	public void userNavigatesToFAQPageByClickingOptionVIEWALL() {
		learn.clickFaq();
		Assert.assertTrue(learn.verifyFaq(), "FAQ tabs verified successfully");

	}

	@Then("user is able to consult an expert by providing {string} & clicking on option - ASK EXPERT")
	public void userIsAbleToConsultAnExpertByProvidingClickingOnOptionASKEXPERT(String arg0) {
		learn.consultExpert(arg0);
	}

	@Then("user clicked on customer care tab")
	public void userClickedOnCustomerCareTab() {
		helpCenter.clickOnCustomerCare();
	}

	@Then("user verifies that details of customer care button are visible")
	public void userVerifiesThatDetailsOfCustomerCareButtonAreVisible() {
		Assert.assertTrue(helpCenter.areDetailsOfCustomerCareButtonDisplayed());
	}

	@Then("user clicked on our offices tab")
	public void userClickedOnOurOfficesTab() {
		helpCenter.clickOnOurOffices();
	}

	@Then("user verifies that details of our offices tab are visible")
	public void userVerifiesThatDetailsOfOurOfficesTabAreVisible() {
		Assert.assertTrue(helpCenter.areDetailsOfOurOfficesButtonDisplayed());
	}

	@Then("user clicked on escalations tab")
	public void userClickedOnEscalationsTab() {
		helpCenter.clickOnEscalations();
	}

	@Then("user verifies that details of escalations tab are visible")
	public void userVerifiesThatDetailsOfEscalationsTabAreVisible() {
		Assert.assertTrue(helpCenter.areDetailsOfEscalationsButtonDisplayed());
	}

	@Then("user clicked on corporate information tab")
	public void userClickedOnCorporateInformationTab() {
		helpCenter.clickOnCorporateInformation();
	}

	@Then("user verifies that details of corporate information tab are visible")
	public void userVerifiesThatDetailsOfCorporateInformationTabAreVisible() {
		Assert.assertTrue(helpCenter.areDetailsOfCorporateInformationButtonDisplayed());
	}

	@Then("user verifies that pre login card is visible")
	public void userVerifiesThatPreLoginCardIsVisible() {
		Assert.assertTrue(helpCenter.isPreLoginCardDisplayed());
	}

	@Then("user verifies that post login card is visible")
	public void userVerifiesThatPostLoginCardIsVisible() {
		Assert.assertTrue(helpCenter.isPostLoginCardDisplayed());
	}

	@Then("user verifies that third party card is visible")
	public void userVerifiesThatThirdPartyCardIsVisible() {
		Assert.assertTrue(helpCenter.isThirdPartyCardDisplayed());
	}

	@Then("user clicks on branch locator button")
	public void userClicksOnBranchLocatorButton() {
		helpCenter.clickOnBranchLocator();
	}

	@Then("user verifies that branch locator button is visible")
	public void userVerifiesThatBranchLocatorButtonIsVisible() {
		Assert.assertTrue(helpCenter.isBranchLocatorButtonDisplayed());
	}

	@Then("user clicks on calculators button")
	public void userClicksOnCalculatorsButton() {
		helpCenter.clickOnCalculators();
	}

	@Then("user verifies that calculators button details are visible")
	public void userVerifiesThatCalculatorsButtonDetailsAreVisible() {
		Assert.assertTrue(helpCenter.isCalculatorsButtonDisplayed());
	}

	@Then("user clicks on existing customer checkbox")
	public void userClicksOnExistingCustomerCheckbox() {
		helpCenter.clickOnExistingCustomer();
	}

	@Then("user enters his email id as {string}")
	public void userEntersHisEmailIdAs(String arg0) {
		helpCenter.enteredHisEmailID(arg0);
	}

	@Then("user enters his contact number as {string}")
	public void userEntersHisContactNumberAs(String arg0) {
		helpCenter.enteredHisContactNumber(arg0);
	}

	@Then("user selects his city and state")
	public void userSelectsHisCityAndState() {
		helpCenter.clickOnCityState();
	}

	@Then("user selects reason for contact")
	public void userSelectsReasonForContact() {
		helpCenter.clickOnReasonForContact();
	}

	@Then("user selects his subject")
	public void userSelectsHisSubject() {
		helpCenter.clickOnSubject();
	}

	@Then("user enters his message {string}")
	public void userEntersHisMessage(String arg0) {
		helpCenter.enteredHisMessage(arg0);
	}

	@Then("user clicks in the terms and conditions")
	public void userClicksInTheTermsAndConditions() {
		helpCenter.clickOnTermsCondition();
	}

	@Then("user clicks on submit")
	public void userClicksOnSubmit() {
		helpCenter.clicksOnSubmit();
	}

	@Then("user entered his full Name as {string}")
	public void userEnteredHisFullNameAs(String arg0) {
		helpCenter.enteredHisFullName(arg0);
	}

	@Then("user clicked on send OTP button")
	public void userClickedOnSendOTPButton() {
		Assert.assertTrue(helpCenter.sendOtpDisplayed());
		helpCenter.clickSendOTP();
	}

	@Then("user provides six digits OTP on page")
	public void userProvidesSixDigitsOTPOnPage() {
		helpCenter.setOTP();
	}

	@Then("user verifies the successful OTP verification one")
	public void userVerifiesTheSuccessfulOTPVerificationOne() {
		Assert.assertTrue(helpCenter.isOtpVerifiedOne());
	}

	@Then("user verifies the successful OTP verification two")
	public void userVerifiesTheSuccessfulOTPVerificationTwo() {
		Assert.assertTrue(helpCenter.isOtpVerifiedTwo());
	}

	@Then("user verifies the submitted request")
	public void userVerifiesTheSubmittedRequest() {
		Assert.assertTrue(helpCenter.isRequestSubmitted());
	}

	@Then("user clicks on download button")
	public void userClicksOnDownloadButton() {
		helpCenter.clickOnDownloads();
	}

	@Then("user verifies that download button details are visible")
	public void userVerifiesThatDownloadButtonDetailsAreVisible() {
		Assert.assertTrue(helpCenter.isDownloadsButtonDisplayed());
	}

	@Then("user clicks on forms")
	public void userClicksOnForms() {
		helpCenter.clickOnForms();
	}

	@Then("user clicks on each sub tabs of forms")
	public void userClicksOnEachSubTabsOfForms() {
		helpCenter.clickOnFormsSubtype();
	}

	@Then("user verifies the apply button applicability")
	public void userVerifiesTheApplyButtonApplicability() {
		Assert.assertTrue(helpCenter.isApplyButtonDisplayed());
	}

	@Then("user clicks on sidkimsai")
	public void userClicksOnSidkimsai() {
		helpCenter.clickOnSidKimSai();
	}

	@Then("user clicks on each sub tabs of sidkimsai")
	public void userClicksOnEachSubTabsOfSidkimsai() {
		Assert.assertTrue(helpCenter.clickOnSidKimSaiSubtype(), "All tabs KIM, SID, SAI are not displayed");
	}

	@Then("user clicks on others")
	public void userClicksOnOthers() {
		helpCenter.clickOnOthers();
	}

	@Then("user verifies others tab is displayed")
	public void userVerifiesOthersTabIsDisplayed() {
		Assert.assertTrue(helpCenter.isOthersButtonDisplayed());
	}

	@Then("user clicks on our funds button")
	public void userClicksOnOurFundsButton() {
		helpCenter.clickOnOurFunds();
	}

	@Then("user verifies that our funds button details are visible")
	public void userVerifiesThatOurFundsButtonDetailsAreVisible() {
		Assert.assertTrue(helpCenter.isOurFundsButtonContentsDisplayed());
	}

	@Then("user clicks on knowledge center button")
	public void userClicksOnKnowledgeCenterButton() {
		helpCenter.clickOnKnowledgeCenter();
	}

	@Then("user verifies that knowledge center button details are visible")
	public void userVerifiesThatKnowledgeCenterButtonDetailsAreVisible() {
		Assert.assertTrue(helpCenter.isKnowledgeCenterButtonContentsDisplayed());
	}

	@Then("user clicks on investor services button")
	public void userClicksOnInvestorServicesButton() {
		helpCenter.clickOnInvestorServices();
	}

	@Then("user verifies that investor services button details are visible")
	public void userVerifiesThatInvestorServicesButtonDetailsAreVisible() {
		Assert.assertTrue(helpCenter.isInvestorServicesButtonContentsDisplayed());
	}

	@Then("user clicks on FAQs button")
	public void userClicksOnFAQsButton() {
		helpCenter.clickFaq();
		Assert.assertTrue(helpCenter.verifyFaq(), "FAQ tabs verified successfully");
	}

	@Then("user clicks on consult an expert by providing {string} & clicking on option - ASK EXPERT")
	public void userClicksOnConsultAnExpertByProvidingClickingOnOptionASKEXPERT(String arg0) {
		helpCenter.clickOnAskExpert(arg0);
	}

	@Then("user clicks on explore button")
	public void userClicksOnExploreButton() {
		helpCenter.clickOnExplore();
	}

	@Then("user verifies that explore button details are visible")
	public void userVerifiesThatExploreButtonDetailsAreVisible() {
		Assert.assertTrue(helpCenter.isExploreButtonDisplayed(), "Explore tabs verified successfully");
	}

	@Then("user gets an error message of {string}")
	public void userGetsAnErrorMessageOf(String arg0) {
		Assert.assertTrue(signin.authError(arg0));
	}

	@Then("user enters a wrong six digit OTP")
	public void userEntersAWrongSixDigitOTP() {
		signin.enterWrongOtp();
	}

	@Then("user clicks on his profile name to display list of options")
	public void userClicksOnHisProfileNameToDisplayListOfOptions() throws Exception {
		signin.clickProfileName();
	}

	@Then("user selects {string} option from drop down")
	public void userSelectsOptionFromDropdown(String arg0) {
		signin.selectDashboardOption(arg0);
	}

	@Then("user sees his name displayed on the page")
	public void userSeesHisNameDisplayedOnThePage() {
		Assert.assertEquals(signin.checkHelloMessage(), "Hello", "hello not diaplayed");
	}

	@Then("quick links are displayed")
	public void quickLinksAreDisplayed() {
		Assert.assertTrue(signin.quickLinksAreDisplayed());
	}

	@Then("user is displayed with his portfolio summary")
	public void userIsDisplayedWithHisPortfolioSummary() {
		Assert.assertTrue(signin.checkIfPortfolioIsDisplayed());
	}

	@Then("user updates his contact details belongs to {string}")
	public void userUpdatesHisContactDetailsBelongsTo(String arg0) {
		kycRegister.updateContactDetailsDropDown(arg0);
	}

	@Then("user clicks on continue on setup your account page")
	public void userClicksOnContinueOnSetupYourAccountPage() throws InterruptedException {
		kycRegister.clickContinue("Business", "Gift");
	}

	@Then("user clicks on support button")
	public void userClicksOnSupportButton() {
		home.clickHelpCenterTab();
	}

	@Then("user is already in support tab")
	public void userIsAlreadyInSupportTab() {
		Assert.assertTrue(home.isHelpCenterTabDisplayed());
		helpCenter = home.goToHelpCenterPage();
	}

	@Then("user clicks on Tools button")
	public void userClicksOnToolsButton() {
		home.clickPlanTab();
	}

	@Then("user is already in tools tab")
	public void userIsAlreadyInToolsTab() {
		Assert.assertTrue(home.isPlanTabDisplayed());
		plan = home.goToPlanPage();
	}

	@Then("user clicks on Services button")
	public void userClicksOnServicesButton() {
		home.clickServicesTab();
	}

	@Then("user is already in Services tab")
	public void userIsAlreadyInServicesTab() {
		Assert.assertTrue(home.isServiceTabDisplayed());
		serviceTab = home.goToServicePage();
	}

	@Then("user verifies if he is able to see the heading as Investor Services")
	public void userVerifiesIfHeIsAbleToSeeTheHeadingAsInvestorServices() {
		Assert.assertEquals(serviceTab.getInvestorServicesHeader(), "Investor Services", "Page heading not matching");
	}

	@Then("user verifies if he is able to see all the sub services")
	public void userVerifiesIfHeIsAbleToSeeAllTheSubServices() {
		Assert.assertTrue(serviceTab.getSubInvestorServices());
	}

	@Then("user verifies if he all the details along with description are correct")
	public void userVerifiesIfHeAllTheDetailsAlongWithDescriptionAreCorrect() {
		Assert.assertTrue(serviceTab.allServices());
	}
}
