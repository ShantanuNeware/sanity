package pages.folio;

import com.utility.BrowserWaits;
import com.utility.JScriptExecutor;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class KycRegister {
	private final WebDriver driver;
	private final By panNumber = By.xpath("//*[text()='PAN Number']/following-sibling::div/input");
	private final By verifyButton = By.xpath("//*[text()='Verify']");
	private final By getOtpToVerifyButton = By.name("next");
	private final By contactDetailsPath = By.xpath("//img[@class='drop-down-icon']");
	private final By contactDetailsDropDownPath = By.xpath("//div[@class='render-dropdown']");
	private final By continueButton = By.name("processButton");
	private final By occupation = By.xpath("//*[text()='Occupation']/parent::div/div/div/button");
	private final By sourceOfIncome = By.xpath("//*[text()='Source of Income']/parent::div/div/div/button");

	public KycRegister(WebDriver driver) {
		this.driver = driver;
	}

	public void setPrimaryPanNumber(String primaryPan) {
		JScriptExecutor.click(driver, panNumber);
		driver.findElement(panNumber).sendKeys(primaryPan);
	}

	public void clickOnVerifyButton() {
		JScriptExecutor.click(driver, verifyButton);
	}

	public void clickOnGetOtpToVerify() {
		BrowserWaits.explicitWaitElementVisible(this.driver, getOtpToVerifyButton);
		BrowserWaits.explicitWaitClickable(this.driver, getOtpToVerifyButton);
		JScriptExecutor.click(driver, getOtpToVerifyButton);
	}

	public BankDetails goToBankDetailsPage() {
		return new BankDetails(driver);
	}

	public BankDetails goToBankDetailsPage(String primaryPan) {
		setPrimaryPanNumber(primaryPan);
		clickOnVerifyButton();
		clickOnGetOtpToVerify();
		return new BankDetails(driver);
	}

	@SneakyThrows
	public void updateContactDetailsDropDown(String value) {
		BrowserWaits.fluentWait(driver, contactDetailsPath);
		List<WebElement> contactDetailsArray = driver.findElements(contactDetailsPath);
		for (WebElement contactDetails : contactDetailsArray) {
			BrowserWaits.fluentWaitWebelement(driver, contactDetails);
			contactDetails.click();
			List<WebElement> dropDownValuesArray = driver.findElements(contactDetailsDropDownPath);
			for (WebElement dropDownValues : dropDownValuesArray) {
				if (dropDownValues.getText().equalsIgnoreCase(value)) {
					dropDownValues.click();
					break;
				}

			}
		}
	}

	@SneakyThrows
	public void clickContinue(String occupationValue, String sOI) throws InterruptedException {
		Thread.sleep(4000);
		try {
			JScriptExecutor.click(driver, continueButton);
		} catch (Exception e) {
			driver.findElement(occupation).click();
			List<WebElement> dropDownValuesArray = driver.findElements(contactDetailsDropDownPath);
			for (WebElement dropDownValues : dropDownValuesArray) {
				if (dropDownValues.getText().equalsIgnoreCase(occupationValue)) {
					dropDownValues.click();
					break;
				}

			}

			driver.findElement(sourceOfIncome).click();
			dropDownValuesArray = driver.findElements(contactDetailsDropDownPath);
			for (WebElement dropDownValues : dropDownValuesArray) {
				if (dropDownValues.getText().equalsIgnoreCase(sOI)) {
					dropDownValues.click();
					break;
				}

			}
			JScriptExecutor.click(driver, continueButton);

		}
	}
}
