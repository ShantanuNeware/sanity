package StepDefination;

import com.driver.Factory;
import distributor.DistributorServices;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class PostLoginServices {
	private final DistributorServices distributorServices = new DistributorServices(Factory.getDriver());

	@Then("distributor clicks on distributor services")
	public void distributorClicksOnDistributorServices() {
		Assert.assertTrue(distributorServices.clickDistributorServices(), "Unable to click Distributor Services");

	}

	@When("Distributor verifies all details displayed in distributor services")
	public void distributorVerifiesAllDetailsDisplayedInDistributorServices() {
		Assert.assertTrue(distributorServices.verifyDistributorServices(), "All 4 cards data are not displayed");
	}

	@Then("Distributor selects {string} and clicks on {string}")
	public void distributorSelectsAndClicksOn(String arg0, String arg1) {
		distributorServices.selectPanAndTypeOfStatement(arg0, arg1);
	}

	@Then("Distributor verifies if he is in statement processing page")
	public void distributorVerifiesIfHeIsInStatementProcessingPage() {
		Assert.assertTrue(distributorServices.subStatementPageVerification(), "all elements not displayed");
	}

	@Then("Distributor clicks on continue")
	public void distributorClicksOnContinue() {
		distributorServices.clickContinueButton();
	}

	@Then("distributor verifies if continue button is enabled")
	public void distributorVerifiesIfContinueButtonIsEnabled() {
		Assert.assertTrue(distributorServices.continueAndCancelButton(),
				"Buttons are not enabled after filling all the data");
	}

	@Then("distributor clicks on {string} and statement type as PAN level and provides other details as {string} and {string}")
	public void distributorClicksOnAndStatementTypeAsPANLevelAndProvidesOtherDetailsAsAnd(String arg0, String arg1,
			String arg2) {
		distributorServices.setPANLevelData(arg0, arg1, arg2);
	}

	@Then("distributor clicks on {string} and statement type as PAN level and provides other details as {string}")
	public void distributorClicksOnAndStatementTypeAsPANLevelAndProvidesOtherDetailsAs(String arg0, String arg1) {
		distributorServices.setFolioLevelData(arg0, arg1);
	}

}
