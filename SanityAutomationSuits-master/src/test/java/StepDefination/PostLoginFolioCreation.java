package StepDefination;

import org.testng.Assert;

import com.driver.Factory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.folio.PostLoginFolioCreationPage;
import pages.homepage.Login;

public class PostLoginFolioCreation {

	private final PostLoginFolioCreationPage LoginFolioCreate = new PostLoginFolioCreationPage(Factory.getDriver());

	@Given("check user is on new dashboard page")
	public void userIsIndashboardPage() {
		Assert.assertTrue(LoginFolioCreate.CheckonDahboardpage());
	}

	@Then("Click on create folio button")
	public void clickoncreatenewfolio() {
		LoginFolioCreate.clickoncreatenewfolio();
	}

	@When("user selects yes {string} for zero balance folio")
	public void SelectRadioButton(String arg0) {

		LoginFolioCreate.clickonczerobalanceFolio(arg0);

	}

	@Then("User Enters Mobile Number {string} and click on Send OTP")
	public void enterMobileNumber(String arg0) throws InterruptedException {
		LoginFolioCreate.enterMobileNumber(arg0);
	}

	@Then("User Enters Mobile Number OTP Manually")
	public void enterMobileNumberOTP() throws InterruptedException {
		LoginFolioCreate.enterMobileNumberOTPManually();
	}

	@Then("User Enters Email {string} and click on Send OTP")
	public void enterEMailID(String arg0) throws InterruptedException {
		LoginFolioCreate.enterEmail(arg0);
	}

	@Then("User Enters Email OTP Manually")
	public void enterEmailOTPManually() throws InterruptedException {
		LoginFolioCreate.enterMobileNumberOTPManually();
	}

	@Then("Enter PAN number {string} of Individual folio creation for resident Indian")
	public void enterPANforFolioCreation(String args0) throws InterruptedException {
		LoginFolioCreate.enterPANforFolioCreation(args0);
	}

	@Then("Click on verify link")
	public void clickonverifylink() throws InterruptedException {
		LoginFolioCreate.clickonverifylink();
	}

	@Then("Click on Proceed Button")
	public void clickonProceedButton() throws InterruptedException {
		LoginFolioCreate.clickonProceedButton();
	}

	@Then("Enter Account Number {string} for Savings account")
	public void EnterAccountNumber(String args0) throws InterruptedException {
		LoginFolioCreate.EnterAccountNumber(args0);
	}

	@Then("Confirm Account Number {string} for Savings account")
	public void ConfirmAccountNumber(String args0) throws InterruptedException {
		LoginFolioCreate.ConfirmAccountNumber(args0);
	}

	@Then("User enters IFSC code {string}")
	public void EntersIFSCcode(String args0) throws InterruptedException {
		LoginFolioCreate.EntersIFSCcode(args0);
	}

	@Then("Click on Proceed Button for confirm bank details")
	public void clickonProceedButtonbankdetails() throws InterruptedException {
		LoginFolioCreate.clickonProceedButtonbankdetails();
	}

	@Then("Select OptOut for Nominee")
	public void selectoptOutfornomineedetails() throws InterruptedException {
		LoginFolioCreate.selectoptOutfornomineedetails();
	}

	@Then("Accept Terms for Opt Out Nominee")
	public void selectTermsoptOut() throws InterruptedException {
		LoginFolioCreate.selectTermsoptOut();
	}

	@Then("Click on Nominee proceed buton")
	public void NomineeproceedButton() throws InterruptedException {
		LoginFolioCreate.NomineeproceedButton();
	}

	@Then("click on Continue button for review details screen")
	public void ContinueButtonForreviewdetails() throws InterruptedException {
		LoginFolioCreate.ContinueButtonForreviewdetails();
	}

}
