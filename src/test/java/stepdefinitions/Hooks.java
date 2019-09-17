package stepdefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.google.inject.Inject;

import config.DriverManager;
import injector.AppInjector;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	
	public Hooks() {
		AppInjector.getInjector().injectMembers(this);
	}
	
	@Inject
	DriverManager driverManager;

	@Before
	public void setup() throws Exception {
		driverManager.initDriver();
	}

	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			try {
				final byte[] screenshot = ((TakesScreenshot) driverManager.getWebDriver())
						.getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
				scenario.write("Scenario failed");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				scenario.embed(((TakesScreenshot) driverManager.getWebDriver()).getScreenshotAs(OutputType.BYTES),
						"image/png");
				scenario.write("Scenario passed");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		driverManager.closeDriver();
	}

}
