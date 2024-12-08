package pages.folio;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import com.utility.BrowserWaits;
import com.utility.JScriptExecutor;

import io.cucumber.java.en.Then;
import com.utility.ManualOtpEntry;

public class PostLoginFolioCreationPage {

	private final WebDriver driver;

	public static ManualOtpEntry ManualOTP = new ManualOtpEntry();

	private final By HelloText = By.xpath("//*[@id=\"root\"]/div/div[3]/div[2]/div/div/div[1]/h3/span");
	private final By CreateFolio = By.xpath("//button[@type='button' and @name ='bt']");
	private final By zeroBalanceFolio = By
			.xpath("//*[@id=\"root\"]/div/div[3]/div[3]/div/div[1]/div/div/div/div[2]/div/span/span[1]/input");
	private final By BalancedFolio = By
			.xpath("//*[@id=\"root\"]/div/div[3]/div[3]/div/div[1]/div/div/div/div[2]/div/span/span[1]/input");
	private final By MobileNumberFiled = By.xpath(
			"//*[@id=\"root\"]/div/div[3]/div/div/div/div/form/div/div/div[1]/div[1]/div[1]/div[2]/div/div/div/input");
	private final By MobileSendOTP = By.xpath(
			"//*[@id=\"root\"]/div/div[3]/div/div/div/div/form/div/div/div[1]/div[1]/div[1]/div[2]/div/div/div/div/button");
	private final By EmailField = By
			.xpath("//*[@id=\"root\"]/div/div[3]/div/div/div/div/form/div/div/div[1]/div[2]/div[1]/div/input");
	private final By EmailSendOTP = By
			.xpath("//*[@id=\"root\"]/div/div[3]/div/div/div/div/form/div/div/div[1]/div[2]/div[1]/div/div/button");
	private final By PANField = By
			.xpath("/html/body/div[1]/div/div[3]/div/div/div/div/form/div/div/div[3]/div/div/div/div/input");
	private final By PANNumber = By
			.xpath("/html/body/div[1]/div/div[3]/div/div/div/div/form/div/div/div[3]/div/div/div/div/input");
	private final By VerifyLink = By
			.xpath("//*[@id=\"root\"]/div/div[3]/div/div/div/div/form/div/div/div[3]/div/div/div/div/div/span");
	private final By ProceedButton = By.xpath("//button[@type='submit' and @name ='next']");
	private final By AccountNumberField = By
			.xpath("/html/body/div[1]/div/div[3]/div/div/div[2]/form/div/div[3]/div/div[2]/div[1]/div/div/input");
	private final By ConfirmAccountNumberField = By
			.xpath("/html/body/div[1]/div/div[3]/div/div/div[2]/form/div/div[3]/div/div[2]/div[2]/div/div/input");
	private final By IFSCCODEFIELD = By
			.xpath("/html/body/div[1]/div/div[3]/div/div/div[2]/form/div/div[4]/div/div[2]/div/div/div/input");
	private final By ProceedButtonBankDetails = By
			.xpath("//*[@id=\"root\"]/div/div[3]/div/div/div[2]/form/div/div[6]/div[2]/button");
	private final By OptOutOption = By.xpath("/html/body/div[1]/div/div[3]/div/div/div[2]/div[1]/div/label/span");
	private final By TermsforOptOut = By.xpath("//button[@type='button' and @name ='proceedBtnYes']");
	private final By nomineeProceed = By.xpath("//button[@type='submit' and @name ='submit']");
	private final By continueReviewDetailButton = By.xpath("//button[@type='submit' and @name ='next']");

	private final By OTPInputfield1 = By.xpath(
			"//*[@id=\"root\"]/div/div[3]/div/div/div/div/form/div/div/div[1]/div[1]/div[2]/div/div/div[1]/input[1]");
	private final By OTPInputfield2 = By.xpath(
			"//*[@id=\"root\"]/div/div[3]/div/div/div/div/form/div/div/div[1]/div[1]/div[2]/div/div/div[1]/input[2]");
	private final By OTPInputfield3 = By.xpath(
			"//*[@id=\"root\"]/div/div[3]/div/div/div/div/form/div/div/div[1]/div[1]/div[2]/div/div/div[1]/input[3]");
	private final By OTPInputfield4 = By.xpath(
			"//*[@id=\"root\"]/div/div[3]/div/div/div/div/form/div/div/div[1]/div[1]/div[2]/div/div/div[1]/input[4]");
	private final By OTPInputfield5 = By.xpath(
			"//*[@id=\"root\"]/div/div[3]/div/div/div/div/form/div/div/div[1]/div[1]/div[2]/div/div/div[1]/input[5]");
	private final By OTPInputfield6 = By.xpath(
			"//*[@id=\"root\"]/div/div[3]/div/div/div/div/form/div/div/div[1]/div[1]/div[2]/div/div/div[1]/input[6]");

