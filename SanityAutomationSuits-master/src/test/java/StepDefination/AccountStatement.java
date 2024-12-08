package StepDefination;

import org.testng.Assert;

import com.driver.Factory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.InvestorServices.AccountStatementPage;

public class AccountStatement {

	private final AccountStatementPage AccountStatement = new AccountStatementPage(Factory.getDriver());

	@Given("check user is on dashboard page")
	public void userIsIndashboardPage() {
		Assert.assertTrue(AccountStatement.checkonDahboardpage());
	}

	@Then("User click on Investor Services")
	public void clickonInvestorServices() {
		AccountStatement.clickonInvestorServices();
	}

	@When("check user is on InvestorServices Label")
	public void checkonInvestorServicesLabel() {
		Assert.assertEquals(AccountStatement.checkonInvestorServicesLabel(), "Investor Services");
	}

	@Then("check Account Statement Label")
	public void checkonAccountStatementLabel() {
		Assert.assertEquals(AccountStatement.checkonAccountStatementLabel(), "Account Statement");
	}

	@Then("User click on Get Account Statement Button")
	public void checkonGetAccountStateentButton() {
		AccountStatement.checkonGetAccountStateentButton();
	}

	@Then("Select Pan {string} from Drop Down")
	public void selectPAN(String arg0) throws InterruptedException {
		AccountStatement.selectPAN(arg0);
	}

	@Then("Select Folio {string} From Drop Down")
	public void selectFolio(String arg0) throws InterruptedException {
		AccountStatement.selectFolio(arg0);
	}

	@Then("Click on Submit  Button")
	public void ClickSubmitButton() throws InterruptedException {
		AccountStatement.ClickSubmitButton();
	}

	@Then("Click on Return To homepage button")
	public void ClickReturnHomepageButton() throws InterruptedException {
		AccountStatement.ClickReturnHomepageButton();
	}

}
