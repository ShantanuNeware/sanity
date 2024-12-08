package pages.homepage;

import com.utility.BrowserWaits;
import com.utility.JScriptExecutor;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.transactions.TransactionPage;

import java.util.HashMap;
import java.util.List;

public class Signin {
	private final WebDriver driver;
	private static final String OTP_VALUE = "//*[@class='input'][";
	private final By register = By.xpath("//*[text()='Register']");
	private final By HeadersignInButton = By.cssSelector(
			"#root > div > div.header > div > div > div > div > div > div.top-nav-mobile.bottom-line > button");
	private final By userId = By.id("user-name");
	private final By password = By.id("password");
	private final By profileName = By.id("profile-code");
	private final By nextButton = By.xpath("//button[text()='Next']");
	private final By signInOtp = By.xpath("//span[text()='here']");
	private final By sendOtpButton = By.xpath("//button[text()='SEND OTP']");
	private final By emailRadioButton = By.name("Email");
	private final By mobileRadioButton = By.name("mobile");
	private final By signInButton = By.xpath("//button[text()='Sign In']");
	private final By signInRegisterTitle = By
			.cssSelector("h3.MuiTypography-root.MuiTypography-h3.Bold.pb-8.css-18h9l83");
	static String errorPath = "//div[normalize-space(text()) ='";
	static final By helloText = By.xpath("//span[text()='Hello']");
	static final By portfolioSummary = By.xpath("//p[text()='Your Portfolio Summary']");
	private final By profileNameDropdown = By.xpath("//label[@id='profile-code']/parent::div/div/img");
	private final By quickLinks = By.xpath("//p[text()='QUICK LINKS']");
	private final By quickAllLinks = By.xpath("//p[text()='QUICK LINKS']/parent::div/div/div/a");
	private final By portfolioLoader = By.xpath("//*[local-name() = 'svg' and @baseProfile='full']");

	private final By LoginButton = By.cssSelector(
			"#root > div > div.root-home > div:nth-child(1) > div > div > div > div > div.slick-slide.slick-active.slick-current > div > div > div > div > div.MuiContainer-root.MuiContainer-maxWidthLg.container.promotional-container.css-1qsxih2 > div > div.MuiGrid-root.MuiGrid-item.MuiGrid-grid-xs-12.MuiGrid-grid-sm-6.MuiGrid-grid-md-5.MuiGrid-grid-lg-6.css-w5zliw > div > div:nth-child(1) > div > div > div.MuiGrid-root.MuiGrid-grid-xs-6.promotional-banner-button.css-51t0hs > button");

	public Signin(WebDriver driver) {
		this.driver = driver;
	}

	public void investorURL(String url) {
		driver.get(url);
	}

	public String getURL() {
		return driver.getCurrentUrl();
	}

	public void clickRegisterButton() {
		JScriptExecutor.click(driver, register);
	}

	public Boolean isRegisterButtonClickable() {
		return driver.findElement(register).isDisplayed();
	}

	public Boolean isSignInRegisterTitleDisplayed() {
		return driver.findElement(signInRegisterTitle).isDisplayed();
	}

	public Register goToRegisterPage() {
		BrowserWaits.explicitWaitClickable(driver, register);
		clickRegisterButton();
		return new Register(driver);
	}

	public void clickOnHeaderSignInButton() {
		BrowserWaits.explicitWaitClickable(driver, HeadersignInButton);
		JScriptExecutor.click(driver, HeadersignInButton);
	}

	public void enterUserid(String username) {
		driver.findElement(userId).sendKeys(username);
	}

	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}

	public void clickOnNext() {
		JScriptExecutor.click(driver, nextButton);
	}

	public void clickOnSignInButton() throws InterruptedException {
		BrowserWaits.waitTillDocumentIsLoaded(driver);
		JScriptExecutor.click(driver, signInButton);
	}

	public void clickOnLoginButton() {
		BrowserWaits.explicitWaitClickable(driver, LoginButton);
		JScriptExecutor.click(driver, LoginButton);
	}

	public void clickOnSignInUsingOtp() {
		BrowserWaits.explicitWaitClickable(driver, signInOtp);
		JScriptExecutor.click(driver, signInOtp);
	}

	public String verifyProfileName() {
		BrowserWaits.explicitWaitClickable(driver, profileName);
		return driver.findElement(profileName).getText();
	}

	public void selectEmailRadioButton() {
		JScriptExecutor.click(driver, emailRadioButton);
	}

	public void selectMobileRadioButton() {
		JScriptExecutor.click(driver, mobileRadioButton);
	}

	public void clickOnSendOtpButton() {
		JScriptExecutor.click(driver, sendOtpButton);
	}

	public void enterOtp() {
		for (int i = 1; i <= 6; i++) {
			driver.findElement(By.xpath(OTP_VALUE + i + "]")).sendKeys(String.valueOf(i));
		}
	}

	public Boolean authError(String error) {
		return driver.findElement(By.xpath(errorPath + error + "']")).isDisplayed();
	}

	public void enterWrongOtp() {
		for (int i = 1; i <= 6; i++) {
			driver.findElement(By.xpath(OTP_VALUE + i + "]")).sendKeys(String.valueOf(1));
		}
	}

	public TransactionPage goToTransactionPage() {
		return new TransactionPage(this.driver);
	}

	@SneakyThrows
	public void clickProfileName() throws InterruptedException {
		Thread.sleep(5000);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(profileNameDropdown)).click().perform();
	}

	public void selectDashboardOption(String option) {
		List<WebElement> elements = driver.findElements(By.xpath("//li[@role='option']"));
		for (WebElement element : elements) {
			if (element.getText().equalsIgnoreCase(option)) {
				element.click();
				break;
			}

		}
	}

	public String checkHelloMessage() {
		return driver.findElement(helloText).getText();
	}

	public Boolean quickLinksAreDisplayed() {
		Boolean flag = false;
		HashMap<String, String> nameAndLinks = new HashMap<>();
		nameAndLinks.put("NEW TRANSACTION", "https://icicipruamcuat.azureedge.net/");
		nameAndLinks.put("Account Statements",
				"https://icicipruamcuat.azureedge.net/home/investor-services/account-statement");
		nameAndLinks.put("Systematic Transaction", "https://icicipruamcuat.azureedge.net/home/systematic-transaction");
		nameAndLinks.put("Transaction History", "https://icicipruamcuat.azureedge.net/home/view-transaction");
		nameAndLinks.put("Investor Services", "https://icicipruamcuat.azureedge.net/home/investor-services");
		driver.findElement(quickLinks).isDisplayed();
		List<WebElement> elements = driver.findElements(quickAllLinks);
		for (WebElement element : elements) {
			if (nameAndLinks.containsKey(element.getText())
					&& nameAndLinks.get(element.getText()).equalsIgnoreCase(element.getAttribute("href"))) {
				flag = true;
			}
		}
		return flag;
	}

	public Boolean checkIfPortfolioIsDisplayed() {
		Boolean flag1 = driver.findElement(portfolioSummary).isDisplayed();
		Boolean flag2 = driver.findElement(portfolioLoader).isDisplayed();
		return flag2 && flag1;
	}
}
