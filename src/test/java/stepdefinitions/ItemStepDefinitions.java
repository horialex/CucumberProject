package stepdefinitions;

import com.google.inject.Inject;

import api.ApiItemService;
import cucumber.api.java.en.Given;
import injector.AppInjector;

public class ItemStepDefinitions {

	
	@Inject
	private ApiItemService apiItemService;
	
	public ItemStepDefinitions() {
		AppInjector.getInjector().injectMembers(this);
	}
	
	
	@Given("I create an item inside the category using api call")
	public void createItemInCategory() {
		apiItemService.createItem();
	}
}
