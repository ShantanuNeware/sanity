package pages.homepage;

import com.utility.BrowserWaits;
import com.utility.JScriptExecutor;
import com.utility.WriteToTextFile;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pages.transactions.TransactionPage;

public class dashboardpage {

	private final WebDriver driver;

	private final By HelloText = By.xpath("//*[@id=\"root\"]/div/div[3]/div[2]/div/div/div[1]/h3/span");
	private final By viewportfolio = By
			.xpath("//*[@id=\"root\"]/div/div[3]/div[2]/div/div/div[2]/div/div[1]/div[2]/div/button");
	private final By showScheme = By
			.xpath("//*[@id=\"root\"]/div/div[3]/div[3]/div/div[2]/div[1]/div/div[1]/div/div/div[2]/button[1]");
	private final By expandScheme = By
			.xpath("//*[@id=\"root\"]/div/div[3]/div[3]/div/div[2]/div[1]/div/div[1]/div/div[2]/div/div/div[2]/div");
	private final By expandclick = By.xpath(
			"//*[@id=\"root\"]/div/div[3]/div[3]/div/div[2]/div[1]/div/div[1]/div/div[2]/div/div/div[1]/div/div[1]");
	private final By XIRRclick = By.xpath(
			"//*[@id=\"root\"]/div/div[3]/div[3]/div/div[2]/div[1]/div/div[1]/div/div[2]/div/div/div[2]/div/div[1]/div/div/div/div[3]/div/p");
	private final By XIRR = By.xpath(
			"//*[@id=\"root\"]/div/div[3]/div[3]/div/div[2]/div[1]/div/div[1]/div/div[2]/div/div/div[1]/div/div[1]/div/div/div/div[3]/div/p");
//	Invested Amount
//	Absolute gain/loss
//	Balance Units
//	Current Value
//	XIRR
//	Current NAV
//	Avg. Purchase NAV

	public dashboardpage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean onDahboardpage() {
		BrowserWaits.fluentWait(driver, HelloText);
		return driver.findElement(HelloText).isDisplayed();
	}

	public void clickonviewPortfolio() {
		BrowserWaits.fluentWait(driver, viewportfolio);
		JScriptExecutor.click(driver, viewportfolio);
	}

	public void clickonshowScheme() {
		BrowserWaits.fluentWait(driver, showScheme);
		JScriptExecutor.click(driver, showScheme);
	}

	public void clickonexpandScheme() throws InterruptedException {
		BrowserWaits.fluentWait(driver, expandScheme);
		JScriptExecutor.click(driver, expandScheme);
		Thread.sleep(2000);
		JScriptExecutor.click(driver, expandclick);

	}

	public void checkValuesforinvestedamount() {
		BrowserWaits.fluentWait(driver, XIRRclick);
		JScriptExecutor.click(driver, XIRRclick);
		JScriptExecutor.getNonTagText(driver, XIRRclick);
		JScriptExecutor.getNonTagText(driver, XIRR);
		System.out.println(XIRRclick);
		System.out.println(XIRR);
	}

}
