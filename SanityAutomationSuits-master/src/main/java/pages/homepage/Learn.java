package pages.homepage;

import com.utility.BrowserWaits;
import com.utility.JScriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Learn {

	private final WebDriver driver;
	private final By faq = By.xpath("//button[@role='tab']");
	private final By knowledgeCenter = By.xpath("//h2[contains(text(),'Knowledge Center')]");
	private final By exploreAll = By.xpath("//span[contains(text(),'explore all')]");
	private final By categoryOfMaterial = By.xpath("//button[text()='Category of Materials']");
	private final By videosPodcastArticles = By.xpath("//button[text()='Videos, Podcasts & Articles']");
	private final By learnCenter = By.xpath("//h3[contains(text(),'Knowledge Center')]");
	private final By viewFaq = By.xpath("//button[contains(text(),'VIEW')]");
	private final By accountOpening = By.xpath("//button[text()='Account Opening']");
	private final By country = By.xpath("//img[@class='select-arrow']");
	private final By countryValue = By.xpath("//input[contains(@value,'IND')]");
	private final By mobile = By.xpath("//input[@type='tel']");
	private final By cityState = By.xpath("(//input[@type='text'])[3]");
	private final By askExpert = By.xpath("//button[@name='AskExpert']");

	public Learn(WebDriver driver) {
		this.driver = driver;
	}

	public String getURL() {
		return driver.getCurrentUrl();
	}

	public void clickExploreAll() {
		BrowserWaits.explicitWaitClickable(driver, exploreAll);
		JScriptExecutor.click(driver, exploreAll);
	}

	public Boolean isCategoryOfMaterialsDisplayed() {
		return driver.findElement(categoryOfMaterial).isDisplayed();
	}

	public void clickVideosPodcastArticles() {
		BrowserWaits.explicitWaitClickable(driver, videosPodcastArticles);
		JScriptExecutor.click(driver, videosPodcastArticles);
	}

	public Boolean isKnowledgeCenterDisplayed() {
		return driver.findElement(knowledgeCenter).isDisplayed();
	}

	public Boolean isLearnPageDisplayed() {
		return driver.findElement(learnCenter).isDisplayed();
	}

	public void clickFaq() {
		BrowserWaits.explicitWaitClickable(driver, viewFaq);
		JScriptExecutor.click(driver, viewFaq);
	}

	public boolean isAccountOpeningDisplayed() {
		return driver.findElement(accountOpening).isDisplayed();
	}

	public void clickCountryDropDown() {
		BrowserWaits.explicitWaitClickable(driver, country);
		JScriptExecutor.click(driver, country);
	}

	public void clickCountryCode() {
		BrowserWaits.explicitWaitClickable(driver, countryValue);
		JScriptExecutor.click(driver, countryValue);
	}

	public void enterMobileNumber(String mobileNumber) {
		BrowserWaits.explicitWaitClickable(driver, mobile);
		JScriptExecutor.click(driver, mobile);
		driver.findElement(mobile).sendKeys(mobileNumber);
	}

	public void selectCityState() {
		BrowserWaits.explicitWaitClickable(driver, cityState);
		JScriptExecutor.click(driver, cityState);
		driver.findElement(cityState).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
	}

	public void clickAskExpert() {
		BrowserWaits.explicitWaitClickable(driver, askExpert);
		JScriptExecutor.click(driver, askExpert);
	}

	public void consultExpert(String mobileNum) {
		enterMobileNumber(mobileNum);
		selectCityState();
		clickAskExpert();
	}

	public Boolean verifyFaq() {
		boolean flag = true;
		List<WebElement> faqOption = driver.findElements(faq);
		List<String> faqOptionExpected = new ArrayList<>();
		faqOptionExpected.add("Account Opening");
		faqOptionExpected.add("Account Statement");
		faqOptionExpected.add("Centralised_KYC");
		faqOptionExpected.add("Demat");
		faqOptionExpected.add("Dividend");
		faqOptionExpected.add("Nomination");
		faqOptionExpected.add("Power of Attorney");
		faqOptionExpected.add("Procedure for claiming unclaimed Amount");
		faqOptionExpected.add("Purchase");
		faqOptionExpected.add("Redemption");
		faqOptionExpected.add("Special Requests");
		faqOptionExpected.add("Systematic Investment Plan");
		faqOptionExpected.add("Updation/Change/Transfer");
		for (int i = 0; i < 13; i++) {
			if (!faqOptionExpected.contains(faqOption.get(0).getText())) {
				flag = false;
			}
		}
		return flag;
	}
}
