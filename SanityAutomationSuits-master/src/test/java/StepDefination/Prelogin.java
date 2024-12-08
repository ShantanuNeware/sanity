package StepDefination;

import ApplicationHooks.AppHooks;
import com.driver.Factory;
import distributor.DisPrelogin;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.preloginpage.PreLogin;
import pages.transactions.TransactionPage;

public class Prelogin {
	private final PreLogin preLogin = new PreLogin(Factory.getDriver());
	private final DisPrelogin disPrelogin = new DisPrelogin(Factory.getDriver());
	private final TransactionPage transactionsPage = new TransactionPage(Factory.getDriver());

	@Given("User pastes the link in the browser according to the environment clicks on enter")
	public void userPastesTheLinkInTheBrowserAccordingToTheEnvironmentClicksOnEnter() {
		preLogin.investorURL("https://" + AppHooks.InvestorBaseUrl() + "/home/sign-in");
	}

	@Then("user provides username")
	public void userProvidesUsername() {
		preLogin.setUsername("TESTUSER11");
	}

	@Then("user provides password")
	public void userProvidesPassword() {
		preLogin.setPassword("Sachin@11");
	}

	@Then("user clicks on sign in")
	public void userClicksOnSignIn() {
		preLogin.clickOnSubmit();
	}

	@Then("user is redirected to ICICI homepage")
	public void userIsRedirectedToICICIHomepage() {
		Assert.assertEquals(preLogin.getURL(), "https://" + AppHooks.InvestorBaseUrl() + "/home/sign-in");
	}

	@Then("distributor clicks home tab")
	public void distributorClicksHomeTab() {
		disPrelogin.clickHomePageTab();
	}

	@Then("Distributor verifies if he is in homepage tab and clicks on services tab")
	public void distributorVerifiesIfHeIsInHomepageTabAndClicksOnServicesTab() {
		Assert.assertTrue(disPrelogin.clickServices(), "all headings are not displayed");
	}

	@Then("Distributor verifies if he is in initiate new transaction page")
	public void distributorVerifiesIfHeIsInInitiateNewTransactionPage() {
		Assert.assertTrue(disPrelogin.inttab(), "All the headings and buttons not enabled");
	}

	@When("Distributor provides IFA as {string} and folio as {string} and clicks on continue")
	public void distributorProvidesIFAAsAndFolioAsAndClicksOnContinue(String arg0, String arg1) {
		Assert.assertTrue(disPrelogin.fillDataInInitiateNewTransaction(arg0, arg1), "Continue button is not enabled");

	}

	@Then("distributor checks terms and condition and hits send to investor")
	public void distributorChecksTermsAndConditionAndHitsSendToInvestor() {
		transactionsPage.tncAndSendToInvestor();
	}
}
