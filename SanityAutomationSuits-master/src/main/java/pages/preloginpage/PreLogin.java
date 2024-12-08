package pages.preloginpage;

import com.utility.BrowserWaits;
import com.utility.JScriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.homepage.Home;

import java.time.Duration;

public class PreLogin {

	private final WebDriver driver;
	private final By userName = By.name("userName");
	private final By password = By.name("password");
	private final By submit = By.xpath("//*[@id=\"root\"]/div/div/button");

	public PreLogin(WebDriver driver) {
		this.driver = driver;
	}

	public void investorURL(String url) {
		driver.get(url);
	}

	public void setUsername(String username) {
		driver.findElement(userName).sendKeys(username);
	}

	public void setPassword(String passwd) {
		driver.findElement(password).sendKeys(passwd);
	}

	public void clickOnSubmit() {
		driver.findElement(submit).click();
	}

	public String getURL() {
		return driver.getCurrentUrl();
	}

	public Home doPreLogin(String url, String username, String passwd) {
		investorURL(url);
		BrowserWaits.fluentWait(driver, userName);
		driver.findElement(userName).sendKeys(username);
		driver.findElement(password).sendKeys(passwd);
		JScriptExecutor.click(driver, submit);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return new Home(driver);
	}
}
