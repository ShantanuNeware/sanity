package pages.ourfunds;

import com.utility.BrowserWaits;
import com.utility.JScriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class OurFundsHome {

	private final WebDriver driver;

	private final By ourFundsTab = By.linkText("Funds");
	private final By ourFundsPageHeader = By.xpath("//h3[text()='Our Funds']");
	private final By promoCardsOurFunds = By.xpath("//div[@class='promo-card__text--title']");
	private final By fundCategories = By.xpath("//span[text()='SEARCH']");
	private final By solutionPacks = By.xpath("//button[text()='Solution Packs']");
	private final By exploreFunds = By.xpath("//h3[text()='Explore Funds']");
	private final By solutionPackTitle = By.xpath("//h2[text()='Solution Packs']");

	public OurFundsHome(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnOurFundsTab() {
		BrowserWaits.explicitWaitClickable(driver, ourFundsTab);
		JScriptExecutor.click(driver, ourFundsTab);
	}

	public String verifyOurFundPage() {
		BrowserWaits.explicitWaitElementVisible(driver, ourFundsPageHeader);
		return driver.findElement(ourFundsPageHeader).getText();
	}

	public boolean verifyPromoCards() {
		BrowserWaits.explicitWaitElementVisible(driver, promoCardsOurFunds);
		List<WebElement> promoCards = driver.findElements(promoCardsOurFunds);
		List<String> promoCardsActual = new ArrayList<>();
		List<String> promoCardsExpected = new ArrayList<>();
		promoCardsExpected.add("Explore our NFOs");
		promoCardsExpected.add("NAV & Dividend");
		promoCardsExpected.add("Downloads");
		// promoCardsExpected.add("Compare ICICI Prudential Funds");
		// promoCardsExpected.add("Know more about our Fund Managers");
		for (WebElement promoCard : promoCards) {
			promoCardsActual.add(promoCard.getText().split("\n")[0]);
		}
		return promoCardsExpected.equals(promoCardsActual);
	}

	public boolean verifyExploreFunds() {
		return driver.findElement(exploreFunds).isDisplayed();
	}

	public boolean verifyFundCategories() {
		BrowserWaits.explicitWaitElementVisible(driver, fundCategories);
		JScriptExecutor.click(driver, fundCategories);
		List<WebElement> fundList = driver.findElements(By.xpath("//div[@class='mt-4']/div"));
		boolean flag = true;
		List<String> fundListExpected = new ArrayList<>();
		fundListExpected.add("NFO");
		fundListExpected.add("Equity Funds");
		fundListExpected.add("Debt Funds");
		fundListExpected.add("Liquid Funds");
		fundListExpected.add("Hybrid Funds");
		fundListExpected.add("ETF Funds");
		fundListExpected.add("Fund of Funds");
		fundListExpected.add("Index Funds");
		for (int i = 0; i < fundListExpected.size(); i++) {
			if (!fundListExpected.contains(fundList.get(0).getText())) {
				flag = false;
			}
		}
		return flag;
	}

	public boolean verifySolutionPack() {
		BrowserWaits.explicitWaitClickable(driver, solutionPacks);
		JScriptExecutor.click(driver, solutionPacks);
		return driver.findElement(solutionPackTitle).getText().equalsIgnoreCase("Solution Packs");
	}

}
