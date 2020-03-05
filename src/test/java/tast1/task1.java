import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.Common;

public class task1 {
private WebDriver driver;
	
	@BeforeClass
	public void setUp () {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get("https://www.porsche.com/usa/modelstart/");
	}
	
	/**
	 * Click the button to display a alert box
	 */
	@Test()
	public void test1 () {
		
		driver.findElement(By.xpath("/html/body/div[2]/div[7]/div/div[2]/a[4]/div/div[1]/img")).click();
		Common.sleep(1);
	
	WebElement sportTiurismo = driver.findElement
		(By.xpath("//*[@id=\"m-14-filter-cat-1-content\"]/div/div[2]/div[3]/div/div/div[1]/div/div[2]/label[5]"));
	Common.sleep(2);
	
	
	
	
	
		Actions action = new Actions(driver);
		Common.sleep(2);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,1000)");
		
		Common.sleep(2);
		action.moveToElement(sportTiurismo).click().perform();
		
		boolean select = 
				driver.findElement(By.xpath("//*[@id=\"m-14-filter-cat-1-content\"]/div/div[2]/div[3]/div/div/div[1]/div/div[2]/label[5]")).isEnabled();
		Assert.assertEquals(select, true);
		Common.sleep(2);
	}
	
	@AfterClass
	public void tearDown () {
		driver.quit();
	}

}