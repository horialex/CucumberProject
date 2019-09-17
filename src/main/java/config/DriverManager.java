package config;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.google.inject.Singleton;

import constants.EnvironmentConstants;
import constants.SetupConstants;

@Singleton
public class DriverManager {


	protected ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	
	private String browser = System.getProperty("browser");
	private String host = EnvironmentConstants.BASE_URL;

	public void initDriver() throws Exception {

		System.out.println("Opening browser [" + browser.toUpperCase() + "]...");

		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", SetupConstants.FIREFOX_DRIVER_PATH);
			//driver = new FirefoxDriver();
			driver.set(new FirefoxDriver());
		} else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", SetupConstants.CHROME_DRIVER_PATH);
			//driver = new ChromeDriver();
			driver.set(new ChromeDriver());

		} else {
			throw new Exception("Unsupported browser type, we don't use IE! or other browser");
		}
		driver.get().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get().manage().window().maximize();
		System.out.println("Oppening URL [" + host + "] ");
		getDriver().get(host);

		System.out.println(
				"\n\n\n==========================================================================================="
						+ "\n ============================= TEST STARTED ==============================\n");

	}

	public WebDriver getDriver() {
		return driver.get();
	}

	public void closeDriver() {
		System.out.println(
				"\n\n\n==========================================================================================="
						+ "\n ============================= TEST ENDED - Closing browser ==============================\n");
		getDriver().close();
		getDriver().quit();
	}

	public void clearCookies() {
		Set<Cookie> cookies = getDriver().manage().getCookies();
		for (Cookie cookie : cookies) {
			getDriver().manage().deleteCookie(cookie);
		}
	}

}
