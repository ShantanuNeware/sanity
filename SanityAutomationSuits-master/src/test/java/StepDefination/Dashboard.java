package StepDefination;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.driver.Factory;

import pages.transactions.SanityTransactions;
import pages.transactions.TransactionPage;
import pages.homepage.Login;
import pages.homepage.dashboardpage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Properties;

public class Dashboard {

	private final dashboardpage dashboardpage = new dashboardpage(Factory.getDriver());

	@Given("user is on dashboard page")
	public void userIsIndashboardPage() {
		Assert.assertTrue(dashboardpage.onDahboardpage());
	}

	@Then("Click on view portfolio button")
	public void clickonviewPortfolio() {
		dashboardpage.clickonviewPortfolio();
	}

	@Then("Click on view showScheme button")
	public void clickonshowScheme() {
		dashboardpage.clickonshowScheme();
	}

	@Then("Click on view expandScheme button")
	public void clickonexpandScheme() throws InterruptedException {
		dashboardpage.clickonexpandScheme();
	}

	@Then("check Values for investedamount")
	public void checkValuesforinvestedamount() {
		dashboardpage.checkValuesforinvestedamount();
	}

}