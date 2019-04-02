package muttu11;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import dataDriver.GetData;
import pages.LoginPage;

public class LoginTest extends BaseClass {

	private Logger logger = LogManager.getLogger(LoginTest.class);

	ITestResult result;

	@Test(dataProvider = "data", dataProviderClass = GetData.class)
	public void test1(String name, String pass) {

		logger.info(driver.getTitle());

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

		loginPage.login(name, pass);

		Assert.assertEquals(driver.getTitle(), "Facebook");

		loginPage.logout(driver);

	}

}
