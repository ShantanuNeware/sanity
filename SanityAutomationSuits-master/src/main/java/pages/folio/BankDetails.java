package pages.folio;

import com.utility.BrowserWaits;
import com.utility.JScriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BankDetails {
	private final WebDriver driver;
	private final By accountNumber = By.id("account-number");
	private final By confirmAccountNumberlabel = By.id("confirm-acct-number-value-label");
	private final By confirmAccountNumber = By.id("confirm-acct-number-value");
	private final By ifscCode = By.id("ifsc-code");
	private final By bankACCDetails = By.xpath("//*[text()='Bank Details']");
	private final By searchIfscCode = By.xpath("//img[@class='select-arrow']");
	private final By bankDetailPage = By.xpath("//h6[text()='Bank Details']");
	private final By continueButton = By.name("proceed");

	public BankDetails(WebDriver driver) {
		this.driver = driver;
	}

	public void setBankNameDropdown(String bankNameValue) {
		BrowserWaits.fluentWait(driver, bankACCDetails);
	}

	public void setAccountNumber(String accNumber) {
		JScriptExecutor.click(driver, accountNumber);
		driver.findElement(accountNumber).sendKeys(accNumber);
	}

	public void confirmAccountNumber(String accNumber) {
		JScriptExecutor.click(driver, confirmAccountNumberlabel);
		driver.findElement(confirmAccountNumber).sendKeys(accNumber);
	}

	public void enterIfscCode(String ifscCodeValue) {
		JScriptExecutor.click(driver, ifscCode);
		driver.findElement(ifscCode).sendKeys(ifscCodeValue);
		JScriptExecutor.click(driver, searchIfscCode);
	}

	public void bankPageLoadSuccessful() {
		BrowserWaits.fluentWait(driver, bankACCDetails);

	}

	public void clickOnContinue() {
		BrowserWaits.explicitWaitClickable(driver, continueButton);
		JScriptExecutor.click(driver, continueButton);
	}

	public boolean verifyBankDetailPage() {
		BrowserWaits.fluentWait(driver, bankDetailPage);
		return driver.findElement(bankDetailPage).isDisplayed();
	}

	public NomineeDetails goToNomineeDetailsPage() {
		return new NomineeDetails(driver);
	}

	public NomineeDetails goToNomineeDetailsPage(String accountNumber, String ifscCodeValue) {
		setAccountNumber(accountNumber);
		confirmAccountNumber(accountNumber);
		enterIfscCode(ifscCodeValue);
		clickOnContinue();

		return new NomineeDetails(driver);
	}

}
