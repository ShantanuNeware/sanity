package distributor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GrowYourBusiness {

	private final WebDriver driver;

	private final By growYourBusinessTitle = By.xpath("//h3[text()='Grow your Business']");
	private final By potentialBusiness = By.xpath("//span[text()='POTENTIAL BUSINESS']");
	private final By potentialBusinessXpathValues = By.xpath("//span[text()='POTENTIAL BUSINESS']/parent::div/div/h6");
	private final By categories = By.xpath("//span[text()='CATEGORIES']");
	private final By categoriesXpathValues = By.xpath("//span[text()='CATEGORIES']/parent::div/div/h6");
	private final By investors = By.xpath("//span[text()='INVESTORS']");
	private final By investorsXpathValues = By.xpath("//span[text()='INVESTORS']/parent::div/div/h6");

	private final By allCardsValue = By.xpath("//div[@class='business-potential']/div/p");

	public GrowYourBusiness(WebDriver driver) {
		this.driver = driver;
	}

	public Boolean pageGrowYourBusiness() {
		return driver.findElement(growYourBusinessTitle).isDisplayed()
				&& driver.findElement(potentialBusiness).isDisplayed() && driver.findElement(categories).isDisplayed()
				&& driver.findElement(investors).isDisplayed();
	}

	public Boolean compareValuesFromDashboard() {

		/// Getting values from Grow your business card on dashboard
		String regex = "[^0-9]";
		double potentialBusinessValueE = Double.parseDouble(Dashboard.potentialBusinessValue.replaceAll(regex, ""));
		int categoriesValueE = Integer.parseInt(Dashboard.categoriesValue);
		int investorsValueE = Integer.parseInt(Dashboard.investorsValue);
		List<WebElement> cds = driver.findElements(potentialBusinessXpathValues);
		// Getting values from yellow card present in grow your business table
		Double potentialD = Double
				.parseDouble(driver.findElements(potentialBusinessXpathValues).get(0).getText().replaceAll(regex, ""));
		String potential = potentialD + "";
		potential = potential.substring(0, 4);
		int category = Integer.parseInt(driver.findElements(categoriesXpathValues).get(0).getText());
		int investor = Integer.parseInt(driver.findElements(investorsXpathValues).get(0).getText());

		// Feting values from each card
		List<WebElement> potts = driver.findElements(allCardsValue);
		double potentialBusinessValueA = 0;
		int categoriesValueA = 0;
		int investorsValueA = 0;

		for (int i = 0; i < 15; i += 3) {
			// Adding up all the values mentioned in the cards
			potentialBusinessValueA += Double.parseDouble(potts.get(i).getText().replaceAll("[^0-9.]", ""));
			categoriesValueA += Integer.parseInt(potts.get(i + 1).getText().replaceAll(regex, ""));
			investorsValueA += Integer.parseInt(potts.get(i + 2).getText().replaceAll(regex, ""));
		}
		// typecasting and doing a substring operation on potential business
		String pbve = potentialBusinessValueE + "";
		pbve = pbve.substring(0, 4);
		String pbva = potentialBusinessValueA + "";
		pbva = pbva.substring(0, 4);

		System.exit(0);
		return categoriesValueA == categoriesValueE && investorsValueA == investorsValueE && pbva.equals(pbve)
				&& category == categoriesValueE && investor == investorsValueE && potential.equals(pbve);

	}

}
