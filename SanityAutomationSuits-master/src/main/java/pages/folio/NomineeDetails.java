package pages.folio;

import com.utility.BrowserWaits;
import com.utility.CommonFunctions;
import com.utility.JScriptExecutor;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class NomineeDetails {
	private final By nomineePage = By.xpath("//*[text()='NOMINEE DETAILS']");
	private final By nomineeName = By.name("nominees.0.name");
	private final By nomineeRelationDropdown = By
			.xpath("//*[text()='Relationship with Nominee']/following-sibling::div/img");
	private final By nomineeContinue = By.name("next");
	private final By nomineeProceed = By.name("submit");
	private final By nomineePAN = By.name("nominees.0.pan");
	private final By warning = By.xpath("//*[text()='Warning']");
	private final By warningText = By.xpath("//*[text()='Warning']/parent::div/div/p");
	private final By warningOkayButton = By.xpath("//button[@type='button' and @name ='proceedBtnYes']");
	private final By selectMonth = By
			.cssSelector("button.MuiTypography-root.MuiTypography-subtitle1.PrivatePickersMonth-root.css-1l4irwy");

	private final By reviewYourInformation = By.xpath("//h3[text()='Review Your Information']");
	private final WebDriver driver;

	public NomineeDetails(WebDriver driver) {
		this.driver = driver;
	}

	public boolean checkIfInNomineePage() {
		BrowserWaits.fluentWait(driver, nomineeName);
		return driver.findElement(nomineeName).isDisplayed() && driver.findElement(nomineePage).isDisplayed();
	}

	@SneakyThrows
	public void enterNomineeName(String name) throws InterruptedException {
		BrowserWaits.explicitWaitElementVisible(driver, nomineeName);
		Thread.sleep(2000);
		JScriptExecutor.click(driver, nomineeName);
		driver.findElement(nomineeName).sendKeys(name);
	}

	public void setNomineeRelation(String relation) {
		BrowserWaits.explicitWaitElementVisible(driver, nomineeRelationDropdown);
		CommonFunctions.actionClick(driver, nomineeRelationDropdown);
		CommonFunctions.actionClick(driver, By.xpath("//*[text()='" + relation + "']"));
	}

	@SneakyThrows
	public void setNomineeDOB(String dob) {
		String[] dateArray = dob.split("/");
		JScriptExecutor.click(driver, By.xpath("//img[@class='cursor-pointer']"));
		String inputYear = dateArray[2];
		List<WebElement> year = driver.findElements(By.cssSelector("button.PrivatePickersYear-yearButton.css-m1gykc"));
		for (WebElement element : year) {
			if (element.getText().equalsIgnoreCase(inputYear)) {
				JScriptExecutor.clickByWebElement(driver, element);
				break;
			}
		}

		String inputMonth = "MAR";

		List<WebElement> month = driver.findElements(selectMonth);
		for (WebElement element : month) {
			if (element.getText().equalsIgnoreCase(inputMonth)) {
				JScriptExecutor.clickByWebElement(driver, element);
				break;
			}
		}

		String inputdate = dateArray[0];
		List<WebElement> date = driver.findElements(By.xpath("//*[@role='gridcell']"));
		for (WebElement element : date) {
			if (element.getText().equalsIgnoreCase(inputdate)) {
				JScriptExecutor.clickByWebElement(driver, element);
				break;
			}
		}

	}

	public void setNomineePAN(String pan) {
		driver.findElement(nomineePAN).click();
		driver.findElement(nomineePAN).sendKeys(pan);
	}

	public void clickOnProceeed() {
		JScriptExecutor.click(driver, nomineeProceed);
	}

	public boolean verifyReviewYourInformationPage() {
		return driver.findElement(reviewYourInformation).isDisplayed();
	}

	public void clickOnContinue() {
		try {
			driver.findElement(warning).isDisplayed();
			driver.findElement(warningText).isDisplayed();
			driver.findElement(warningOkayButton).click();
		} finally {
			JScriptExecutor.click(driver, nomineeContinue);
		}

	}

	public FolioGeneration goToFolioGenerationPage() {
		return new FolioGeneration(driver);
	}
}
