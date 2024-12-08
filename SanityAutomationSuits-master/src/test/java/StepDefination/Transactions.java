package StepDefination;

import ApplicationHooks.AppHooks;
import com.driver.Factory;
import com.utility.ReadFromFile;
import com.utility.Screenshot;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import org.openqa.selenium.WebDriverException;
import org.testng.Assert;
import pages.transactions.TransactionPage;

public class Transactions {
	private final TransactionPage transactionsPage = new TransactionPage(Factory.getDriver());

	@Then("user is redirected to transaction page")
	public void userIsRedirectedToTransactionPage() {
		transactionsPage.directToTransactionPage(AppHooks.InvestorBaseUrl());
	}

	@Then("user is selects {string},{string},{string},{string} , provides amount as {string}")
	public void userIsSelectsProvidesAmountAs(String arg0, String arg1, String arg2, String arg3, String arg4) {
		transactionsPage.selectSchemesAmountProceed(arg0, arg1, arg2, arg3, arg4);
	}

	@Then("user provides otp and checks terms and condition")
	public void userProvidesOtpAndChecksTermsAndCondition() throws InterruptedException {
		transactionsPage.sentOTPTNC();

	}

	@Then("user proceeds to do UPI transaction using UPI id as {string}")
	public void userProceedsToDoUPITransactionUsingUPIIdAs(String arg0) throws InterruptedException {
		transactionsPage.doUPITransaction(arg0);
	}

	@Then("user is in transaction receipt page for verification of folio number as {string} and payment method as {string}")
	public void userIsInTransactionReceiptPageForVerificationOfFolioNumberAsAndPaymentMethodAs(String arg0, String arg1)
			throws WebDriverException, IOException, InterruptedException {

		String folioNo = ReadFromFile.readOneLineData("target/folioNo.txt");
		if (!folioNo.isEmpty())
			Assert.assertEquals(transactionsPage.inRRGPVerifyFolioNumber(), folioNo, "Folio Number not matching");
		else
			Assert.assertEquals(transactionsPage.inRRGPVerifyFolioNumber(), arg0, "Folio Number not matching");
		Assert.assertEquals(transactionsPage.inRRGPVerifyPaymentMethod(), arg1, "Payment Method not matching");
		Screenshot.click("Transaction Receipt");
	}

	@When("user is in transaction page")
	public void userIsInTransactionPage() {
		Assert.assertTrue(transactionsPage.inTransactionPage());
	}

	@When("user is in schemes page")
	public void userIsInSchemesPage() {
		Assert.assertTrue(transactionsPage.inSchemePage());
	}

	@When("user is in otp page")
	public void userIsInOtpPage() {
		Assert.assertTrue(transactionsPage.inOTPPage());
	}

	@When("user is in payment page")
	public void userIsInPaymentPage() {
		Assert.assertTrue(transactionsPage.inPaymentPage());
	}

	@Then("user is redirected to ICICI payment page")
	public void userIsRedirectedToICICIPaymentPage() throws InterruptedException {
		transactionsPage.submitUserIdAndPassword("testinfi8", "test$2018");
	}

	@Then("user selects already Mandate from mandate section and selects {string}")
	public void userSelectsAlreadyMandateFromMandateSectionAndSelects(String arg0) throws InterruptedException {
		transactionsPage.doSubmitExistingMandate(arg0);
	}

	@Then("user selects net banking as payment mode")
	public void userSelectsNetBankingAsPaymentMode() throws InterruptedException {
		transactionsPage.doNetBanking();
	}

	@Then("user selects his PAN as {string} , Folio as {string}")
	public void userSelectsHisPANAsFolioAs(String arg0, String arg1) {
		transactionsPage.selectPANFolio(arg0, arg1);
	}

	@Then("user selects Create New Auto Mandate from mandate section and creates a mandate of {string}")
	public void userSelectsCreateNewAutoMandateFromMandateSectionAndCreatesAMandateOf(String arg0)
			throws InterruptedException {
		transactionsPage.doCreateNewMandate(arg0);
	}

	@Then("user clicks on proceed button on investment details page")
	public void userClicksOnProceedButtonOnInvestmentDetailsPage() throws InterruptedException {
		transactionsPage.clickProceedInvestmentDetails();
	}

	@Then("user selects {string} ,{string} ,{string} ,{string},{string},{string},{string},{string},{string}")
	public void userSelects(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6,
			String arg7, String arg8) throws Exception, InterruptedException {
		transactionsPage.selectFrequencyAndOtherDetails(arg0, arg1, arg2, true, Boolean.valueOf(arg4), arg5,
				Integer.parseInt(arg6), arg7, arg8);
	}

	@Then("user selects his PAN as {string} , Folio as {string} and clicks on proceed button on Booster Sip transaction")
	public void userSelectsHisPANAsFolioAsAndClicksOnProceedButtonOnBoosterSipTransaction(String arg0, String arg1) {
		transactionsPage.selectPANFolio(arg0, arg1);
	}

	@Then("user selects Sip transaction")
	public void userSelectsSipTransaction() {
		transactionsPage.clickSip();
	}

	@Then("user selects lumpsum transaction")
	public void userSelectsLumpsumTransaction() {
		transactionsPage.clickLumpsum();
	}

	@Then("user clicks on proceed button on Booster Sip transaction")
	public void userClicksOnProceedButtonOnBoosterSipTransaction() {
		transactionsPage.clickBoosterSIP();
	}

	@Then("user selects STP details {string}, {string},{string}, {string},{string}")
	public void userSelectsSTPDetails(String arg0, String arg1, String arg2, String arg3, String arg4)
			throws InterruptedException {
		transactionsPage.fillSTPDetails(arg0, arg1, arg2, arg3, arg4);
	}

