package stepdefinitions;

import com.google.inject.Inject;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import injector.AppInjector;
import service.BookingService;

public class BookingStepDefinitions {

	@Inject
	private BookingService bookingService;

	public BookingStepDefinitions() {
		AppInjector.getInjector().injectMembers(this);
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
