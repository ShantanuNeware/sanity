package StepDefination;

import org.openqa.selenium.WebDriver;

import com.driver.Factory;

import pages.transactions.SanityTransactions;
import pages.homepage.Login;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.Properties;

public class Sanity_Login {

	static Properties properties;
	private final Login Login = new Login(Factory.getDriver());
	private final SanityTransactions SanitytransactionsPage = new SanityTransactions(Factory.getDriver());
	private WebDriver driver;

	@Given("User pastes the link in the browser and clicks on enter")
	public void userPastesTheLinkInTheBrowserAccordingToTheEnvironmentClicksOnEnter() {
		Login.investorURL("https://www.icicipruamc.com/sign-in");
	}

	@Then("User click on Log In button")
	public void User_clicks_on_Login_button() {
		Login.clickOnLoginButton();
	}

	@Then("User Click on UserID field")
	public void User_click_userid() throws InterruptedException {
		Login.clickonuserid();
	}

	@Then("Enter {string} userid")
	public void enterUserid(String arg0) throws InterruptedException {
		Login.enterUserid(arg0);

	}

	@Then("Click On Next button")
	public void clickOnNext() throws InterruptedException {
		Login.clickOnNext();
	}

	@Then("Enter {string} password")
	public void enterPassword(String arg0) throws InterruptedException {
		Login.enterPassword(arg0);

	}

	@Then("Click On SignIn button")
	public void clickOnSignIn() throws InterruptedException {
		Login.clickOnSignIn();
	}

	@Then("Click On Profile Name")
	public void clickProfileName() throws InterruptedException {
		Login.clickProfileName();
		System.out.println();
	}

	@Then("Navigate to Transactions page")
	public void NavigateToTransactionPage() {
		SanitytransactionsPage.directToTransaction();
	}

	@Then("Select Pan {string} Folio {string}")
	public void selectPANFolio(String arg0, String arg1) {
		SanitytransactionsPage.selectPANFolio(arg0, arg1);
	}

	@Then("click Invest tab")
	public void clickInvestTab() throws InterruptedException {
		SanitytransactionsPage.clickInvestTab();
	}

	@Then("click Withdraw tab")
	public void clickWithdrawTab() throws InterruptedException {
		SanitytransactionsPage.clickWithdrawTab();
	}

	@Then("click Switch tab")
	public void clickSwitchTab() throws InterruptedException {
		SanitytransactionsPage.clickSwitchTab();
	}

	@Then("click Others tab")
	public void clickOthersTab() throws InterruptedException {
		SanitytransactionsPage.clickOthersTab();
	}

	@Then("Click Lumpsum Start")
	public void SelectLumpsum() throws InterruptedException {
		SanitytransactionsPage.SelectLumpsum();
	}

	@Then("Click SIP Start")
	public void SelectSIP() throws InterruptedException {
		SanitytransactionsPage.SelectSIP();
	}

	@Then("Click Redeem Start")
	public void SelectRedeem() throws InterruptedException {
		SanitytransactionsPage.SelectRedeem();
	}

	@Then("Click Switch Start")
	public void SelectSwitch() throws InterruptedException {
		SanitytransactionsPage.SelectSwitch();
	}

	@Then("Select Category {string}")
	public void selectCategory(String arg0) {
		SanitytransactionsPage.selectCategory(arg0);
	}

	@Then("Select Fund {string}")
	public void selectFund(String arg0) {
		SanitytransactionsPage.selectFund(arg0);
	}

	@Then("Select Scheme Option {string}")
	public void selectSchemeOption(String arg0) {
		SanitytransactionsPage.selectSchemeOption(arg0);
	}

	@Then("Enter Amount {string}")
	public void Enter_Amount(String arg0) throws InterruptedException {
		SanitytransactionsPage.EnterAmount(arg0);
	}

	@Then("Click Proceed To Payment Lumpsum")
	public void clickProceedToPaymentLumpsum() throws InterruptedException {
		SanitytransactionsPage.clickProceedToPaymentPurchase();
		Thread.sleep(5000);
	}

	@Then("Click Proceed To Payment SIP")
	public void clickProceedToPayment() throws InterruptedException {
		SanitytransactionsPage.clickProceedToPaymentSIP();
		Thread.sleep(5000);
	}

