package pages.homepage;

import com.utility.BrowserWaits;
import com.utility.JScriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.folio.KycRegister;

public class PasswordScreen {
	private final WebDriver driver;
	private final By password = By.id("new-password");
	private final By confirmPassword = By.id("password");
	private final By continueButton = By.name("next");

	private final By setUpAccountPage = By.xpath("//h3[text()='Set up your Account']");

	private final By proceedButton = By.xpath("//button[text()='Proceed']");
	private final By userRegistration = By.xpath("//*[text()='User Registration']");

	public PasswordScreen(WebDriver driver) {
		this.driver = driver;
	}

	public boolean userRegistrationScreen() {
		return driver.findElement(userRegistration).isDisplayed();
	}

	public void setPassword(String passwd) {
		driver.findElement(password).sendKeys(passwd);
	}

	public void setConfirmPassword(String passwd) {
		driver.findElement(confirmPassword).sendKeys(passwd);
	}

	public void clickOnContinue() {
		BrowserWaits.fluentWait(driver, continueButton);
		JScriptExecutor.click(driver, continueButton);
	}

	public KycRegister goToKycRegisterPage() {
		return new KycRegister(driver);
	}

	public boolean verifySetUpAccountPage() {
		return driver.findElement(setUpAccountPage).isDisplayed();
	}

	public void clickOnProceedButton() {
		BrowserWaits.explicitWaitElementVisible(driver, proceedButton);
		BrowserWaits.explicitWaitClickable(driver, proceedButton);
		JScriptExecutor.click(driver, proceedButton);
	}
}
