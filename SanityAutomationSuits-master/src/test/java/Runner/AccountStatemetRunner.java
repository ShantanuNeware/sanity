package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

/**
 * Main TestRunner for the project
 */
@CucumberOptions(features = "Features",

		tags = "@Login_AccountStatement",

		glue = { "StepDefination", "ApplicationHooks" }, monochrome = true, plugin = { "pretty",
				"json:target/cucumber.json", "rerun:target/Spark/failed_scenarios.txt", "html:target/cucumber",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" })

public class AccountStatemetRunner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}
