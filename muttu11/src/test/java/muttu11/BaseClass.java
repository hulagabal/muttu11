package muttu11;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import helpers.BrowserFactory;

public class BaseClass {

	WebDriver driver;

	@BeforeClass
	public void openBrowser() {
		
		BrowserFactory browserFactory=new BrowserFactory();
		driver = BrowserFactory.getBrowser(browserFactory.getBrowser());

		driver.get("https://www.facebook.com/");

	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
