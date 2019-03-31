package muttu11;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Test1 {
	private WebDriver driver;

	@BeforeClass
	public void check() {

		driver = new ChromeDriver();

		driver.manage().deleteAllCookies();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@Test
	public void getBrowser() {

		driver.get("https://github.com/bonigarcia/webdrivermanager");
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
