package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import config.TestContext;
import io.cucumber.java.en.Given;
import models.User;

public class StepDefinitionsA {

	private TestContext context;

	public StepDefinitionsA(TestContext context) {
		this.context = context;
	}

	@Given("^Login$")
	public void stepA() throws InterruptedException {
		System.out.println("Thread ID " + Thread.currentThread().getId());
		WebDriver driver = new ChromeDriver();
		driver.get("https://altex.ro/");
		driver.manage().window().maximize();

		User user = new User();
		user.setName("Hori");
		user.setAge(28);
		context.set("user", user);
	}

	@Given("^Step definition B$")
	public void stepB() throws InterruptedException {
		System.out.println("Step B");
		Thread.sleep(3000);
		User expectedUser = context.get("user");
		System.out.println(expectedUser.toString());
		Assert.assertTrue("The age is not correct", expectedUser.getAge() == 28);
		Assert.assertTrue("The name is not correct", expectedUser.getName().contentEquals("Hori"));
	}

}
