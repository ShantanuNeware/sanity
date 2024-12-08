package pages.homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Services {
	private final WebDriver driver;

	private final By getAllServicesWithDescription = By.xpath("//h5/parent::div/div/div/div/div/div/p");
	private final By getAllServicesSubHeading = By.xpath("//h5");
	private final By getInvestorServicesHeading = By.xpath("//h3");

	public Services(WebDriver driver) {
		this.driver = driver;
	}

	public Boolean allServices() {
		List<WebElement> allServicesDetails = driver.findElements(getAllServicesWithDescription);
		List<String> expectedList = new ArrayList<>();
		List<String> actualList = new ArrayList<>();
		actualList.add("Account Statement");
		actualList.add(
				"Account statements provide a comprehensive view of your transactions and balances within the selected Folio(s)");
		actualList.add("Capital Gains Statement");
		actualList.add(
				"This statement gives a view of Capital Gains / Losses incurred on your applicable transactions within any of your linked folios");
		actualList.add("Exit Load Statement");
		actualList.add(
				"This statement gives you a view on possible Exit load applicability for your investments for your chosen Folio");
		actualList.add("STT Statement");
		actualList.add(
				"The Securities Transactions Tax (STT) statement gives you a detailed view of the STT incurred on your applicable transactions");
		actualList.add("Update Contact Details");
		actualList.add(
				"Use this feature to update the Mobile number or Email ID registered in any of your linked Folios");
		actualList.add("Update FATCA Details");
		actualList
				.add("Use this service to update FATCA / CRS and Additional KYC details for any of your linked folios");
		actualList.add("Update Nominees");
		actualList.add(
				"This service allows you to View, Manage or Opt-out of having Nominees for any of your linked folios");
		actualList.add("Update PAN / KYC");
		actualList.add(
				"This service allows you to Update / Upload PAN details for your linked folios (or) Update any of your linked PANs' KYC");
		actualList.add("Update FIRC");
		actualList.add(
				"The Foreign Inward Remittance Certificate (FIRC) declaration service allows NRE investors to make a declaration regarding the source of funds");
		actualList.add("Submit Form 15G / 15H");
		actualList.add("Forms 15G / 15H are used to request for stoppage of TDS deduction in IDCW payouts");
		actualList.add("View / Register Mandates");
		actualList.add(
				"Use this service to View and Manage your existing Autopay Mandates, or to register a new Autopay Mandate");
		actualList.add("Subscribe to NAV Alerts");
		actualList.add(
				"This service allows you to receive regular alerts about NAV movements of any of our Schemes that you would like to track");
		actualList.add("FAQs");
		actualList.add("Get detailed explanations for some of the most common queries that our Investors have");
		actualList.add("Change of Bank Mandate");
		actualList.add(
				"Change the default Bank Account for your folios (with valuation < Rs.1.5 Lakhs) by visiting our Service provider 's (CAMS) website");
		actualList.add(
				"View the details of any Unclaimed Redemptions / IDCW payouts by visiting our Service provider's (CAMS) website");
		actualList.add(
				"View the details of any Unclaimed Redemptions / IDCW payouts by visiting our Service provider's (CAMS) website");
		actualList.add("Submit Form 15G / 15H");
		actualList.add("Forms 15G / 15H are used to request for stoppage of TDS deduction in IDCW payouts");
		actualList.add("Cancel Autopay Mandates");
		actualList.add(
				"This facility allows you to cancel some of your eligible Mandates by visiting our Service provider's (CAMS) website");
		actualList.add("Cancel Existing Mandate");
		actualList.add(
				"This facility allows you to cancel some of your eligible Mandates by visiting our Service provider's (CAMS) website");
		actualList.add("View / Register Mandates");
		actualList.add(
				"Use this service to View and Manage your existing Autopay Mandates, or to register a new Autopay Mandate");
		for (WebElement element : allServicesDetails)
			expectedList.add(element.getText());
		return actualList.equals(expectedList);
	}

	public String getInvestorServicesHeader() {
		return driver.findElement(getInvestorServicesHeading).getText();
	}

	public Boolean getSubInvestorServices() {
		List<WebElement> allServices = driver.findElements(getAllServicesSubHeading);
		List<String> expectedList = new ArrayList<>();
		List<String> actualList = new ArrayList<>();
		actualList.add("Statements");
		actualList.add("Update Services");
		actualList.add("Others");
		actualList.add("Third Party Services");
		actualList.add("Manage Auto Pay Mandates (OTMs)");
		for (WebElement element : allServices)
			expectedList.add(element.getText());
		return expectedList.equals(actualList);
	}

}
