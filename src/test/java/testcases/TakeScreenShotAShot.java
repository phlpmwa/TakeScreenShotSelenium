package testcases;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class TakeScreenShotAShot {
	WebDriver driver ;
	
	@BeforeMethod
	public void setUp()
	{
		
		WebDriverManager.chromedriver().setup();
		driver  = new ChromeDriver();	
	}
	
	@Test
	public void TakeshotFullPageTest() throws IOException
	{
		driver.get("http://demo.guru99.com/test/guru99home/");
		driver.manage().window().maximize();
		String Path=System.getProperty("user.dir");
		Screenshot Screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver);
		ImageIO.write(Screenshot.getImage(), "jpg", new File(Path + "\\src\\test\\resources\\ElementScreenshot2.jpg"));
	}
	
	@AfterMethod
	
	public void tearDown()
	{
		driver.quit();
	}
	}


