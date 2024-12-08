package com.driver;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Factory {

	public static final ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	/**
	 * This Method takes a browser as string and returns webdriver as output
	 *
	 * @param browser value from property file is provided here
	 * @return this return threadsafe web driver Created by @Navneet Mishra
	 */
	public WebDriver driverInitilization(String browser, int width, int height) {
		switch (browser) {
		case "chrome":
			ChromeOptions options = new ChromeOptions();
			options.addArguments("incognito");
			tlDriver.set(new ChromeDriver(options));
			break;
		case "firefox":
			tlDriver.set(new FirefoxDriver());
			break;
		case "edge":
			tlDriver.set(new EdgeDriver());
			break;
		default:
			break;
		}
		getDriver().manage().deleteAllCookies();
		// Dimension newDimension = new Dimension(width, height);
		getDriver().manage().window().maximize();

		// getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		return getDriver();
	}

	public static WebDriver getDriver() {
		return tlDriver.get();

	}
}
