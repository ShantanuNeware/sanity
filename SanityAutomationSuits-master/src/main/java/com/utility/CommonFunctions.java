package com.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class CommonFunctions {

	public static void selectValueFromDropdown(WebDriver driver, By by, String value) {
		List<WebElement> webElements = driver.findElements(by);
		for (WebElement we : webElements) {
			if (we.getText().contains(value)) {
				we.click();
				break;
			}
		}
	}

	public static void actionClick(WebDriver driver, By by) {
		Actions actions = new Actions(driver);
		actions.click(driver.findElement(by)).build().perform();
	}

	public static void ng(WebDriver driver, By by) {
		Actions actions = new Actions(driver);
		actions.click(driver.findElement(by)).click();
	}
}
