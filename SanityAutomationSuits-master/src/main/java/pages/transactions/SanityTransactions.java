package pages.transactions;

import com.utility.BrowserWaits;
import com.utility.JScriptExecutor;
import com.utility.ReadEmail;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SanityTransactions {

	private final WebDriver driver;
	private final By newTransaction = By
			.xpath("//*[@id=\"root\"]/div/div[3]/div[2]/div/div/div[2]/div/div[2]/div/div[3]/div/div[1]/button/a");
	private final By clickSelectPANDropDown = By
			.xpath("//label[text()='Select PAN']/following-sibling::div/div/button[@aria-label='Open']");
	private final By selectPAN = By.xpath("//li[@class='MuiAutocomplete-option']");
	private final By folio = By.xpath("//p[text()='Folio number']/following-sibling::p");

	private final By clickOnInvest = By
			.xpath("//*[@id=\"modal-scroll\"]/div/div[4]/div[2]/div/div/div[2]/div/button[1]");
	private final By clickOnWithdraw = By.xpath("//button[text()='Withdraw']");
	private final By clickOnSwitch = By.xpath("//button[text()='Switch']");
	private final By clickOnOthers = By.xpath("//button[text()='Others']");

	private final By clickOnLumpsumTransaction = By
			.xpath("//p[text()='Lumpsum']/parent::div/following-sibling::div[2]/button");
	private final By clickOnSIPTransaction = By.xpath("//p[text()='SIP']/parent::div/following-sibling::div[2]/button");
	private final By clickOnWithdrawRedeemTransaction = By
			.xpath("//p[text()='Redeem']/parent::div/following-sibling::div[2]/button");
	private final By clickOnSwitchTransaction = By
			.xpath("//p[text()='Switch']/parent::div/following-sibling::div[2]/button");

	private final By allCategoriesDropDown = By
			.xpath("//*[@id=\"modal-scroll\"]/div/div/div/form/div/div[2]/div[1]/div/div/div/div/button[2]");
	private final By allCategoriesValue = By.xpath("//li[starts-with(@class,'MuiAutocomplete-option')]");
	private final By selectFundDropDown = By
			.xpath("//label[text()='Select Fund']/following-sibling::div/div/button[@aria-label='Open']");
	private final By allFundsValue = By.xpath("//ul[@id='mui-27-listbox']/div");
	private final By inputInvestmentAmount = By.xpath("//input[@name='investmentAmount']");
	private final By ProceedToPaymentLumpsum = By.xpath("//button[@name='back' and @type='submit']");
	private final By ProceedToPaymentSIP = By.xpath("//button[@name='Proceed to payment' and @type='submit']");
	private final By ProceedToPayment = By.xpath("//button[@name='back' and @type='submit']");
	private final By selectFundToRedeem = By
			.xpath("//div[@id='invest-fund']/div/div/div/fieldset/label/span/div/div/p");
	private final By redeemDetailsAmount = By.xpath("//span[text()='Amount']");
	private final By redeemDetailsUnit = By.xpath("//span[text()='Units']");
	private final By redeemAmountInput = By.name("redeemAmount");
	private final By redeemUnitsInput = By.name("redeemUnits");
	private final By redeemfundlist = By.xpath("//*[@id=\"invest-fund\"]");
	private final By redeempaymentMode = By.xpath("//*[@id=\"modal-scroll\"]/div/div/div/div/div[3]/div[2]/div[1]/p");
	private final By SwitchAmountInput = By.name("targets.0.investmentAmount");
	private final By SwitchUnitsInput = By.name("targets.0.investmentUnit");
	private final By SwitchContinueButton = By.xpath("//button[@name='submitButton' and @type='submit']");

	private final By allCategoriesDropDown3 = By
			.xpath("//*[@id=\"modal-scroll\"]/div/div/div/form/div/div[7]/div[1]/div[1]/div/div/div/div/button[2]");
	private final By allCategoriesValue3 = By.xpath("//li[@class='MuiAutocomplete-option']");
	private final By allFundsValue3 = By.xpath("//ul[@id='mui-80-listbox']/div");
	private final By allSchemeValue3 = By.xpath("//ul[@id='mui-82-listbox']/div");

	private final By OTPV = By.xpath("//*[@class='input']");
	private static final String OTPVALUE = "//*[@class='input'][";

	private final By clickContinueOnRedeem = By.xpath("//button[@name='CONTINUE']");
	private final By clickTermsAndCondition = By.xpath("//input[@name='termsCondition' and @type='checkbox']");
	private final By clickContinue = By.xpath("//button[@name='Continue' and @type='button']");

	private final By OTPInputfield1 = By.xpath("//*[@class='input'][1]");
	private final By OTPInputfield2 = By.xpath("//*[@class='input'][2]");
	private final By OTPInputfield3 = By.xpath("//*[@class='input'][3]");
	private final By OTPInputfield4 = By.xpath("//*[@class='input'][4]");
	private final By OTPInputfield5 = By.xpath("//*[@class='input'][5]");
	private final By OTPInputfield6 = By.xpath("//*[@class='input'][6]");

	private final By UPIExpanded = By.xpath("//div[text()='UPI']");
	private final By EnterUPI_ID = By.xpath("//input[@name='upiId']");
	private final By verifyUPIId = By.xpath("//button[@name='verify']");

	private final By UPIMandateExpanded = By.xpath("//div[text()='UPI Mandate']");

	List<WebElement> elements;

	public SanityTransactions(WebDriver driver) {
		this.driver = driver;
	}

	public void directToTransaction() {
		BrowserWaits.fluentWait(driver, newTransaction);
		JScriptExecutor.click(driver, newTransaction);
	}

	public void selectPANFolio(String pan, String foliono) {
		BrowserWaits.explicitWaitClickable(driver, clickSelectPANDropDown);
		JScriptExecutor.click(driver, clickSelectPANDropDown);
		elements = driver.findElements(selectPAN);
		for (WebElement element : elements) {
			if (element.getText().contains(pan)) {
				JScriptExecutor.clickByWebElement(driver, element);
				break;
			}
		}
		BrowserWaits.fluentWait(driver, folio);
		elements = driver.findElements(folio);
		for (WebElement element : elements) {
			if (element.getText().contains(foliono)) {
				JScriptExecutor.clickByWebElement(driver, element);
				break;
			}
		}
	}

	public void clickInvestTab() throws InterruptedException {
		Thread.sleep(3000);
		JScriptExecutor.click(driver, clickOnInvest);
	}

	public void clickWithdrawTab() throws InterruptedException {
		Thread.sleep(3000);
		JScriptExecutor.click(driver, clickOnWithdraw);
	}

	public void clickSwitchTab() throws InterruptedException {
		Thread.sleep(3000);
		JScriptExecutor.click(driver, clickOnSwitch);
	}

	public void clickOthersTab() throws InterruptedException {
		Thread.sleep(3000);
		JScriptExecutor.click(driver, clickOnOthers);
	}

	public void SelectLumpsum() throws InterruptedException {
		Thread.sleep(3000);
		JScriptExecutor.click(driver, clickOnLumpsumTransaction);
	}

	public void SelectSIP() throws InterruptedException {
		Thread.sleep(3000);
		JScriptExecutor.click(driver, clickOnSIPTransaction);
	}

	public void SelectRedeem() throws InterruptedException {
		Thread.sleep(3000);
		JScriptExecutor.click(driver, clickOnWithdrawRedeemTransaction);
	}

	public void SelectSwitch() throws InterruptedException {
		Thread.sleep(3000);
		JScriptExecutor.click(driver, clickOnSwitchTransaction);
	}

	public void selectCategory(String Category) {
		BrowserWaits.fluentWait(driver, allCategoriesDropDown);
		JScriptExecutor.click(driver, allCategoriesDropDown);
		elements = driver.findElements(allCategoriesValue);
		for (WebElement element : elements) {
			if (element.getText().contains(Category)) {
				JScriptExecutor.clickByWebElement(driver, element);
				break;
			}
		}
	}

	public void selectFund(String FUND) {
		elements = driver.findElements(allCategoriesValue);
		for (WebElement element : elements) {
			if (element.getText().contains(FUND)) {
				JScriptExecutor.clickByWebElement(driver, element);
				break;
			}
		}
	}

	public void selectSchemeOption(String SchemeOption) {
		elements = driver.findElements(allCategoriesValue);
		for (WebElement element : elements) {
			if (element.getText().contains(SchemeOption)) {
				JScriptExecutor.clickByWebElement(driver, element);
				break;
			}
		}
	}

	public void userSelectsHisFundforRedeem_Switch(String fund) throws InterruptedException {
		Thread.sleep(5000);
		BrowserWaits.fluentWait(driver, redeemfundlist);
		elements = driver.findElements(selectFundToRedeem);
		for (WebElement element : elements) {
			if (element.getText().contains(fund)) {
				element.click();
				break;
			}
		}

	}

	public void doRedeem2(String redemptionMode, String value) throws InterruptedException {
		elements = driver.findElements(redeempaymentMode);
		Thread.sleep(3000);
		if (redemptionMode.equalsIgnoreCase("amount")) {
			JScriptExecutor.click(driver, redeemDetailsAmount);
			// driver.findElement(redeemDetailsAmount).click();
			driver.findElement(redeemAmountInput).sendKeys(value);
		} else {
			JScriptExecutor.click(driver, redeemDetailsUnit);
			// driver.findElement(redeemDetailsUnit).click();
			driver.findElement(redeemUnitsInput).sendKeys(value);
		}

		Thread.sleep(3000);
		Actions a = new Actions(driver);
		a.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(5000);
		JScriptExecutor.click(driver, clickContinueOnRedeem);

	}

	public void userSelectsModeforSwitch(String redemptionMode, String value) throws InterruptedException {
		elements = driver.findElements(redeempaymentMode);
		Thread.sleep(3000);
		if (redemptionMode.equalsIgnoreCase("amount")) {
			JScriptExecutor.click(driver, redeemDetailsAmount);
		} else {
			JScriptExecutor.click(driver, redeemDetailsUnit);
		}
	}

	public void userSelectsCategoryforSwitch(String Category) throws InterruptedException {
		Thread.sleep(3000);
		JScriptExecutor.click(driver, allCategoriesDropDown3);
		elements = driver.findElements(allCategoriesValue3);
		for (WebElement element : elements) {
			if (element.getText().contains(Category)) {
				JScriptExecutor.clickByWebElement(driver, element);
				break;
			}
		}
	}

	public void userSelectsFundforSwitch(String FUND) throws InterruptedException {
		Thread.sleep(3000);
		elements = driver.findElements(allFundsValue3);
		for (WebElement element : elements) {
			if (element.getText().contains(FUND)) {
				JScriptExecutor.clickByWebElement(driver, element);
				break;
			}
		}
	}

	public void userSelectsSchemeOptionforSwitch(String SchemeOption) throws InterruptedException {
		Thread.sleep(3000);
		elements = driver.findElements(allSchemeValue3);
		for (WebElement element : elements) {
			if (element.getText().contains(SchemeOption)) {
				JScriptExecutor.clickByWebElement(driver, element);
				break;
			}
		}
	}

	public void userEnterAmountORUnit(String redemptionMode, String value) throws InterruptedException {
		elements = driver.findElements(redeempaymentMode);
		Thread.sleep(3000);
		if (redemptionMode.equalsIgnoreCase("amount")) {
			JScriptExecutor.click(driver, SwitchAmountInput);
			driver.findElement(SwitchAmountInput).sendKeys(value);
		} else {
			JScriptExecutor.click(driver, SwitchUnitsInput);
			driver.findElement(SwitchUnitsInput).sendKeys(value);
		}

		Thread.sleep(3000);
		Actions a = new Actions(driver);
		a.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(2000);
		a.sendKeys(Keys.PAGE_DOWN).build().perform();

	}

	public void Click_Continue_ButtonSwitch() throws InterruptedException {
		Thread.sleep(3000);
		JScriptExecutor.click(driver, SwitchContinueButton);
		Thread.sleep(3000);
	}

	public void checkBankDetails() throws InterruptedException {
		Thread.sleep(3000);
		JScriptExecutor.click(driver, clickContinue);
		Thread.sleep(3000);
	}

	public void EnterAmount(String amount) throws InterruptedException {
		Thread.sleep(3000);
		JScriptExecutor.click(driver, inputInvestmentAmount);
		driver.findElement(inputInvestmentAmount).sendKeys(amount);
	}

	public void clickProceedToPaymentPurchase() throws InterruptedException {
		Thread.sleep(5000);
		JScriptExecutor.click(driver, ProceedToPaymentLumpsum);

	}

	public void clickProceedToPaymentSIP() throws InterruptedException {
		Thread.sleep(5000);
		JScriptExecutor.click(driver, ProceedToPaymentSIP);

	}

	public void EnterOTPLumpsum() throws InterruptedException {

		setOTPintoOTPfield("Purchase Transaction OTP");

	}

	public void EnterOTPSIP() throws InterruptedException {

		setOTPintoOTPfield("SIP Purchase Transaction OTP");

	}

	public void EnterOTPRedeem() throws InterruptedException {

		setOTPintoOTPfield("Redeem transaction OTP");

	}

	public void EnterOTPSwitch() throws InterruptedException {

		setOTPintoOTPfield("Switch transaction OTP");

	}

	public void setOTPintoOTPfield(String Subjectt) throws InterruptedException {

		Thread.sleep(5000);
		String otp = ReadEmail.getOtp(Subjectt);
		System.out.println(otp.toString());

		char a = otp.charAt(0);
		String p = String.valueOf(a);
		char b = otp.charAt(1);
		String q = String.valueOf(b);
		char c = otp.charAt(2);
		String r = String.valueOf(c);
		char d = otp.charAt(3);
		String s = String.valueOf(d);
		char e = otp.charAt(4);
		String t = String.valueOf(e);
		char f = otp.charAt(5);
		String u = String.valueOf(f);

		driver.findElement(OTPInputfield1).sendKeys(p);
		driver.findElement(OTPInputfield2).sendKeys(q);
		driver.findElement(OTPInputfield3).sendKeys(r);
		driver.findElement(OTPInputfield4).sendKeys(s);
		driver.findElement(OTPInputfield5).sendKeys(t);
		driver.findElement(OTPInputfield6).sendKeys(u);
		Thread.sleep(5000);

	}

	public void ClickOnTermsCondition() throws InterruptedException {

		JScriptExecutor.click(driver, clickTermsAndCondition);

	}

	public void ClickOnContinue() throws InterruptedException {
		Thread.sleep(2000);
		JScriptExecutor.click(driver, clickContinue);
	}

	public void EnterUPI_Click_PreoceedTo_Pay(String UPIID) throws InterruptedException {
		Thread.sleep(10000);
		BrowserWaits.fluentWait(driver, UPIExpanded);
		JScriptExecutor.click(driver, UPIExpanded);
		Thread.sleep(2000);
//    	JScriptExecutor.click(driver, UPIBankSelected);
		Thread.sleep(2000);
		JScriptExecutor.click(driver, EnterUPI_ID);
		Thread.sleep(2000);
		driver.findElement(EnterUPI_ID).sendKeys(UPIID);
		Thread.sleep(2000);
		JScriptExecutor.click(driver, verifyUPIId);
	}

	public void EnterUPIMandate_Click_PreoceedTo_Pay(String UPIID) throws InterruptedException {
		Thread.sleep(10000);
		BrowserWaits.fluentWait(driver, UPIMandateExpanded);
		JScriptExecutor.click(driver, UPIMandateExpanded);
		Thread.sleep(2000);
//    	JScriptExecutor.click(driver, UPIBankSelected);
		Thread.sleep(2000);
		JScriptExecutor.click(driver, EnterUPI_ID);
		Thread.sleep(2000);
		driver.findElement(EnterUPI_ID).sendKeys(UPIID);
		Thread.sleep(2000);
		JScriptExecutor.click(driver, verifyUPIId);
	}

	public void clickProceedToPayment() throws InterruptedException {
		Thread.sleep(5000);
		BrowserWaits.fluentWait(driver, ProceedToPayment);
		JScriptExecutor.click(driver, ProceedToPayment);

	}

}
