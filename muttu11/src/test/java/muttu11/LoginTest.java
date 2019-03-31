package muttu11;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginTest extends BaseClass {
	ITestResult result;

	@Test
	public void test1() {

		System.out.println(driver.getTitle());

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

		loginPage.login();

		Assert.assertEquals(driver.getTitle(), "Facebook");

		loginPage.logout(driver);
		

	}

}
