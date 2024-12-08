package StepDefination;

import ApplicationHooks.AppHooks;
import com.driver.Factory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.ourfunds.OurFundsHome;
import pages.preloginpage.PreLogin;

public class OurFunds {

	private final PreLogin preLogin = new PreLogin(Factory.getDriver());
	private OurFundsHome ourFundsHome;

	@Given("user completes pre login and clicks on OurFund Tab")
	public void userCompletesPreLoginAndClicksOnOurFundTab() throws InterruptedException {
		ourFundsHome = preLogin
				.doPreLogin("https://" + AppHooks.InvestorBaseUrl() + "/home/sign-in", "TESTUSER11", "Sachin@11")
				.goToOurFundsPage();
		ourFundsHome.clickOnOurFundsTab();
	}

	@Then("user verifies that Our Fund Page loaded successfully")
	public void userVerifiesThatOurFundPageLoadedSuccessfully() {
		String expectedHeaderPage = "Our Funds";
		Assert.assertEquals(ourFundsHome.verifyOurFundPage(), expectedHeaderPage);
	}

	@Then("user verifies that promo cards loaded successfully")
	public void userVerifiesThatPromoCardsLoadedSuccessfully() {
		Assert.assertTrue(ourFundsHome.verifyPromoCards());
	}

	@Then("user verifies that explore funds categories and values are displayed")
	public void userVerifiesThatExploreFundsCategoriesAndValuesAreDisplayed() {
		Assert.assertTrue(ourFundsHome.verifyExploreFunds());
		Assert.assertTrue(ourFundsHome.verifyFundCategories(), "Fund Category verified successfully");
		// Assert.assertTrue(ourFundsHome.verifySolutionPack(), "Solution Pack verified
		// successfully");
	}
}
