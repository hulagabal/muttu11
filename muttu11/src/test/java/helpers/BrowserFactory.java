package helpers;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


public class BrowserFactory {

	FileInputStream inStream;
	Properties properties;

	private static WebDriver driver;

	public BrowserFactory() {
		try {
			inStream = new FileInputStream(
					new File("C:\\Users\\Mutturaj\\muttu11\\muttu11\\PropertyFiles\\config.proparties"));

			properties = new Properties();

			properties.load(inStream);
		} catch (Exception e) {

			System.out.println("Fiel not loaded " + e.getMessage());
		}
	}

	public static WebDriver getBrowser(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Mutturaj\\muttu11\\muttu11\\Drivers\\chromedriver.exe");

			driver = new ChromeDriver(chromeOptions);
		} else if(browserName.equalsIgnoreCase("firefox")) {

			FirefoxOptions options = new FirefoxOptions();
			options.setProfile(new FirefoxProfile());
			options.addPreference("dom.webnotifications.enabled", false);
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\Mutturaj\\muttu11\\muttu11\\Drivers\\geckodriver.exe");

			driver = new FirefoxDriver(options);

		}else{
			
			driver = new HtmlUnitDriver();
			
		}

		driver.manage().deleteAllCookies();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}

	public String getBrowser() {

		String browsername = properties.getProperty("browser");
		System.out.println(browsername);
		return properties.getProperty("browser");

	}

}
