package dropdownpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Test cases of the "Dropdown" task
 */
public class DropdownTest {

	String baseURL = "http://the-internet.herokuapp.com/dropdown";
	String driverPath = "D://ChromeDriver//chromedriver.exe";
	WebDriver driver;
	
	/**
	 * Verify a dropdown menu
	 */
	@Test             
	public void verifyDropdown() {
		
		WebElement dropdown = driver.findElement(By.id("dropdown"));
		
		// Verify that the dropdown list is enabled and visible
		Assert.assertTrue((dropdown.isEnabled() && dropdown.isDisplayed()));
		
		Select options = new Select(dropdown);
		
		// Verify that dropdown doesn't allow multiple selections
		Assert.assertFalse(options.isMultiple());
		
		// Get and verify the total size of the list of options
		int optionsSize = options.getOptions().size();
		Assert.assertEquals(optionsSize, 3);
		
		// Select the option “Option 1” and verify that it is selected as an option
		options.selectByVisibleText("Option 1");
		String firstSelectedOptionText = options.getFirstSelectedOption().getText();
	    Assert.assertEquals(firstSelectedOptionText, "Option 1");
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