	@Then("Enter OTP for Lumpsum")
	public void EnterOTPLumpsum() throws InterruptedException {
		SanitytransactionsPage.EnterOTPLumpsum();
		Thread.sleep(5000);
	}

	@Then("Enter OTP for SIP")
	public void EnterOTPSIP() throws InterruptedException {
		SanitytransactionsPage.EnterOTPSIP();
		Thread.sleep(5000);
	}

	@Then("Click on Terms and condition")
	public void ClickOnTermsCondition() throws InterruptedException {
		SanitytransactionsPage.ClickOnTermsCondition();
		Thread.sleep(5000);
	}

	@Then("Click on Continue")
	public void ClickOnContinue() throws InterruptedException {
		SanitytransactionsPage.ClickOnContinue();
	}

	@Then("Lumpsum Enter UPI ID {string} and click on verify")
	public void EnterUPI_Click_PreoceedTo_Pay(String arg0) throws InterruptedException {
		Thread.sleep(5000);
		SanitytransactionsPage.EnterUPI_Click_PreoceedTo_Pay(arg0);
	}

	@Then("user selects his fund as {string}")

	public void userSelectsHisFundforRedeem_Switch(String arg0) throws InterruptedException {
		Thread.sleep(5000);
		SanitytransactionsPage.userSelectsHisFundforRedeem_Switch(arg0);
	}

	@Then("user selects Redeemmode {string}, {string} from cart menu and clicks on proceed")
	public void userSelectsredeemMode(String arg0, String arg1) throws InterruptedException {
		SanitytransactionsPage.doRedeem2(arg0, arg1);
		Thread.sleep(5000);
	}

	@Then("user selects mode for switch {string} {string}")
	public void userSelectsModeforSwitch(String arg0, String arg1) throws InterruptedException {
		SanitytransactionsPage.userSelectsModeforSwitch(arg0, arg1);
		Thread.sleep(5000);
	}

	@Then("user selects Category for switch {string}")
	public void userSelectsCategoryforSwitch(String arg0) throws InterruptedException {
		SanitytransactionsPage.userSelectsCategoryforSwitch(arg0);
		Thread.sleep(5000);
	}

	@Then("user selects Fund for switch {string}")
	public void userSelectsFundforSwitch(String arg0) throws InterruptedException {
		SanitytransactionsPage.userSelectsFundforSwitch(arg0);
		Thread.sleep(5000);
	}

	@Then("user selects SchemeOption for switch {string}")
	public void userSelectsSchemeOptionforSwitch(String arg0) throws InterruptedException {
		SanitytransactionsPage.userSelectsSchemeOptionforSwitch(arg0);
		Thread.sleep(5000);
	}

	@Then("user Enters Amount or Units {string} {string}")
	public void userEnterAmountorUnit(String arg0, String arg1) throws InterruptedException {
		SanitytransactionsPage.userEnterAmountORUnit(arg0, arg1);
		Thread.sleep(5000);
	}

	@Then("SIP Enter UPI ID {string} and click on verify")
	public void EnterUPIMandate_Click_PreoceedTo_Pay(String arg0) throws InterruptedException {
		Thread.sleep(5000);
		SanitytransactionsPage.EnterUPIMandate_Click_PreoceedTo_Pay(arg0);
	}

	@Then("user checks his bank details and clicks continue")
	public void userChecksHisBankDetailsAndClicksOnContinue() throws InterruptedException {
		SanitytransactionsPage.checkBankDetails();
	}

	@Then("Click Proceed To Payment")
	public void clickProceedToPayment1() throws InterruptedException {
		SanitytransactionsPage.clickProceedToPayment();
		Thread.sleep(5000);
	}

	@Then("User Enters amount for switch {string} {string}")
	public void userEnterAmountORUnit(String arg0, String arg1) throws InterruptedException {
		SanitytransactionsPage.userEnterAmountORUnit(arg0, arg1);
		Thread.sleep(5000);
	}

	@Then("Click Continue for switch")
	public void Click_Continue_ButtonSwitch() throws InterruptedException {
		Thread.sleep(5000);
		SanitytransactionsPage.Click_Continue_ButtonSwitch();

	}

}
