package pages.homepage;

import com.utility.BrowserWaits;
import com.utility.JScriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.ourfunds.OurFundsHome;

public class Home {
	private final WebDriver driver;
	private final By signin = By.xpath("//button/span[contains(text(),'SIGN IN')]");

	private final By plan = By.xpath("//a[text()='Tools']");
	private final By helpCenter = By.xpath("//a[text()='Support']");
	private final By servicesTab = By.xpath("//a[text()='Services']");
	private final By learn = By.partialLinkText("Insights");

	public Home(WebDriver driver) {
		this.driver = driver;
	}

	public String getURL() {
		return driver.getCurrentUrl();
	}

	public void clickSignInButton() {
		BrowserWaits.fluentWait(driver, signin);
		JScriptExecutor.click(driver, signin);
	}

	public Boolean isSignInButtonClickable() {
		return driver.findElement(signin).isDisplayed();
	}

	public Signin goToSigninScreen() {
		clickSignInButton();
		return new Signin(driver);
	}

	public OurFundsHome goToOurFundsPage() {
		return new OurFundsHome(driver);
	}

	public void clickPlanTab() {
		BrowserWaits.explicitWaitElementVisible(driver, plan);
		JScriptExecutor.click(driver, plan);
	}

	public Boolean isPlanTabDisplayed() {
		return driver.findElement(plan).isDisplayed();
	}

	public Plan goToPlanPage() {
		driver.manage().window().maximize();
		return new Plan(driver);
	}

	public Learn clickLearnPage() {
		BrowserWaits.explicitWaitClickable(driver, learn);
		JScriptExecutor.click(driver, learn);
		return new Learn(driver);
	}

	public Boolean isLearnOptionDisplayed() {
		return driver.findElement(learn).isDisplayed();
	}

	public Boolean isLearnOptionEnabled() {
		return driver.findElement(learn).isEnabled();
	}

	public Learn goToLearnSection() {
		clickLearnPage();
		return new Learn(driver);
	}

	public void clickHelpCenterTab() {
		BrowserWaits.explicitWaitClickable(driver, helpCenter);
		JScriptExecutor.click(driver, helpCenter);
	}

	public Boolean isHelpCenterTabDisplayed() {
		return driver.findElement(helpCenter).isDisplayed();
	}

	public HelpCenter goToHelpCenterPage() {
		driver.manage().window().maximize();
		return new HelpCenter(driver);
	}

	public Services goToServicePage() {
		driver.manage().window().maximize();
		return new Services(driver);
	}

	public void clickServicesTab() {
		BrowserWaits.explicitWaitClickable(driver, servicesTab);
		JScriptExecutor.click(driver, servicesTab);
	}

	public Boolean isServiceTabDisplayed() {
		return driver.findElement(servicesTab).isDisplayed();
	}
}
