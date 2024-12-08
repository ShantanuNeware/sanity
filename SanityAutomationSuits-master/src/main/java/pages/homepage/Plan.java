package pages.homepage;

import com.utility.BrowserWaits;
import com.utility.JScriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Plan {
	private final WebDriver driver;

	private final By planTab = By.xpath("//a[text()='Tools']");
	private final By goalPlanner = By
			.xpath("//span[contains(@class, 'MuiTypography-root MuiTypography-body3 Bold button-text css-13jaz8d')]");
	private final By basicCalculator = By.xpath("//*[text()='Returns Calculator']/parent::div/button");

	private final By yourGoal = By.xpath("//div/h6[text()='1. What’s your name?']");

	private final By closeIcon = By.xpath("//img[@class='close-icon']");

	private final By enterName = By.cssSelector("input[id='full-name']");

	private final By annualIncome = By.xpath("//input[@id='annual-income']");

	private final By goalCost = By.xpath("//input[@id='target-amount']");

	private final By enterAge = By.xpath("//input[@id='age']");

	private final By targetAge = By.xpath("//input[@id='target-age']");

	private final By savedAmount = By.xpath("//input[@id='saved-amount']");

	private final By highRisk = By.xpath("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[3]");

	private final By back = By.xpath("//*[contains(text(),'BACK')]");
	private final By done = By.xpath("//div/button[text()='DONE']");
	private final By continueButton = By.xpath("//button[text()='CONTINUE']");

	private final By continueCalculate = By.xpath("//button[text()='Continue']");

	private final By advancedCalculator = By.xpath("//*[text()='Investment Simulator']/parent::div/button");
	private final By calculate = By.xpath(
			"(//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeLarge MuiButton-containedSizeLarge MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeLarge MuiButton-containedSizeLarge pb-2 css-110xwq5'])[1]");

	private final By firstThought = By.xpath("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[4]");

	private final By uncertainty = By.xpath("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[2]");

	private final By salariedEmployee = By.xpath("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[1]");

	private final By risk = By.xpath("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[1]");

	private final By performance = By.xpath("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[4]");

	private final By underPerformed = By.xpath("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[3]");

	private final By gender = By.xpath("//span[text()='Male']");

	private final By age = By.xpath("//span[@id='111_27']");

	private final By income = By.xpath("//span[@id='112_28']");

	private final By occupation = By.xpath("//span[@id='113_31']");

	private final By education = By.xpath("//span[@id='114_32']");

	private final By experienceInInvesting = By.xpath("//span[@id='117_36']");

	private final By duration = By.xpath("//span[@id='116_34']");

	private final By assetAllocator = By.xpath("//div/h6[text() = 'Asset Allocator']");

	private final By sipAllocation = By.xpath("//button[text() = 'SIP Allocation']");

	private final By fundAllocation = By.xpath("//button[text() = 'SHOW FUND ALLOCATION']");
	private final By customizeGoal = By.xpath("//button[text()='customize goal']");

	private final By bottomCalculate = By.xpath("//span[normalize-space()='calculate']");

	private final By elementCheck = By
			.xpath("//h6[@class = 'MuiTypography-root MuiTypography-h6 Bold mb-4 css-1anx036']");
	private final By home = By.xpath("(//div[@class='planner-card cursor-pointer'])[4]");

	private final By educationButton = By.xpath("//p[text()=\"Child's Education\"]");

	private final By marriage = By.xpath("(//div[@class='planner-card cursor-pointer'])[2]");

	private final By holiday = By.xpath("(//div[@class='planner-card cursor-pointer'])[3]");

	private final By wealthCreation = By.xpath("(//div[@class='planner-card cursor-pointer'])[5]");

	private final By retirement = By.xpath("(//div[@class='planner-card cursor-pointer'])[6]");

	private final By showFunds = By.xpath("//button[normalize-space()='Show Funds']");

	public Plan(WebDriver driver) {

		this.driver = driver;
	}

	public void clickOnGoalPlanner() {
		BrowserWaits.fluentWait(driver, goalPlanner);
		driver.findElement(goalPlanner).click();
		BrowserWaits.explicitWaitElementVisible(driver, yourGoal);
	}

	public void clickOnCloseIcon() {
		BrowserWaits.explicitWaitClickable(driver, closeIcon);
		JScriptExecutor.click(driver, closeIcon);
	}

	public void enterName(String fullName) {
		// driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		JScriptExecutor.click(driver, enterName);
		driver.findElement(enterName).sendKeys(fullName);
	}

	public void annualIncome(String income) {
		JScriptExecutor.click(driver, annualIncome);
		driver.findElement(annualIncome).sendKeys(income);
	}

	public void goalCost(String cost) {
		BrowserWaits.explicitWaitClickable(driver, goalCost);
		JScriptExecutor.click(driver, goalCost);
		driver.findElement(goalCost).sendKeys(cost);
	}

	public void enterAge(String hisAge) {
		JScriptExecutor.click(driver, enterAge);
		driver.findElement(enterAge).sendKeys(hisAge);
	}

	public void targetAge(String hisTargetAge) {
		JScriptExecutor.click(driver, targetAge);
		driver.findElement(targetAge).sendKeys(hisTargetAge);
	}

	public void savedAmount(String amountSaved) {
		JScriptExecutor.click(driver, savedAmount);
		driver.findElement(savedAmount).sendKeys(amountSaved);
	}

	public void highRisk() {
		JScriptExecutor.click(driver, highRisk);
	}

	public void done() {
		JScriptExecutor.click(driver, done);
	}

	public void clickOnContinue() {
		BrowserWaits.explicitWaitClickable(driver, continueButton);
		JScriptExecutor.click(driver, continueButton);
	}

	public void continueCalculate() {
		BrowserWaits.explicitWaitClickable(driver, continueCalculate);
		JScriptExecutor.click(driver, continueCalculate);
	}

	public void clickBasicCalculator() {
		BrowserWaits.explicitWaitClickable(driver, basicCalculator);
		driver.findElement(basicCalculator).click();
	}

	public void back() {
		driver.findElement(back).click();
		BrowserWaits.explicitWaitClickable(driver, planTab);
	}

	public void clickAdvancedCalculator() {
		BrowserWaits.explicitWaitClickable(driver, basicCalculator);
		driver.findElement(advancedCalculator).click();
	}

	public void clickCalculate() {
		BrowserWaits.explicitWaitClickable(driver, calculate);
		driver.findElement(calculate).click();
	}

	public void clickFirstThought() {
		BrowserWaits.fluentWait(driver, firstThought);
		driver.findElement(firstThought).click();
	}

	public void clickOnUncertainty() {
		BrowserWaits.fluentWait(driver, uncertainty);
		driver.findElement(uncertainty).click();
	}

	public void clickOnSalariedEmployee() {
		BrowserWaits.fluentWait(driver, salariedEmployee);
		driver.findElement(salariedEmployee).click();
	}

	public void clickOnRisk() {
		BrowserWaits.fluentWait(driver, risk);
		driver.findElement(risk).click();
	}

	public void clickOnPerformance() {
		BrowserWaits.fluentWait(driver, performance);
		driver.findElement(performance).click();
	}

	public void clickOnUnderPerformed() {
		BrowserWaits.fluentWait(driver, underPerformed);
		driver.findElement(underPerformed).click();
	}

	public void clickOnDemographicScore() {
		BrowserWaits.fluentWait(driver, gender);
		driver.findElement(gender).click();
		BrowserWaits.fluentWait(driver, age);
		driver.findElement(age).click();
		BrowserWaits.fluentWait(driver, income);
		driver.findElement(income).click();
		BrowserWaits.fluentWait(driver, occupation);
		driver.findElement(occupation).click();
		BrowserWaits.fluentWait(driver, education);
		driver.findElement(education).click();
		BrowserWaits.fluentWait(driver, experienceInInvesting);
		driver.findElement(experienceInInvesting).click();
		BrowserWaits.fluentWait(driver, duration);
		driver.findElement(duration).click();
	}

	public void clickOnAssetAllocation() {
		BrowserWaits.explicitWaitElementVisible(driver, assetAllocator);
		driver.findElement(fundAllocation).click();
		driver.findElement(sipAllocation).click();
	}

	public void clickCustomizeGoal() {
		BrowserWaits.explicitWaitElementVisible(driver, customizeGoal);
		JScriptExecutor.click(driver, customizeGoal);
	}

	public void clickHome() {
		BrowserWaits.explicitWaitClickable(driver, home);
		driver.findElement(home).click();
		BrowserWaits.explicitWaitElementVisible(driver, elementCheck);
	}

	public void clickOnEducation() throws InterruptedException {
		BrowserWaits.waitTillDocumentIsLoaded(driver);
		BrowserWaits.explicitWaitClickable(driver, educationButton);
		driver.findElement(educationButton).click();
		BrowserWaits.explicitWaitElementVisible(driver, elementCheck);
	}

	public void clickOnMarriage() {
		BrowserWaits.explicitWaitClickable(driver, marriage);
		driver.findElement(marriage).click();
		BrowserWaits.explicitWaitElementVisible(driver, elementCheck);

	}

	public void clickOnHoliday() {
		BrowserWaits.explicitWaitClickable(driver, holiday);
		driver.findElement(holiday).click();
		BrowserWaits.explicitWaitElementVisible(driver, elementCheck);
	}

	public void clickOnWealthCreation() {
		BrowserWaits.explicitWaitClickable(driver, wealthCreation);
		driver.findElement(wealthCreation).click();
		BrowserWaits.explicitWaitElementVisible(driver, elementCheck);
	}

	public void clickOnRetirement() {
		BrowserWaits.explicitWaitClickable(driver, retirement);
		driver.findElement(retirement).click();
		BrowserWaits.explicitWaitElementVisible(driver, elementCheck);
	}

	public void clickOnBottomCalculate() {
		driver.findElement(bottomCalculate).click();
	}

	public void clickOnShowFunds() {
		driver.findElement(showFunds).click();
	}

	public Boolean isGoalPlannerDisplayed() {
		BrowserWaits.explicitWaitClickable(driver, goalPlanner);
		return driver.findElement(goalPlanner).isDisplayed();
	}

	public Boolean isBasicCalculatorButtonDisplayed() {
		BrowserWaits.explicitWaitClickable(driver, basicCalculator);
		return driver.findElement(basicCalculator).isDisplayed();
	}

	public Boolean isAdvancedCalculatorButtonDisplayed() {
		BrowserWaits.explicitWaitClickable(driver, advancedCalculator);
		return driver.findElement(advancedCalculator).isDisplayed();
	}

	public Boolean isCalculateButtonDisplayed() {
		BrowserWaits.explicitWaitClickable(driver, calculate);
		return driver.findElement(calculate).isDisplayed();
	}

	public Boolean isCustomizedGoalButtonDisplayed() {
		BrowserWaits.explicitWaitClickable(driver, customizeGoal);
		return driver.findElement(customizeGoal).isDisplayed();
	}

	public Boolean isRiskAppetiteCalculatorButtonDisplayed() {
		BrowserWaits.explicitWaitClickable(driver, bottomCalculate);
		return driver.findElement(bottomCalculate).isDisplayed();
	}
}