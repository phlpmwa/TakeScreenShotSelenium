package testcases;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class TakeElementsScreenShotAshot {
	
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		driver  = new ChromeDriver();
	}
	
	@Test
	public void elementsScreenShotTest() throws IOException
	{
		driver.get("http://demo.guru99.com/test/guru99home/");
		driver.manage().window().maximize();
				
		// Find the element to take a screenshot

		WebElement element = driver.findElement(By.xpath ("//*[@id=\"site-name\"]/a[1]/img"));

		// Along with driver pass element also in takeScreenshot() method.
		String Path=System.getProperty("user.dir");

		Screenshot Screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver,element);

		ImageIO.write(Screenshot.getImage(), "jpg", new File(Path+"\\src\\test\\resources\\ElementsScreenshot2.jpg"));
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	

	
		}

