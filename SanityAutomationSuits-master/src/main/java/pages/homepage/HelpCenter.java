package pages.homepage;

import com.utility.BrowserWaits;
import com.utility.JScriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class HelpCenter extends Learn {

	private final WebDriver driver;
	private final By customerCare = By.xpath("//button[text()='Customer Care']");
	private final By advisor = By.xpath("//span[text()='ADVISOR']");
	private final By investorBSNL = By.xpath("//span[text()='INVESTOR (BSNL/MTNL)']");
	private final By investorOther = By.xpath("//span[text()='INVESTOR (OTHER SERVICE PROVIDERS)']");
	private final By ourOffices = By.xpath("//button[text()='Our Offices']");
	private final By corporateOffice = By.xpath("//span[text()='CORPORATE OFFICE']");
	private final By centralServiceOffice = By.xpath("//span[text()='CENTRAL SERVICE OFFICE']");
	private final By registeredOffices = By.xpath("//span[text()='REGISTERED OFFICE']");
	private final By escalations = By.xpath("//button[text()='Escalations']");
	private final By headCompliance = By.xpath("//span[text()='HEAD - COMPLIANCE']");
	private final By investorRelatedQueries = By
			.xpath("//span[text()='INVESTOR SERVICE OFFICER (INVESTOR RELATED QUERIES / GRIEVANCES)']");
	private final By boardLine = By.xpath("//span[text()='BOARD LINE']");
	private final By email = By.xpath("//span[text()='EMAIL']");
	private final By corporateInformation = By.xpath("//button[text()='Corporate Information']");
	private final By entity1 = By.xpath("(//span[text()='ENTITY'])[1]");
	private final By entity2 = By.xpath("(//span[text()='ENTITY'])[2]");
	private final By cin1 = By.xpath("(//span[text()='CIN'])[1]");
	private final By cin2 = By.xpath("(//span[text()='CIN'])[2]");
	private final By preLogin = By.xpath("//span[text()='PRE LOGIN']");
	private final By postLogin = By.xpath("//span[text()='POST LOGIN']");
	private final By thirdParty = By.xpath("//span[text()='THIRD PARTY']");
	private final By branchLocator = By.xpath("//p[text()='Branch Locator']");
	private final By branchLocatorTextCheck = By.xpath("//div/h3[text()='Branch Locator']");
	private final By calculators = By.xpath("//p[text()='Calculators']");
	private final By planYourLife = By.xpath("//div/h3[text()='What goal are your trying to set?']");
	private final By existingCustomer = By.xpath("(//input[@type='checkbox'])[1]");
	private final By fullName = By.xpath("//div/input[@name='fullName']");
	private final By enterEmail = By.xpath("//div/input[@name='emailObj.email']");
	private final By contactNumberMob = By.xpath("//div/input[@name='mobile.mobileNumber']");
	private final By cityState = By.xpath(
			"(//input[@class='MuiInputBase-input MuiInput-input MuiInputBase-inputSizeSmall MuiInputBase-inputAdornedEnd MuiAutocomplete-input MuiAutocomplete-inputFocused css-2duac4'])[1]");
	private final By selectCityState = By.xpath("//li[normalize-space()='Bhubaneshwar, Orissa']");
	private final By feedback = By.xpath("//li[normalize-space()='Feedback']");
	private final By reasonForContact = By.xpath(
			"(//div[@class='MuiSelect-select MuiSelect-standard MuiInputBase-input MuiInput-input css-1cccqvr'])[2]");
	private final By subject = By.xpath("//div[@aria-labelledby='subject-type']");
	private final By transaction = By.xpath("//li[normalize-space()='Transaction']");
	private final By yourMessage = By.xpath("//textarea[@name='messageText']");
	private final By termConditions = By.xpath("(//input[@type='checkbox'])[2]");
	private final By sendOTP = By.xpath("//*[text()='SEND OTP']");
	private static final String OTP_VALUE = "//*[@class='input'][";
	private final By submit = By.xpath("//button[text()='SUBMIT']");
	private final By verified1 = By.xpath("(//img[@alt='Otp Verified'])[1]");
	private final By verified2 = By.xpath("(//img[@alt='Otp Verified'])[2]");
	private final By requestSubmitted = By.xpath("//p[text()='Your request has been successfully submitted']");
	private final By downloads = By.xpath("//p[text()='Downloads']");
	private final By verifiedDownloads = By.xpath("//h3[text()='Downloads']");
	private final By forms = By.xpath("//button[text()='FORMS']");
	private final By sidKimSai = By.xpath("//button[text()='SID KIM SAI']");
	private final By others = By.xpath("//button[text()='Others']");
	private final By applicationForms = By.xpath("//span[text()='Application Forms']");
	private final By systematicInvestmentsForms = By.xpath("//span[text()='Systematic Investments Forms']");
	private final By nonFinancialTransactionsForms = By.xpath("//span[text()='Non-Financial Transactions Forms']");
	private final By apply = By.xpath("//button[text()='APPLY']");
	private final By kim = By.xpath("//span[text()='Key Information Memorandum(KIM)']");
	private final By sai = By.xpath("//span[text()='Statement Of Additional Information(SAI)']");
	private final By sid = By.xpath("//span[text()='Scheme Information Document(SID)']");
	private final By othersDisplayed = By.xpath("//h3[text()='Others (4)']");
	private final By ourFunds = By.xpath("//p[text()='Our Funds']");
	private final By ourFundsContents = By.xpath("//h3[text()='Our Funds']");
	private final By knowledgeCenter = By.xpath("//p[text()='Knowledge Center']");
	private final By knowledgeCenterContents = By.xpath("//h2[text()='Knowledge Center']");
	private final By investorServices = By.xpath("//p[text()='Investor Services']");
	private final By investorServicesContents = By.xpath("//h3[text()='Investor Services']");
	private final By consultExpertText = By.xpath("//h4[text()='Consult our Experts']");
	private final By mobileNumber = By.xpath("//input[@name='phone-number']");
	private final By cityStateExpert = By.xpath(
			"(//input[@class='MuiInputBase-input MuiInput-input MuiInputBase-inputSizeSmall MuiInputBase-inputAdornedEnd MuiAutocomplete-input MuiAutocomplete-inputFocused css-2duac4'])[2]");
	private final By citySelect = By.xpath("//li[normalize-space()='Bhubaneshwar, Orissa']");
	private final By askExpert = By.xpath("//button[text()='ASK EXPERT']");
	private final By explore = By.xpath("//span[text()='Explore']");
	private final By investorServiceText = By.xpath("//h3[text()='Investor Services']");

	public HelpCenter(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void clickSendOTP() {
		JScriptExecutor.click(driver, sendOTP);
	}

	public boolean sendOtpDisplayed() {
		BrowserWaits.explicitWaitElementVisible(driver, sendOTP);
		return driver.findElement(sendOTP).isDisplayed();
	}

	public void setOTP() {
		for (int i = 1; i <= 6; i++) {
			driver.findElement(By.xpath(OTP_VALUE + i + "]")).sendKeys(String.valueOf(i));
		}
	}

	public boolean isOtpVerifiedOne() {
		BrowserWaits.explicitWaitElementVisible(driver, verified1);
		return driver.findElement(verified1).isDisplayed();
	}

	public boolean isOtpVerifiedTwo() {
		BrowserWaits.explicitWaitElementVisible(driver, verified2);
		return driver.findElement(verified2).isDisplayed();
	}

	public void clickOnOurFunds() {
		driver.findElement(ourFunds).click();
	}

	public Boolean isOurFundsButtonContentsDisplayed() {
		BrowserWaits.explicitWaitElementVisible(driver, ourFundsContents);
		return driver.findElement(ourFundsContents).isDisplayed();
	}

	public void clickOnInvestorServices() {
		driver.findElement(investorServices).click();
	}

	public Boolean isInvestorServicesButtonContentsDisplayed() {
		BrowserWaits.explicitWaitElementVisible(driver, investorServicesContents);
		return driver.findElement(investorServicesContents).isDisplayed();
	}

	public void clickOnKnowledgeCenter() {
		driver.findElement(knowledgeCenter).click();
	}

	public Boolean isKnowledgeCenterButtonContentsDisplayed() {
		BrowserWaits.explicitWaitElementVisible(driver, knowledgeCenterContents);
		return driver.findElement(knowledgeCenterContents).isDisplayed();
	}

	public void clickOnForms() {
		driver.findElement(forms).click();
	}

	public Boolean clickOnSidKimSaiSubtype() {
		boolean counter = true;
		try {
			driver.findElement(kim).isDisplayed();
			driver.findElement(sid).isDisplayed();
			driver.findElement(sai).isDisplayed();
		} catch (NoSuchElementException e) {
			counter = false;
		}
		return counter;
	}

	public Boolean isApplyButtonDisplayed() {
		BrowserWaits.explicitWaitClickable(driver, apply);
		return driver.findElement(apply).isDisplayed();
	}

	public void clickOnSidKimSai() {
		driver.findElement(sidKimSai).click();
	}

	public void clickOnOthers() {
		driver.findElement(others).click();
	}

	public Boolean isOthersButtonDisplayed() {
		BrowserWaits.explicitWaitElementVisible(driver, othersDisplayed);
		return driver.findElement(othersDisplayed).isDisplayed();
	}

	public void clickOnFormsSubtype() {
		driver.findElement(applicationForms).click();
		driver.findElement(systematicInvestmentsForms).click();
		driver.findElement(nonFinancialTransactionsForms).click();
	}

	public void clickOnCustomerCare() {
		driver.findElement(customerCare).click();
	}

	public void clickOnOurOffices() {
		driver.findElement(ourOffices).click();
	}

	public void clickOnEscalations() {
		driver.findElement(escalations).click();
	}

	public void clickOnCorporateInformation() {
		driver.findElement(corporateInformation).click();
	}

	public void clickOnBranchLocator() {
		driver.findElement(branchLocator).click();
	}

	public void clickOnDownloads() {
		driver.findElement(downloads).click();
	}

	public Boolean isDownloadsButtonDisplayed() {
		BrowserWaits.explicitWaitElementVisible(driver, verifiedDownloads);
		return driver.findElement(verifiedDownloads).isDisplayed();
	}

	public void clickOnExistingCustomer() {
		driver.findElement(existingCustomer).click();
	}

	public void clickOnCityState() {
		driver.findElement(cityState).click();
		BrowserWaits.explicitWaitElementVisible(driver, selectCityState);
		driver.findElement(selectCityState).click();
	}

	public void clickOnReasonForContact() {
		driver.findElement(reasonForContact).click();
		BrowserWaits.explicitWaitElementVisible(driver, feedback);
		driver.findElement(feedback).click();
	}

	public void clickOnSubject() {
		driver.findElement(subject).click();
		BrowserWaits.explicitWaitElementVisible(driver, transaction);
		driver.findElement(transaction).click();
	}

	public void clickOnTermsCondition() {
		driver.findElement(termConditions).click();
	}

	public void clicksOnSubmit() {
		JScriptExecutor.click(driver, submit);
	}

	public void enteredHisMessage(String hisMessage) {
		JScriptExecutor.click(driver, yourMessage);
		driver.findElement(yourMessage).sendKeys(hisMessage);
	}

	public void enteredHisFullName(String hisFullName) {
		JScriptExecutor.click(driver, fullName);
		driver.findElement(fullName).sendKeys(hisFullName);
	}

	public void enteredHisEmailID(String email) {
		JScriptExecutor.click(driver, enterEmail);
		driver.findElement(enterEmail).sendKeys(email);
	}

	public void enteredHisContactNumber(String contactNumber) {
		JScriptExecutor.click(driver, contactNumberMob);
		driver.findElement(contactNumberMob).sendKeys(contactNumber);
	}

	public void clickOnCalculators() {
		driver.findElement(calculators).click();
	}

	public Boolean areDetailsOfCustomerCareButtonDisplayed() {
		BrowserWaits.explicitWaitElementVisible(driver, advisor);
		BrowserWaits.explicitWaitElementVisible(driver, investorBSNL);
		BrowserWaits.explicitWaitElementVisible(driver, investorOther);
		return driver.findElement(advisor).isDisplayed();
	}

	public Boolean areDetailsOfOurOfficesButtonDisplayed() {
		BrowserWaits.explicitWaitElementVisible(driver, corporateOffice);
		BrowserWaits.explicitWaitElementVisible(driver, centralServiceOffice);
		BrowserWaits.explicitWaitElementVisible(driver, registeredOffices);
		return driver.findElement(registeredOffices).isDisplayed();
	}

	public Boolean areDetailsOfEscalationsButtonDisplayed() {
		BrowserWaits.explicitWaitElementVisible(driver, headCompliance);
		BrowserWaits.explicitWaitElementVisible(driver, investorRelatedQueries);
		BrowserWaits.explicitWaitElementVisible(driver, boardLine);
		BrowserWaits.explicitWaitElementVisible(driver, email);
		return driver.findElement(email).isDisplayed();
	}

	public Boolean areDetailsOfCorporateInformationButtonDisplayed() {
		BrowserWaits.explicitWaitElementVisible(driver, entity1);
		BrowserWaits.explicitWaitElementVisible(driver, entity2);
		BrowserWaits.explicitWaitElementVisible(driver, cin1);
		BrowserWaits.explicitWaitElementVisible(driver, cin2);
		return driver.findElement(cin2).isDisplayed();
	}

	public Boolean isPreLoginCardDisplayed() {
		BrowserWaits.explicitWaitElementVisible(driver, preLogin);
		return driver.findElement(preLogin).isDisplayed();
	}

	public Boolean isPostLoginCardDisplayed() {
		BrowserWaits.explicitWaitElementVisible(driver, postLogin);
		return driver.findElement(postLogin).isDisplayed();
	}

	public Boolean isThirdPartyCardDisplayed() {
		BrowserWaits.explicitWaitElementVisible(driver, thirdParty);
		return driver.findElement(thirdParty).isDisplayed();
	}

	public Boolean isBranchLocatorButtonDisplayed() {
		BrowserWaits.explicitWaitElementVisible(driver, branchLocatorTextCheck);
		return driver.findElement(branchLocatorTextCheck).isDisplayed();
	}

	public Boolean isCalculatorsButtonDisplayed() {
		BrowserWaits.explicitWaitElementVisible(driver, planYourLife);
		return driver.findElement(planYourLife).isDisplayed();
	}

	public Boolean isRequestSubmitted() {
		BrowserWaits.explicitWaitElementVisible(driver, requestSubmitted);
		return driver.findElement(requestSubmitted).isDisplayed();
	}

	public void clickOnAskExpert(String mobileNum) {
		BrowserWaits.explicitWaitElementVisible(driver, consultExpertText);
		JScriptExecutor.click(driver, mobileNumber);
		driver.findElement(mobileNumber).sendKeys(mobileNum);
		driver.findElement(cityStateExpert).click();
		BrowserWaits.explicitWaitElementVisible(driver, citySelect);
		driver.findElement(citySelect).click();
		driver.findElement(askExpert).click();
	}

	public void clickOnExplore() {

		driver.findElement(explore).click();
	}

	public Boolean isExploreButtonDisplayed() {
		BrowserWaits.explicitWaitClickable(driver, investorServiceText);
		return driver.findElement(investorServiceText).isDisplayed();
	}
}
