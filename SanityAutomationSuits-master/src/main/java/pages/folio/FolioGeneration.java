package pages.folio;

import com.utility.BrowserWaits;
import com.utility.JScriptExecutor;
import com.utility.WriteToTextFile;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.transactions.TransactionPage;

public class FolioGeneration {

	private final WebDriver driver;
	private final By folioNumberGenMessage = By.xpath("//h6[text()='Congratulations!']");
	private final By folioNumber = By.xpath("//h6[text()='Congratulations!']/following-sibling::p[3]");

	private final By proceedToCheckout = By.name("incrementButton");

	public FolioGeneration(WebDriver driver) {
		this.driver = driver;
	}

	public boolean verifyFolioNumberMessage() {
		BrowserWaits.fluentWait(driver, folioNumberGenMessage);
		return driver.findElement(folioNumberGenMessage).isDisplayed();
	}

	public String getFolioNumber() throws IOException {
		String folioNo = driver.findElement(folioNumber).getText();
		WriteToTextFile.writeData(folioNo, "target/folioNo.txt", false);
		return folioNo;

	}

	public void clickOnProceedToCheckout() {
		JScriptExecutor.click(driver, proceedToCheckout);
	}

	public TransactionPage goToTransactionScreen() {
		return new TransactionPage(driver);
	}

}
