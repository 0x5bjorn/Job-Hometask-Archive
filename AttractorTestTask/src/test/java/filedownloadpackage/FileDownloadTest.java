package filedownloadpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Test cases of the "File Download" task
 */
public class FileDownloadTest {

	String baseURL = "http://the-internet.herokuapp.com/download";
	String driverPath = "D://ChromeDriver//chromedriver.exe";
	WebDriver driver;
	
	/**
	 * Verify a file downloading
	 */
	@Test             
	public void verifyFileDownload() {
		
		WebElement sampleFile = driver.findElement(By.xpath("//*[text()='some-file.txt']"));

		FileHandlingMethods.downloadFileFromURL(sampleFile.getAttribute("href"), sampleFile.getText());
			
		FileHandlingMethods.verifyFileContainsString(sampleFile.getText(), "red255");
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
