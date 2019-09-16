package stepdefinitions;

import com.google.inject.Inject;

import api.ApiLoginService;
import constants.EnvironmentConstants;
import cucumber.api.java.en.Given;
import injector.AppInjector;
import page.HeaderPage;
import page.HomePage;
import page.LoginPage;

public class LoginStepDefinitions {
	
	@Inject
	private ApiLoginService apiLoginService;
	@Inject
	private HomePage homePage;
	@Inject
	private LoginPage loginPage;
	@Inject 
	private HeaderPage headerPage;
	
	public LoginStepDefinitions() {
		AppInjector.getInjector().injectMembers(this);
	}
	
	@Given("^I open home page$")
	public void openHomePage() {
		homePage.navigateToHomePage();
	}

	@Given("^I login as an admin using api call$")
	public void loginAsAdmin() throws Exception {
		apiLoginService.loginAsAdmin();
	}
	
	@Given("^I login as an admin user$")
	public void login() {
		homePage.clickLogin();
		loginPage.enterEmail(EnvironmentConstants.USER);
		loginPage.enterPassword(EnvironmentConstants.PASS);
		loginPage.submit();
	}
	

}
