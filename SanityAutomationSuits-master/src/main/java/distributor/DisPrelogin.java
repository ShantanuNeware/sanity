package distributor;

import com.utility.JScriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DisPrelogin {
	private final WebDriver driver;

	private final By tabHomePage = By.xpath("//a[contains(text(),'Home')]");
	private final By tabServices = By.xpath("//span[contains(text(),'Find Out')]");
	private final By importantLinks = By.xpath("//h2[contains(text(),'Important Links')]");
	private final By ifaInterview = By.xpath("//h2[contains(text(),'Featured IFA Interviews')]");
	private final By ourFunds = By.xpath("//*[contains(text(),'Our FUNDs')]");
	private final By empanel = By.xpath("//*[contains(text(),'Empanel with ICICI')]");
	private final By becomeAnAdvisor = By.xpath("//*[contains(text(),'Become an Advisor')]");
	private final By initiatingRequestAs = By.xpath("//p[contains(text(),'Initiating Request As')]");
	private final By ifa = By.xpath("//p[contains(text(),'IFA')]");
	private final By ifaRadioBox = By.xpath("//input[@type='radio']");
	private final By ria = By.xpath("//p[contains(text(),'RIA')]");
	private final By others = By.xpath("//p[contains(text(),'OTHERS')]");
	private final By enterIFACode = By.xpath("//label[contains(text(),'Enter IFA Code')]");
	private final By folioNumber = By.xpath("//*[contains(text(),'Folio Number')]");
	private final By clickHere = By.xpath("//*[contains(text(),'Click Here')]");
	private final By cancelButton = By.xpath("//*[contains(text(),'CANCEL')]");
	private final By continueButton = By.xpath("//*[contains(text(),'CONTINUE')]");
	private final By arnNumberEntryField = By.xpath("//p[contains(text(),'ARN-')]/parent::div/parent::div/input");
	private final By folioNumberTextbox = By.xpath("//label[contains(text(),'Folio Number')]/parent::div/div/input");

	public DisPrelogin(WebDriver driver) {
		this.driver = driver;
	}

	public void clickHomePageTab() {
		JScriptExecutor.flashColour(driver, driver.findElement(tabHomePage));
		driver.findElement(tabHomePage).click();
	}

	public Boolean clickServices() {
		boolean flag = driver.findElement(tabServices).isEnabled() && driver.findElement(importantLinks).isDisplayed()
				&& driver.findElement(ifaInterview).isDisplayed() && driver.findElement(ourFunds).isDisplayed()
				&& driver.findElement(empanel).isDisplayed() && driver.findElement(becomeAnAdvisor).isDisplayed();
		JScriptExecutor.flashColour(driver, driver.findElement(tabServices));
		driver.findElement(tabServices).click();
		return flag;
	}

	public Boolean inttab() {
		return driver.findElement(initiatingRequestAs).isDisplayed() && driver.findElement(ifaRadioBox).isSelected()
				&& driver.findElement(ifa).isDisplayed() && driver.findElement(ria).isDisplayed()
				&& driver.findElement(others).isDisplayed() && driver.findElement(enterIFACode).isDisplayed()
				&& driver.findElement(folioNumber).isDisplayed() && driver.findElement(clickHere).isDisplayed()
				&& driver.findElement(cancelButton).isEnabled() && !driver.findElement(continueButton).isEnabled();
	}

	public Boolean fillDataInInitiateNewTransaction(String arnnumber, String folioNumber) {
		driver.findElement(arnNumberEntryField).sendKeys(arnnumber);
		driver.findElement(folioNumberTextbox).sendKeys(folioNumber);

		boolean flag = driver.findElement(continueButton).isEnabled();

		driver.findElement(continueButton).click();
		return flag;
	}
}
