package stepdefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import config.DriverManager;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

	@Before
	public void setup() throws Exception {
		// System.setProperty("http.proxyHost", "localhost");
		// System.setProperty("http.proxyPort", "8081");
		// System.setProperty("https.proxyHost", "localhost");
		// System.setProperty("https.proxyPort", "8081");
		// System.setProperty("isSecondSupplier", "true");
		System.out.println("Thread ID " + Thread.currentThread().getId());
		DriverManager.initDriver();

	}

	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			try {
				final byte[] screenshot = ((TakesScreenshot) DriverManager.getWebDriver())
						.getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
				scenario.write("Scenario failed");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				scenario.embed(((TakesScreenshot) DriverManager.getWebDriver()).getScreenshotAs(OutputType.BYTES),
						"image/png");
				scenario.write("Scenario passed");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		DriverManager.closeDriver();
	}

}
