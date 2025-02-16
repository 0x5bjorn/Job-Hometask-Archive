package formauthenticationpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Authentication methods for code reuse
 */
public class AuthenticationMethods {

	/**
	 * Perform login operation with given credentials
	 * 
	 * @param driver		Reference to an instance of the driver object for Chrome browser
	 * @param username		Username credentials
	 * @param password		Password credentials
	 */
	public static void login(WebDriver driver, String username, String password) {
		WebElement usernameField = driver.findElement(By.id("username"));
		WebElement passwordField = driver.findElement(By.id("password"));
		WebElement loginBtn = driver.findElement(By.xpath("//button[contains(@type, 'submit')]"));
		
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		loginBtn.click();
	}
	
	/**
	 * Perform logout operation
	 * 
	 * @param driver		Reference to an instance of the driver object for Chrome browser
	 */
	public static void logout(WebDriver driver) {
		WebElement logoutBtn = driver.findElement(By.xpath("//*[contains(@href, '/logout')]"));
		logoutBtn.click();
	}
}
