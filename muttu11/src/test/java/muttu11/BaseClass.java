package muttu11;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import helpers.BrowserFactory;

public class BaseClass {

	WebDriver driver;

	@BeforeMethod
	public void openBrowser() {
		
		BrowserFactory browserFactory=new BrowserFactory();
		driver = BrowserFactory.getBrowser(browserFactory.getBrowser());

		driver.get("https://www.facebook.com/");

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	@AfterMethod
	public  void takeScreeshot(ITestResult result) {

		if (ITestResult.FAILURE==result.getStatus()) {
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File src = screenshot.getScreenshotAs(OutputType.FILE);

			File dest = new File("C:\\Users\\Mutturaj\\muttu11\\muttu11\\Screenshots\\screenshot"+BrowserFactory.dateStamp()+".PNG");

			try {
				FileUtils.copyFile(src, dest);
			} catch (IOException e) {

				System.out.println("Screenshot hasnt taken " + e.getMessage());
			}
		}
	}

}
