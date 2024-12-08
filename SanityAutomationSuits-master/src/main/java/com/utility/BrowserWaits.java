package com.utility;

import lombok.SneakyThrows;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

public class BrowserWaits {

	public static void explicitWaitElementVisible(WebDriver driver, By webElement) {
		new WebDriverWait(driver, Duration.ofSeconds(50))
				.until(ExpectedConditions.visibilityOfElementLocated(webElement));
	}

	public static void explicitWaitClickable(WebDriver driver, By webElement) {
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(webElement));
	}

	public static void refreshTheDriver(WebDriver driver) {
		driver.navigate().refresh();
	}

	public static Boolean fluentWait(WebDriver driver, By by) {
		FluentWait<WebDriver> fluentWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(120))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);

		Function<WebDriver, Boolean> function = driver1 -> {

			WebElement webElement = driver1.findElement(by);
			boolean flag = false;
			String value = webElement.getCssValue("display");

			if (value.equalsIgnoreCase("block") || value.equalsIgnoreCase("inline-flex")
					|| value.equalsIgnoreCase("flex") || value.equalsIgnoreCase("inline"))
				flag = true;
			return flag;
		};
		return fluentWait.until(function);

	}

	public static Boolean fluentWaitWebelement(WebDriver driver, WebElement webElement) {
		FluentWait<WebDriver> fluentWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(100))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);

		Function<WebDriver, Boolean> function = driver1 -> {

			boolean flag = false;
			String value = webElement.getCssValue("display");

			if (value.equalsIgnoreCase("block") || value.equalsIgnoreCase("inline-flex")
					|| value.equalsIgnoreCase("flex") || value.equalsIgnoreCase("inline"))
				flag = true;
			return flag;
		};
		return fluentWait.until(function);

	}

	@SneakyThrows
	public static void waitTillDocumentIsLoaded(WebDriver driver) throws InterruptedException {
		while (true)
			if (((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"))
				break;
			else
				Thread.sleep(1000);
	}
}
