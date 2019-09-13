package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {
	
	public LoginPage() {
		super();
	}

    @FindBy(css = "input#email")
    WebElement email;
    
    @FindBy(css = "input#pass")
    WebElement password;
    
    @FindBy(css = "input[class*='signin']")
    WebElement signIn;

    public void enterEmail(String email){
        this.email.sendKeys(email);
    }

    public void enterPassword(String password){
        this.password.sendKeys(password);
    }

    public void submit(){
        this.signIn.click();
    }
}
