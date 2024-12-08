package com.utility;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class ManualOtpEntry {

	public static String OTP;
	public static String OTPPromptText = "Please enter OTP";

	public static String displayOTPPrompt(WebDriver driver, int timeOutInSeconds, int sleepInSeconds)
			throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.promptResponse=prompt('" + OTPPromptText + "');");

		long timeOutInMillis = timeOutInSeconds * 1000;
		long sleepInMillis = sleepInSeconds * 1000;
		long startTime = System.currentTimeMillis();

		while (isOTPPromptPresent(driver, OTPPromptText)
				&& ((System.currentTimeMillis() - startTime) < timeOutInMillis)) {
			Thread.sleep(sleepInMillis);
		}

		OTP = (String) js.executeScript("return window.promptResponse");
		return OTP;

	}

	public static boolean isOTPPromptPresent(WebDriver driver, String OTPPromptText) {
		try {
			Alert prompt = driver.switchTo().alert();
			if (prompt.getText() != null && prompt.getText().equals(OTPPromptText))
				return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
		return false;
	}

}