	@Then("user clicks on proceed button on Freedom Sip transaction")
	public void userClicksOnProceedButtonOnFreedomSipTransaction() {
		transactionsPage.clickFreedomSip();
	}

	@Then("user selects SWP details {string}, {string},{string}, {string},{string}")
	public void userSelectsSWPDetails(String arg0, String arg1, String arg2, String arg3, String arg4)
			throws InterruptedException {
		transactionsPage.fillSWPDetails(arg0, arg1, arg2, arg3, arg4);
	}

	@Then("user clicks on proceed button on withdraw redeem transaction")
	public void userClicksOnProceedButtonOnWithdrawRedeemTransaction() {
		transactionsPage.clickWithdrawRedeem();
	}

	@Then("user selects his fund as {string}, {string}, {string} from cart menu and clicks on proceed")
	public void userSelectsHisFundAsFromCartMenuAndClicksOnProceed(String arg0, String arg1, String arg2)
			throws InterruptedException {
		transactionsPage.doRedeem(arg0, arg1, arg2);
	}

	@Then("user checks his bank details and clicks on continue")
	public void userChecksHisBankDetailsAndClicksOnContinue() throws InterruptedException {
		transactionsPage.checkBankDetails();
	}

	@When("user is in redeem otp page")
	public void userIsInRedeemOtpPage() throws InterruptedException {
		transactionsPage.sentOTPTNCRedeem();
	}

	@Then("user clicks on proceed button on withdraw redeem Freedom SWP transaction")
	public void userClicksOnProceedButtonOnWithdrawRedeemFreedomSWPTransaction() {
		transactionsPage.clickRedeemFreedomSWp();
	}

	@Then("user selects his fund as {string}, {string}, {string}, {string}, {string},{string} from cart menu and clicks on proceed")
	public void userSelectsHisFundAsFromCartMenuAndClicksOnProceed(String arg0, String arg1, String arg2, String arg3,
			String arg4, String arg5) throws Exception, InterruptedException {
		transactionsPage.doRedeemFreedomSWP(arg0, arg1, Integer.parseInt(arg2), arg3, arg4, arg5);
	}

	@Then("user clicks on start button on switch switch transaction")
	public void userClicksOnStartButtonOnSwitchSwitchTransaction() {
		transactionsPage.clickSwitchSwitch();

	}

	@Then("user selects his fund as {string}, {string}, {string}, {string},{string},{string} from cart menu and clicks on proceed for switch")
	public void userSelectsHisFundAsFromCartMenuAndClicksOnProceedForSwitch(String arg0, String arg1, String arg2,
			String arg3, String arg4, String arg5) throws InterruptedException {
		transactionsPage.fillNewSwitchDetails(arg0, arg1, arg2, arg3, arg4, arg5);
	}

	@Then("user clicks on start button on switch STP transaction")
	public void userClicksOnStartButtonOnSwitchSTPTransaction() {
		transactionsPage.clickSwitchSTP();
	}

	@Then("user selects his fund as {string},{string},{string},{string},{string},{string},{string}, {string},{string} from cart menu and clicks on proceed for switch STP")
	public void userSelectsHisFundAsFromCartMenuAndClicksOnProceedForSwitchSTP(String arg0, String arg1, String arg2,
			String arg3, String arg4, String arg5, String arg6, String arg7, String arg8) throws InterruptedException {
		transactionsPage.fillNewSTPDetails(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
	}

	@Then("user clicks on start button on switch Flex STP transaction")
	public void userClicksOnStartButtonOnSwitchFlexSTPTransaction() {
		transactionsPage.clickSwitchFlexSTP();
	}

	@Then("user clicks on start button on switch Booster STP transaction")
	public void userClicksOnStartButtonOnSwitchBoosterSTPTransaction() {
		transactionsPage.clickSwitchBoosterSTP();
	}

	@Then("user clicks on start button on Others Rollover transaction")
	public void userClicksOnStartButtonOnOthersRolloverTransaction() {
		transactionsPage.clickOthersRollover();
	}

	@Then("user clicks on start button on Others Trigger on Maturity transaction")
	public void userClicksOnStartButtonOnOthersTriggerOnMaturityTransaction() {
		transactionsPage.clickOthersTriggerOnMaturity();
	}

	@Then("user selects his fund as {string},{string}, {string},{string} from cart menu and clicks on proceed for switch STP")
	public void userSelectsHisFundAsFromCartMenuAndClicksOnProceedForSwitchSTP(String arg0, String arg1, String arg2,
			String arg3) throws InterruptedException {
		transactionsPage.fillTriggerOnMaturity(arg0, arg1, arg2, arg3);
	}

	@Then("user clicks on start button on Others Close Ended Scheme Redeem transaction")
	public void userClicksOnStartButtonOnOthersCloseEndedSchemeRedeemTransaction() throws InterruptedException {
		transactionsPage.clickOthersCloseEndedSchemeRedeem();
	}

	@Then("user clicks on start button on Others Close Ended Scheme Switch transaction")
	public void userClicksOnStartButtonOnOthersCloseEndedSchemeSwitchTransaction() {
		transactionsPage.clickOthersCloseEndedSchemeSwitch();
	}

	@Then("user selects his fund as {string},{string}, {string},{string}, {string} from cart menu and clicks on proceed for switch")
	public void userSelectsHisFundAsFromCartMenuAndClicksOnProceedForSwitch(String arg0, String arg1, String arg2,
			String arg3, String arg4) throws InterruptedException {
		transactionsPage.fillCloseEndedSchemeSwitch(arg0, arg1, arg2, arg3, arg4);
	}

}
