package stepdefinitions;

import org.junit.Assert;

import config.TestContext;
import io.cucumber.java.en.Given;
import models.User;

public class StepDefinitionsB {

	private TestContext context;

	public StepDefinitionsB(TestContext context) {
		this.context = context;
	}

	
	@Given("^Step definition C$")
	public void stepC() throws InterruptedException {
		Thread.sleep(100);
		User user = context.get("user");
		user.setAge(30);
		
	}
	
	
	@Given("^Step definition D$")
	public void stepD() throws InterruptedException {
		Thread.sleep(500);
		System.out.println("Step C");
		User expectedUser = context.get("user");
		System.out.println(expectedUser.toString());
		Assert.assertTrue("The age is not correct", expectedUser.getAge() == 30);
		Assert.assertTrue("The name is not correct", expectedUser.getName().contentEquals("Hori"));
	}

}
