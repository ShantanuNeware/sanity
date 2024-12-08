package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

/**
 * Main TestRunner for the project
 */
@CucumberOptions(features = "Features",

		tags = "@Transactions-LUMPSUM_with_UPI or @Transactions-SIP or @Transactions-REDEEM or @Transactions-SWITCH",

		glue = { "StepDefination", "ApplicationHooks" }, monochrome = true, plugin = { "pretty",
				"json:target/cucumber.json", "rerun:target/Spark/failed_scenarios.txt", "html:target/cucumber",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" })

public class SanityRunner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}
