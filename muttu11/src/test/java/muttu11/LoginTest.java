package muttu11;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import dataDriver.GetData;
import pages.LoginPage;

public class LoginTest extends BaseClass {
	ITestResult result;

	@Test(dataProvider="data", dataProviderClass=GetData.class)
	public void test1(String name, String pass) {

		System.out.println(driver.getTitle());

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

		loginPage.login(name, pass);

		Assert.assertEquals(driver.getTitle(), "Facebook");

		loginPage.logout(driver);
		

	}

}
