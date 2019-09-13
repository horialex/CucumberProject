package page;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CategoriesPage extends AbstractPage {
	public CategoriesPage() {
		super();
	}
//	@FindBy(css = "ul#categories_container")
//	WebElement categoriesContainer;
//	@FindBy(css = "input#title")
//	WebElement searchBar;
//	@FindBy(css = "div[class*='list-container']")
//	WebElement cont;
	
	By categoriesContainerElement = By.cssSelector("ul#categories_container");
	By searchBar = By.cssSelector("input#title");
	By cont = By.cssSelector("div[class*='list-container']");
	

	public void selectCategory(String categoryName) {
		WebElement selectedCategory = getCategory(categoryName);
		WebElement category = selectedCategory.findElement(By.cssSelector("h3 a"));
		
		//category.sendKeys("");
		category.click();
		//category.sendKeys(Keys.ENTER);
		System.out.println("XXX");
	}

	public WebElement getCategory(String categoryName) {
		WebElement categoriesContainer = getDriver().findElement(categoriesContainerElement);
		List<WebElement> categoryList = categoriesContainer.findElements(By.cssSelector("div[class*='categoryDetails']"));
		System.out.println("Categories list  size " + categoryList.size());
		
		WebElement searchedCategory = categoryList.stream()
				.filter(element -> element.findElement(By.cssSelector("h3 a")).getText().contentEquals(categoryName))
				.findFirst().orElse(null);
		Assert.assertTrue("The element has not been found", searchedCategory != null);
		return searchedCategory;
	}

	public void searchItem(String itemName) {
		getDriver().findElement(searchBar).clear();
		getDriver().findElement(searchBar).sendKeys(itemName);
	}

}
