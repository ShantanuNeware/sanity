package distributor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	private final WebDriver driver;
	private final By loginLabel = By.xpath("//h6[normalize-space(text())='Login']");
	private final By arnNumberLabel = By.xpath("//label[normalize-space(text())='ARN Number']");
	private final By loginGreetingHeading = By
			.xpath("//*[normalize-space(text())='Login to your distributor account']");
	private final By distributorArnNumber = By.name("arnNumber");
	private final By distributorPassword = By.name("password");
	private final By loginButton = By.xpath("//button[@type='submit']");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public String loginLabelText() {
		return driver.findElement(loginLabel).getText();
	}

	public String arnNumberLabelText() {
		return driver.findElement(arnNumberLabel).getText();
	}

	public String loginGreetingHeading() {
		return driver.findElement(loginGreetingHeading).getText();
	}

	public void enterUsernameAndPassword(String distributorCode, String distributorPass) {
		driver.findElement(distributorArnNumber).sendKeys(distributorCode);
		driver.findElement(distributorPassword).sendKeys(distributorPass);
	}

	public Boolean isLoginButtonEnabled() {
		return driver.findElement(loginButton).isEnabled();
	}

	public void clickLogin() {
		driver.findElement(loginButton).click();

	}
}
