package stepdefinitions;

import com.google.inject.Inject;

import cucumber.api.java.en.Given;
import injector.AppInjector;
import page.HeaderPage;
import page.HomePage;

public class GeneralStepDefinitions {

	@Inject
	private HomePage homePage;
	@Inject
	private HeaderPage headerPage;

	public GeneralStepDefinitions() {
		AppInjector.getInjector().injectMembers(this);
	}

	@Given("^I open home page$")
	public void openHomePage() {
		homePage.navigateToHomePage();
	}

	@Given("^I select option (.*) from header menu$")
	public void selectHeaderMenu(String option) {
		headerPage.selectHeader(option);
	}

}
