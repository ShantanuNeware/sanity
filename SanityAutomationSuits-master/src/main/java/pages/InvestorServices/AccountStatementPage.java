package pages.InvestorServices;

import com.utility.BrowserWaits;
import com.utility.JScriptExecutor;

import lombok.SneakyThrows;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class AccountStatementPage {

	private final WebDriver driver;
	private final By HelloText = By.xpath("//*[@id=\"root\"]/div/div[3]/div[2]/div/div/div[1]/h3/span");
	private final By InvestorServices = By
			.xpath("//*[@id=\"root\"]/div/div[3]/div[2]/div/div/div[2]/div/div[2]/div/div[3]/div/div[5]/a");
	private final By AccStatGetStatement = By
			.xpath("//*[@id=\"root\"]/div/div[3]/div/div[2]/div[1]/div/div[1]/div/div/div[3]/button/p");
	private final By IvestorServicesLabel = By.xpath("//h3[contains(text(),'Investor Services')]");
	private final By AccStatement = By.xpath(
			"//*[@id=\"root\"]/div/div[3]/div/div[2]/div[1]/div/div[1]/div/div/div[1]/p[contains(text(),'Account Statement')]");

	private final By ACCPAN = By.xpath("//*[@id=\"mui-25\"]");
	private final By CLEARACCPAN = By
			.xpath("//*[@id=\"root\"]/div/div[3]/div/div/form/div[2]/div[1]/div/div/div/div/button[1]");
//	private final By SelectPan = By.xpath("//li[@class='MuiAutocomplete-option']");
	private final By ACCFolio = By.xpath("//*[@id=\"mui-31\"]");
	private final By SelectFolio = By.xpath("//*[@id=\"mui-31\"]");
	private final By DownloadPDFOption = By
			.xpath("//*[@id=\"root\"]/div/div[3]/div/div/form/div[5]/div/div[1]/fieldset/label/span[1]/input");
	private final By SubmitButton = By.xpath("//button[@type='submit' and @name ='continue']");
	private final By ReturnHomepage = By.xpath("//button[@type='button' and @name ='continue']");

	public AccountStatementPage(WebDriver driver) {
		this.driver = driver;
	}

	List<WebElement> elements;

	public boolean checkonDahboardpage() {
		BrowserWaits.fluentWait(driver, HelloText);
		return driver.findElement(HelloText).isDisplayed();
	}

	public void clickonInvestorServices() {
		BrowserWaits.fluentWait(driver, InvestorServices);
		JScriptExecutor.click(driver, InvestorServices);

	}

	public String checkonInvestorServicesLabel() {
		BrowserWaits.fluentWait(driver, IvestorServicesLabel);
		return driver.findElement(IvestorServicesLabel).getText();
	}

	public String checkonAccountStatementLabel() {
		BrowserWaits.fluentWait(driver, AccStatement);
		return driver.findElement(AccStatement).getText();
	}

	public void checkonGetAccountStateentButton() {
		BrowserWaits.fluentWait(driver, AccStatGetStatement);
		JScriptExecutor.click(driver, AccStatGetStatement);

	}

	public void selectPAN(String pan) throws InterruptedException {
		Thread.sleep(1000);
		BrowserWaits.fluentWait(driver, ACCPAN);
		JScriptExecutor.click(driver, CLEARACCPAN);
		Thread.sleep(1000);
		driver.findElement(ACCPAN).sendKeys(pan);
//		JScriptExecutor.setDataByValue(driver,ACCPAN, pan);
		driver.findElement(ACCPAN).sendKeys(Keys.ENTER);
	}

	public void selectFolio(String Folio) throws InterruptedException {
		Thread.sleep(1000);
		JScriptExecutor.click(driver, SelectFolio);

		driver.findElement(ACCFolio).sendKeys(Folio);
		JScriptExecutor.setDataByValue(driver, ACCPAN, Folio);
		driver.findElement(ACCFolio).sendKeys(Keys.ENTER);
	}

	public void selectDownloadRadioButton() throws InterruptedException {
		BrowserWaits.fluentWait(driver, DownloadPDFOption);
		JScriptExecutor.click(driver, DownloadPDFOption);
	}

	public void ClickSubmitButton() throws InterruptedException {
		BrowserWaits.fluentWait(driver, SubmitButton);
		JScriptExecutor.click(driver, SubmitButton);
	}

	public void ClickReturnHomepageButton() throws InterruptedException {
		Thread.sleep(500);
		BrowserWaits.fluentWait(driver, ReturnHomepage);
		JScriptExecutor.click(driver, ReturnHomepage);
		Thread.sleep(500);
	}

}
