package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

	@FindBy(how = How.NAME, using = "email")
	WebElement email;
	@FindBy(how = How.NAME, using = "pass")
	WebElement password;

	@FindBy(how = How.XPATH, using = "//input[@value='Log In']")
	WebElement login;

	@FindBy(how = How.XPATH, using = "//div[text()='Account Settings']")
	@CacheLookup
	WebElement accountSettings;

	@FindBy(how = How.LINK_TEXT, using = "Log Out")
	WebElement logout;

	public void login(String name, String pass) {
		email.sendKeys(name);
		password.sendKeys(pass);
		login.click();

	}

	public void logout(WebDriver driver) {
		
		accountSettings.click();
		logout.click();
		

	}
	

}
