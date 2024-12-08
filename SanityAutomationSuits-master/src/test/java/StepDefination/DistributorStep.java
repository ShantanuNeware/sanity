package StepDefination;

import ApplicationHooks.AppHooks;
import com.driver.Factory;
import distributor.Dashboard;
import distributor.GrowYourBusiness;
import distributor.HomePage;
import distributor.SipBook;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.preloginpage.PreLogin;

public class DistributorStep {
	private final PreLogin preLogin = new PreLogin(Factory.getDriver());
	private final HomePage homePage = new HomePage(Factory.getDriver());
	private final Dashboard dashboard = new Dashboard(Factory.getDriver());
	private final SipBook sipBook = new SipBook(Factory.getDriver());

	private final GrowYourBusiness growYourBusiness = new GrowYourBusiness(Factory.getDriver());

	@Given("user has passed valid credentials on pre login page for Distributor as {string} and {string}")
	public void userHasPassedValidCredentialsOnPreLoginPageForDistributorAsAnd(String arg0, String arg1) {
		preLogin.doPreLogin("https://" + AppHooks.DistributorBaseUrl() + "/home/sign-in", arg0, arg1);
	}

	@Given("User is in Distributor Signin Page")
	public void userIsInDistributorSigninPage() {
		Assert.assertEquals(homePage.loginLabelText(), "Login", "The Login text is not matching");
		Assert.assertEquals(homePage.arnNumberLabelText(), "ARN Number",
				"The ARN Number label text " + "is not matching");
		Assert.assertEquals(homePage.loginGreetingHeading(), "Login to your distributor account",
				"The login heading text is not matching");
	}

	@Then("distributor enters his {string} and {string} and clicks on login")
	public void distributorEntersHisAndAndClicksOnLogin(String arg0, String arg1) {
		homePage.enterUsernameAndPassword(arg0, arg1);
		Assert.assertTrue(homePage.isLoginButtonEnabled(),
				"Login button should be enabled after distributor " + "enters username and password");
		homePage.clickLogin();
	}

	@Given("that the Distributor is on the dashboard page and his details like {string} are displayed")
	public void thatTheDistributorIsOnTheDashboardPageAndHisDetailsLikeAreDisplayed(String arg0)
			throws InterruptedException {
		Assert.assertFalse(dashboard.getWelcomeText().substring(7).isEmpty());
		Assert.assertEquals(dashboard.getARNNumberValue(), "ARN Number: " + arg0,
				"The distributor ARN number is wrong");
		Assert.assertTrue(dashboard.tabItems());
	}

	@Then("distributor goes to My clients section and clicks on view all clients")
	public void distributorGoesToMyClientsSectionAndClicksOnViewAllClients() {
		dashboard.clickOnViewAllClients();
	}

	@When("distributor clicks on client search and send {string} details to search pan")
	public void distributorClicksOnClientSearchAndSendDetailsToSearchPan(String arg0) {
		dashboard.searchPAN(arg0);
	}

	@Then("distributor verifies details AUM tab displayed page")
	public void distributorVerifiesDetailsAUMTabDisplayedPage() {
		Assert.assertTrue(dashboard.detailsAUMTAB(), "Aum Dashboard tab validation failed");
	}

	@Then("after verification distributor clicks on view latest details on dashboard page")
	public void afterVerificationDistributorClicksOnViewLatestDetailsOnDashboardPage() {
		dashboard.clickViewLatestDetails();
	}

	@Then("distributor verifies field and other details on Business summary")
	public void distributorVerifiesFieldAndOtherDetailsOnBusinessSummary() {
		Assert.assertTrue(dashboard.verifyAUMBusinessSummary(),
				"all the details on AUM Business Summary page could not be verified as all details are not matching");
	}

	@Then("distributor clicks on SIP Book Tab")
	public void distributorClicksOnSIPBookTab() {
		sipBook.clickSIPBook();
	}

	@When("SIP book tab is displayed then he verifies if Graph parameters is displayed")
	public void sipBookTabIsDisplayedThenHeVerifiesIfGraphParametersIsDisplayed() {
		Assert.assertTrue(sipBook.dashboardGraph(), "Dashboard SIP book not working");
	}

	@Then("Distributor verifies if all types of fund breakdown are shown in Dashboard")
	public void distributorVerifiesIfAllTypesOfFundBreakdownAreShownInDashboard() {
		Assert.assertTrue(sipBook.detailsSIPTAB(), "Sip tab details issue");
	}

