package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import constants.EnvironmentConstants;

public class HomePage extends AbstractPage {
	
	public HomePage() {
		super();
	}
	
    @FindBy(css = ".sign-in-a")
    WebElement loginButton;

    
    public void clickLogin(){
        loginButton.click();
    }
    
    public void navigateToHomePage(){
        getDriver().get(EnvironmentConstants.BASE_URL);
    }
    
}
