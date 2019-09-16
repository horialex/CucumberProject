package stepdefinitions;

import com.google.inject.Inject;

import api.ApiCategoryService;
import cucumber.api.java.en.Given;
import injector.AppInjector;

public class CategoryStepDefinitions {
	
	@Inject
	private ApiCategoryService apiCategoryService;
	
	
	public CategoryStepDefinitions() {
		AppInjector.getInjector().injectMembers(this);
	}
	
	@Given("I create a category using api call")
	public void createCategoryApi() {
		apiCategoryService.createCategory();
	}

}