	@Then("Distributor clicks on view latest details page")
	public void distributorClicksOnViewLatestDetailsPage() {
		dashboard.clickViewLatestDetails();
	}

	@When("user is redirected to next page he validates if business summary is shown on the page")
	public void userIsRedirectedToNextPageHeValidatesIfBusinessSummaryIsShownOnThePage() {
		Assert.assertTrue(sipBook.onBusinessSummaryPage(), "On business summary page");
	}

	@Then("distributor verifies field and other details on Business summary for SIP Book")
	public void distributorVerifiesFieldAndOtherDetailsOnBusinessSummaryForSIPBook() {
		Assert.assertTrue(sipBook.verifySIPBusinessSummary(), "Business summary SIP book");
	}

	@Then("distributor clicks on net sales Tab")
	public void distributorClicksOnNetSalesTab() {
		sipBook.clickNetSales();
	}

	@When("net sales tab is displayed then he verifies if Graph parameters is displayed")
	public void netSalesTabIsDisplayedThenHeVerifiesIfGraphParametersIsDisplayed() {
		Assert.assertTrue(sipBook.dashboardNetSales(), "Dashboard net sales values mismatch");
	}

	@Then("Distributor verifies if all types of fund breakdown are shown in Dashboard for net sales")
	public void distributorVerifiesIfAllTypesOfFundBreakdownAreShownInDashboardForNetSales() {
		Assert.assertTrue(sipBook.netSalesFundBreakdown(), "Net sales dashboard contents not displayed correctly");
	}

	@When("user is redirected to next page he validates if business summary is shown on the page for net sales")
	public void userIsRedirectedToNextPageHeValidatesIfBusinessSummaryIsShownOnThePageForNetSales() {
		Assert.assertTrue(sipBook.onBusinessSummaryPage(), "on business summary page");
	}

	@Then("distributor verifies field and other details on Business summary for net sales")
	public void distributorVerifiesFieldAndOtherDetailsOnBusinessSummaryForNetSales() {
		Assert.assertTrue(sipBook.netSalesBusinessSummary(), "Verification on net sales business summary not correct");
	}

	@Then("distributor clicks on clients Tab")
	public void distributorClicksOnClientsTab() {
		sipBook.clickClientsTab();
	}

	@When("clients tab is displayed then he verifies if Graph parameters is displayed")
	public void clientsTabIsDisplayedThenHeVerifiesIfGraphParametersIsDisplayed() {
		Assert.assertTrue(sipBook.dashboardClients(), "Details for dashboard clients tab is not correct");
	}

	@Then("Distributor verifies if all types of client breakup are shown in Dashboard for client")
	public void distributorVerifiesIfAllTypesOfClientBreakupAreShownInDashboardForClient() {
		Assert.assertTrue(sipBook.clientsBreakdown(), "Dashboard client page validation failed");
	}

	@When("user is redirected to next page he validates if business summary is shown on the page for client")
	public void userIsRedirectedToNextPageHeValidatesIfBusinessSummaryIsShownOnThePageForClient() {
		Assert.assertTrue(sipBook.clientsBusinessSummary(), "client business summary failure");
	}

	@Then("Distributor verifies details on grow your business card if those are not null")
	public void distributorVerifiesDetailsOnGrowYourBusinessCardIfThoseAreNotNull() {
		Assert.assertTrue(dashboard.verifyGrowYourBusiness(), "we have an empty value on grow your business card");
	}

	@Then("Distributor clicks view details button and is transferred to grow your business page")
	public void distributorClicksViewDetailsButtonAndIsTransferredToGrowYourBusinessPage() {
		dashboard.clickViewDetails();
	}

	@Then("Distributor verifies numbers and other details from dashboard and compares them")
	public void distributorVerifiesNumbersAndOtherDetailsFromDashboardAndComparesThem() {
		Assert.assertTrue(growYourBusiness.compareValuesFromDashboard(), "Values are not matching");
	}

	@Then("Distributor verifies if he is in Grow your business page")
	public void distributorVerifiesIfHeIsInGrowYourBusinessPage() {
		Assert.assertTrue(growYourBusiness.pageGrowYourBusiness(), "titles and subtitles are not getting displayed");
	}
}
