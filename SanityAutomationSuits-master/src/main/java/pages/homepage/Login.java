package pages.homepage;

import com.utility.BrowserWaits;
import com.utility.JScriptExecutor;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.transactions.TransactionPage;
import pages.folio.PostLoginFolioCreationPage;
import pages.homepage.dashboardpage;

import java.util.HashMap;
import java.util.List;

public class Login {
	private final WebDriver driver;

	private static final String OTP_VALUE = "//*[@class='input'][";
	private final By register = By.xpath("//*[text()='Register']");
	private final By HeadersignInButton = By.cssSelector(
			"#root > div > div.header > div > div > div > div > div > div.top-nav-mobile.bottom-line > button");

	private final By userIdfield = By
			.xpath("/html/body/div/div/div[3]/div/div/div/div/form/div/div/div[1]/div/div/div/div[2]/div/div");
	private final By userId = By.xpath("//*[@id=\"user-name\"]");
	private final By password = By.id("password");
	private final By profileName = By.id("profile-code");
	private final By nextButton = By.xpath(
			"//*[@id=\"root\"]/div/div[3]/div/div/div/div/form/div/div/div[1]/div/div/div/div[2]/button[1]/span");
	private final By signInOtp = By.xpath("//span[text()='here']");
	private final By sendOtpButton = By.xpath("//button[text()='SEND OTP']");
	private final By emailRadioButton = By.name("Email");
	private final By mobileRadioButton = By.name("mobile");
	private final By signInButton = By.xpath("//button[text()='Sign In']");
	private final By signInRegisterTitle = By
			.cssSelector("h3.MuiTypography-root.MuiTypography-h3.Bold.pb-8.css-18h9l83");
	static String errorPath = "//div[normalize-space(text()) ='";
	static final By helloText = By.xpath("//*[@id=\"root\"]/div/div[3]/div[2]/div/div/div[1]/h3/span");
	static final By portfolioSummary = By.xpath("//p[text()='Your Portfolio Summary']");
	private final By profileNameDropdown = By.xpath("//label[@id='profile-code']/parent::div/div/img");
	private final By quickLinks = By.xpath("//p[text()='QUICK LINKS']");
	private final By quickAllLinks = By.xpath("//p[text()='QUICK LINKS']/parent::div/div/div/a");
	private final By portfolioLoader = By.xpath("//*[local-name() = 'svg' and @baseProfile='full']");

	private final By LoginButton = By.xpath(
			"//*[@id=\"root\"]/div/div[2]/div[1]/div/div/div/div/div[1]/div/div/div/div/div[2]/div/div[2]/div/div[1]/div/div/div[2]/button");

	public Login(WebDriver driver) {
		this.driver = driver;

	}

	public void investorURL(String URL) {
		driver.get(URL);
	}

	public void clickOnLoginButton() {
		BrowserWaits.explicitWaitClickable(driver, LoginButton);
		JScriptExecutor.click(driver, LoginButton);
	}

	public void clickonuserid() throws InterruptedException {
		Thread.sleep(3000);
		JScriptExecutor.click(driver, userIdfield);
	}

	public void enterUserid(String data) throws InterruptedException {
		Thread.sleep(3000);
		JScriptExecutor.click(driver, userIdfield);
		driver.findElement(userId).sendKeys(data);

	}

	public void clickOnNext() throws InterruptedException {
		BrowserWaits.waitTillDocumentIsLoaded(driver);
		JScriptExecutor.click(driver, nextButton);

	}

	public void enterPassword(String data) throws InterruptedException {
		Thread.sleep(5000);
		JScriptExecutor.click(driver, password);
		driver.findElement(password).sendKeys(data);

	}

	public void clickOnSignIn() throws InterruptedException {
		BrowserWaits.waitTillDocumentIsLoaded(driver);
		JScriptExecutor.click(driver, signInButton);

	}

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

	public dashboardpage goToDashboardPage() {
		return new dashboardpage(this.driver);
	}

	public PostLoginFolioCreationPage FolioCreationPage() {
		return new PostLoginFolioCreationPage(this.driver);
	}

}
