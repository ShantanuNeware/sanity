package distributor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class DistributorServices {

	private static final String PTEXT = "//p[text()='";
	private final By distServices = By.xpath("//div/a/span[text()='Distributor Services']");
	private final By distServicesHeading = By.xpath("//h3[text()='Distributor Services']");
	private final By statement = By.xpath("//h5[text()='Statements']");
	private final By cardServices = By.xpath("//div[@class='services-white-card']/div/div/p");
	private final By cardServicesAllValue = By.xpath("//div[@class='services-white-card']/div/div");
	private final By initiate = By.xpath("//h3[text()='Initiate']");
	private final By comprehensiveView = By.xpath(
			"//p[text()='Account statements provide a comprehensive view of your transactions and balances within the selected Folio(s)']");
	private final By receiveAccountStatementText = By
			.xpath("//p[text()='To Recieve Account Statements, enter the following details:']");
	private final By initiatingRequest = By.xpath("//p[text()='Initiating Request As']");
	private final By radioButtonIFA = By.xpath("//input[@value='IFA']");
	private final By radioButtonRIA = By.xpath("//input[@value='RIA']");
	private final By radioButtonOthers = By.xpath("//input[@value='Others']");
	private final By radioButtonPANLevel = By.xpath("//input[@value='PAN_LEVEL']");
	private final By radioButtonFolioLevel = By.xpath("//input[@value='FOLIO_LEVEL']");
	private final By textPANNumber = By.xpath("//input[@name='panNumber']");
	private final By textInvestorEmailId = By.xpath("//input[@name='emailId']");
	private final By textFolioNumber = By.xpath("//input[@name='folioNumber']");
	private final By buttonContinue = By.xpath("//button[@name='continue']");
	private final By buttonCancel = By.xpath("//button[@name='cancel']");
	private final WebDriver driver;

	public DistributorServices(WebDriver driver) {
		this.driver = driver;
	}

	public Boolean clickDistributorServices() {
		boolean flag = driver.findElement(distServices).isEnabled();
		driver.findElement(distServices).click();
		return flag;
	}

	public Boolean verifyDistributorServices() {
		boolean flag = driver.findElement(distServicesHeading).isDisplayed();
		if (!driver.findElement(statement).isDisplayed()) {
			flag = false;
		}
		List<WebElement> cards = driver.findElements(cardServices);
		if (cards.size() != 8) {
			flag = false;
		}
		List<String> expectedCards = new ArrayList<>();
		List<String> actualCards = new ArrayList<>();
		expectedCards.add("Account Statement");
		expectedCards.add("Exit Load Statement");
		expectedCards.add("STT Statement");
		expectedCards.add("Capital Gains Statement");
		for (WebElement eCards : cards) {
			actualCards.add(eCards.getText());
		}
		if (!new HashSet<>(actualCards).containsAll(expectedCards)) {
			flag = false;
		}
		return flag;
	}

	public void selectPanAndTypeOfStatement(String pan, String statement) {
		driver.findElement(By.xpath(PTEXT + pan + "']")).click();
		List<WebElement> cards = driver.findElements(cardServicesAllValue);
		for (int i = 0; i < 12; i += 2) {
			if (cards.get(i).getText().equalsIgnoreCase(statement)) {
				cards.get(i + 2).click();
				break;
			}
		}

	}

	public boolean subStatementPageVerification() {
		return driver.findElement(initiate).isDisplayed() && driver.findElement(comprehensiveView).isDisplayed()
				&& driver.findElement(receiveAccountStatementText).isDisplayed()
				&& driver.findElement(initiatingRequest).isDisplayed() && driver.findElement(radioButtonIFA).isEnabled()
				&& driver.findElement(radioButtonRIA).isEnabled() && driver.findElement(radioButtonOthers).isEnabled()
				&& driver.findElement(radioButtonPANLevel).isEnabled()
				&& driver.findElement(radioButtonFolioLevel).isEnabled();

	}

	public void setPANLevelData(String initiatingRequest, String pan, String emailid) {
		extracted(initiatingRequest);
		driver.findElement(radioButtonPANLevel).click();
		driver.findElement(textPANNumber).sendKeys(pan);
		driver.findElement(textInvestorEmailId).sendKeys(emailid);

	}

	public void setFolioLevelData(String initiatingRequest, String folioNum) {
		extracted(initiatingRequest);
		driver.findElement(radioButtonFolioLevel).click();
		driver.findElement(textFolioNumber).sendKeys(folioNum);

	}

	private void extracted(String initiatingRequest) {
		switch (initiatingRequest.toUpperCase()) {
		case "RIA":
			driver.findElement(radioButtonRIA).click();
			break;
		case "OTHERS":
			driver.findElement(radioButtonOthers).click();
			break;
		default:
			driver.findElement(radioButtonIFA).click();
		}
	}

	public Boolean continueAndCancelButton() {
		return driver.findElement(buttonCancel).isEnabled() && driver.findElement(buttonContinue).isEnabled();
	}

	public void clickContinueButton() {
		driver.findElement(buttonContinue).click();
	}
}
