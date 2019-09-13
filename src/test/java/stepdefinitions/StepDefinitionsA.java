package stepdefinitions;

import org.junit.Assert;

import com.google.inject.Inject;

import api.ApiCategoryService;
import api.ApiItemService;
import api.ApiLoginService;
import constants.EnvironmentConstants;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import injector.AppInjector;
import page.HeaderPage;
import page.HomePage;
import page.LoginPage;
import service.BookingService;

public class StepDefinitionsA {

	@Inject
	private ApiLoginService apiLoginService;
	@Inject
	private ApiItemService apiItemService;
	@Inject
	private ApiCategoryService apiCategoryService;
	@Inject
	private HomePage homePage;
	@Inject
	private LoginPage loginPage;
	@Inject 
	private HeaderPage headerPage;
	@Inject
	private BookingService bookingService;
	
	public StepDefinitionsA() {
		AppInjector.getInjector().injectMembers(this);
	}

	@Given("^I login as an admin using api call$")
	public void loginAsAdmin() throws Exception {
		apiLoginService.loginAsAdmin();
	}
	
	@Given("I create a category using api call")
	public void createCategoryApi() {
		apiCategoryService.createCategory();
	}
	
	
	@Given("I create an item inside the category using api call")
	public void createItemInCategory() {
		apiItemService.createItem();
	}
	
	@Given("^I open home page$")
	public void openHomePage() {
		homePage.navigateToHomePage();
	}
	
	@Then("^I fail the scenario$")
	public void fail() {
		Assert.fail("Test failed!");
	}
	
	@Then("^I pass the scenario$")
	public void pass() {
		Assert.assertTrue(true);
	}
	
	@Given("^I login as an admin user$")
	public void login() {
		homePage.clickLogin();
		loginPage.enterEmail(EnvironmentConstants.USER);
		loginPage.enterPassword(EnvironmentConstants.PASS);
		loginPage.submit();
	}
	
	@Given("^I select option (.*) from header menu$")
	public void selectHeaderMenu(String option) {
		headerPage.selectHeader(option);
	}
	
	@When("I book the items from last category")
	public void bookItemsFromLastCategory() {
		bookingService.bookItemFromLastCategory();
	}
	
	@Then("^I validate the booked items$")
	public void validateBookedItems() {
		bookingService.goToMyBookings();
		bookingService.validateBookedItems();
	}
	
}
