package keypressespackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Test cases of the "Key Presses" task
 */
public class KeyPressesTest {

	String baseURL = "http://the-internet.herokuapp.com/key_presses";
	String driverPath = "D://ChromeDriver//chromedriver.exe";
	WebDriver driver;
	
	/**
	 * Verify a key presses
	 */
	@Test             
	public void verifyKeyPresses() {
		
		Actions actionProvider = new Actions(driver);
		WebElement result = driver.findElement(By.id("result"));

		actionProvider.sendKeys(Keys.CONTROL).perform();
		Assert.assertEquals(result.getText(), "You entered: CONTROL");
		
		actionProvider.sendKeys(Keys.ENTER).perform();
		Assert.assertEquals(result.getText(), "You entered: ENTER");
		
		actionProvider.sendKeys(Keys.ESCAPE).perform();
		Assert.assertEquals(result.getText(), "You entered: ESCAPE");
		
		actionProvider.sendKeys(Keys.SPACE).perform();
		Assert.assertEquals(result.getText(), "You entered: SPACE");
		
		actionProvider.sendKeys(Keys.TAB).perform();
		Assert.assertEquals(result.getText(), "You entered: TAB");
	}

	@BeforeTest
	public void setDriver() {
		
		// Set the system property for Chrome driver
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		// Instantiate driver object for CHROME browser
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		// Navigate to a page 
		driver.get(baseURL);
	}
	
	@AfterTest
	public void closeDriver() {
		driver.quit();
	}
}