package pages.homepage;

import com.utility.JScriptExecutor;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Register {
	private final WebDriver driver;
	private final By fullName = By.id("full-name");
	private final By email = By.id("email");
	private final By sendOTP = By.xpath("//*[text()='Send OTP']");
	private static final String OTP_VALUE = "//*[@class='input'][";
	private final By enterMobileNumber = By.cssSelector("input[maxlength='10']");
	private final By tnc = By.cssSelector("input[name='termsCondition']");

	private final By nextPage = By.xpath("//*[@name='next']");

	private final By setPasswordPage = By.xpath("//h6[text()='Set a Password']");

	private final By userRegistrationTile = By
			.cssSelector("h4.MuiTypography-root.MuiTypography-h4.Bold.sign-up__heading.css-1xvinid");

	public Register(WebDriver driver) {
		this.driver = driver;
	}

	public String getURL() {
		return driver.getCurrentUrl();
	}

	public void setFullName(String name) {
		driver.findElement(fullName).sendKeys(name);
	}

	public void setEmail(String eml) {
		driver.findElement(email).sendKeys(eml);
	}

	public void clickSendOTP() {
		JScriptExecutor.click(driver, sendOTP);
	}

	public boolean sendOtpDisplayed() {
		return driver.findElement(sendOTP).isDisplayed();
	}

	@SneakyThrows
	public void setOTP() throws InterruptedException {
		for (int i = 1; i <= 6; i++) {
			driver.findElement(By.xpath(OTP_VALUE + i + "]")).sendKeys(String.valueOf(i));
		}
		Thread.sleep(1000);
	}

	public void setMobileNumber(String number) {
		JScriptExecutor.click(driver, enterMobileNumber);
		driver.findElement(enterMobileNumber).sendKeys(number);
	}

	public String getMobileNumber() {
		return driver.findElement(enterMobileNumber).getAttribute("value");
	}

	public void clickTNC() {
		JScriptExecutor.click(driver, tnc);
	}

	@SneakyThrows
	public void clickOnContinue() throws InterruptedException {
		Thread.sleep(1000);
		JScriptExecutor.click(driver, nextPage);
	}

	public boolean verifySetPasswordScreen() {
		return driver.findElement(setPasswordPage).isDisplayed();
	}

	public boolean isUserRegistrationTileDisplayed() {
		return driver.findElement(userRegistrationTile).isDisplayed();
	}

	public PasswordScreen goToPasswordScreen(String name, String eml, String mobile) throws InterruptedException {
		setFullName(name);
		setEmail(eml);
		clickSendOTP();
		setOTP();
		setMobileNumber(mobile);
		clickSendOTP();
		setOTP();
		clickTNC();
		clickOnContinue();
		return new PasswordScreen(driver);
	}

	public PasswordScreen goToPasswordScreen() {
		return new PasswordScreen(driver);
	}

}