	private final By EmailOTPInputfield1 = By.xpath(
			"//*[@id=\"root\"]/div/div[3]/div/div/div/div/form/div/div/div[1]/div[2]/div[2]/div/div/div[1]/input[1]");
	private final By EmailOTPInputfield2 = By.xpath(
			"//*[@id=\"root\"]/div/div[3]/div/div/div/div/form/div/div/div[1]/div[2]/div[2]/div/div/div[1]/input[2]");
	private final By EmailOTPInputfield3 = By.xpath(
			"//*[@id=\"root\"]/div/div[3]/div/div/div/div/form/div/div/div[1]/div[2]/div[2]/div/div/div[1]/input[3]");
	private final By EmailOTPInputfield4 = By.xpath(
			"//*[@id=\"root\"]/div/div[3]/div/div/div/div/form/div/div/div[1]/div[2]/div[2]/div/div/div[1]/input[4]");
	private final By EmailOTPInputfield5 = By.xpath(
			"//*[@id=\"root\"]/div/div[3]/div/div/div/div/form/div/div/div[1]/div[2]/div[2]/div/div/div[1]/input[5]");
	private final By EmailOTPInputfield6 = By.xpath(
			"//*[@id=\"root\"]/div/div[3]/div/div/div/div/form/div/div/div[1]/div[2]/div[2]/div/div/div[1]/input[6]");

	public PostLoginFolioCreationPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean CheckonDahboardpage() {
		BrowserWaits.fluentWait(driver, HelloText);
		return driver.findElement(HelloText).isDisplayed();
	}

	public void clickonczerobalanceFolio(String zeroBalance) {
		if (zeroBalance == "YES") {
			BrowserWaits.fluentWait(driver, zeroBalanceFolio);
			JScriptExecutor.click(driver, zeroBalanceFolio);
		} else {
			BrowserWaits.fluentWait(driver, zeroBalanceFolio);
			JScriptExecutor.click(driver, BalancedFolio);
		}

	}

	public void clickoncreatenewfolio() {
		BrowserWaits.fluentWait(driver, CreateFolio);
		JScriptExecutor.click(driver, CreateFolio);
	}

	public void enterMobileNumber(String Mobile) throws InterruptedException {
		BrowserWaits.fluentWait(driver, MobileNumberFiled);
		JScriptExecutor.click(driver, MobileNumberFiled);
		JScriptExecutor.setDataByValue(driver, MobileNumberFiled, Mobile);
		JScriptExecutor.click(driver, MobileSendOTP);
	}

	public void enterMobileNumberOTPManually() throws InterruptedException {
		ManualOtpEntry.displayOTPPrompt(driver, 3, 40);
		String OTP = ManualOtpEntry.OTP;
		char a = OTP.charAt(0);
		String p = String.valueOf(a);
		char b = OTP.charAt(1);
		String q = String.valueOf(b);
		char c = OTP.charAt(2);
		String r = String.valueOf(c);
		char d = OTP.charAt(3);
		String s = String.valueOf(d);
		char e = OTP.charAt(4);
		String t = String.valueOf(e);
		char f = OTP.charAt(5);
		String u = String.valueOf(f);

		driver.findElement(OTPInputfield1).sendKeys(p);
		driver.findElement(OTPInputfield2).sendKeys(q);
		driver.findElement(OTPInputfield3).sendKeys(r);
		driver.findElement(OTPInputfield4).sendKeys(s);
		driver.findElement(OTPInputfield5).sendKeys(t);
		driver.findElement(OTPInputfield6).sendKeys(u);

	}

	public void enterEmail(String Email) throws InterruptedException {
		BrowserWaits.fluentWait(driver, EmailField);
		JScriptExecutor.click(driver, EmailField);
		JScriptExecutor.setDataByValue(driver, MobileNumberFiled, Email);
		JScriptExecutor.click(driver, EmailSendOTP);
		Thread.sleep(1000);
	}

