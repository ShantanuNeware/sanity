package distributor;

import com.utility.BrowserWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SipBook {
	private static final String FUNDS = "//span[text()='";
	private static final String BUSINESS_SUMMARY_FUNDS = "//p[text()='";
	private static final String SIP_CATEGORY_DATE = "//p[normalize-space(text())='SIP Book as of ";
	private static final String NET_SALES_DATE = "//p[normalize-space(text())='Net Sales as of ";
	private final WebDriver driver;
	private final By tabSIPBook = By.xpath("//p[text()='SIP Book']");
	private final By netSales = By.xpath("//p[text()='Net Sales']");
	private final By growthSIP = By.xpath("//p[text()='SIP Growth']");
	private final By clients = By.xpath("//p[text()='Clients']");
	private final By showBy = By.xpath("//label[text()='Show By']");
	private final By showByDropDownValue = By.xpath("//ul[@role='listbox']/li");
	private final By showByDropDownArrow = By.xpath("//label[text()='Show By']/parent::div/div");
	private final By latestCategoryBreakup = By.xpath("//p[text()='Latest Category Breakup']");
	private final By clientBreakup = By.xpath("//p[text()='Client Breakup']");
	private final By clientDetailsForSelectedCategory = By.xpath("//p[text()='Client Details for Selected Category']");
	private final By schemeCategoryBreakup = By.xpath("//p[text()='Scheme Category Breakup']");
	private final By businessSummary = By.xpath("//h3[text()='Business Summary']");
	private final By searchScheme = By.xpath("//input[@name='search']");
	private final By searchSchemeButton = By.xpath("//button[@name='search']");
	private final By tableData = By.xpath("//div[@class='text-header']");
	private final By viewClients = By.xpath("//button[text()='VIEW CLIENTS']");
	private final By topDemographicData = By.xpath("//p[text()='Top Demographic Data']");
	String[] fundsArray = new String[] { "Debt", "Hybrid", "Solution oriented", "Equity", "Index" };
	String[] clientsArray = new String[] { "debt funds clients", "non debt funds clients", " clients debt funds sip",
			"new debt funds clients" };
	String[] clientsBusinessSummary = new String[] { "Active Age", "Most Client in city", "AUM Range",
			"Offline Clients", "Client details for Selected Category", "debt funds clients", "non debt funds clients",
			" clients debt funds sip", "new debt funds clients" };
	int counter;
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d MMM yyyy");
	LocalDateTime now = LocalDateTime.now();

	public SipBook(WebDriver driver) {
		this.driver = driver;
	}

	public Boolean netSalesFundBreakdown() {
		boolean flag = false;
		counter = 0;
		if (Boolean.TRUE.equals(driver.findElement(latestCategoryBreakup).isDisplayed())) {
			counter++;
		}

		for (String value : fundsArray) {
			extracted(value);
		}

		if (counter > 28)
			flag = true;
		return flag;
	}

	private void extracted(String value) {
		BrowserWaits.fluentWait(driver, By.xpath(BUSINESS_SUMMARY_FUNDS + value + " funds']"));
		driver.findElement(By.xpath(BUSINESS_SUMMARY_FUNDS + value + " funds']")).click();
		BrowserWaits.fluentWait(driver, By.xpath(BUSINESS_SUMMARY_FUNDS + value + " funds']"));
		if (Boolean.TRUE.equals(driver.findElement(By.xpath("//p[text()='Net Sales']")).isDisplayed())) {
			counter++;
		}

		if (Boolean.TRUE.equals(driver.findElement(By.xpath("//span[text()='purchasing client']")).isDisplayed())) {
			counter++;
		}
		if (Boolean.TRUE.equals(driver.findElement(By.xpath("//span[text()='purchases']")).isDisplayed())) {
			counter++;
		}
		if (Boolean.TRUE.equals(driver.findElement(By.xpath("//span[text()='purchases schemes']")).isDisplayed())) {
			counter++;
		}
		if (Boolean.TRUE.equals(driver.findElement(By.xpath("//span[text()='redeeming client']")).isDisplayed())) {
			counter++;
		}
		if (Boolean.TRUE.equals(driver.findElement(By.xpath("//span[text()='redemption']")).isDisplayed())) {
			counter++;
		}
		if (Boolean.TRUE.equals(driver.findElement(By.xpath("//span[text()='redemption scheme']")).isDisplayed())) {
			counter++;
		}
	}

	public void clickSIPBook() {
		driver.findElement(tabSIPBook).click();
	}

	public void clickClientsTab() {
		driver.findElement(clients).click();
	}

	public void clickNetSales() {
		driver.findElement(netSales).click();
	}

	public Boolean dashboardGraph() {
		counter = 0;
		boolean flag = true;
		if (Boolean.TRUE.equals(driver.findElement(growthSIP).isDisplayed())) {
			counter++;
		}

		extracted();

		if (counter < 3)
			flag = false;
		return flag;
	}

	public Boolean dashboardNetSales() {
		counter = 0;
		boolean flag = false;
		if (Boolean.TRUE.equals(driver.findElement(netSales).isDisplayed())) {
			counter++;
		}

		extracted();

		if (counter >= 3)
			flag = true;

		return flag;
	}

	public Boolean dashboardClients() {
		counter = 0;
		boolean flag = false;
		if (Boolean.TRUE.equals(driver.findElement(clients).isDisplayed())) {
			counter++;
		}

		extracted();

		if (counter >= 3)
			flag = true;

		return flag;
	}

	private void extracted() {
		if (Boolean.TRUE.equals(driver.findElement(showBy).isDisplayed())) {
			counter++;
		}
		driver.findElement(showByDropDownArrow).click();
		List<WebElement> dropDown = driver.findElements(showByDropDownValue);
		List<String> expectedValue = new ArrayList<>();
		List<String> actualValue = new ArrayList<>();
		expectedValue.add("Max");
		expectedValue.add("Last 6 Months");
		expectedValue.add("Last 1 Year");
		expectedValue.add("This Financial Year");
		expectedValue.add("Last Financial Year");
		for (WebElement value : dropDown) {
			actualValue.add(value.getText());
		}
		dropDown.get(0).click();
		if (Boolean.TRUE.equals(new HashSet<>(actualValue).containsAll(expectedValue))) {
			counter++;
		}
	}

	public Boolean detailsSIPTAB() {
		boolean flag = false;
		counter = 0;
		if (Boolean.TRUE.equals(driver.findElement(latestCategoryBreakup).isDisplayed())) {
			counter++;
		}
		for (String value : fundsArray) {
			BrowserWaits.explicitWaitClickable(driver, By.xpath(BUSINESS_SUMMARY_FUNDS + value + " funds']"));
			driver.findElement(By.xpath(BUSINESS_SUMMARY_FUNDS + value + " funds']")).click();
			BrowserWaits.fluentWait(driver, By.xpath(BUSINESS_SUMMARY_FUNDS + value + " funds']"));
			if (Boolean.TRUE
					.equals(driver.findElement(By.xpath(BUSINESS_SUMMARY_FUNDS + value + " funds']")).isDisplayed())) {
				counter++;
			}

			if (Boolean.TRUE.equals(
					driver.findElement(By.xpath(FUNDS + value.toLowerCase() + " funds sip book']")).isDisplayed())) {
				counter++;
			}
			if (Boolean.TRUE.equals(
					driver.findElement(By.xpath(FUNDS + "no of " + value.toLowerCase() + " funds sips clients']"))
							.isDisplayed())) {
				counter++;
			}
			if (Boolean.TRUE.equals(
					driver.findElement(By.xpath(FUNDS + "no of " + value.toLowerCase() + " funds sips schemes']"))
							.isDisplayed())) {
				counter++;
			}
			if (Boolean.TRUE.equals(driver
					.findElement(By.xpath(FUNDS + "no of " + value.toLowerCase() + " funds sips']")).isDisplayed())) {
				counter++;
			}
		}

		if (counter >= 26)
			flag = true;
		return flag;
	}

	public Boolean verifySIPBusinessSummary() {
		boolean flag = true;
		for (String value : fundsArray) {

			driver.findElement(By.xpath(BUSINESS_SUMMARY_FUNDS + value + " Funds']")).click();
			BrowserWaits.fluentWait(driver, By.xpath(BUSINESS_SUMMARY_FUNDS + value + " Funds']"));
			if (Boolean.TRUE.equals(driver
					.findElement(By.xpath(BUSINESS_SUMMARY_FUNDS + value + " Funds New SIP Book']")).isDisplayed())) {
				counter++;
			}

			if (Boolean.TRUE
					.equals(driver.findElement(By.xpath(BUSINESS_SUMMARY_FUNDS + value + " Funds New SIP Clients']"))
							.isDisplayed())) {
				counter++;
			}
			if (Boolean.TRUE
					.equals(driver.findElement(By.xpath(BUSINESS_SUMMARY_FUNDS + value + " Funds New SIP Schemes']"))
							.isDisplayed())) {
				counter++;
			}
			if (Boolean.TRUE.equals(driver.findElement(By.xpath("//p[text()=\"" + value + " Funds No. of New SIP's\"]"))
					.isDisplayed())) {
				counter++;
			}
			if (Boolean.TRUE.equals(driver.findElement(latestCategoryBreakup).isDisplayed())) {
				counter++;
			}
			if (Boolean.TRUE
					.equals(driver.findElement(By.xpath(SIP_CATEGORY_DATE + dtf.format(now) + "']")).isDisplayed())) {
				counter++;
			}
			counter = getCounter(counter);
			if (counter >= 10) {
				return flag;
			}
			counter = 0;
		}
		return flag;
	}

	private int getCounter(int counter) {

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

	public Boolean onBusinessSummaryPage() {
		return Boolean.TRUE.equals(driver.findElement(businessSummary).isDisplayed());
	}

	public Boolean netSalesBusinessSummary() {
		boolean flag = true;

		for (String value : fundsArray) {

			driver.findElement(By.xpath(BUSINESS_SUMMARY_FUNDS + value + " Funds']")).click();
			BrowserWaits.fluentWait(driver, By.xpath(BUSINESS_SUMMARY_FUNDS + value + " Funds']"));
			if (Boolean.TRUE.equals(driver.findElement(By.xpath(BUSINESS_SUMMARY_FUNDS + value + " Funds Net Sales']"))
					.isDisplayed())) {
				counter++;
			}

			if (Boolean.TRUE
					.equals(driver.findElement(By.xpath(BUSINESS_SUMMARY_FUNDS + value + " Funds Purchasing Clients']"))
							.isDisplayed())) {
				counter++;
			}
			if (Boolean.TRUE.equals(driver.findElement(By.xpath(BUSINESS_SUMMARY_FUNDS + value + " Funds Purchases']"))
					.isDisplayed())) {
				counter++;
			}
			if (Boolean.TRUE
					.equals(driver.findElement(By.xpath(BUSINESS_SUMMARY_FUNDS + value + " Funds Redeeming Clients']"))
							.isDisplayed())) {
				counter++;
			}
			if (Boolean.TRUE
					.equals(driver.findElement(By.xpath(BUSINESS_SUMMARY_FUNDS + value + " Funds Redemption Count']"))
							.isDisplayed())) {
				counter++;
			}
			if (Boolean.TRUE
					.equals(driver.findElement(By.xpath(BUSINESS_SUMMARY_FUNDS + value + " Funds Redemption Schemes']"))
							.isDisplayed())) {
				counter++;
			}
			if (Boolean.TRUE
					.equals(driver.findElement(By.xpath(BUSINESS_SUMMARY_FUNDS + value + " Funds Purchases Schemes']"))
							.isDisplayed())) {
				counter++;
			}
			if (Boolean.TRUE.equals(driver.findElement(schemeCategoryBreakup).isDisplayed())) {
				counter++;
			}
			if (Boolean.TRUE
					.equals(driver.findElement(By.xpath(NET_SALES_DATE + dtf.format(now) + "']")).isDisplayed())) {
				counter++;
			}
			counter = getCounter(counter);
			if (counter >= 10) {
				return flag;
			}
			counter = 0;
		}
		return flag;
	}

	public Boolean clientsBreakdown() {
		boolean flag = false;
		counter = 0;
		if (Boolean.TRUE.equals(driver.findElement(clientBreakup).isDisplayed())) {
			counter++;
		}
		if (Boolean.TRUE.equals(driver.findElement(clientDetailsForSelectedCategory).isDisplayed())) {
			counter++;
		}
		for (String value : clientsArray) {
			if (Boolean.TRUE.equals(driver.findElement(By.xpath(FUNDS + value + "']")).isDisplayed()))
				counter++;
		}

		if (counter > 5)
			flag = true;
		return flag;
	}

	public Boolean clientsBusinessSummary() {
		counter = 0;
		boolean flag = true;
		if (Boolean.TRUE.equals(driver.findElement(businessSummary).isDisplayed())) {
			counter++;
		}
		if (Boolean.TRUE.equals(driver
				.findElement(By.xpath("//p[text()='The data shown is the latest data as of " + dtf.format(now) + "']"))
				.isDisplayed())) {
			counter++;
		}
		if (Boolean.TRUE.equals(driver.findElement(topDemographicData).isDisplayed())) {
			counter++;
		}
		for (String value : clientsBusinessSummary) {
			if (Boolean.TRUE
					.equals(driver.findElement(By.xpath(BUSINESS_SUMMARY_FUNDS + value + "']")).isDisplayed())) {
				counter++;
			}
		}
		if (counter < 11)
			flag = false;

		return flag;
	}
}
