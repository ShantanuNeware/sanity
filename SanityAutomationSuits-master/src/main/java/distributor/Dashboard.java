package distributor;

import com.utility.BrowserWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Dashboard {
	private final WebDriver driver;
	private final By welcomeText = By.xpath("//*[text()='Welcome']/parent::h6");
	private final By arnNumberSpanData = By.xpath("//*[normalize-space(text())='ARN Number']/parent::p");
	private final By getTabs = By.xpath("//div[@role='tablist']/button/p/p/parent::p");
	private final By viewAllClients = By.xpath("//span[contains(text(),'VIEW')]");
	private final By dropDownPANButton = By.xpath("//label[text()='PAN Cards']/parent::div/div/div");
	private final By clickPANFilterApply = By.xpath("//button[@name='apply']");
	private final By selectFirstDisplayedUser = By.xpath("//div[@id='table-wrapper']/table/tbody/tr/td[1]");
	private final By growthAUM = By.xpath("//p[text()='AUM Growth']");
	private final By latestCategoryBreakup = By.xpath("//p[text()='Latest Category Breakup']");
	private static final String FUNDS = "//span[text()='";
	private static final String BUSINESS_SUMMARY_FUNDS = "//p[text()='";
	private static final String AUM_CATEGORY_DATE = "//p[text()='AUM as of  ";
	private final By viewLatestDetails = By.xpath("//button[text()='View Latest Details']");
	private final By businessSummary = By.xpath("//h3[text()='Business Summary']");
	private final By searchScheme = By.xpath("//input[@name='search']");
	private final By searchSchemeButton = By.xpath("//button[@name='search']");
	private final By tableData = By.xpath("//div[@class='text-header']");
	private final By viewClients = By.xpath("//button[text()='VIEW CLIENTS']");
	private final By growYourBusiness = By.xpath("//h6[text()='Grow your business']");
	private final By viewDetails = By.xpath("//button[@type='submit' and @name='next']");
	private final By potentialBusiness = By.xpath("//span[text()='POTENTIAL BUSINESS']");
	private final By potentialBusinessValueXpath = By.xpath("//span[text()='POTENTIAL BUSINESS']/parent::div/p");
	private final By categories = By.xpath("//span[text()='CATEGORIES']");
	private final By categoriesValueXpath = By.xpath("//span[text()='CATEGORIES']/parent::div/p");
	private final By investors = By.xpath("//span[text()='INVESTORS']");
	private final By investorsValueXpath = By.xpath("//span[text()='INVESTORS']/parent::div/p");
	static String potentialBusinessValue;
	static String categoriesValue;
	static String investorsValue;
	int counter = 0;

	public Dashboard(WebDriver driver) {
		this.driver = driver;
	}

	public String getARNNumberValue() {
		return driver.findElement(arnNumberSpanData).getText();
	}

	public String getWelcomeText() throws InterruptedException {
		BrowserWaits.waitTillDocumentIsLoaded(driver);
		BrowserWaits.fluentWait(driver, welcomeText);

		return driver.findElement(welcomeText).getText();
	}

	public Boolean tabItems() {
		String text;
		boolean flag = true;
		List<String> expectedTabs = new ArrayList<>();
		expectedTabs.add("AUM");
		expectedTabs.add("SIP Book");
		expectedTabs.add("Net Sales");
		expectedTabs.add("Clients");

		List<WebElement> elemnts = driver.findElements(getTabs);
		for (WebElement web : elemnts) {
			text = web.getText();
			if (expectedTabs.contains(text)) {
				flag = false;
			}
		}
		return flag;
	}

	public void clickOnViewAllClients() {
		driver.findElement(viewAllClients).click();
	}

	public void searchPAN(String pan) {
		driver.findElement(dropDownPANButton).click();

		List<WebElement> listOfPANS = driver.findElements(By.xpath("//div[@class='checkbox-heading']"));
		for (WebElement pans : listOfPANS) {
			if (pans.getText().equalsIgnoreCase(pan)) {
				pans.click();
				break;
			}
		}

		driver.findElement(clickPANFilterApply).click();
		BrowserWaits.fluentWait(driver, selectFirstDisplayedUser);
		driver.findElement(selectFirstDisplayedUser).click();

	}

	public Boolean detailsAUMTAB() {
		boolean flag = false;
		counter = 0;
		if (Boolean.TRUE.equals(driver.findElement(growthAUM).isDisplayed())) {
			counter++;
		}
		if (Boolean.TRUE.equals(driver.findElement(latestCategoryBreakup).isDisplayed())) {
			counter++;
		}

		String[] fundsArray = new String[] { "Debt", "Hybrid", "Solution oriented", "Equity", "Index" };
		for (String value : fundsArray) {
			BrowserWaits.explicitWaitClickable(driver, By.xpath("//p[text()='" + value + " funds']"));
			driver.findElement(By.xpath("//p[text()='" + value + " funds']")).click();
			BrowserWaits.explicitWaitElementVisible(driver, By.xpath("//p[text()='" + value + " funds']"));
			if (Boolean.TRUE.equals(driver.findElement(By.xpath("//p[text()='" + value + " funds']")).isDisplayed())) {
				counter++;
			}

			if (Boolean.TRUE
					.equals(driver.findElement(By.xpath(FUNDS + value.toLowerCase() + " funds aum']")).isDisplayed())) {
				counter++;
			}
			if (Boolean.TRUE
					.equals(driver.findElement(By.xpath(FUNDS + "no of " + value.toLowerCase() + " funds clients']"))
							.isDisplayed())) {
				counter++;
			}
			if (Boolean.TRUE
					.equals(driver.findElement(By.xpath(FUNDS + "no of " + value.toLowerCase() + " funds schemes']"))
							.isDisplayed())) {
				counter++;
			}
			if (Boolean.TRUE.equals(driver
					.findElement(By.xpath(FUNDS + "no of " + value.toLowerCase() + " funds sips']")).isDisplayed())) {
				counter++;
			}
		}
		if (counter > 26)
			flag = true;
		return flag;
	}

	public void clickViewLatestDetails() {

		driver.findElement(viewLatestDetails).click();
	}

	public Boolean verifyAUMBusinessSummary() {
		boolean flag = true;

		String[] fundsArray = new String[] { "Debt", "Hybrid", "Solution Oriented", "Equity", "Index" };
		for (String value : fundsArray) {

			driver.findElement(By.xpath(BUSINESS_SUMMARY_FUNDS + value + " Funds']")).click();
			BrowserWaits.fluentWait(driver, By.xpath(BUSINESS_SUMMARY_FUNDS + value + " Funds']"));
			if (Boolean.TRUE
					.equals(driver.findElement(By.xpath(BUSINESS_SUMMARY_FUNDS + value + " Funds']")).isDisplayed())) {
				counter++;
			}
			if (Boolean.TRUE.equals(
					driver.findElement(By.xpath(BUSINESS_SUMMARY_FUNDS + value + " Funds AUM']")).isDisplayed())) {
				counter++;
			}
			if (Boolean.TRUE.equals(
					driver.findElement(By.xpath(BUSINESS_SUMMARY_FUNDS + value + " Funds Clients']")).isDisplayed())) {
				counter++;
			}
			if (Boolean.TRUE.equals(
					driver.findElement(By.xpath(BUSINESS_SUMMARY_FUNDS + value + " Funds Schemes']")).isDisplayed())) {
				counter++;
			}
			if (Boolean.TRUE
					.equals(driver.findElement(By.xpath("//p[text()=\"" + value + " Funds SIP's\"]")).isDisplayed())) {
				counter++;
			}
			counter = getCounter(counter);
			if (counter > 11) {
				return flag;
			}
			counter = 0;
		}
		return flag;
	}

	private int getCounter(int counter) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d MMM yyyy");
		LocalDateTime now = LocalDateTime.now();
		if (Boolean.TRUE.equals(driver.findElement(businessSummary).isDisplayed())) {
			counter++;
		}
		if (Boolean.TRUE.equals(driver.findElement(latestCategoryBreakup).isDisplayed())) {
			counter++;
		}
		if (Boolean.TRUE
				.equals(driver.findElement(By.xpath(AUM_CATEGORY_DATE + dtf.format(now) + "']")).isDisplayed())) {
			counter++;
		}
		if (Boolean.TRUE.equals(driver.findElement(searchScheme).isDisplayed())) {
			counter++;
		}
		if (Boolean.TRUE.equals(driver.findElement(searchSchemeButton).isEnabled())) {
			counter++;
		}
		if (driver.findElements(tableData).size() / driver.findElements(viewClients).size() == 6) {
			counter++;
		}
		return counter;
	}

	public Boolean verifyGrowYourBusiness() {
		potentialBusinessValue = driver.findElement(potentialBusinessValueXpath).getText();
		categoriesValue = driver.findElement(categoriesValueXpath).getText();
		investorsValue = driver.findElement(investorsValueXpath).getText();
		return driver.findElement(growYourBusiness).isDisplayed() && driver.findElement(viewDetails).isEnabled()
				&& driver.findElement(potentialBusiness).isDisplayed() && driver.findElement(categories).isDisplayed()
				&& driver.findElement(investors).isDisplayed()
				&& !driver.findElement(investorsValueXpath).getText().isEmpty()
				&& !driver.findElement(categoriesValueXpath).getText().isEmpty()
				&& !driver.findElement(potentialBusinessValueXpath).getText().isEmpty();
	}

	public void clickViewDetails() {
		driver.findElement(viewDetails).click();
	}
}
