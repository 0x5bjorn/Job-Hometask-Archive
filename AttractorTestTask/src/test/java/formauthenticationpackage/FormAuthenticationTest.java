package formauthenticationpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Test cases of the "Form Authentication" task
 */
public class FormAuthenticationTest {

	String baseURL = "http://the-internet.herokuapp.com/login";
	String driverPath = "D://ChromeDriver//chromedriver.exe";
	WebDriver driver;
	
	/**
	 * Verify a successful login
	 */
	@Test             
	public void verifyValidLogin() {

		AuthenticationMethods.login(driver, "tomsmith", "SuperSecretPassword!");
		
		String expectedURL = "http://the-internet.herokuapp.com/secure";
		String resultURL = driver.getCurrentUrl();
		Assert.assertEquals(resultURL, expectedURL);
		
		AuthenticationMethods.logout(driver);
	}
	
	/**
	 * Verify an unsuccessful login (with incorrect username)
	 */
	@Test             
	public void verifyInvalidUsernameLogin() {

		AuthenticationMethods.login(driver, "test", "test!");
		
		String expectedURL = "http://the-internet.herokuapp.com/login";
		String resultURL = driver.getCurrentUrl();
		Assert.assertEquals(resultURL, expectedURL);
		
		Boolean invalidAlert = driver.findElement(By.xpath("//*[contains(text(),'username is invalid')]")).isDisplayed();
		Assert.assertTrue(invalidAlert);
	}
	
	/**
	 * Verify an unsuccessful login (with incorrect password)
	 */
	@Test             
	public void verifyInvalidPasswordLogin() {
		
		AuthenticationMethods.login(driver, "tomsmith", "test!");
		
		String expectedURL = "http://the-internet.herokuapp.com/login";
		String resultURL = driver.getCurrentUrl();
		Assert.assertEquals(resultURL, expectedURL);
		
		Boolean invalidAlert = driver.findElement(By.xpath("//*[contains(text(),'password is invalid')]")).isDisplayed();
		Assert.assertTrue(invalidAlert);
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
