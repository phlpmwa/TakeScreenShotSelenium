package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.UtilitiesHome;

public class TakeScreenShot {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}

	@Test
	public void testTakeScreenShot() throws Exception {

		// goto url

		driver.get("http://demo.guru99.com/V4/");
		String path = System.getProperty("user.dir");

		// Call take screenshot function
		UtilitiesHome.takeSnapShot(driver, path + "\\src\\test\\resources\\test.png");

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
