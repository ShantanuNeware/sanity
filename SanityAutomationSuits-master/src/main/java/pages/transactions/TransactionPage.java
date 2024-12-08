package pages.transactions;

import com.utility.BrowserWaits;
import lombok.SneakyThrows;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class TransactionPage {

	private final WebDriver driver;
	private final By clickSelectPANDropDown = By
			.xpath("//label[text()='Select PAN']/following-sibling::div/div/button[@aria-label='Open']");
	private final By clickOnInvest = By.xpath("//button[text()='Invest']");
	private static final String OTPVALUERedeem = "//*[@class='input input'][";
	private final By clickOnWithdraw = By.xpath("//button[text()='Withdraw']");
	private final By clickOnSwitch = By.xpath("//button[text()='Switch']");
	private final By clickOnOthers = By.xpath("//button[text()='Others']");
	private final By clickOnSwitchStart = By.xpath("//p[text()='Switch']/parent::div/following-sibling::div[2]/button");
	private final By clickOnSTPStart = By.xpath("//p[text()='STP']/parent::div/following-sibling::div[2]/button");
	private final By clickOnFlexSTPStart = By
			.xpath("//p[text()='Flex STP']/parent::div/following-sibling::div[2]/button");
	private final By clickOnBoosterSTPStart = By
			.xpath("//p[text()='Booster STP']/parent::div/following-sibling::div[2]/button");
	private final By clickOnRolloverStart = By
			.xpath("//p[text()='Rollover']/parent::div/following-sibling::div[2]/button");
	private final By clickOnTriggerOnMaturityStart = By
			.xpath("//p[text()='Trigger on Maturity']/parent::div/following-sibling::div[2]/button");
	private final By clickOnCloseEndedSchemeRedeemStart = By
			.xpath("//p[text()='Close Ended Scheme Redeem']/parent::div/following-sibling::div[2]/button");
	private final By clickOnCloseEndedSchemeSwitchStart = By
			.xpath("//p[text()='Close Ended Scheme Switch']/parent::div/following-sibling::div[2]/button");
	private final By clickOnRedeemFreedomSwpTransaction = By
			.xpath("//p[text()='Freedom SWP']/parent::div/following-sibling::div[2]/button");

	private final By clickOnLumpsumTransaction = By
			.xpath("//p[text()='Lumpsum']/parent::div/following-sibling::div[2]/button");

	private final By clickOnSIPTransaction = By.xpath("//p[text()='SIP']/parent::div/following-sibling::div[2]/button");
	private final By clickOnBoosterSipTransaction = By
			.xpath("//p[text()='Booster SIP']/parent::div/following-sibling::div[2]/button");
	private final By clickOnFreedomSipTransaction = By
			.xpath("//p[text()='Freedom SIP']/parent::div/following-sibling::div[2]/button");
	private static final String OTPVALUE = "//*[@class='input'][";
	private final By clickOnWithdrawRedeemTransaction = By
			.xpath("//p[text()='Reedem']/parent::div/following-sibling::div[2]/button");
	private final By allCategoriesDropDown = By
			.xpath("//input[@value='All Categories']/following-sibling::div/button[@aria-label='Open']");
	private final By selectFundDropDown = By
			.xpath("//label[text()='Select Fund']/following-sibling::div/div/button[@aria-label='Open']");
	private final By selectSchemeOptionDropDown = By
			.xpath("//label[text()='Scheme Option']/following-sibling::div/div/button[@aria-label='Open']");
	private final By allCategoriesDropDown2 = By.xpath("//input[@id='mui-35']/parent::div/div/button[@title='Open']");
	private final By selectFundDropDown2 = By.xpath("//input[@id='mui-37']/parent::div/div/button");
	private final By selectSchemeOptionDropDown2 = By.xpath("//input[@id='mui-20']/parent::div/div/button");
	private final By allCategoriesDropDown3 = By.xpath("//input[@id='mui-30']/parent::div/div/button[@title='Open']");
	private final By selectFundDropDown3 = By.xpath("//input[@id='mui-17']/parent::div/div/button");
	private final By selectSchemeOptionDropDown3 = By.xpath("//input[@id='mui-19']/parent::div/div/button");
	private final By allCategoriesDropDown4 = By.xpath("//input[@id='mui-33']/parent::div/div/button[@title='Open']");
	private final By selectFundDropDown4 = By.xpath("//input[@id='mui-35']/parent::div/div/button");
	private final By selectSchemeOptionDropDown4 = By.xpath("//input[@id='mui-14']/parent::div/div/button");

	private final By inputInvestmentAmount = By.xpath("//input[@name='investmentAmount']");
	private final By submitButton = By.xpath("//button[@type='submit']");
	private final By clickTermsAndCondition = By.xpath("//input[@name='termsCondition' and @type='checkbox']");
	private final By clickContinue = By.xpath("//button[@name='Continue']");
	private final By clickContinueOnRedeem = By.xpath("//button[@name='CONTINUE']");
	private final By onOTPVerificationPage = By.xpath("//h6[text()='OTP Verification']");
	// private final By selectPAN = By.xpath("//ul[@id='mui-19-listbox']/div");
	private final By selectPAN = By.xpath("//li[@class='MuiAutocomplete-option']");
	private final By folio = By.xpath("//p[text()='Folio number']/following-sibling::p");
	private final By clickUPIDropdown = By.xpath("//div[text()='UPI']");
	private final By onPaymentpage = By.xpath("//h3[text()='Select a payment method']");
	private final By enterUPIId = By.xpath("//input[@name='upiId']");
	private final By verifyUPIId = By.xpath("//button[@name='verify']");
	private final By proceedToPayButton = By.xpath("//button[@name='back' and @type='submit']");
	private final By allCategoriesValue = By.xpath("//li[starts-with(@class,'MuiAutocomplete-option')]");
	private final By allFundsValue = By.xpath("//ul[@id='mui-27-listbox']/div");
	private final By allSchemeValue = By.xpath("//ul[@id='mui-29-listbox']/div");

	private final By allCategoriesValue2 = By.xpath("//ul[@id='mui-35-listbox']/div");
	private final By allFundsValue2 = By.xpath("//ul[@id='mui-37-listbox']/div");
	private final By allSchemeValue2 = By.xpath("//ul[@id='mui-39-listbox']/div");
	private final By allCategoriesValue3 = By.xpath("//ul[@id='mui-30-listbox']/div");
	private final By allFundsValue3 = By.xpath("//ul[@id='mui-32-listbox']/div");
	private final By allSchemeValue3 = By.xpath("//ul[@id='mui-34-listbox']/div");
	private final By allCategoriesValue4 = By.xpath("//ul[@id='mui-33-listbox']/div");
	private final By allFundsValue4 = By.xpath("//ul[@id='mui-35-listbox']/div");
	private final By allSchemeValue4 = By.xpath("//ul[@id='mui-37-listbox']/div");
	private final By clickPayout = By.xpath("//span[text()='Payout']");
	private final By clickReinvestment = By.xpath("//span[text()='Reinvestment']");
	private final By rgpFolioNumber = By.xpath("//p[text()='Folio Number']/following-sibling::p");
	private final By rgpPaymentMethod = By.xpath("//p[text()='Payment Method']/following-sibling::p");
	private static final String SELECTMANDATE = "']/parent::div/parent::div/parent::div/parent::div/div/div/div/fieldset/label/span/input";
	private final By clickNewMandate = By.xpath("//div[text()='CREATE NEW AUTOPAY MANDATE']");
	private final By createNewMandate = By.xpath("//input[@type='radio' and @name='selectBank']");
	private final By newMandateAmount = By.name("newMandateAmount");
	private final By firstUserId = By.id("DUMMY1");
	private final By sendUserId = By.id("AuthenticationFG.USER_PRINCIPAL");
	private final By sendPassword = By.id("AuthenticationFG.ACCESS_CODE");
	private final By clickLogin = By.id("VALIDATE_CREDENTIALS");
	private final By clickPay = By.xpath("//input[@id='CONTINUE_TRANSACTION']");
	private final By submit = By.id("SUBMIT_TRANSACTION");
	private final By getMandateAmount = By.xpath("//p[text()='Mandate Amount']/following-sibling::span");
	private final By clickNetBankingDropDown = By.xpath("//div[text()='Net Banking']");
	private final By selectNetBankingRadio = By.xpath(
			"//div[text()='Net Banking']/parent::div/following-sibling::div/div/div/div/div/div/div/div/div/fieldset/label/span/input");
	private final By frequencyDaily = By.xpath("//span[text()='Daily']");
	private final By frequencyWeekly = By.xpath("//span[text()='Weekly']");
	private final By frequencyFortnightly = By.xpath("//span[text()='Fortnightly']");
	private final By frequencyMonthly = By.xpath("//span[text()='Monthly']");
	private final By frequencyQuarterly = By.xpath("//span[text()='Quarterly']");
	private final By clickTopUp = By.name("topup");
	private final By clickTopUpModeDropDown = By.xpath("//div[text()='Percentage']");
	private final By clickTopUpModeDropDownValues = By.xpath("//ul[@role='listbox']/li");
	private final By clickHalfYearly = By.xpath("//span[text()='Half-yearly']");
	private final By clickAnnual = By.xpath("//span[text()='Annual']");
	private final By clickPlusIcon = By.xpath("//img[@src='/static/media/plusIcon.54ec0cf3.svg']");
	private final By enterInvAmount = By.name("topUpAmount");
	private final By multiplierDropdown = By.xpath("//div[@id='select-fund']");
	private final By targetAmountSTP = By.name("stpTargetAmount");
	private final By targetAmountSWP = By.name("swpInvestmentAmount");
	private final By selectFundToRedeem = By
			.xpath("//div[@id='invest-fund']/div/div/div/fieldset/label/span/div/div/p");
	private final By selectFundToRedeem2 = By.xpath("//input[@name='switchedFundOptionRadio']");
	private final By redeemDetailsAmount = By.xpath("//span[text()='Amount']");
	private final By redeemDetailsUnit = By.xpath("//span[text()='Units']");
	private final By redeemAmountInput = By.name("redeemAmount");
	private final By redeemUnitsInput = By.name("redeemUnits");
	private final By redeemFreedomSWPAmount = By.name("investmentAmount");
	private final By switchAmount = By.name("targets.0.investmentAmount");
	private final By switchUnits = By.name("targets.0.investmentUnit");
	private final By noOfInstallments = By.name("numOfInstallments");
	private final By noOfInstallmentsAmount = By.name("numOfInstallmentAmt");
	private final By specificEndDate = By.name("specificEndDate");
	private final By stpCalenderClick = By.xpath("//label[text()='STP From']/parent::div/div/div/img");
	private final By selectMonth = By
			.cssSelector("button.MuiTypography-root.MuiTypography-subtitle1.PrivatePickersMonth-root.css-1l4irwy");
	private final By newTransaction = By.xpath("//a[text()='New Transaction']");
	private final By sendToInvestor = By.xpath("//button[contains(text(),'Send To Investor')]");
	List<WebElement> elements;

	public TransactionPage(WebDriver driver) {
		this.driver = driver;
	}

	@SneakyThrows
	public void directToTransactionPage(String baseURI) {
		BrowserWaits.fluentWait(driver, newTransaction);
		driver.findElement(newTransaction).click();

	}

	@SneakyThrows
	public void selectPANFolio(String pan, String foliono) {
		BrowserWaits.explicitWaitClickable(driver, clickSelectPANDropDown);

		driver.findElement(clickSelectPANDropDown).click();

		elements = driver.findElements(selectPAN);
		for (WebElement element : elements) {
			if (element.getText().contains(pan)) {
				element.click();
				break;
			}
		}

		elements = driver.findElements(folio);
		for (WebElement element : elements) {
			if (element.getText().contains(foliono)) {
				element.click();
				break;
			}
		}

	}

	public void clickLumpsum() {
		driver.findElement(clickOnInvest).click();
		driver.findElement(clickOnLumpsumTransaction).click();
	}

	public void clickWithdrawRedeem() {
		driver.findElement(clickOnWithdraw).click();
		driver.findElement(clickOnWithdrawRedeemTransaction).click();
	}

	public void clickBoosterSIP() {
		driver.findElement(clickOnInvest).click();
		driver.findElement(clickOnBoosterSipTransaction).click();
	}

	public void clickSip() {
		driver.findElement(clickOnInvest).click();
		driver.findElement(clickOnSIPTransaction).click();
	}

	public void clickFreedomSip() {
		driver.findElement(clickOnInvest).click();
		driver.findElement(clickOnFreedomSipTransaction).click();
	}

	public void clickRedeemFreedomSWp() {
		driver.findElement(clickOnWithdraw).click();
		driver.findElement(clickOnRedeemFreedomSwpTransaction).click();
	}

	public void clickSwitchSwitch() {
		driver.findElement(clickOnSwitch).click();
		driver.findElement(clickOnSwitchStart).click();
	}

	@SneakyThrows
	public void selectSchemesAmountProceed(String allCategories, String fundDropdown, String selectScheme,
			String payout, String amount) {
		BrowserWaits.fluentWait(driver, allCategoriesDropDown);
		driver.findElement(allCategoriesDropDown).click();

		elements = driver.findElements(allCategoriesValue);
		for (WebElement element : elements) {
			if (element.getText().contains(allCategories)) {
				element.click();
				break;
			}
		}

		elements = driver.findElements(allCategoriesValue);
		for (WebElement element : elements) {
			if (element.getText().contains(fundDropdown)) {
				element.click();
				break;
			}
		}

		elements = driver.findElements(allCategoriesValue);
		for (WebElement element : elements) {
			if (element.getText().contains(selectScheme)) {
				element.click();
				break;
			}
		}
		if (payout.equals("Payout")) {
			driver.findElement(clickPayout).click();
		} else if (payout.equals("Reinvestment"))
			driver.findElement(clickReinvestment).click();

		driver.findElement(inputInvestmentAmount).click();
		driver.findElement(inputInvestmentAmount).sendKeys(amount);
	}

	@SneakyThrows
	public void selectFrequencyAndOtherDetails(String frequency, String startdate, String enddate, Boolean rightAway,
			Boolean topUp, String topUpMode, int plusIcon, String topupamount, String topUpFrequency)
			throws InterruptedException {
		extracted(frequency);
		if (Boolean.TRUE.equals(topUp)) {
			driver.findElement(clickTopUp).click();
			Thread.sleep(1000);
			driver.findElement(clickTopUpModeDropDown).click();
			Thread.sleep(1000);
			elements = driver.findElements(clickTopUpModeDropDownValues);
			for (WebElement element : elements) {
				if (element.getText().equalsIgnoreCase(topUpMode)) {
					element.click();
					break;

				}
			}
			if (topUpMode.equalsIgnoreCase("amount")) {
				driver.findElement(enterInvAmount).sendKeys(topupamount);
			} else {
				for (int i = 0; i < plusIcon; i++) {
					driver.findElement(clickPlusIcon).click();
				}
			}
			if (topUpFrequency.equalsIgnoreCase("Annual"))
				driver.findElement(clickAnnual).click();
			else
				driver.findElement(clickHalfYearly).click();
		}
	}

	private void extracted(String frequency) {
		frequency = frequency.toLowerCase();
		switch (frequency) {
		case "daily":
			driver.findElement(frequencyDaily).click();
			break;
		case "weekly":
			driver.findElement(frequencyWeekly).click();
			break;
		case "fortnightly":
			driver.findElement(frequencyFortnightly).click();
			break;
		case "quarterly":
			driver.findElement(frequencyQuarterly).click();
			break;
		default:
			driver.findElement(frequencyMonthly).click();
		}
	}

	@SneakyThrows
	public void fillSTPDetails(String allCategories, String fundDropdown, String selectScheme, String multiplier,
			String amount) throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(allCategoriesDropDown2).click();
		elements = driver.findElements(allCategoriesValue2);
		for (WebElement element : elements) {
			if (element.getText().contains(allCategories)) {
				element.click();
				break;
			}
		}

		driver.findElement(selectFundDropDown2).click();
		elements = driver.findElements(allFundsValue2);
		for (WebElement element : elements) {
			if (element.getText().contains(fundDropdown)) {
				element.click();
				break;
			}
		}
		Thread.sleep(1000);
		// driver.findElement(selectSchemeOptionDropDown2).click();
		elements = driver.findElements(allSchemeValue2);
		for (WebElement element : elements) {
			if (element.getText().contains(selectScheme)) {
				element.click();
				break;
			}
		}
		driver.findElement(multiplierDropdown).click();
		elements = driver.findElements(clickTopUpModeDropDownValues);
		for (WebElement element : elements) {
			if (element.getText().equalsIgnoreCase(multiplier)) {
				element.click();
				break;

			}
		}

		driver.findElement(targetAmountSTP).click();
		driver.findElement(targetAmountSTP).sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,
				Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);
		driver.findElement(targetAmountSTP).sendKeys(amount);
	}

	@SneakyThrows
	public void fillSWPDetails(String allCategories, String fundDropdown, String selectScheme, String payout,
			String amount) throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(allCategoriesDropDown2).click();
		elements = driver.findElements(allCategoriesValue2);
		for (WebElement element : elements) {
			if (element.getText().contains(allCategories)) {
				element.click();
				break;
			}
		}
		/*
		 * driver.findElement(selectFundDropDown2).click(); Thread.sleep(1000);
		 */
		driver.findElement(selectFundDropDown2).click();
		elements = driver.findElements(allFundsValue2);
		for (WebElement element : elements) {
			if (element.getText().contains(fundDropdown)) {
				element.click();
				break;
			}
		}
		Thread.sleep(1000);
		// driver.findElement(selectSchemeOptionDropDown2).click();
		elements = driver.findElements(allSchemeValue2);
		for (WebElement element : elements) {
			if (element.getText().contains(selectScheme)) {
				element.click();
				break;
			}
		}

		driver.findElement(targetAmountSWP).click();
		driver.findElement(targetAmountSWP).sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,
				Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);
		driver.findElement(targetAmountSWP).sendKeys(amount);

	}

	@SneakyThrows
	public void clickProceedInvestmentDetails() throws InterruptedException {
		driver.findElement(submitButton).click();
		Thread.sleep(5000);
	}

	@SneakyThrows
	public void sentOTPTNC() throws InterruptedException {

		for (int i = 1; i <= 6; i++) {
			driver.findElement(By.xpath(OTPVALUE + i + "]")).sendKeys(String.valueOf(i));
		}

		driver.findElement(clickTermsAndCondition).click();
		driver.findElement(clickContinue).click();
		Thread.sleep(15000);
	}

	@SneakyThrows
	public void doUPITransaction(String upi) throws InterruptedException {
		Thread.sleep(2000);
		BrowserWaits.fluentWait(driver, clickUPIDropdown);
		driver.findElement(clickUPIDropdown).click();
		driver.findElement(enterUPIId).sendKeys(upi);
		Thread.sleep(2000);
		driver.findElement(verifyUPIId).click();
		Thread.sleep(2000);
		driver.findElement(proceedToPayButton).click();
		Thread.sleep(40000);
	}

	@SneakyThrows
	public void doCreateNewMandate(String amount) throws InterruptedException {
		driver.findElement(clickNewMandate).click();
		Thread.sleep(2000);
		driver.findElement(createNewMandate).click();
		Thread.sleep(2000);
		driver.findElement(newMandateAmount).sendKeys(Integer.valueOf(amount) + 500 + "");
		Thread.sleep(2000);
		driver.findElement(proceedToPayButton).click();
		Thread.sleep(2000);
	}

	@SneakyThrows
	public void doSubmitExistingMandate(String amount) throws InterruptedException {

		List<WebElement> mandates = driver.findElements(getMandateAmount);
		for (WebElement mandate : mandates) {
			if (Integer.parseInt(amount) + 600 < Integer
					.parseInt(mandate.getText().substring(2, mandate.getText().trim().length() - 2))) {
				driver.findElement(By.xpath("//span[text()='" + mandate.getText() + SELECTMANDATE)).click();
				System.out.println("//span[text()='" + mandate.getText() + SELECTMANDATE);
				break;
			}
		}

		Thread.sleep(2000);
		driver.findElement(proceedToPayButton).click();
		Thread.sleep(2000);
	}

	@SneakyThrows
	public void submitUserIdAndPassword(String userName, String password) throws InterruptedException {
		driver.findElement(firstUserId).click();
		Thread.sleep(2000);
		driver.findElement(sendUserId).sendKeys(userName);
		driver.findElement(sendPassword).sendKeys(password);
		driver.findElement(clickLogin).click();
		Thread.sleep(2000);
		try {
			driver.findElement(clickPay).click();
		} catch (NoSuchElementException e) {
		}
		Thread.sleep(2000);
		driver.findElement(submit).click();
		Thread.sleep(11200);
	}

	@SneakyThrows
	public void doNetBanking() throws InterruptedException {
		driver.findElement(clickNetBankingDropDown).click();
		Thread.sleep(2000);
		driver.findElement(proceedToPayButton).click();
		Thread.sleep(2000);
	}

	@SneakyThrows
	public String inRRGPVerifyFolioNumber() throws InterruptedException {
		BrowserWaits.fluentWait(driver, rgpFolioNumber);
		Thread.sleep(6000);
		return driver.findElement(rgpFolioNumber).getText();
	}

	public String inRRGPVerifyPaymentMethod() {
		return driver.findElement(rgpPaymentMethod).getText();
	}

	public boolean inTransactionPage() {
		return driver.findElement(clickSelectPANDropDown).isDisplayed();
	}

	public boolean inSchemePage() {
		return driver.findElement(allCategoriesDropDown).isDisplayed();
	}

	public boolean inOTPPage() {
		return driver.findElement(onOTPVerificationPage).isDisplayed();
	}

	public boolean inPaymentPage() {
		return driver.findElement(onPaymentpage).isDisplayed();
	}

	@SneakyThrows
	public void doRedeem(String fund, String redemptionMode, String value) throws InterruptedException {
		elements = driver.findElements(selectFundToRedeem);
		for (WebElement element : elements) {
			if (element.getText().contains(fund)) {
				element.click();
				break;
			}
		}
		if (redemptionMode.equalsIgnoreCase("amount")) {
			driver.findElement(redeemDetailsAmount).click();
			driver.findElement(redeemAmountInput).sendKeys(value);
		} else {
			driver.findElement(redeemDetailsUnit).click();
			driver.findElement(redeemUnitsInput).sendKeys(value);
		}
		Actions a = new Actions(driver);
		a.sendKeys(Keys.PAGE_DOWN).build().perform();
		driver.findElement(clickContinueOnRedeem).click();
		Thread.sleep(3000);
	}

	@SneakyThrows
	public void checkBankDetails() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(clickContinue).click();
		Thread.sleep(3000);
	}

	@SneakyThrows
	public void sentOTPTNCRedeem() throws InterruptedException {
		for (int i = 1; i <= 6; i++) {
			driver.findElement(By.xpath(OTPVALUERedeem + i + "]")).sendKeys(String.valueOf(i));
		}
		driver.findElement(clickTermsAndCondition).click();
		driver.findElement(clickContinue).click();
		Thread.sleep(15000);
	}

	@SneakyThrows
	public void doRedeemFreedomSWP(String fund, String amount, int inc, String frequency, String start, String end)
			throws InterruptedException {

		elements = driver.findElements(selectFundToRedeem);
		for (WebElement element : elements) {
			if (element.getText().contains(fund)) {
				element.click();
				break;
			}
		}
		driver.findElement(redeemFreedomSWPAmount).sendKeys(amount);

		for (int i = 0; i < inc; i++) {
			driver.findElement(clickPlusIcon).click();
		}
		extracted(frequency);

		Actions a = new Actions(driver);
		a.sendKeys(Keys.PAGE_DOWN).build().perform();
		driver.findElement(clickContinue).click();
		Thread.sleep(3000);
	}

	@SneakyThrows
	public void fillNewSwitchDetails(String fund, String switchBy, String selectFundCategory, String selectFund,
			String selectScheme, String value) throws InterruptedException {
		Thread.sleep(10000);
		elements = driver.findElements(selectFundToRedeem);
		for (WebElement element : elements) {
			if (element.getText().contains(fund)) {
				element.click();
				break;
			}
		}
		if (switchBy.equalsIgnoreCase("amount")) {
			driver.findElement(redeemDetailsAmount).click();
		} else
			driver.findElement(redeemDetailsUnit).click();

		driver.findElement(allCategoriesDropDown3).click();
		elements = driver.findElements(allCategoriesValue3);
		for (WebElement element : elements) {
			if (element.getText().contains(selectFundCategory)) {
				element.click();
				break;
			}
		}

		elements = driver.findElements(allFundsValue3);
		for (WebElement element : elements) {
			if (element.getText().contains(selectFund)) {
				element.click();
				break;
			}
		}

		elements = driver.findElements(allSchemeValue3);
		for (WebElement element : elements) {
			if (element.getText().contains(selectScheme)) {
				element.click();
				break;
			}
		}
		if (switchBy.equalsIgnoreCase("amount")) {
			driver.findElement(switchAmount).click();
			driver.findElement(switchAmount).sendKeys(value);
		} else {
			driver.findElement(switchUnits).click();
			driver.findElement(switchUnits).sendKeys(value);
		}

		driver.findElement(submitButton).click();
	}

	public void clickSwitchSTP() {
		driver.findElement(clickOnSwitch).click();
		driver.findElement(clickOnSTPStart).click();
	}

	@SneakyThrows
	public void fillNewSTPDetails(String fund, String amount, String frequency, String stpFrom, String sED, String nOI,
			String selectFundCategory, String selectFund, String selectScheme) throws InterruptedException {
		Thread.sleep(9000);
		elements = driver.findElements(selectFundToRedeem2);
		for (WebElement element : elements) {
			if (element.isEnabled()) {
				Thread.sleep(1000);
				element.click();
				break;
			}
		}

		driver.findElement(inputInvestmentAmount).sendKeys(amount);
		frequency = frequency.toLowerCase();
		extracted(frequency);

		if (!sED.isEmpty()) {
			driver.findElement(noOfInstallments).click();
			Thread.sleep(1000);
			driver.findElement(noOfInstallments).sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE);
			driver.findElement(noOfInstallmentsAmount).sendKeys(nOI);
		} else {
			driver.findElement(noOfInstallments).click();
			driver.findElement(noOfInstallmentsAmount).sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE);
			driver.findElement(noOfInstallmentsAmount).sendKeys(nOI);
		}

		Thread.sleep(1000);
		driver.findElement(allCategoriesDropDown4).click();
		elements = driver.findElements(allCategoriesValue4);
		for (WebElement element : elements) {
			if (element.getText().contains(selectFundCategory)) {
				element.click();
				break;
			}
		}
		Thread.sleep(1000);
		driver.findElement(selectFundDropDown4).click();
		elements = driver.findElements(allFundsValue4);
		for (WebElement element : elements) {
			if (element.getText().contains(selectFund)) {
				element.click();
				break;
			}
		}
		Thread.sleep(1000);
		// driver.findElement(selectSchemeOptionDropDown4).click();
		elements = driver.findElements(allSchemeValue4);
		for (WebElement element : elements) {
			if (element.getText().contains(selectScheme)) {
				element.click();
				break;
			}
		}
		Actions a = new Actions(driver);
		a.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(1000);
		driver.findElement(submitButton).click();
	}

	public void clickSwitchFlexSTP() {
		driver.findElement(clickOnSwitch).click();
		driver.findElement(clickOnFlexSTPStart).click();
	}

	public void clickSwitchBoosterSTP() {
		driver.findElement(clickOnSwitch).click();
		driver.findElement(clickOnBoosterSTPStart).click();
	}

	public void clickOthersRollover() {
		driver.findElement(clickOnOthers).click();
		driver.findElement(clickOnRolloverStart).click();
	}

	public void clickOthersTriggerOnMaturity() {
		driver.findElement(clickOnOthers).click();
		driver.findElement(clickOnTriggerOnMaturityStart).click();
	}

	@SneakyThrows
	public void fillTriggerOnMaturity(String fund, String selectFundCategory, String selectFund, String selectScheme)
			throws InterruptedException {
		Thread.sleep(1000);
		elements = driver.findElements(selectFundToRedeem2);
		for (WebElement element : elements) {
			if (element.isEnabled()) {
				Thread.sleep(1000);
				element.click();
				break;
			}
		}
		Thread.sleep(1000);
		driver.findElement(allCategoriesDropDown4).click();
		elements = driver.findElements(allCategoriesValue4);
		for (WebElement element : elements) {
			if (element.getText().contains(selectFundCategory)) {
				element.click();
				break;
			}
		}
		Thread.sleep(1000);
		driver.findElement(selectFundDropDown4).click();
		elements = driver.findElements(allFundsValue4);
		for (WebElement element : elements) {
			if (element.getText().contains(selectFund)) {
				element.click();
				break;
			}
		}
		Thread.sleep(1000);
		// driver.findElement(selectSchemeOptionDropDown4).click();
		elements = driver.findElements(allSchemeValue4);
		for (WebElement element : elements) {
			if (element.getText().contains(selectScheme)) {
				element.click();
				break;
			}
		}
	}

	@SneakyThrows
	public void clickOthersCloseEndedSchemeRedeem() throws InterruptedException {
		driver.findElement(clickOnOthers).click();
		driver.findElement(clickOnCloseEndedSchemeRedeemStart).click();
		Thread.sleep(4000);
	}

	public void clickOthersCloseEndedSchemeSwitch() {
		driver.findElement(clickOnOthers).click();
		driver.findElement(clickOnCloseEndedSchemeSwitchStart).click();

	}

	@SneakyThrows
	public void fillCloseEndedSchemeSwitch(String fund, String selectFundCategory, String selectFund,
			String selectScheme, String amount) throws InterruptedException {
		Thread.sleep(5000);
		elements = driver.findElements(selectFundToRedeem2);
		for (WebElement element : elements) {
			if (element.isEnabled()) {
				Thread.sleep(1000);
				element.click();
				break;
			}
		}
		Thread.sleep(1000);
		driver.findElement(allCategoriesDropDown4).click();
		elements = driver.findElements(allCategoriesValue4);
		for (WebElement element : elements) {
			if (element.getText().contains(selectFundCategory)) {
				element.click();
				break;
			}
		}
		Thread.sleep(1000);
		driver.findElement(selectFundDropDown4).click();
		elements = driver.findElements(allFundsValue4);
		for (WebElement element : elements) {
			if (element.getText().contains(selectFund)) {
				element.click();
				break;
			}
		}
		Thread.sleep(1000);
		// driver.findElement(selectSchemeOptionDropDown4).click();
		elements = driver.findElements(allSchemeValue4);
		for (WebElement element : elements) {
			if (element.getText().contains(selectScheme)) {
				element.click();
				break;
			}
		}

		driver.findElement(switchUnits).click();
		driver.findElement(switchUnits).sendKeys(amount);

	}

	public void tncAndSendToInvestor() {
		driver.findElement(clickTermsAndCondition).click();
		driver.findElement(sendToInvestor).click();
	}

}
