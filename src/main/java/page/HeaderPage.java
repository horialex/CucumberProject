package page;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderPage extends AbstractPage {
	
	public HeaderPage() {
		super();
	}

	@FindBy(css = "ul[class='nav navbar-nav views']")
	WebElement tabContainer;

	public void selectHeader(String header) {
		List<WebElement> headersList = tabContainer.findElements(By.cssSelector("li a"));
		WebElement headerElement = headersList.stream().filter(element -> element.getText().contentEquals(header))
				.findAny().orElse(null);
		waitForElementToBeClickable(headerElement);
		Assert.assertTrue("The element has not been found", headerElement != null);
		headerElement.click();
	}

}
