package ApplicationHooks;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.driver.Factory;
import com.utility.CleanUpDB;
import com.utility.ConfigPropertyReader;
import com.utility.WriteToTextFile;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class AppHooks {
	private WebDriver driver;
	static Properties properties;

	public static String InvestorBaseUrl() {
		String[] s = properties.getProperty("Investor-URL").split("/");
		return s[2];
	}

	public static String DistributorBaseUrl() {
		String[] s = properties.getProperty("Distributor-URL").split("/");
		return s[2];
	}

	@Before(order = 0)
	public static void getProperty() {
		ConfigPropertyReader configPropertyReader = new ConfigPropertyReader();
		properties = configPropertyReader.propertyInitialization();
	}

	@Before(order = 1)
	public void browserLaunch() throws IOException {
		CleanUpDB.clean();
		WriteToTextFile.writeData("", "target/folioNo.txt", false);
		Factory driverFactory = new Factory();
		driver = driverFactory.driverInitilization(properties.getProperty("browser"),
				Integer.parseInt(properties.getProperty("width")), Integer.parseInt(properties.getProperty("height")));

	}

//    @After(order = 0)
//    public void closeBrowser()
//    {
//        driver.quit();
//    }

	@AfterStep(order = 0)
	public void AllScreenshot(Scenario scenario) throws IOException {

		String clipName = scenario.getName().replaceAll(" ", "_");
		Shutterbug.shootPage(driver, Capture.VIEWPORT).save("Images Folder");
		File file = new File("Images Folder");
		File mfile = file.listFiles()[0];
		BufferedImage bImage = ImageIO.read(mfile);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ImageIO.write(bImage, "png", bos);
		byte[] data = bos.toByteArray();
		scenario.attach(data, "image/png", clipName);
		mfile.delete();
		file.delete();
	}

	@After(order = 1)
	public void failedScreenshot(Scenario scenario) throws IOException {
		if (scenario.isFailed()) {
			String clipName = scenario.getName().replaceAll(" ", "_");
			Shutterbug.shootPage(driver, Capture.FULL_SCROLL).save("Images Folder");
			File file = new File("Images Folder");
			File mfile = file.listFiles()[0];
			BufferedImage bImage = ImageIO.read(mfile);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ImageIO.write(bImage, "png", bos);
			byte[] data = bos.toByteArray();
			scenario.attach(data, "image/png", clipName);
			mfile.delete();
			file.delete();
		}
	}
}
