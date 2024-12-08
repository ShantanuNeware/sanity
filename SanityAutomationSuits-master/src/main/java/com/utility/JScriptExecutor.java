package com.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JScriptExecutor {

	public static void click(WebDriver driver, By element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", driver.findElement(element));
	}

	public static void clickByWebElement(WebDriver driver, WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public static void clickByWebElements(WebDriver driver, By element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public static void setDataByValue(WebDriver driver, By element, String data) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].setAttribute('value','" + data + "')", driver.findElement(element));
	}

	public static void sendText(WebDriver driver, By element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].value = 'shantanu';", element);
	}

	public static void modifyAttributeByID(WebDriver driver, String attribute) {
		((JavascriptExecutor) driver)
				.executeScript("document.getElementById('" + attribute + "').removeAttribute('readonly',0);");
	}

	public static String getNonTagText(WebDriver driver, By by) {

		return ((JavascriptExecutor) driver).executeScript("return arguments[0].value;", driver.findElement(by))
				.toString();
	}

	public static void changeBackgroundColour(WebDriver driver, WebElement element, String color) {
		((JavascriptExecutor) driver).executeScript("arguments[0].style.backgroundColor='" + color + "'", element);
	}

	public static void flashColour(WebDriver driver, WebElement element) {
		String backGroundColour = element.getCssValue("backgroundColor");

		for (int i = 0; i <= 100; i++) {
			changeBackgroundColour(driver, element, "rgb(140,200,0)");
			changeBackgroundColour(driver, element, backGroundColour);
		}
	}
}