	public void enterEmailOTPManually() throws InterruptedException {
		ManualOtpEntry.displayOTPPrompt(driver, 3, 40);
		String OTP = ManualOtpEntry.OTP;
		char a = OTP.charAt(0);
		String p = String.valueOf(a);
		char b = OTP.charAt(1);
		String q = String.valueOf(b);
		char c = OTP.charAt(2);
		String r = String.valueOf(c);
		char d = OTP.charAt(3);
		String s = String.valueOf(d);
		char e = OTP.charAt(4);
		String t = String.valueOf(e);
		char f = OTP.charAt(5);
		String u = String.valueOf(f);

		driver.findElement(EmailOTPInputfield1).sendKeys(p);
		driver.findElement(EmailOTPInputfield2).sendKeys(q);
		driver.findElement(EmailOTPInputfield3).sendKeys(r);
		driver.findElement(EmailOTPInputfield4).sendKeys(s);
		driver.findElement(EmailOTPInputfield5).sendKeys(t);
		driver.findElement(EmailOTPInputfield6).sendKeys(u);

	}

	public void enterPANforFolioCreation(String PAN) throws InterruptedException {

		Thread.sleep(5000);
		BrowserWaits.explicitWaitElementVisible(driver, PANField);
		JScriptExecutor.click(driver, PANField);
		driver.findElement(PANNumber).sendKeys(PAN);
		Thread.sleep(5000);

	}

	public void clickonverifylink() throws InterruptedException {
		Thread.sleep(5000);
		BrowserWaits.explicitWaitElementVisible(driver, VerifyLink);
		JScriptExecutor.click(driver, VerifyLink);
	}

	public void clickonProceedButton() throws InterruptedException {
		Thread.sleep(5000);
		BrowserWaits.explicitWaitElementVisible(driver, ProceedButton);
		JScriptExecutor.click(driver, ProceedButton);
	}

	public void EnterAccountNumber(String AccountNumber) throws InterruptedException {

		Thread.sleep(5000);
		BrowserWaits.explicitWaitElementVisible(driver, AccountNumberField);
		JScriptExecutor.click(driver, AccountNumberField);
		driver.findElement(AccountNumberField).sendKeys(AccountNumber);
		Thread.sleep(5000);

	}

	public void ConfirmAccountNumber(String AccountNumber) throws InterruptedException {

		Thread.sleep(5000);
		BrowserWaits.explicitWaitElementVisible(driver, ConfirmAccountNumberField);
		JScriptExecutor.click(driver, ConfirmAccountNumberField);
		driver.findElement(ConfirmAccountNumberField).sendKeys(AccountNumber);
		Thread.sleep(5000);

	}

	public void EntersIFSCcode(String IFSC) throws InterruptedException {

		Thread.sleep(5000);
		BrowserWaits.explicitWaitElementVisible(driver, IFSCCODEFIELD);
		JScriptExecutor.click(driver, IFSCCODEFIELD);
		driver.findElement(IFSCCODEFIELD).sendKeys(IFSC);
		Thread.sleep(10000);

	}

	public void clickonProceedButtonbankdetails() throws InterruptedException {
		Thread.sleep(5000);
		BrowserWaits.explicitWaitElementVisible(driver, ProceedButtonBankDetails);
		JScriptExecutor.click(driver, ProceedButtonBankDetails);
	}

	public void selectoptOutfornomineedetails() throws InterruptedException {

		BrowserWaits.fluentWait(driver, OptOutOption);
		JScriptExecutor.click(driver, OptOutOption);

	}

	public void selectTermsoptOut() throws InterruptedException {
		Thread.sleep(10000);
		BrowserWaits.fluentWait(driver, TermsforOptOut);
		JScriptExecutor.click(driver, TermsforOptOut);
	}

	public void NomineeproceedButton() throws InterruptedException {
		BrowserWaits.fluentWait(driver, nomineeProceed);
		JScriptExecutor.click(driver, nomineeProceed);
	}

	public void ContinueButtonForreviewdetails() throws InterruptedException {
		BrowserWaits.fluentWait(driver, continueReviewDetailButton);
		JScriptExecutor.click(driver, continueReviewDetailButton);
	}

}
